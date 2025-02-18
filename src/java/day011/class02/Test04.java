package java.day011.class02;

class Point {
    int x;
    int y;

    Point(int x, int y) { // 부모에 생성자를 추가하면 자식에 에러 생김
        this.x = x;
        this.y = y;
    }
}

class ColorPoint extends Point {
    String color;

    ColorPoint() { // 기본생성자 만드니 12번 에러가 14번으로 내려옴
        /*기본 생성자를 눈에 안 보이니 12번째에 에러가 생겼던 거임
        자식 클래스의 모든 생성자는 무조건 가장 먼저 부모의 기본 생성자를 호출함
        해결 방법 1. 부모 클래스에게 기본 생성자를 선언
        (추천)   2. 자식 클래스가 부모 클래스가 가지고 있는 다른 생성자를 호출

        생성자 이슈가 상속에서 가장 중요한 이슈다!!! ★★★
        */
        super(10, 20); // 부모의 기본 생성자가 에러의 원인!!!
        // 부모의 기본 생성자가 없어서 생긴 에러임
    }
}

public class Test04 {
}
