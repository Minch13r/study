package java.day026.controller;

import java.day026.model.board.BoardDAO;
import java.day026.model.board.BoardDTO;
import java.day026.model.member.MemberDAO;
import java.day026.model.member.MemberDTO;
import java.day026.view.View;

import java.util.ArrayList;

public class Controller {
    private BoardDAO boardDAO;
    private MemberDAO memberDAO;
    private View view;
    private MemberDTO user; // 로그인 여부
    public Controller(){
        this.boardDAO = new BoardDAO();
        this.memberDAO = new MemberDAO();
        this.view = new View();
        this.user = null; // 초기에는 비로그인 상태
    }

    public void startApp(){
        while(true){
            // 로그인 확인
            if(user != null){
                view.printMenuLogin();
            }
            else {
                view.printMenuLogOut();
            }

            // 숫자 입력
            int action = view.inputAction();

            // 1. 이름 변경
            if(action==1) {
                if(user == null) {
                    continue;
                }

                String name=view.inputName();

                MemberDTO dto=new MemberDTO();
                dto.setMember_name(name); // 사용자가 입력한 이름 정보
                dto.setMember_id(user.getMember_id()); // 현재 로그인한 아이디 정보
                boolean flag=memberDAO.update(dto);
                if(flag) {
                    user=null; // 로그아웃 강제
                }
                view.printResult(flag);
            }

            // 회원탈퇴
            else if(action==2) {
                if(user == null) {
                    continue;
                }
                boolean flag=memberDAO.delete(user);
                // update 하면서 view에서 탈퇴한 회원이라고 처리
                if(flag) {
                    user=null; // 로그아웃 강제
                }
                view.printResult(flag);
            }

            // 글 작성
            else if(action == 3){
                // 로그인 한 사람만
                if(user == null){
                    view.printResult(false);
                    continue;
                }
                // View로부터 제목, 내용 입력 받기
                BoardDTO dto = view.inputBoardDTO();
                // 현재 로그인 한 사람이 제목내용을 썼다고 모델에게 알려줌
                dto.setWriter(user.getMember_id());
                // 모델에서 insert를 수행
                boolean flag = boardDAO.insert(dto);
                // 뷰로 결과 출력
                view.printResult(flag);
            }

            // 4. 글 선택
            else if(action == 4) {
                int boardNum = view.inputBoardNum();  // 사용자로부터 게시글 번호 입력받기
                BoardDTO dto = new BoardDTO();
                dto.setNum(boardNum);

                BoardDTO result = boardDAO.selectOne(dto);
                if(result != null) {
                    view.printBoard(result);
                    String ans = view.questionUpdate();
                    if(ans.equalsIgnoreCase("y")){
                        String contentAns = view.printContent();
                        dto.setContent(contentAns);
                        boolean flag = boardDAO.update(dto);
                        dto.setCondition("UPDATE");
                        view.printResult(flag);
                    }
                    else if(ans.equalsIgnoreCase("n")){
                        continue;
                    }
                    else {
                        view.printResult(false);
                    }
                } else {
                    view.printResult(false);
                }
            }


            // 5. 글 삭제
            else if(action == 5){
                if(user == null){
                    view.printResult(false);
                    continue; // 로그인하지 않은 경우 다음 반복으로
                }
                int num = view.inputBoardNum();
                BoardDTO dto = new BoardDTO();
                dto.setNum(num);
                boolean result = boardDAO.delete(dto); // BoardDTO가 아닌 boolean으로 받아야 합니다
                view.printResult(result); // 삭제 결과를 화면에 출력
            }


            // 6. 로그아웃
            else if(action == 6){
                if(user == null){
                    continue;
                }
                user = null;
            }

            // 7. 회원가입
            else if(action == 7){
                if(user != null){
                    continue;
                }
                MemberDTO memberDTO = view.inputMemberDTO();
                boolean flag = memberDAO.insert(memberDTO);
                view.printResult(flag);
            }

            // 8. 로그인
            else if(action==8) {
                if(user != null) {
                    continue;
                }

                MemberDTO memberDTO=view.login();
                MemberDTO data=memberDAO.selectOne(memberDTO);
                if(data==null) {
                    view.printResult(false);
                }
                else {
                    this.user = data;
                    this.user.setMember_password(null);
                    view.printResult(true);
                }
            }

            // 9. 목록 출력
            else if(action==9) {
                BoardDTO dto=new BoardDTO();
                dto.setCondition("SELECTALL");
                view.printDatas(boardDAO.selectAll(dto));
            }

            // 10. 검색
            else if(action==10) {
                action = view.inputAction();
                BoardDTO dto=null;
                if(action == 1) {
                    // 작성자 검색
                    String name = view.inputName();
                    dto=new BoardDTO();
                    dto.setCondition("SEARCH_WRITER");
                    dto.setWriter(name);
                }
                else {
                    // 제목 검색
                    String title = view.inputTitle();
                    dto=new BoardDTO();
                    dto.setCondition("SEARCH_TITLE");
                    dto.setTitle(title);
                }
                ArrayList<BoardDTO> datas=boardDAO.selectAll(dto);
                view.printDatas(datas);
            }

            // 11. 종료
            else if(action == 11){
                break;
            }
        }
    }
}
