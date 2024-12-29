package day002.class01;

import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        // 제어문
        // 1. 조건문 2. 반복문
        // if - else if - else

        Scanner scanner = new Scanner(System.in); //scanner 객체 생성
        System.out.println("나이를 입력하세요 : "); //나이 입력하기
        int age = scanner.nextInt(); //scanner nextInt로 정수값 입력받기

        if(age<1 || age >120){ // 유효성 검사(1세 미만 혹은 120세를 초과하는 경우에는 유효하지 않음)
            System.out.println("올바른 나이를 입력했는지 확인해주세요!");
        } else if (age < 14) { // 14세 미만인 경우에는 어린이 회원으로 분류
            System.out.println("어린이 회원입니다");
        } else if (age < 20) { // 14세 이상 20세 미만인 경우에는 청소년 회원으로 분류
            System.out.println("청소년 회원입니다.");
        } else {
            System.out.println("성인 회원입니다.");
        }

        scanner.close(); //scanner 닫기
    }
}
