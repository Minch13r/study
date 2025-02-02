package weeks_2.View;

import java.util.Scanner;

public class View {
    Scanner sc;
    private static final int MenuMIN = 0;
    private static final int MenuMAX = 2;

    public View() {
        Scanner sc = new Scanner(System.in);
    }

    // ========== 메뉴 출력 ==========

    // 로그인 메뉴 출력
    public void showMenu() {
        System.out.println("1. 회원가입");
        System.out.println("2. 로그인");
        System.out.println("0. 프로그램 종료");
    }

    // 관리자 메뉴 번호 입력
    public int inputLogInMenuNum() {
        int num;
        while (true) {
            try {
                System.out.print("메뉴를 선택해주세요. >> ");
                num = sc.nextInt();
                if (MenuMIN <= num && num <= MenuMAX) {
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

    // ========== 입력 메서드 ==========

    // 번호 입력 메서드
    public int inputNum() {
        System.out.print("번호를 입력해주세요. >> ");

        int num = sc.nextInt();
        return num;
    }

    // 이름 입력 메서드
    public String inputString() {
        System.out.print("영상 이름을 입력해주세요. >> ");

        String name = sc.next();
        return name;
    }

    // 평점 입력 메서드
    public double inputRating() {
        System.out.println("평점을 입력해주세요. >> ");

        double rating = sc.nextDouble();
        return rating;
    }

    // ========== 결과 출력 메서드 ==========

    // 성공 문구
    public void printSuccess() {
        System.out.println("완료되었습니다!");
    }

    // 실패 문구
    public void printFail() {
        System.out.println("실패하였습니다...");
    }

    // 잘못된 입력
    public void printWrong() {
        System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
    }

    // 없는 자료
    public void printEmpty() {
        System.out.println("없는 자료 입니다...");
    }

    // 종료 메서드

    // 프로그램 종료
    public void printExit() {

        for (int i = 0; i < 5; i++) {
            System.out.print(".");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("프로그램을 종료합니다...");
    }

    // 로그아웃
    public void printLogOut() {
        for (int i = 0; i < 5; i++) {
            System.out.print(".");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println(/* ID명 + */"에서 로그아웃합니다!");
    }

    // 오류 메서드

    // 관리자 아이디와 같다면 이미 사용중인 아이디 출력
    public String printUsingID() {
        System.out.println("이미 사용중인 아이디 입니다.");
        System.out.print("아이디를 다시 입력해주세요. >>");

        String name = sc.next();
        return name;
    }

    // 회원가입 & 로그인

    // ID
    public String inputID() {
        System.out.print("사용할 아이디를 입력해주세요. >> ");

        String id = sc.next();
        return id;
    }

    // PW
    public int inputPW() {
        System.out.println("사용할 비밀번호를 입력해주세요. >> ");

        int pw = sc.nextInt();
        return pw;
    }

    // PW 재입력 >> 회원가입 처음하면 비밀번호 2번 입력하게 하는 것 처럼 (사용 안해도 됨)
    public int checkPW() {
        System.out.println("입력한 비밀번호를 확인해주세요. >> ");

        int checkpw = sc.nextInt();
        return checkpw;
    }

    // 로그인 시 > ID 잘못 입력할 경우
    public String notSavedId() {
        System.out.print("저장되지 않은 ID 입니다. 다시 입력해주세요. >> ");

        String name = sc.next();
        return name;
    }

    // 로그인 시 > PW 잘못 입력할 경우
    public int notSavedPw() {
        System.out.print("저장되지 않은 PW 입니다. 다시 입력해주세요. >> ");

        int num = sc.nextInt();
        return num;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

    } // End of main
} // End of MainView