package javastudy.day013.class01;

// "추상화"
// 추상 클래스 : 객체를 생성하지 않는 클래스
//           : 클래스들을 정의하는 추상 클래스
//           : 자식 클래스들의 공통점을 정의해두는 설계용 클래스

abstract class Pokemon {
    abstract void hello(); // 추상 메서드
    // : 오버라이딩 강제, 자유도가 낮으면 개발자에게 좋음
    // : 오직 추상 클래스만이 추상 메서드를 가질 수 있음!!
}

class Pikachu extends Pokemon {
    @Override
    void hello(){
        System.out.println("피카피카");
    }
}

class Person {
    // 주민
}

class Dog extends Person {
    // 강아지 주민
}

public class Test01 {
    // Pokemon p = new Pokemon();
    // 추상 클래스로는 인스턴스화(객체화) xxx
    // 실수로 객체를 만드는 것을 방지하는 역할
    // 또한 설계용임을 개발자에게 알리는 역할을 한다.
    public static void main(String[] args) {

    }
}
