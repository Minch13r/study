package weeks_2.Controller;

import weeks_2.Model.*;
import weeks_2.View.AdminView;
import weeks_2.View.ClientView;
import weeks_2.View.View;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private ArrayList<MovieDTO> movieList; // 크롤링한 데이터를 저장할 리스트
    private MovieDAO movieDao;
    private MemberDAO memberDao;
    private AdminView adminView;
    private ClientView clientView;
    private View baseView;
    private Crawling crawling;

    private MovieDTO adMovie;

    private ArrayList<MovieDTO> datas;
    // 생성자
    public Controller() {
        this.movieDao = new MovieDAO();
        this.memberDao = new MemberDAO();
        this.adminView = new AdminView();
        this.clientView = new ClientView();
        this.baseView = new View();
        initializeMovieData();

        this.datas=new ArrayList<>();
        this.adMovie=null;
    }

    // 크롤링 데이터 초기화 메소드
    private void initializeMovieData() {
        // 크롤링으로 데이터 가져오기
        this.movieList = Crawling.makeDatas();

        // 가져온 데이터를 DB에 저장
        if (movieList != null && !movieList.isEmpty()) {
            // movieList에 있는 내용 불러오기
            for (MovieDTO movie : movieList) {
                // 가져온 내용 DB에 저장
                movieDao.insert(movie);
            }
            System.out.println("[로그]영화 데이터 초기화 완료");
        } else {
            System.out.println("[로그]영화 데이터 초기화 실패");
        }
    }

    // 메인 실행 메소드
    public void start() {
        while(true) {
            // 메인 메뉴 출력
            baseView.showMenu();

            // 사용자 선택 입력받기
            int mainChoice = baseView.inputMenuNum();

            // 로그인
            if (mainChoice == 1) {
                // id 입력
                String id = baseView.inputId();
                // pw 입력
                String password = baseView.inputPw();

                // MemberDTO 인스턴스화
                MemberDTO memberDTO = new MemberDTO();
                // 관리자 인스턴스화(보안 위해서)
                Admin admin=new Admin();

                // 관리자 로그인
                if (admin.isAdminLogin(id, password)) {
                    while(true) {
                        // 관리자 메뉴 호출
                        adminView.showAdminMenu();

                        // 숫자 입력받기
                        int adminChoice = adminView.inputNum();

                        // 영상추가
                        if (adminChoice == 6) {
                            // 이름 입력받기
                            String movieName = adminView.inputNewMovie();
                            // 평점 입력받기
                            double rating = adminView.inputRating();
                            // scope 이슈(객체 생성)
                            MovieDTO movieDTO = new MovieDTO();
                            // 이름 DB에 저장
                            movieDTO.setTitle(movieName);
                            // 평점 DB에 저장
                            movieDTO.setRating(rating);

                            // 성공시
                            if(movieDao.insert(movieDTO)) {
                                baseView.printSuccess();
                            }
                            // 실패시
                            else {
                                baseView.printFail();
                            }
                        }
                        // 영상삭제
                        else if (adminChoice == 7) {
                            // 객체 생성
                            MovieDTO movieDTO = new MovieDTO();
                            // 영화 전체 불러오기
                            movieDTO.setCondition("PRINTALL");
                            ArrayList<MovieDTO> movies = movieDao.selectAll(movieDTO);

                            // 영화 배열이 비어있는 경우
                            if(movies.isEmpty()) {
                                baseView.printEmpty();
                            }
                            // 영화 목록 출력
                            else {
                                clientView.showMovieList(movies);
                            }

                            // 숫자 입력받기
                            int movieNum = adminView.inputDeleteMovie();

                            // 0. 뒤로가기
                            if(movieNum == 0){
                                continue;
                            }

                            // 삭제한 번호 DB에 저장
                            movieDTO.setMovieId(movieNum);

                            // 먼저 모든 사용자의 즐겨찾기에서 해당 영화를 제거
                            memberDao.delete(null, movieDTO);

                            // 그 다음 영화 데이터베이스에서 영화 삭제
                            if(movieDao.delete(movieDTO)) {
                                baseView.printSuccess();
                                System.out.println("[로그] 영화 삭제 및 모든 사용자의 즐겨찾기에서 제거 완료");
                            } else {
                                baseView.printFail();
                            }
                        }
                        // 광고영상관리
                        else if (adminChoice == 8) {

                            //광고가 null이면 새로 객체 생성(예외에러)
                            if(adMovie!=null) {
                                if(adminView.deleteAD()==true) {
                                    adMovie=null;
                                }
                            }
                            else {
                                int num=adminView.addNewAd();
                                MovieDTO data=new MovieDTO();
                                data.setMovieId(num);	//dto에 영화 번호 넣기
                                MovieDTO selectedMovie=movieDao.selectOne(data);//영화 번호로 찾기

                                movieDao.selectOne(selectedMovie);
                                baseView.showAd(selectedMovie);	//영상 가져와서 출력

                                adMovie=new MovieDTO();
                                //광고 영상에 넣기
                                adMovie.setMovieId(selectedMovie.getMovieId());
                                adMovie.setTitle(selectedMovie.getTitle());
                                adMovie.setRating(selectedMovie.getRating());
                                adMovie.setViewCount(selectedMovie.getViewCount());
                            }

                        }
                        // 로그아웃
                        else if (adminChoice == 9) {
                            baseView.printSuccess();
                            break;  // 관리자 메뉴 종료
                        }
                        // 프로그램 종료
                        else if (adminChoice == 0) {
                            baseView.printExit();
                            return;  // 프로그램 완전 종료
                        }
                    }
                }
                // 사용자 로그인
                else {
                    // id db에 연결
                    memberDTO.setId(id);
                    // pw db에 연결
                    memberDTO.setPw(password);
                    // DB에서 아이디랑 비밀번호 불러오기
                    MemberDTO loginResult = memberDao.selectOne(memberDTO);
                    // loginResult가 null이 아닌지 확인
                    boolean loginSuccess = (loginResult != null);

                    // 로그인 성공시
                    if (loginSuccess) {
                        while(true) {
                            // 사용자 메뉴 출력
                            clientView.showClientMenu(null);
                            if(adMovie==null) {
                                baseView.printNull();
                            }
                            else {
                                baseView.showAd(adMovie);
                            }
                            // 숫자 입력받기
                            int userChoice = clientView.inputNum();

                            // 1. 시청하기
                            if (userChoice == 1) {
                                MovieDTO movieDTO = new MovieDTO();
                                // 전체출력
                                movieDTO.setCondition("PRINTALL");
                                ArrayList<MovieDTO> movies = movieDao.selectAll(movieDTO);

                                // 배열이 비어있을 때
                                if(movies.isEmpty()) {
                                    baseView.printEmpty();
                                }
                                // 배열이 안 비어있을 때
                                else {
                                    clientView.showMovieList(movies);  // 영화 목록 출력
                                    int movieChoice = clientView.inputMovieChoiceNum();  // 영화 번호 입력받기

                                    // 0. 뒤로가기
                                    if(movieChoice == 0){
                                        continue;
                                    }
                                    // DB에 저장
                                    movieDTO.setMovieId(movieChoice);
                                    MovieDTO selectedMovie = movieDao.selectOne(movieDTO);

                                    // 실패시
                                    if (selectedMovie == null) {
                                        baseView.printFail();
                                    }
                                    // 성공시
                                    else {
                                        // 시청횟수 증가 성공
                                        if (movieDao.update(movieDTO)) {
                                            MovieDTO updatedMovie = movieDao.selectOne(movieDTO);
                                            clientView.showMovieDetail(updatedMovie);
                                            baseView.printSuccess();
                                        }
                                        // 시청횟수 증가 실패
                                        else {
                                            baseView.printFail();
                                        }
                                    }
                                }
                            }

                            // 즐겨찾기 기능
                            else if (userChoice == 2) {
                                boolean favoriteMenuActive = true;
                                while (favoriteMenuActive) {
                                    // 현재 사용자의 즐겨찾기 목록 조회
                                    ArrayList<MovieDTO> favorites = loginResult.getIsPremium();

                                    // 즐겨찾기 목록 표시
                                    if (favorites == null || favorites.isEmpty()) {
                                        baseView.printEmpty();
                                    } else {
                                        clientView.showMovieList(favorites);
                                    }

                                    // 즐겨찾기 메뉴 표시
                                    clientView.showFavoriteMenu();
                                    int favoriteChoice = clientView.inputNum();

                                    // 즐겨찾기 추가
                                    if (favoriteChoice == 1) {
                                        MovieDTO searchCondition = new MovieDTO();
                                        // 즐겨찾기 전체 출력
                                        searchCondition.setCondition("PRINTALL");
                                        ArrayList<MovieDTO> allMovies = movieDao.selectAll(searchCondition);

                                        // 비어있으면
                                        if (allMovies.isEmpty()) {
                                            baseView.printEmpty();
                                            continue;
                                        }

                                        // 즐겨찾기에 추가할 내용 찾기
                                        clientView.showMovieList(allMovies);
                                        int movieId = clientView.inputNum();

                                        // 선택한 영화 찾기
                                        MovieDTO selectedMovie = null;
                                        for (MovieDTO movie : allMovies) {
                                            if (movie.getMovieId() == movieId) {
                                                selectedMovie = movie;
                                                break;  // 찾았으면 반복문 종료
                                            }
                                        }

                                        // 선택한 영화가 존재할 때
                                        if (selectedMovie != null) {
                                            // 현재 사용자 id db에 저장
                                            memberDTO.setId(loginResult.getId());
                                            // 즐겨찾기 목록을 저장할 ArrayList 생성
                                            ArrayList<MovieDTO> updatedFavorites = new ArrayList<>();

                                            // 기존 즐겨찾기 목록이 있다면 복사
                                            if (favorites != null) {
                                                updatedFavorites = new ArrayList<>(favorites);
                                            }
                                            // 선택한 영화 즐겨찾기에 추가
                                            updatedFavorites.add(selectedMovie);
                                            // 업데이트 된 즐겨찾기 목록을 db에 저장
                                            memberDTO.setIsPremium(updatedFavorites);

                                            // DB에 즐겨찾기 정보 업데이트
                                            if (memberDao.update(loginResult.getId(), selectedMovie)) {
                                                loginResult.setIsPremium(updatedFavorites);
                                                baseView.printSuccess();
                                            } else {
                                                baseView.printFail();
                                            }
                                        }
                                    }

                                    // 즐겨찾기 삭제 기능 선택
                                    else if (favoriteChoice == 2) {
                                        // 즐겨찾기 목록이 비어있는지 확인
                                        if (favorites == null || favorites.isEmpty()) {
                                            baseView.printEmpty();
                                            continue;
                                        }

                                        // 현재 즐겨찾기 목록 출력
                                        clientView.showMovieList(favorites);
                                        // 삭제할 영화 번호 입력 받기
                                        int deleteMovieId = clientView.inputNum();

                                        // 삭제할 영화 정보 생성
                                        MovieDTO movieToDelete = new MovieDTO();
                                        movieToDelete.setMovieId(deleteMovieId);

                                        // memberDao의 delete 메소드 호출하여 즐겨찾기에서 삭제
                                        if (memberDao.delete(loginResult, movieToDelete)) {
                                            baseView.printSuccess();
                                            // 로그인 정보의 즐겨찾기 목록도 업데이트
                                            loginResult.setIsPremium(memberDao.selectOne(loginResult).getIsPremium());
                                        } else {
                                            baseView.printFail();
                                        }
                                    }

                                    // 0. 돌아가기
                                    else if (favoriteChoice == 0) {
                                        favoriteMenuActive = false;
                                    }

                                }
                            }
                            // 3. 영상 전체출력
                            else if (userChoice == 3) {
                                MovieDTO movieDTO = new MovieDTO();
                                movieDTO.setCondition("PRINTALL");
                                // MovieDAO에서 전체 영화 목록 가져오기
                                ArrayList<MovieDTO> movies = movieDao.selectAll(movieDTO);
                                // 영화 목록이 비어있는 경우
                                if(movies.isEmpty()) {
                                    baseView.printEmpty();  // 데이터 없음 메시지 출력
                                }
                                // 영화 목록이 있는 경우
                                else {
                                    clientView.showMovieList(movies);  // 영화 목록 출력
                                }
                            }

                            // 영화 검색
                            else if (userChoice == 4) {
                                String searchName = clientView.inputSearchKeyword();

                                // 0 입력시 뒤로가기
                                if (searchName.equals("0")) {
                                    continue;
                                }

                                MovieDTO searchDTO = new MovieDTO();
                                // 이름 DB에 넘기기
                                searchDTO.setTitle(searchName);
                                searchDTO.setCondition("SEARCH");

                                // db에서 불러오기
                                List<MovieDTO> results = movieDao.selectAll(searchDTO);
                                // 없는 경우
                                if (results.isEmpty()) {
                                    baseView.printFail();
                                    continue;
                                }
                                //있는 경우
                                else {
                                    // 검색 결과 목록 출력
                                    clientView.showMovieList((ArrayList<MovieDTO>) results);
                                    // 상세 정보를 보고 싶은 영화 선택
                                    clientView.showSelectMovieNum();
                                    int selectedId = clientView.inputSelectMovieNum();

                                    // 0. 뒤로가기
                                    if(selectedId == 0){
                                        continue;
                                    }

                                    // 선택한 영화를 저장할 변수 선언
                                    MovieDTO selectedMovie = null;

                                    // 입력받은 ID와 일치하는 영화 찾기
                                    for (MovieDTO movie : results) {
                                        if (movie.getMovieId() == selectedId) {
                                            selectedMovie = movie;
                                            break;
                                        }
                                    }

                                    // 선택한 영화가 있을 때
                                    if (selectedMovie != null) {
                                        clientView.showMovieDetail(selectedMovie);
                                    }
                                    // 선택한 영화가 없을 때
                                    else {
                                        baseView.printFail();
                                    }
                                }
                            }
                            // 로그아웃
                            else if (userChoice == 5) {
                                baseView.printSuccess();
                                break;
                            }
                            // 종료
                            else if (userChoice == 0) {
                                baseView.printExit();
                                return;
                            }
                        }
                    }
                    // 로그인 실패
                    else {
                        baseView.printFail();
                    }
                }
            }
            // 회원가입
            else if (mainChoice == 2) {
                // id 입력 받기
                String id = baseView.inputId();
                // 비밀번호 입력받기
                String password = baseView.inputPw();
                MemberDTO memberDto = new MemberDTO();
                memberDto.setId(id);
                memberDto.setPw(password);
                // 성공여부 판단
                boolean success = memberDao.insert(memberDto);
                // 성공시
                if(success) {
                    baseView.printSuccess();
                }
                // 실패시
                else {
                    baseView.printFail();
                }
            }
            // 종료
            else if (mainChoice == 0) {
                baseView.printExit();
                return;
            }
        }
    }
}


