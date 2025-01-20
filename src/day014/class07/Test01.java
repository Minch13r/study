package day014.class07;

/*class Point
   int x
   int y
class ColorPoint extends Point
   String color

Point() ▶ (0,0)
Point(1,2) ▶ (1,2)
ColorPoint() ▶ 검정(0,0)
ColorPoint(1,2) ▶ 검정(1,2)
ColorPoint(분홍) ▶ 분홍(0,0)
ColorPoint(1,2,분홍) ▶ 분홍(1,2)

모든 점 객체들을 저장할 수 있는 리스트에 임의로 10개의 점 객체들을 저장해주세요.

점들은 좌표가 같다면 같은 점으로 판단합니다.

[0]에 저장된 점과 같은 점은 몇개인지 출력해주세요.

색을 사용자에게 입력받아서
같은 색의 점이 몇개 존재하는지 출력해주세요.

+++) 이 문제를 map 을 활용해서 해결해주세요.
점들에게 번호를 1001번부터 순차적으로 부여합니다.
*/


import java.util.*;

/*
* Point 클래스 생성, 멤버변수 x,y 설정
* 생성자 인자 두개 다 있는거랑 없는거 오버로딩 진행
*/
class Point {
    int x;
    int y;

    Point() {
        this(0, 0);
    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }

    @Override
    public boolean equals(Object obj) {  // Object 타입의 매개변수
        // 자기 자신과 비교할 때
        if (this == obj) {
            return true;
        }
        // null이거나 다른 클래스인 경우
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        // Point로 형변환
        Point point = (Point) obj;
        // x와 y 좌표가 모두 같은지 비교
        return x == point.x && y == point.y;
    }
}

/* colorPoint 클래스 생성, 멤버변수 color 설정
 * 생성자 인자 여러개 오버로딩 해야 할 것 같음 상황에 맞게*/
class ColorPoint extends Point {
    String color;

    public ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    public ColorPoint() {
        this(0, 0, "검정");
    }
    public ColorPoint(int x, int y) {
        this(x, y, "검정");
    }
    public ColorPoint(String color) {
        this(0, 0, color);
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "ColorPoint{" + "color='" + color + '\'' + '}';
    }
}

/*
* Point 클래스 관련 리스트 선언
* HashMap으로 번호랑 포인트 매핑
* 임의의 점 10개 만들고 Arraylist랑 HashMap에 저장
* [0]에 저장된 점과 같은 점 몇개인지 찾아야 함
* get(0)으로 기본값 세팅하고 equals 써서 똑같은 점 찾고
* 변수 따로 둬서 찾을 때마다 카운트 한개씩 올려서 카운트 수 출력
* 색깔은 scanner로 색 입력받아서 위에랑 같이 equals 써서 찾기*/
public class Test01 {
    public static void main(String[] args) {
        // Point 클래스 관련 리스트
        ArrayList<Point> points = new ArrayList<>();

        // 번호랑 점 매핑
        Map<Integer, Point> map = new HashMap<>();

        // 10개의 점 임의로 생성 및 저장
        points.add(new Point(0, 0));
        points.add(new ColorPoint(1, 2, "분홍"));
        points.add(new Point(0, 0));
        points.add(new ColorPoint(3, 4, "파랑"));
        points.add(new ColorPoint(0, 0, "검정"));
        points.add(new ColorPoint(5, 6, "분홍"));
        points.add(new Point(3, 8));
        points.add(new ColorPoint(9, 10, "파랑"));
        points.add(new Point(1, 9));
        points.add(new ColorPoint(7, 3, "분홍"));

        // Map에 점들 저장 (1001번부터 번호 부여)
        for (int i = 0; i < points.size(); i++) {
            map.put(1001 + i, points.get(i));
        }

        // [0]에 저장된 점과 같은 점 개수 찾기
        // 지정 안 됨 issue
        Point point = points.get(0);
        int cnt = 0; // 카운트 0으로 초기화
        for (Point p : points) {
            if (p.equals(point)) { // point와 같은 점 찾을 때마다
                cnt++; // 카운트 개수 1개씩 증가
            }
        }
        System.out.println("[0]에 저장된 점과 같은 좌표를 가진 점의 개수: " + cnt);

        // 스캐너 객체 생성
        Scanner scanner = new Scanner(System.in);
        System.out.print("찾고 싶은 색상을 입력하세요: ");
        // 스캐너로 색상 입력받기
        String color = scanner.nextLine();

        // 같은색 카운트 변수
        int pointCnt = 0;
        for (Point p : points) {
            try {
                //point 타입으로는 getColor를 쓸 수 없어서
                // 기존 Point 타입의 p를 ColorPoint로 형변환
                ColorPoint cp = (ColorPoint) p;  // 형변환
                if (cp.getColor().equals(color)) { // 같은거 찾으면
                    pointCnt++; // 카운트 향상
                }
            } catch (Exception e) {
                continue;  // 가독성 향상
            }
        }
        System.out.println("입력한 색상을 가진 점의 개수: " + pointCnt);
    }
}
