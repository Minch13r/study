package weeks_2.View;

import weeks_2.Model.MemberDAO;
import weeks_2.Model.MemberDTO;
import weeks_2.Model.MovieDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientView extends View {
    Scanner sc;
    private static final int clientMenuMAX = 5;

    public ClientView() {
        Scanner sc = new Scanner(System.in);
    }

    // 클라이언트 메뉴 출력
    public int showClientMenu() {
        System.out.println("1. 시청하기");
        System.out.println("2. 즐겨찾기");
        System.out.println("3. 영상 목록 출력");
        System.out.println("4. 영화 이름 검색");
        System.out.println("5. 로그아웃");
        System.out.println("0. 프로그램 종료");

        int num = sc.nextInt();
        return num;
    }

    // 클라이언트 메뉴 번호 입력
    public int inputClientMenuNum() {
        int num;
        while (true) {
            try {
                System.out.print("메뉴를 선택해주세요. >> ");
                num = sc.nextInt();
                if (0 <= num && num <= clientMenuMAX) {
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

    // 시청하기
    public void watchingMovie() {
        String watching = "영..화..상..영..중..";
        for (char ch : watching.toCharArray()) {
            System.out.print(ch);
            try {
                Thread.sleep(500); // 0.5초(500ms) 동안 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("영상 시청이 종료되었습니다!");
    }

    // 즐겨찾기 추가 여부 확인
    public String addToFavorite() {
        System.out.print("영상을 즐겨찾기 목록에 추가 하시겠습니까? Y / N >> ");

        String addFavorite = sc.next().toUpperCase();
        return addFavorite;
    }

    // 즐겨찾기 목록 출력
    public void showMyPage(ArrayList<MemberDTO> datas) {
        if (datas.size() <= 0) {
            System.out.println("즐겨찾기에 추가된 영상이 없습니다...");
            return;
        }
        for (MemberDTO data : datas) {
            System.out.println(data);
        }
    }

    // 즐겨찾기 목록에서 추가하기 >> 번호로 추가할꺼면 int로 변경, 제목은 번호로 수정
    public String addToMyPage() {
        System.out.println("즐겨찾기에 추가할 영상 제목을 입력해주세요. >> ");

        String addToMyPage = sc.next();
        return addToMyPage;
    }

    // 즐겨찾기 목록에서 삭제하기 >> 번호로 삭제할꺼면 int로 변경, 제목은 번호로 수정
    public String removeFromMyPage() {
        System.out.println("즐겨찾기에서 삭제할 영상 제목을 입력해주세요. >> ");

        String removeFromMyPage = sc.next();
        return removeFromMyPage;
    }

    // 영화 목록 출력
    public void showMovieList(ArrayList<MovieDTO> datas) {
        if (datas.size() <= 0) {
            System.out.println("시청할 수 있는 영상이 없습니다...");
            return;
        }
        for (MovieDTO data : datas) {
            System.out.println(data);
        }
    }

    // 영화 이름 검색
    public String inputSearchKeyword() {
        System.out.println("검색할 내용을 입력해주세요. >> ");

        String searchKeyword = sc.next();
        return searchKeyword;
    }

    // 영화 정보 출력
    public void showMovieDetail(MovieDTO dto) {
        if (dto == null) {
            System.out.println("해당 영상의 정보를 찾을 수 없습니다...");
            return;
        }
        System.out.println("=== 영상 정보 ===");
        System.out.println("순 위 : " + dto.getMovieId());
        System.out.println("제 목 : " + dto.getTitle());
        System.out.println("평 점 : " + dto.getRating());
        System.out.println("===============");
    }

    // 클라이언트 아이디 로그아웃
    public void logoutAdmin() {
        System.out.println("클라이언트 아이디에서 로그인합니다.");
        System.out.println("첫 메뉴로 돌아갑니다!");
    }

}
