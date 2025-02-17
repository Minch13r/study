package day026.controller;

import day026.model.BoardDAO;
import day026.model.MemberDAO;
import day026.model.MemberDTO;
import day026.view.View;

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
            if(user != null){
                view.printMenuLogin();
            }
            else {
                view.printMenuLogOut();
            }
            int action = view.inputAction();
            if(action == 1){

            }
            else if(action == 2){

            }
            else if(action == 3){

            }
            else if(action == 4){

            }
            else if(action == 5){

            }
            else if(action == 6){

            }
            else if(action == 7){
                if(user != null){
                    continue;
                }
                MemberDTO memberDTO = view.inputMemberDTO();
                boolean flag = memberDAO.insert(memberDTO);
                view.printResult(flag);
            }
            else if(action == 8){
                if(user != null){
                    continue;
                }
                MemberDTO memberDTO = view.login();
                MemberDTO data = memberDAO.selectOne(memberDTO);
                if(data == null){
                    // 로그인 실패
                    view.printResult(false);
                }
                else{
                    // 로그인 성공
                    this.user = data;
                    this.user.setMember_password(null);
                    view.printResult(true);
                }
            }
            else if(action == 9){

            }
            else if(action == 10){

            }
        }
    }
}
