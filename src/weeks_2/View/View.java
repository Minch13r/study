package weeks_2.View;

import java.util.Scanner;

public class View {
    Scanner sc;
    private static final int MenuMIN = 0;
    private static final int MenuMAX = 2;

    public View() {
        this.sc = new Scanner(System.in);
    }

    // ========== 메뉴 출력 ==========
    public void showMenu() {
        System.out.println("============= NETFLIX =============");
        System.out.println("1. 로그인");
        System.out.println("2. 회원가입");
        System.out.println("0. 프로그램 종료");
        System.out.println("=================================");
    }

    // 메뉴 번호 입력
    public int inputLogInMenuNum() {
        int num;
        while (true) {
            try {
                System.out.print("메뉴를 선택해주세요 >> ");
                num = sc.nextInt();
                if (MenuMIN <= num && num <= MenuMAX) {
                    break;
                }
                System.out.println("❌ 잘못된 입력입니다. 다시 입력해주세요.");
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("❌ 숫자로 입력해주세요.");
                continue;
            }
        }
        return num;
    }

    // ========== 입력 메서드 ==========
    // 번호 입력 메서드
    public int inputNum() {
        System.out.print("번호를 선택해주세요 >> ");
        int num = sc.nextInt();
        return num;
    }

    // ID/PW 입력 메서드
    public String inputString() {
        // ID 입력인 경우
        if (sc.nextLine().isEmpty()) {
            System.out.print("아이디를 입력해주세요 >> ");
        }
        // PW 입력인 경우
        else {
            System.out.print("비밀번호를 입력해주세요 >> ");
        }
        return sc.next();
    }

    // 평점 입력 메서드
    public double inputRating() {
        System.out.print("평점을 입력해주세요 (0.0 ~ 5.0) >> ");
        double rating = sc.nextDouble();
        return rating;
    }

    // ========== 결과 출력 메서드 ==========
    // 성공 문구
    public void printSuccess() {
        System.out.println("✅ 작업이 성공적으로 완료되었습니다!");
    }

    // 실패 문구
    public void printFail() {
        System.out.println("❌ 작업 수행에 실패했습니다. 다시 시도해주세요.");
    }

    // 잘못된 입력
    public void printWrong() {
        System.out.println("❌ 잘못된 입력입니다. 다시 입력해주세요.");
    }

    // 없는 자료
    public void printEmpty() {
        System.out.println("⚠️ 검색된 데이터가 없습니다...");
    }

    // 종료 메서드
    // 프로그램 종료
    public void printExit() {
        System.out.println("🔄 프로그램을 종료합니다...");
        String[] progressBar = {"⬛", "⬛", "⬛", "⬛", "⬛"};
        for (int i = 0; i < progressBar.length; i++) {
            System.out.print(progressBar[i]);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n프로그램이 종료되었습니다.");
    }

    // 로그아웃
    public void printLogOut() {
        System.out.println("👋 안전하게 로그아웃되었습니다.");
    }
}
