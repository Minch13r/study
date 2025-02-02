package weeks_2.View;

import weeks_2.Model.MovieDTO;
import java.util.ArrayList;

public class ClientView extends View {
    private static final int clientMenuMAX = 5;

    public ClientView() {
        super(); // 부모 클래스의 Scanner 초기화
    }

    // 클라이언트 메뉴 출력 및 선택 번호 반환
    public int showClientMenu() {
        System.out.println("\n======== NETFLIX 메인 메뉴 ========");
        System.out.println("1. 시청하기");
        System.out.println("2. 즐겨찾기");
        System.out.println("3. 영상 목록 출력");
        System.out.println("4. 영화 이름 검색");
        System.out.println("5. 로그아웃");
        System.out.println("0. 프로그램 종료");
        System.out.println("================================");

        return inputClientMenuNum();
    }

    // 클라이언트 메뉴 번호 입력받아 반환
    private int inputClientMenuNum() {
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

    // 시청하기 기능
    public void watchingMovie() {
        System.out.println("\n🎬 영화 재생을 시작합니다...");
        String watching = "▶ 영..화..상..영..중..";
        for (char ch : watching.toCharArray()) {
            System.out.print(ch);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n✅ 영상 시청이 종료되었습니다!");
    }

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
            System.out.println("[번호] 제목          평점    조회수");
            System.out.println("----------------------------");
            for (MovieDTO movie : movies) {
                System.out.printf("[%d] %-12s %.1f     %d\n",
                        movie.getMovieId(),
                        movie.getTitle(),
                        movie.getRating());
            }
        }
        System.out.println("==========================");
    }

    // 영화 검색 키워드 입력받아 반환
    public String inputSearchKeyword() {
        System.out.print("검색할 영화 제목을 입력해주세요 >> ");
        return sc.nextLine();
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
        System.out.println("============================");
    }

    // 번호 입력받아 반환
    @Override
    public int inputNum() {
        System.out.print("번호를 선택해주세요 >> ");
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ 올바른 숫자를 입력해주세요.");
                System.out.print("번호를 다시 선택해주세요 >> ");
            }
        }
    }
}
