package javastudy.day009.class03;

class Point {
    int x;
    int y;
    Point(){
        System.out.println("점 객체가 생성되었습니다.");
    }
}

public class Test02 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        Point point01 = new Point(); //point1과 point2는 주소가 다르다
        Point point02 = new Point(); //point1이 움직였다고 해서 point2도 같이 움직이지 않는다.

        point02.x = 10;
        point02.y = 20;

        System.out.println("점 01은 (" + point01.x + "," + point01.y + ")입니다.");
        System.out.println("점 02는 (" + point02.x + "," + point02.y + ")입니다.");
    }
}
