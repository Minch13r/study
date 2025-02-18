package javastudy.day010.class01;

class Point{
    int x;
    int y;
    Point() {
        this(0,0); // 자기자신 객체를 가르킴. 자신과 똑같은 이름을 가진 함수를 불러냄
        // this()는 생성자가 되는거임
        // this.멤버변수 이거는 멤버변수 접근 연산자
        System.out.println("강아지");
    }
    Point(int x){ // 인자가 가장 많은 생성자를 재사용
        this(x,x);
        // 이미 만둘어둔 생성자를 호출하기는 하는데 앞에 있는게 없는 경우 0 적으면 됨
        System.out.println("고양이");
    }
    Point(int x, int y){ // 가장 인자가 많은 생성자 먼저 구현
        this.x = x;
        this.y = y;

        System.out.println("카피바라");
    }
}
public class Test02 {
    public static void main(String[] args) {
        Point p1 = new Point(1,2);
        Point p2 = new Point(1); // 12, 13, 17, 18, 19, 21, 15 순서
        Point p3 = new Point(); // 6, 7, 17, 21, 13, 15, 10 순서
    }
}
