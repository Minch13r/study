package weeks_2.Controller;

import weeks_2.Model.*;
import weeks_2.View.AdminView;
import weeks_2.View.ClientView;
import weeks_2.View.View;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private MovieDAO movieDao; // 영화관련 dao
    private MemberDAO memberDao; // 멤버관련 dao
    private AdminView adminView; // 관리자뷰
    private ClientView clientView; // 사용자뷰
    private View baseView; // 부모뷰
    private Crawling crawling; // 크롤링

    // 생성자
    public Controller() {
        this.movieDao = new MovieDAO();
        this.memberDao = new MemberDAO();
        this.adminView = new AdminView();
        this.clientView = new ClientView();
        this.baseView = new View();
        this.crawling = new Crawling();
    }

    // controller start
    public void start() {
        while(true) {
            // 로그인, 회원가입, 종료
            baseView.showMenu();
            // 숫자 입력받기
            int mainChoice = baseView.inputNum();

            if (mainChoice == 1) {  // 로그인
                String id = baseView.inputString();      // ID 입력
                String password = baseView.inputString(); // 비밀번호 입력
                MemberDTO memberDTO = new MemberDTO();
                memberDTO.setId(id);
                memberDTO.setPw(password);

                if (id.equals("admin") && password.equals("admin1234")) {  // 관리자 계정 확인
                    while(true) {
                        // 관리자 메뉴 출력
                        adminView.showAdminMenu();
                        // 숫자 입력 받기
                        int adminChoice = adminView.inputNum();

                        // 6. 영상추가
                        if (adminChoice == 6) {
                            // 이름 입력받기
                            String movieName = adminView.inputNewMovie();
                            // 평점(?) 사용자 만족도 입력
                            double rating = adminView.inputRating();
                            MovieDTO movieDTO = new MovieDTO();
                            movieDTO.setTitle(movieName);
                            movieDTO.setRating(rating);
                            // 성공 여부 판단
                            boolean success = movieDao.insert(movieDTO);
                            // 성공시
                            if(success) {
                                baseView.printSuccess();
                            }
                            // 실패시
                            else {
                                baseView.printFail();
                            }
                        }
                        // 7. 영상삭제
                        else if (adminChoice == 7) {
                            // 번호 입력받기
                            int movieNum = adminView.inputDeleteMovie();
                            MovieDTO movieDTO = new MovieDTO();
                            movieDTO.setMovieId(movieNum);
                            // 성공 여부 판단
                            boolean success = movieDao.delete(movieDTO);
                            // 성공시
                            if(success) {
                                baseView.printSuccess();
                            }
                            // 실패시
                            else {
                                baseView.printFail();
                            }
                        }
                        // 8. 광고영상관리
                        else if (adminChoice == 8) {
                            adminView.addNewAd(); // 광고 영상 있는지??
                            // 광고를 넣으시겠습니까?
                            // 있는경우 -> 삭제하고 넣겠습니까?
                            // 없는경우 -> 그냥 넣기
                        }
                        // 9. 로그아웃
                        else if (adminChoice == 9) {
                            baseView.printSuccess();
                            break;
                        }
                        // 0. 종료
                        else if (adminChoice == 0) {
                            baseView.printExit();
                            return;
                        }
                    }
                }
                // 사용자 로그인
                else {
                    // 성공 여부 판단
                    // for문으로 싹 긁어서 id랑 pw 맞으면 true 반환 아니면 false 반환
                    MemberDTO loginResult = memberDao.selectOne(memberDTO); // 고민
                    boolean loginSuccess = (loginResult != null);
                    // 로그인 성공시
                    if (loginSuccess) {
                        while(true) {
                            // 사용자 메뉴 출력
                            clientView.showClientMenu();
                            // 숫자 입력받기
                            int userChoice = clientView.inputNum();

                            // 1. 시청하기
                            if (userChoice == 1) {
                                // 영화 목록 보여주기
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
                                // 영화 번호 입력받기
                                int movieChoice = clientView.inputNum();

                                // MovieDTO 객체 생성하여 선택한 영화 정보 설정
                                movieDTO.setMovieId(movieChoice);

                                // 선택한 영화가 존재하는지 확인
                                MovieDTO selectedMovie = movieDao.selectOne(movieDTO);

                                if(selectedMovie == null) {
                                    baseView.printFail(); // 영화를 찾을 수 없음
                                    continue;
                                }

                                // 시청 횟수 증가 처리
                                boolean success = movieDao.update(movieDTO);

                                // 성공시
                                if(success) {
                                    // 업데이트된 영화 정보 다시 가져오기
                                    MovieDTO updatedMovie = movieDao.selectOne(movieDTO);
                                    clientView.showMovieDetail(updatedMovie);
                                    baseView.printSuccess();
                                }
                                // 실패시
                                else {
                                    baseView.printFail();
                                }
                            }
                            // 2. 즐겨찾기
                            else if (userChoice == 2) {
                                while(true) {
                                    // 즐겨찾기 목록 출력
                                    clientView.showMyPage();
                                    // 숫자 입력받기
                                    int favoriteChoice = clientView.inputNum();

                                    // 즐겨찾기 추가
                                    if (favoriteChoice == 1) {
                                        int movieId = clientView.inputNum();
                                        // 즐겨찾기 추가 로직
                                        ???
                                    }
                                    // 즐겨찾기 삭제
                                    else if (favoriteChoice == 2) {
                                        int movieId = clientView.inputNum();
                                        // 즐겨찾기 삭제 로직
                                        ???
                                    }
                                    // 뒤로가기
                                    else if (favoriteChoice == 0) {
                                        break;
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
                            // 4. 영화 이름 검색
                            else if (userChoice == 4) {
                                // 이름으로 입력받기
                                String searchName = clientView.inputSearchKeyword();
                                MovieDTO movieDTO = new MovieDTO();
                                movieDTO.setTitle(searchName);
                                // 해당되는 이름이 있는지 model 검색
                                List<MovieDTO> results = movieDao.selectAll(movieDTO);
                                // 아무것도 없으면
                                if(results.isEmpty()) {
                                    // 오류
                                    baseView.printFail();
                                }
                                // 있으면
                                else {
                                    // 성공
                                    clientView.showMovieDetail(movieDTO);
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
                String id = baseView.inputString();
                // 비밀번호 입력받기
                String password = baseView.inputString();
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

    // 광고 여부 판단
    private boolean checkAdRequirement() {
        return true;
    }
}
