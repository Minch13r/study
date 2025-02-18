package java.day026.view;

import java.day026.model.board.BoardDTO;
import java.day026.model.member.MemberDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    private Scanner sc;
    public View() {
        this.sc = new Scanner(System.in);
    }

    public void printMenuLogin() {
        System.out.println("1. 이름변경");
        System.out.println("2. 회원탈퇴");
        System.out.println("3. 글 작성");
        System.out.println("4. 글 선택");
        System.out.println("5. 글 삭제");
        System.out.println("6. 로그아웃");
    }
    public void printMenuLogout() {
        System.out.println("7. 회원가입");
        System.out.println("8. 로그인");
        System.out.println("9. 목록출력");
        System.out.println("10. 검색");
        System.out.println("0. 프로그램 종료");
    }
    public void printDatas(ArrayList<BoardDTO> datas) {
        if(datas.isEmpty()) {
            System.out.println("검색결과가 없습니다!");
            return;
        }
        for(BoardDTO data:datas) {
            System.out.println(data);
        }
    }
    public void printData(BoardDTO data) {
        if(data == null) {
            System.out.println("검색결과가 없습니다!");
            return;
        }
        System.out.println("번호 >> "+data.getNum());
        System.out.println("제목 >> "+data.getTitle());
        System.out.println("내용 >> "+data.getContent());
        if(data.getName() == null) {
            System.out.println("작성자 >> 탈퇴한 회원이 작성한 글입니다.");
        }
        else {
            System.out.println("작성자 >> "+data.getName());
        }
        System.out.println("조회수 >> "+data.getCnt());
        System.out.println("작성일 >> "+data.getRegdate());
    }
    public String inputContent() {
        System.out.print("변경할 내용 입력 >> ");
        String content=sc.next();
        return content;
    }
    public int inputAction() {
        return sc.nextInt();
    }
    public String inputTitle() {
        System.out.print("검색할 제목 입력 >> ");
        return sc.next();
    }
    public BoardDTO inputBoardDTO() {
        System.out.print("글 제목 >> ");
        String title=sc.next();
        System.out.print("글 내용 >> ");
        String content=sc.next();
        BoardDTO dto = new BoardDTO();
        dto.setTitle(title);
        dto.setContent(content);
        return dto;
    }
    public MemberDTO inputMemberDTO() {
        System.out.print("아이디 >> ");
        String mid=sc.next();
        System.out.print("비밀번호 >> ");
        String password=sc.next();
        System.out.print("이름 >> ");
        String name=sc.next();
        MemberDTO memberDTO=new MemberDTO();
        memberDTO.setMember_id(mid);
        memberDTO.setMember_password(password);
        memberDTO.setMember_name(name);
        return memberDTO;
    }
    public MemberDTO login() {
        System.out.print("아이디 >> ");
        String mid=sc.next();
        System.out.print("비밀번호 >> ");
        String password=sc.next();
        MemberDTO memberDTO=new MemberDTO();
        memberDTO.setMember_id(mid);
        memberDTO.setMember_password(password);
        return memberDTO;
    }
    public String inputName() {
        System.out.print("이름 >> ");
        String name=sc.next();
        return name;
    }
    public void printResult(boolean flag) {
        System.out.println(flag);
    }
}
