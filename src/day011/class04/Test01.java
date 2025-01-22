package day011.class04;

// [ Object ]
// : JAVA의 최상위 클래스
// JAVA에서 선언 및 생성하는 모든 클래스는 Object를 상속받는다.

class Student extends Object{ // extends Object는 가려진 코드임 원래 있던거
    String name;
    int score;

    @Override
    public String toString(){
        return this.name + "학생입니다.";
    }
}

public class Test01 {
    public static void main(String[] args) {
        Student s = new Student();
        System.out.println(s.toString());
        // s만 넣으면 해쉬값만 나오는데 왜냐하면 toString이 자동적으로 호출
    }
}
