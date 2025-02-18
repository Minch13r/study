package day026.view;

import day026.model.board.BoardDTO;
import day026.model.member.MemberDTO;

import java.util.ArrayList;
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

    public String inputName() {
        System.out.print("이름 >> ");
        String name=sc.next();
        return name;
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

    public void printBoardAllList(ArrayList<BoardDTO> datas) {
        System.out.println("=== 게시글 목록 ===");
        System.out.println("번호\t제목\t작성자\t조회수\t작성일");
        System.out.println("=====================================");
        for(BoardDTO data : datas) {
            System.out.println(data.getNum() + "\t" +
                    data.getTitle() + "\t" +
                    data.getWriter() + "\t" +
                    data.getCnt() + "\t" +
                    data.getRegdate());
        }
        System.out.println("=====================================");
    }


    public int inputBoardNum() {
        System.out.print("숫자 입력 >>");
        int boardNum = sc.nextInt();
        return boardNum;
    }

    public void printBoard(BoardDTO board) {
        System.out.println("=== 게시글 상세 보기 ===");
        System.out.println("번호: " + board.getNum());
        System.out.println("제목: " + board.getTitle());
        System.out.println("작성자: " + board.getWriter());
        System.out.println("내용: " + board.getContent());
        System.out.println("조회수: " + board.getCnt());
        System.out.println("작성일: " + board.getRegdate());
        System.out.println("=====================");
    }

    public String questionUpdate() {
        System.out.println("수정하시겠습니까?(Y/N)");
        String ans = sc.next();
        return ans;
    }

    public String inputTitle() {
        System.out.print("검색할 제목을 입력해주세요 >>");
        return sc.next();
    }

    public void printDatas(ArrayList<BoardDTO> datas) {
        if(datas.size() <= 0) {
            System.out.println("검색결과가 없습니다!");
            return;
        }
        for(BoardDTO data : datas) {
            System.out.println(data);
        }
    }
}
