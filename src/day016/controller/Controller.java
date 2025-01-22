package day016.controller;

import day016.model.StudentDAO;
import day016.model.StudentDTO;
import day016.view.View;

import java.util.ArrayList;

public class Controller {
    private StudentDAO model;
    private View view;
    public Controller(){
        this.model = new StudentDAO();
        this.view = new View();
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void startApp(){
        while(true){
            this.view.printMenu();
            int menuNum = this.view.inputMenuNum();
            if(menuNum == 0){
                this.view.printShutdown();
                break;
            } else if (menuNum==1) {

            } else if (menuNum==2) {
                ArrayList<StudentDTO> datas = this.model.selectAll();
                this.view.printDatas(datas);
            } else if (menuNum==3) {

            } else if (menuNum==4) {

            } else if (menuNum==5) {

            }
//            else {
//                System.out.println("잘못된 입력입니다!!"); // 이거는 View 역할이라서 여기에 넣으면 안 됨
//                // MVC를 정확히 구분할 줄 알아야 함
//            }
        }
    }
}
