package javastudy.weeks_2.View;

import javastudy.weeks_2.Model.MovieDTO;

import java.util.ArrayList;

public class AdminView extends View {
    private static final int adminMenuMAX = 9;
    private static final int adminMenuMIN = 6;

    private boolean hasAD;
    private int adMovieId;

    public int getAdMovieId() {
        return adMovieId;
    }

    public void setAdMovieId(int adMovieId) {
        this.adMovieId = adMovieId;
    }

    public AdminView() {
        super();
    }

    // 관리자 메뉴 출력
    public void showAdminMenu() {
        System.out.println("\n======== 관리자 메뉴 ========");
        System.out.println("6. 영상 추가");
        System.out.println("7. 영상 삭제");
        System.out.println("8. 광고 영상 관리");
        System.out.println("9. 로그아웃");
        System.out.println("0. 프로그램 종료");
        System.out.println("=========================");
    }

    // 관리자 메뉴 번호 입력 (Override)
    @Override
    public int inputNum() {
        while (true) {
            try {
                System.out.print("메뉴를 선택해주세요 >> ");
                int num = Integer.parseInt(sc.nextLine());
                if ((adminMenuMIN <= num && num <= adminMenuMAX) || num == 0) {
                    return num;
                }
                System.out.println("❌ 잘못된 메뉴 번호입니다. 다시 입력해주세요.");
            } catch (NumberFormatException e) {
                System.out.println("❌ 숫자로 입력해주세요.");
            }
        }
    }

    // ========== 영상 추가 파트 ==========

    // 새로운 영상 이름 입력
    public String inputNewMovie() {
        System.out.println("\n======== 새 영상 추가 ========");
        String movieName;
        while (true) {
            System.out.print("영상 제목을 입력해주세요 (0 : 뒤로가기) >> ");
            movieName = sc.nextLine().trim();
            if(movieName.isEmpty()) {
                System.out.println("❌ 영상 제목이 없다면 등록할 수 없습니다!");
                continue;
            }
            return movieName;
        }
    }

    // 영상 평점 입력
    public double inputRating() {
        double rating;
        while (true) {
            try {
                System.out.print("평점을 입력해주세요 (0.0 ~ 100.0) >> ");
                rating = Double.parseDouble(sc.nextLine());
                if (0.0 <= rating && rating <= 100.0) {
                    return rating;
                } else {
                    System.out.println("❌ 평점은 0.0 ~ 100.0 사이여야 합니다.");
                }
            } catch (Exception e) {
                System.out.println("❌ 숫자로 입력해주세요.");
            }
        }
    }

    // ========== 영상 삭제 파트 ==========

    // 삭제할 영상 번호 입력
    public int inputDeleteMovie() {
        System.out.println("\n======== 영상 삭제 ========");
        while (true) {
            try {
                System.out.print("삭제할 영상 번호를 입력해주세요 (0 : 뒤로가기) >> ");
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ 올바른 숫자를 입력해주세요.");
            }
        }
    }

    // 영상 삭제 확인
    public boolean printCheckDelete() {
        while (true) {
            System.out.print("정말 해당 영상을 삭제하시겠습니까? (Y/N) >> ");
            String answer = sc.nextLine().trim().toUpperCase();
            if (answer.equals("Y"))
                return true;
            if (answer.equals("N"))
                return false;
            System.out.println("❌ Y 또는 N으로 입력해주세요.");
        }
    }

    // ========== 광고 파트 ==========

    // 새 광고 영상 등록
    public boolean hasAD() {
        return this.hasAD;
    }

    // hasAD값 받기
    public void setAdStatus() {
        System.out.print("광고가 이미 등록되어 있습니까? (Y/N) >> ");
        String answerAD = sc.nextLine().toUpperCase();
        if (answerAD.equals("Y")) {
            this.hasAD = true;
        }
        if (answerAD.equals("N")) {
            this.hasAD = false;
        }
    }

    public int addNewAd(ArrayList<MovieDTO> movies) {
        System.out.println("\n======== 광고 영상 등록 ========");
        while (true) {
            System.out.print("광고로 등록할 영상 번호를 입력해주세요 (0 : 뒤로가기) >> ");
            int num;
            try {
                num = sc.nextInt();
                sc.nextLine();
                if(num>=0 && num <= movies.size()) {
                    return num;
                }else {
                    System.out.println("❌ 광고로 등록할 수 없는 번호입니다.");
                }
            } catch (Exception e) {
                System.out.println("❌ 숫자로 입력해주세요.");
            }
        }
    }

    // 기존 광고 삭제 확인
    public boolean deleteAD() {
        System.out.println("\n⚠️ 광고가 이미 등록되어 있습니다.");
        while (true) {
            System.out.print("현재 광고를 삭제하시겠습니까? (Y/N) >> ");
            String answer = sc.nextLine().trim().toUpperCase();
            if (answer.equals("Y"))
                return true;
            if (answer.equals("N"))
                return false;
            System.out.println("❌ Y 또는 N으로 입력해주세요.");
        }
    }

    // 관리자 로그아웃 메시지
    public void logoutAdmin() {
        System.out.println("\n✅ 관리자 계정에서 로그아웃되었습니다.");
        System.out.println("메인 메뉴로 돌아갑니다.");
    }

    // ========== 광고 삭제 파트 ========== 안쓰는 메서드
    //public void printDelete() {
    //	System.out.println("이미 광고가 있습니다. 삭제하시려면 Y를 입력, 아니면 N을 입력해주세요");
//	}

    // y, n 입력
    //public String yOrn() {
    //String input = sc.next();
    //return input;
}
