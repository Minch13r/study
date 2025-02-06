package weeks_2.View;

import weeks_2.Model.MovieDTO;
import java.util.ArrayList;

public class ClientView extends View {
    private static final int clientMenuMAX = 5;

    public ClientView() {
        super(); // 부모 클래스의 Scanner 초기화
    }

    // 클라이언트 메뉴 출력 및 선택 번호 반환
    public void showClientMenu(MovieDTO dto) {
        System.out.println("\n======== NETFLIX 메인 메뉴 ========");
        System.out.println("1. 시청하기");
        System.out.println("2. 즐겨찾기");
        System.out.println("3. 영상 목록 출력");
        System.out.println("4. 영화 이름 검색");
        System.out.println("5. 로그아웃");
        System.out.println("0. 프로그램 종료");
        if (dto != null) {
            System.out.println(dto.getMovieId() + " " + dto.getTitle() + " " + dto.getRating());
        }
        System.out.println("================================");
    }

    // 클라이언트 메뉴 번호 입력받아 반환
    public int inputClientMenuNum() {
        int num;
        while (true) {
            try {
                System.out.print("메뉴를 선택해주세요 >> ");
                num = Integer.parseInt(sc.nextLine());
                if (0 <= num && num <= clientMenuMAX) {
                    return num;
                }
                System.out.println("❌ 잘못된 입력입니다. 다시 입력해주세요.");
            } catch (Exception e) {
                System.out.println("❌ 숫자로 입력해주세요.");
            }
        }
    }

    // 시청하기 기능 안쓰는 메서드
    //public void watchingMovie() {
    //System.out.println("\n🎬 영화 재생을 시작합니다...");
    //String watching = "▶ 영..화..상..영..중..";
    //for (char ch : watching.toCharArray()) {
    //	System.out.print(ch);
    //	try {
    //	Thread.sleep(500);
    //} catch (InterruptedException e) {
    //e.printStackTrace();
    //}
    //	}
    //System.out.println("\n✅ 영상 시청이 종료되었습니다!");
    //}

    // 즐겨찾기 메뉴 출력
    public void showFavoriteMenu() {
        System.out.println("\n======== 즐겨찾기 메뉴 ========");
        System.out.println("1. 즐겨찾기 추가");
        System.out.println("2. 즐겨찾기 삭제");
        System.out.println("0. 이전 메뉴로");
        System.out.println("============================");
    }

    // 영화 목록 출력
    public void showMovieList(ArrayList<MovieDTO> movies) {
        System.out.println("\n======== 영화 목록 ========");
        if (movies.isEmpty()) {
            System.out.println("등록된 영화가 없습니다.");
        } else {
            System.out.println("[번호] 제목          평점    ");
            System.out.println("----------------------------");
            for (MovieDTO movie : movies) {
                System.out.printf("[%d] %-12s %.1f     \n", movie.getMovieId(), movie.getTitle(), movie.getRating());
            }
        }
        System.out.println("==========================");
    }

    // 영화 검색 키워드 입력받아 반환
    public String inputSearchKeyword() {
        while (true) {
            System.out.print("검색할 영화 제목을 입력해주세요 (0 : 뒤로가기)>> ");
            String keyword = sc.nextLine().trim();

            //if (keyword.equals("0")) {   //빼기
            //	return keyword;
            //}
            if (!keyword.isEmpty()) {
                return keyword;
            }
            System.out.println("❌ 검색어 입력은 필수입니다!");
        }
    }

    // 영화 상세 정보 출력
    public void showMovieDetail(MovieDTO movie) {
        if (movie == null) {
            System.out.println("⚠️ 해당 영상의 정보를 찾을 수 없습니다...");
            return;
        }
        System.out.println("\n======== 영화 상세 정보 ========");
        System.out.println("번 호: " + movie.getMovieId());
        System.out.println("제 목: " + movie.getTitle());
        System.out.println("평 점: " + movie.getRating());
        System.out.println("시청횟수: " + movie.getViewCount());
        System.out.println("============================");
    }

    // 번호 입력받아 반환
    @Override
    public int inputNum() {
        int num;
        while (true) {
            try {
                System.out.print("번호를 선택해주세요 >> ");
                num = sc.nextInt();
                sc.nextLine(); // 버퍼 비우기
                if (num >= 0) {
                    return num;
                } else {
                    System.out.println("❌ 음수는 입력할 수 없습니다.");
                }
            } catch (Exception e) {
                sc.nextLine(); // 입력 버퍼 비우기
                System.out.println("❌ 숫자로 입력해주세요. >> ");
            }
        }
    }

    // 정상 작동하면 Controller > 1. 시청하기 >> 배열이 안비어있을 때 안에 movies 넣어야함
    public int inputMovieChoiceNum(ArrayList<MovieDTO> movies) {
        while (true) {
            System.out.print("번호를 선택해주세요 ");
            int num;
            try {
                num = sc.nextInt();
                sc.nextLine(); // 버퍼 비우기

                //	if (num == 0) {   //빼기
                //		return num;
                //	}

                if (num > 0 && num <= movies.size()) {
                    return num;
                } else {
                    System.out.println("❌ 등록되지 않은 영상입니다.");
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("❌ 숫자로 입력해주세요.");
            }
        }
    }

    public void showSelectMovieNum() {
        System.out.println("상세 정보를 볼 영화의 번호를 선택하세요 (0 : 뒤로가기)");
    }

    public int inputSelectMovieNum() {
        int num = inputNum();
        return num;
    }
}
