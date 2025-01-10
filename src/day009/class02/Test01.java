package day009.class02;

import day008.class02.Student;

import java.util.Random;

// 자바에서 Class(클래스)란, 기본단위를 의미(더 이상 나눠지지 않는 원자 같은 단위)
// 클래스 : 객체들을 생성하기 위한 틀
// 클래스 예시) 포켓몬, 학생, 자동차, 챔피언
// 객체 : 클래스를 통해 생성된 것
// 객체 예시) 피카츄, 파이리, 홍길동

// 학생의 이름, 나이, 성적, 주소, 학번, ... 등을 저장하고 싶을 때
// "학생"이란 '자료형'을 만들면 좋겠구나!!
//class Student { // 클래스 선언 == 자료형을 만드는 행위
//    String name; // 멤버 변수
//    int age;
//    int score;
//    String addr;
//    int num;
//}
//public class Test01 {
//    public static void main(String[] args) {
//        // 정수 변수 선언
//        int num = 10;
//
//        // 배열 선언
//        int[] datas = new int[10];
//
//        // 랜덤 '객체' 선언
//        Random rand = new Random(); // new는 개발자영역 메모리
//
//        // 클래스명 객체명 선언
//        Student hong = new Student(); // heap 메모리 영역에 생성되고, hash 값으로 주소 저장
//        System.out.println(hong);
//        System.out.println(hong.name); // . -> 포인터 개념
//        // 개발자 영역에 생성되면 초기화하지 않아도 자동적으로 초기화 됨.
//        System.out.println(hong.age); // 멤버접근연산자
//    }
//}