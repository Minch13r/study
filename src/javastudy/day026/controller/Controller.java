package javastudy.day026.controller;

import javastudy.day026.model.board.BoardDAO;
import javastudy.day026.model.board.BoardDTO;
import javastudy.day026.model.member.MemberDAO;
import javastudy.day026.model.member.MemberDTO;
import javastudy.day026.view.View;

import java.util.ArrayList;

public class Controller {
    private BoardDAO boardDAO;
    private MemberDAO memberDAO;
    private View view;
    private MemberDTO user; // 로그인 여부
    public Controller() {
        this.boardDAO = new BoardDAO();
        this.memberDAO = new MemberDAO();
        this.view = new View();
        this.user = null; // 초기에는 비로그인 상태
    }

    public void startApp() {
        while(true) {
            if(user != null) { // 로그인 상태라면
                view.printMenuLogin();
            }
            else {
                view.printMenuLogout();
            }
            int action=view.inputAction();
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
            else if(action==2) {
                if(user == null) {
                    continue;
                }

                BoardDTO dto=new BoardDTO();
                dto.setCondition("UPDATE_DELETEMEMBER");
                dto.setWriter(user.getMember_id());
                boardDAO.update(dto);
                boolean flag=memberDAO.delete(user);
                if(flag) {
                    user=null; // 로그아웃 강제
                }
                view.printResult(flag);
            }
            else if(action==3) {
                if(user == null) {
                    continue;
                }

                BoardDTO dto=view.inputBoardDTO();
                dto.setWriter(user.getMember_id());
                boolean flag=boardDAO.insert(dto);
                view.printResult(flag);
            }
            else if(action==4) {
                if(user == null) {
                    continue;
                }

                int num = view.inputAction();
                BoardDTO dto=new BoardDTO();
                dto.setNum(num);
                BoardDTO data=boardDAO.selectOne(dto);
                view.printData(data);

                if(data.getWriter().equals(user.getMember_id())) { // 본인인증
                    String content=view.inputContent();
                    dto=new BoardDTO();
                    dto.setNum(num);
                    dto.setContent(content);
                    dto.setCondition("UPDATE");
                    boolean flag=boardDAO.update(dto);
                    view.printResult(flag);
                }
            }
            else if(action==5) {
                if(user == null) {
                    continue;
                }

                int num = view.inputAction();
                BoardDTO dto=new BoardDTO();
                dto.setNum(num);
                boolean flag=boardDAO.delete(dto);
                view.printResult(flag);
            }
            else if(action==6) {
                if(user == null) {
                    continue;
                }

                user=null;
            }
            else if(action==7) {
                if(user != null) {
                    continue;
                }

                MemberDTO memberDTO=view.inputMemberDTO();
                boolean flag=memberDAO.insert(memberDTO);
                view.printResult(flag);
            }
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
            else if(action==9) {
                BoardDTO dto=new BoardDTO();
                dto.setCondition("SELECTALL");
                view.printDatas(boardDAO.selectAll(dto));
            }
            else if(action==10) {
                action = view.inputAction();
                BoardDTO dto=null;
                if(action == 1) {
                    // 작성자 검색
                    String name = view.inputName();
                    dto=new BoardDTO();
                    dto.setCondition("SEARCH_WRITER");
                    dto.setSearchKeyword(name);
                }
                else {
                    // 제목 검색
                    String title = view.inputTitle();
                    dto=new BoardDTO();
                    dto.setCondition("SEARCH_TITLE");
                    dto.setSearchKeyword(title);
                }
                ArrayList<BoardDTO> datas=boardDAO.selectAll(dto);
                view.printDatas(datas);
            }
            else {
                break;
            }
        }
    }
}
