package day016.controller;

import day016.model.StudentDAO;
import day016.model.StudentDTO;
import day016.view.View;

import java.util.ArrayList;

public class Controller {
    // model 불러오기
    private StudentDAO model;
    // view 불러오기
    private View view;
    // 학생 번호
    private int NUM;
    // 생성자
    public Controller(){
        this.model = new StudentDAO();
        this.view = new View();
        this.NUM = 1004; // 1003번까지 추가돼서 1004번를 기본 설정
    }

    // App 시작 Controller
    public void startApp(){
        // 무한루프, 언제까지 제대로 된 입력을 할지 모르기 때문
        while(true){
            // 학생부 메뉴 보여주는 메서드
            this.view.printMenu();
            // 스캐너로 입력받은 값을 menuNum으로 넘겨주는 메서드
            int menuNum = this.view.inputMenuNum();

            // 프로그램 종료
            if(menuNum == 0){
                // 종료시키는 메서드
                this.view.printShutdown();
                // 종료되면 학생부 프로그램 나가야함.
                break;
            }

            // 학생추가
            else if (menuNum==1) {
                // 학생 이름 입력받고 반환한 값을 name에다가 저장
                String name = this.view.inputName();
                // 점수 입력받고 받환한 값을 score에다가 저장
                int score = this.view.inputScore();
                // 이름, 점수 입력받고 번호는 1004번부터 상승
                boolean flag = this.model.insert(name, score, this.NUM++);

                // flag가 true면 생성에 성공했다고 로그 출력
                if(flag){
                    this.view.printInsertTrue();
                }
            }

            // 전체출력
            else if (menuNum==2) {
                // 전체 다 출력하는 메서드
                ArrayList<StudentDTO> datas = this.model.selectAll();
                // model에서 selectAll로 갖고오고 view로 보여줌
                this.view.printDatas(datas);
            }

            // 학생번호로검색
            else if (menuNum==3) {
                // 입력받은 숫자를 반환한 값을 num에 넣어줌
                int num = this.view.inputNum();
                // model에서 selectOne으로 하나만 갖고옴
                StudentDTO data = this.model.selectOne(num);
                // view로 model에서 갖고온거 출력
                this.view.printData(data);
            }

            // 학생이름변경
            else if (menuNum==4) {
                /*사용자에게 번호받아서
                * 해당번호의 학생 새로운 이름 받고 변경한 후에 변경완료 화면 띄우기*/
                int num = this.view.inputNum();
                String name = this.view.inputName();
                // 수정 메서드인데 model에서 true/false 중 하나를 입력받아서 저장
                boolean flag = this.model.update(num, name);

                if(flag){ // true면 성공
                    this.view.printUpdateTrue();
                } else { // false면 실패
                    this.view.printUpdateFalse();
                }
            }

            // 학생삭제
            else if (menuNum==5) {
                // view를 통해 숫자를 입력받음
                int num = this.view.inputNum();
                // model을 통해 true/false 반환
                boolean flag = this.model.delete(num);

                if(flag){ // true면 삭제 성공
                    this.view.printDeleteTrue();
                } else { // false 삭제 실패
                    this.view.printDeleteFalse();
                }
            }
        }
    }
}
