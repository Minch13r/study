package weeks_2.View;

import java.util.Scanner;

public class AdminView extends View {
    Scanner sc;
    private static final int adminMenuMAX = 9;

    public AdminView() {
        Scanner sc = new Scanner(System.in);
    }

    // 관리자 메뉴 출력
    public void showAdminMenu() {
        System.out.println("6. 영상 추가");
        System.out.println("7. 영상 삭제");
        System.out.println("8. 광고 영상 관리");
        System.out.println("9. 로그아웃");
        System.out.println("0. 프로그램 종료");
    }

    // 관리자 메뉴 번호 입력
    public int inputAdminMenuNum() {
        int num;
        while (true) {
            try {
                System.out.print("메뉴를 선택해주세요. >> ");
                num = sc.nextInt();
                if (0 <= num && num <= adminMenuMAX) {
                    break;
                }
                System.out.println("잘못된 입력입니다 다시 입력해주세요.");
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("숫자로 입력해주세요.");
                continue;
            }
        }
        return num;
    }

    // ========== 영상 추가 파트 ==========

    // 영상 추가 - 이름으로 입력
    public String inputNewMovie() {
        System.out.print("영상의 이름을 입력해주세요. >> ");
        String newMovieName = sc.next();
        return newMovieName;
    }

    // 영상 추가 - 평점
    public double inputRating() {
        System.out.print("영상의 평점을 입력해주세요. >> ");
        double newMovieRating = sc.nextDouble();
        return newMovieRating;
    }

    // ========== 영상 삭제 파트 ==========

    // 영상 번호 입력
    public int inputDeleteMovie() {
        System.out.print("삭제할 영상의 번호를 입력해주세요. >> ");
        int movieNum = sc.nextInt();
        return movieNum;
    }

    // 영상 삭제
    public String printCheckDelete() {
        System.out.print("정말 해당 영상을 삭제하시겠습니까? Y / N >> ");
        String answerDelete = sc.next().toUpperCase(); // 무조건 대문자로
        return answerDelete;
    }

    // ========== 광고 파트 ==========

    // 광고 추가
    public int addNewAd() {
        System.out.print("광고로 등록할 영상 번호를 입력해주세요. >> ");

        int num = sc.nextInt();
        return num;
    }

    // 광고가 이미 있는 경우
    public String deleteAD() {
        System.out.println("광고가 이미 등록되어 있습니다. ");
        System.out.print("현재 광고를 삭제하시겠습니까? Y / N");

        String deleteAD = sc.next().toUpperCase();
        return deleteAD;
    }

    // 관리자 아이디 로그아웃
    public void logoutAdmin() {
        System.out.println("관리자 아이디에서 로그인합니다.");
        System.out.println("첫 메뉴로 돌아갑니다!");
    }

}