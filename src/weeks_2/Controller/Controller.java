package weeks_2.Controller;

import weeks_2.Model.*;
import weeks_2.View.AdminView;
import weeks_2.View.ClientView;
import weeks_2.View.View;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private MovieDAO movieDao;
    private MemberDAO memberDao;
    private AdminView adminView;
    private ClientView clientView;
    private View baseView;
    private Crawling crawling;

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
            baseView.showMenu();
            int mainChoice = baseView.inputNum();

            if (mainChoice == 1) {  // 로그인
                String id = baseView.inputString();
                String password = baseView.inputString();
                MemberDTO memberDTO = new MemberDTO();
                memberDTO.setId(id);
                memberDTO.setPw(password);

                if (id.equals("admin") && password.equals("admin1234")) {  // 관리자 로그인
                    while(true) {
                        adminView.showAdminMenu();
                        int adminChoice = adminView.inputNum();

                        if (adminChoice == 6) {  // 영상추가
                            String movieName = adminView.inputNewMovie();
                            double rating = adminView.inputRating();
                            MovieDTO movieDTO = new MovieDTO();
                            movieDTO.setTitle(movieName);
                            movieDTO.setRating(rating);

                            if(movieDao.insert(movieDTO)) {
                                baseView.printSuccess();
                            } else {
                                baseView.printFail();
                            }
                        }
                        else if (adminChoice == 7) {  // 영상삭제
                            int movieNum = adminView.inputDeleteMovie();
                            MovieDTO movieDTO = new MovieDTO();
                            movieDTO.setMovieId(movieNum);

                            if(movieDao.delete(movieDTO)) {
                                baseView.printSuccess();
                            } else {
                                baseView.printFail();
                            }
                        }
                        else if (adminChoice == 8) {  // 광고영상관리
                            adminView.addNewAd();
                        }
                        else if (adminChoice == 9) {  // 로그아웃
                            baseView.printSuccess();
                            break;  // 관리자 메뉴 종료
                        }
                        else if (adminChoice == 0) {  // 프로그램 종료
                            baseView.printExit();
                            return;  // 프로그램 완전 종료
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
                            else if (userChoice == 2) {  // 즐겨찾기 기능
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

                                    if (favoriteChoice == 1) {  // 즐겨찾기 추가
                                        MovieDTO searchCondition = new MovieDTO();
                                        searchCondition.setCondition("PRINTALL");
                                        ArrayList<MovieDTO> allMovies = movieDao.selectAll(searchCondition);

                                        if (allMovies.isEmpty()) {
                                            baseView.printEmpty();
                                            continue;
                                        }

                                        clientView.showMovieList(allMovies);
                                        int movieId = clientView.inputNum();

                                        // 선택한 영화 찾기
                                        MovieDTO selectedMovie = allMovies.stream()
                                                .filter(movie -> movie.getMovieId() == movieId)
                                                .findFirst()
                                                .orElse(null);

                                        if (selectedMovie != null) {
                                            memberDTO.setId(loginResult.getId());
                                            ArrayList<MovieDTO> updatedFavorites =
                                                    (favorites != null) ? new ArrayList<>(favorites) : new ArrayList<>();
                                            updatedFavorites.add(selectedMovie);
                                            memberDTO.setIsPremium(updatedFavorites);

                                            if (memberDao.insert(memberDTO)) {
                                                baseView.printSuccess();
                                            } else {
                                                baseView.printFail();
                                            }
                                        } else {
                                            baseView.printFail();
                                        }
                                    }
                                    else if (favoriteChoice == 2) {  // 즐겨찾기 삭제
                                        if (favorites == null || favorites.isEmpty()) {
                                            baseView.printEmpty();
                                            continue;
                                        }

                                        clientView.showMovieList(favorites);
                                        int deleteMovieId = clientView.inputNum();

                                        MovieDTO movieToDelete = favorites.stream()
                                                .filter(movie -> movie.getMovieId() == deleteMovieId)
                                                .findFirst()
                                                .orElse(null);

                                        if (movieToDelete != null) {
                                            if (movieDao.delete(movieToDelete)) {
                                                baseView.printSuccess();
                                            } else {
                                                baseView.printFail();
                                            }
                                        } else {
                                            baseView.printFail();
                                        }
                                    }
                                    else if (favoriteChoice == 0) {  // 이전 메뉴로
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


                            // 영화 검색 부분 수정 (userChoice == 4 부분)
                            else if (userChoice == 4) {
                                String searchName = clientView.inputSearchKeyword();
                                MovieDTO searchDTO = new MovieDTO();
                                searchDTO.setTitle(searchName);
                                searchDTO.setCondition("SEARCH");

                                List<MovieDTO> results = movieDao.selectAll(searchDTO);
                                if (results.isEmpty()) {
                                    baseView.printFail();
                                } else {
                                    // 검색 결과 목록 출력
                                    clientView.showMovieList((ArrayList<MovieDTO>) results);
                                    // 상세 정보를 보고 싶은 영화 선택
                                    System.out.println("상세 정보를 볼 영화의 번호를 선택하세요:");
                                    int selectedId = clientView.inputNum();

                                    MovieDTO selectedMovie = results.stream()
                                            .filter(movie -> movie.getMovieId() == selectedId)
                                            .findFirst()
                                            .orElse(null);

                                    if (selectedMovie != null) {
                                        clientView.showMovieDetail(selectedMovie);
                                    } else {
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
