package day016.controller;

import day016.model.StudentDAO;
import day016.model.StudentDTO;
import day016.view.View;

import java.util.ArrayList;

public class Controller {
    private StudentDAO model;
    private View view;
    private int NUM;
    public Controller(){
        this.model = new StudentDAO();
        this.view = new View();
        this.NUM = 1004;
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

            // 프로그램 종료
            if(menuNum == 0){
                this.view.printShutdown();
                break;
            }

            // 학생추가
            else if (menuNum==1) {
                String name = this.view.inputName();
                int score = this.view.inputScore();
                boolean flag = this.model.insert(name, score, this.NUM++);

                if(flag){
                    this.view.printInsertTrue();
                }
            }

            // 전체출력
            else if (menuNum==2) {
                ArrayList<StudentDTO> datas = this.model.selectAll();
                this.view.printDatas(datas);
            }

            // 학생번호로검색
            else if (menuNum==3) {
                int num = this.view.inputNum();
                StudentDTO data = this.model.selectOne(num);
                this.view.printData(data);
            }

            // 학생이름변경
            else if (menuNum==4) {
                /*사용자에게 번호받아서
                * 해당번호의 학생 새로운 이름 받고 변경한 후에 변경완료 화면 띄우기*/
                int num = this.view.inputNum();
                String name = this.view.inputName();
                boolean flag = this.model.update(num, name);

                if(flag){
                    this.view.printUpdateTrue();
                } else {
                    this.view.printUpdateFalse();
                }
            }

            // 학생삭제
            else if (menuNum==5) {
                int num = this.view.inputNum();
                boolean flag = this.model.delete(num);

                if(flag){
                    this.view.printDeleteTrue();
                } else {
                    this.view.printDeleteFalse();
                }
            }
        }
    }
}
