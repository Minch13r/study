package java.day010.class01;

import java.util.Random;

class Student {
    String name; // 멤버변수
    int score; // 필드, 속성 attribute, property
    Student(){
        this.name="무명";
        this.score=0;
    }
    Student(String name){
        this.name = name;
        this.score = 0;
    }
    Student(String name, int score){
        this.name = name;
        this.score = score;
    }
    void printInfo(){ // 멤버함수, "메서드
        System.out.println("학생" + this.name + "은(는)" + this.score + " 점 입니다.");
    }
    // changeScore 함수를 불러내는게 Student라고 해서 이미 인자를 다 갖고 있어서 따로 선언 안 해도 됨.
    // 즉, 인자가 가벼워진다는 의미
    // Student 클래스 바깥이였으면 changeScore(String name) 이런식으로 불러와야 함
    void changeScore(){
        this.score = new Random().nextInt(101);
        System.out.println(this.name + " 학생의 점수가 변경되었습니다!");
    }
}

public class Test01 {
    public static void main(String[] args) {
        Student s1 = new Student("홍길동");
        Student s2 = new Student("임꺽정", 80);

        s1.printInfo();
        s2.printInfo();
    }
}
