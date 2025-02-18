package java.day018.class02.View;

import java.util.ArrayList;
import java.day018.class02.Model.KyochonDTO;
import java.util.Scanner;

public class View {
    Scanner sc;

    public View() {
        // 공통 인자 생성자로 선언
        this.sc=new Scanner(System.in);
    }

    // 메뉴출력
    public void showMainMenu(){
        System.out.println("\n=== 교촌치킨 메뉴 관리 시스템 ===");
        System.out.println("1. 메뉴 크롤링하기");
        System.out.println("2. 전체 메뉴 보기");
        System.out.println("3. 메뉴 검색하기");
        System.out.println("4. 메뉴 삭제하기");
        System.out.println("0. 종료");
    }

    // 번호 입력
    public int inputNum(){
        System.out.print("번호입력 >> ");
        int num = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기
        return num;    }

    // 종료 안내
    public void printExit(){
        System.out.println("종료됩니다.");
    }

    public void printTrue() {
        System.out.println("성공!");
    }

    public void printFalse() {
        System.out.println("실패...");
    }

    public void printMenuList(ArrayList<KyochonDTO> menus) {
        menus.forEach(System.out::println);
    }

    public void printEmpty() {
        System.out.println("등록된 메뉴가 없습니다. 먼저 크롤링을 실행해주세요.");
    }

    public String inputMenuName() {
        while(true) {
            System.out.print("메뉴명을 입력하세요: ");
            String input = sc.nextLine().trim();

            if(input.isEmpty()) {
                System.out.println("메뉴명을 반드시 입력해주세요!");
                continue;
            }
            return input;
        }
    }

    public void printNotFound() {
        System.out.println("해당 메뉴를 찾을 수 없습니다.");
    }

    public void printMenu(ArrayList<KyochonDTO> menus) {
        for(KyochonDTO menu : menus) {
            System.out.println("================");
            System.out.println("메뉴명 : " + menu.getMenuName());
            System.out.println("설명 : " + menu.getDescription());
            System.out.println("가격 : " + menu.getPrice());
            System.out.println("================");
        }
    }

    public void inputElse(){
        System.out.println("잘못 입력했습니다. 0~4번 사이 숫자를 입력해주세요");
    }
}
