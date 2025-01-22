package day016.view;

import day008.class02.Student;
import day016.model.StudentDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class View { // printMenu를 숨길 이유가 없어서 public이 붙음
    // 공통적으로 값을 가지고 있는 공유자원이기 때문에 멤버변수로 지정
    private Scanner sc;
    // new는 생성자에서 진행
    public View(){
        this.sc = new Scanner(System.in);
    }


    public int inputNum(){
        System.out.print("학생번호입력 >>");
        int num = this.sc.nextInt();
        return num;
    }

    public void printData(StudentDTO data){
        if(data == null){
            System.out.println("출력할 결과가 없습니다!");
            return;
        }
        System.out.println(data);
    }

    public String inputName() {
        System.out.print("학생이름 >>");
        String name = this.sc.next();
        return name;
    }

    public int inputScore(){
        System.out.print("학생성적 입력 >>");
        int score = this.sc.nextInt();
        return score;
    }

    public void printInsertTrue(){
        System.out.println("학생추가가 완료되었습니다!");
    }

    public void printUpdateTrue(){
        System.out.println("학생이름 변경이 완료되었습니다!");
    }

    public void printUpdateFalse(){
        System.out.println("학생이름 변경에 실패했습니다...");
    }

    public void printDeleteTrue(){
        System.out.println("학생 삭제가 완료되었습니다!");
    }

    public void printDeleteFalse(){
        System.out.println("학생 삭제가 실패했습니다...");
    }

    public void printDatas(ArrayList<StudentDTO> datas){
        if(datas==null || datas.size()<=0) {
            System.out.println("출력할 결과가 없습니다!");
            return;
        }

        for(StudentDTO v : datas){
            System.out.println(v);
        }
    }
    public void printMenu(){
        System.out.println("=== 학생부 ===");
        System.out.println("1. 학생추가");
        System.out.println("2. 전체출력");
        System.out.println("3. 학생번호로검색");
        System.out.println("4. 학생이름변경");
        System.out.println("5. 학생삭제");
        System.out.println("0. 프로그램종료");
    }
    public int inputMenuNum(){
        System.out.print("메뉴번호입력 >> ");
        int num = sc.nextInt();
        return num;
    }

    public void printShutdown() {
        for(int i=0; i<3; i++) {
            System.out.print(".");
            try {
                Thread.sleep(500);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("학생부 종료!");
        System.out.println("이용해주셔서 감사합니다.");
    }
}
