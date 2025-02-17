package day026.view;

import org.openqa.selenium.json.JsonOutput;

import java.util.Scanner;

public class View {
    private Scanner sc;
    public View() {
        this.sc = new Scanner(System.in);
    }

    public void printMenuLogin(){
        System.out.println("1. 이름변경");
        System.out.println("2. 회원탈퇴");
        System.out.println("3. 글 작성");
        System.out.println("4. 글 선택");
        System.out.println("5. 글 삭제");
        System.out.println("6. 로그아웃");
    }
    public void printMenuLogOut(){
        System.out.println("7. 회원가입");
        System.out.println("8. 로그인");
        System.out.println("9. 목록출력");
        System.out.println("10. 검색");
        System.out.println("11. 프로그램 종료");
    }
    public int inputAction(){
        return sc.nextInt();
    }
}
