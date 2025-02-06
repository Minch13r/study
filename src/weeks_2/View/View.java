package weeks_2.View;

import weeks_2.Model.MovieDTO;

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

    public void printNull() {
        System.out.println("");
    }

    // 광고 출력
    public void showAd(MovieDTO movies) {
        System.out.println(movies.getMovieId() + " " + movies.getTitle() + " " + movies.getRating());
        System.out.println("==========================");
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
    // 번호 입력 메서드 안쓰는 메서드
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

    // 메인 메뉴용 입력 메소드
    public int inputMenuNum() {
        int num;
        while (true) {
            try {
                System.out.print("번호를 선택해주세요 >> ");
                num = sc.nextInt();
                sc.nextLine(); // 버퍼 비우기
                return num;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("❌ 숫자로 입력해주세요.");
                continue;
            }
        }
    }

    // ID/PW 입력 메서드

    // ID >> 공백 체크
    public String inputId() {
        String id;
        if (sc.hasNextLine()) {
            sc.nextLine(); // 개행문자 제거
        }
        while (true) {
            System.out.print("아이디를 입력해주세요 >> ");
            id = sc.nextLine().trim(); // 공백 제거
            if (id.isEmpty()) {
                System.out.println("❌ 아이디는 공백일 수 없습니다!");
            } else if (id.contains(" ")) {
                System.out.println("❌ 아이디에 띄어쓰기는 불가능합니다!");
            } else {
                return id;
            }
        }
    }

    // PW >> 공백 체크
    public String inputPw() {
        String pw;
        while (true) {
            System.out.print("비밀번호를 입력해주세요 >> ");
            pw = sc.nextLine().trim();
            if (pw.isEmpty()) {
                System.out.println("❌ 비밀번호는 공백일 수 없습니다!");
            } else if (pw.contains(" ")) {
                System.out.println("❌ 비밀번호에 띄어쓰기는 불가능합니다!");
            } else {
                return pw;
            }
        }
    }

    // 평점 입력 메서드
    public double inputRating() {
        double rating;
        while (true) {
            try {
                System.out.print("평점을 입력해주세요 (0.0 ~ 5.0) >> ");
                rating = Double.parseDouble(sc.nextLine());

                if (0.0 <= rating && rating <= 5.0) {
                    return rating;
                } else {
                    System.out.print("❌ 평점은 0.0 ~ 5.0 사이여야 합니다.");
                }
            } catch (Exception e) {
                System.out.println("❌ 숫자로 입력해주세요.");
            }
        }
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
        String[] progressBar = { "⬛", "⬛", "⬛", "⬛", "⬛" };
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

    // ID 입력
    public void printSignInIDErr(){
        System.out.println("[안내] ID를 입력해주세요");
    }

    // 사용중인 ID
    public void printSignInIdDuplicationErr(){
        System.out.println("[안내] 이미 사용 중인 ID입니다.");
    }

}
