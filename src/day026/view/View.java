package day026.view;

import day026.model.BoardDTO;
import day026.model.MemberDTO;
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

    public MemberDTO inputMemberDTO(){
        System.out.print("아이디 >>");
        String mid = sc.next();
        System.out.print("비밀번호 >>");
        String password = sc.next();
        System.out.print("이름 >>");
        String name = sc.next();
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMember_id(mid);
        memberDTO.setMember_password(password);
        memberDTO.setMember_name(name);
        return memberDTO;
    }

    public void printResult(boolean flag){
        System.out.println(flag);
    }

    public MemberDTO login() {
        System.out.print("아이디 >>");
        String mid = sc.next();
        System.out.print("비밀번호 >>");
        String password = sc.next();
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMember_id(mid);
        memberDTO.setMember_password(password);
        return memberDTO;
    }

    public MemberDTO inputNewName() {
        MemberDTO memberDTO = new MemberDTO();
        System.out.print("변경할 이름을 입력하세요 >> ");
        String newName = sc.next();
        memberDTO.setMember_name(newName);
        return memberDTO;
    }

    public BoardDTO inputBoardDTO(){
        System.out.print("글 제목 >>");
        String title = sc.next();
        System.out.print("글 내용 >>");
        String content = sc.next();
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setTitle(title);
        boardDTO.setContent(content);
        return boardDTO;
    }

}
