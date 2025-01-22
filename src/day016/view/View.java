package day016.view;

import day008.class02.Student;
import day016.model.StudentDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class View { // printMenu를 숨길 이유가 없어서 public이 붙음
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
        Scanner sc = new Scanner(System.in);
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
