package day009.class03;

class Student{
    String name;
    int score;
    Student(){ // 생성자는 수행결과 객체를 무조건 반환 → output 기입 X
        name = "무명"; // 생성자의 역할
        score = -1; // ===> 멤버변수를 초기화
        // 생성자 왜 써요? 멤버변수 초기화 하려고요
        System.out.println("기본생성자가 호출됨");
    }
    Student(String n){ // 생성자 오버로딩
        name = n;
        score = -1;
        System.out.println("생성자가 호출됨");
    }
    // 함수명은 같지만 인자가 다르니 사용이 가능하다. 이를 생성자 오버로딩이라고 한다.
}

public class Test01 {
    public static void main(String[] args) {
        // 학생 1명 생성
        Student stu = new Student("홍길동");
        // new 연산자
        // Student() 생성자 : 클래스와 이름이 동일한 함수
        // 객체 생성 == 객체화(인스턴스화)
        // 통칭은 Object가 맞는데 피카츄, 럭스 이런 실제 애들은 instance라고 함

        // 1명에게 이름, 성적을 부여
//        stu.name = "홍길동";
//        stu.score = 98;

        // 화면에 출력
        System.out.println(stu.name + " 학생은 " + stu.score + "점 입니다.");
    }
}
