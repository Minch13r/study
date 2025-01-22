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
                // 현재 등록된 학생 수를 기반으로 최대 번호 계산
                ArrayList<StudentDTO> datas = this.model.selectAll();
                int maxNum = datas.size() + 1001;
                // maxNum을 View에 전달
                int num = this.view.inputNum(maxNum);
                StudentDTO data = this.model.selectOne(num);
                this.view.printData(data);
            }

            // 학생이름변경
            else if (menuNum==4) {
                // 학생 이름 변경하기 전에 리스트 안에 학생이 있는지 먼저 파악
                ArrayList<StudentDTO> datas = this.model.selectAll();

                if(datas.isEmpty()) {  // 학생 데이터가 하나도 없는 경우
                    this.view.printNoStudent();  // "등록된 학생이 없습니다. 학생을 먼저 추가해주세요."
                    continue;  // while문의 처음으로 돌아감
                }

                /*사용자에게 번호받아서
                * 해당번호의 학생 새로운 이름 받고 변경한 후에 변경완료 화면 띄우기*/
                // 현재 등록된 학생 수를 기반으로 최대 번호 계산
                int maxNum = datas.size() + 1001;
                // maxNum을 View에 전달
                int num = this.view.inputNum(maxNum);
                String name = this.view.inputName();
                // 수정 메서드인데 model에서 true/false 중 하나를 입력받아서 저장
                boolean flag = this.model.update(num, name);

                if(flag){ // true면 성공
                    this.view.printUpdateTrue();
                } else { // false면 실패
                    this.view.printErrInfo();
                    this.view.printUpdateFalse();
                }
            }

            // 학생삭제
            else if (menuNum==5) {
                // 현재 등록된 학생 수를 기반으로 최대 번호 계산
                ArrayList<StudentDTO> datas = this.model.selectAll();
                int maxNum = datas.size() + 1001;
                // maxNum을 View에 전달
                int num = this.view.inputNum(maxNum);
                // model을 통해 true/false 반환
                boolean flag = this.model.delete(num);

                if(flag){ // true면 삭제 성공
                    this.view.printDeleteTrue();
                } else { // false 삭제 실패
                    this.view.printErrInfo();
                    this.view.printDeleteFalse();
                }
            }

            // 학생 성적 변경 기능
            else if (menuNum==6){
                // 학생 리스트가 비어있는지 먼저 확인
                ArrayList<StudentDTO> datas = this.model.selectAll();

                // 학생이 아무도 없으면
                if(datas.isEmpty()) {
                    // 학생 없다고 출력 후 while문 다시 반복시키기
                    this.view.printNoStudent();
                    continue;
                }

                // model에서 selectAll로 갖고오고 view로 보여줌
                this.view.printDatas(datas);

                while(true) {
                    int maxNum = datas.size() + 1001;
                    // maxNum을 View에 전달
                    int num = this.view.inputNum(maxNum);
                    // num 유효성 검사
                    if (num >= datas.size()+1001 && num < datas.size()) {
                        this.view.printNoStudentNum();
                        continue;
                    }
                    // 새로운 성적 입력받기
                    int score = this.view.inputScore();
                    // 성적 변경 시도
                    boolean flag = this.model.update(num, score);

                    // true면 성적 변경 성공 메서드 출력
                    if (flag) {
                        this.view.printUpdateScoreTrue();
                        break;
                    } else {
                        // false면 성적 변경 실패 메서드 출력
                        this.view.printErrInfo();
                        this.view.printUpdateScoreFalse();
                        break;
                    }
                }
            }

            // 학생 이름 검색 기능
            else if (menuNum == 7){
                // View를 통해서 이름 입력받고
                // Model을 통해 해당하는 이름이 있는지 검색
                // 다시 View를 통해서 해당 학생 정보 출력
                String name = this.view.inputName();
                ArrayList<StudentDTO> datas = this.model.selectAll(name);
                this.view.printDatas(datas);
            }
        }
    }
}
