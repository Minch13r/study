package javastudy.day014.class04;

/*
 * 원을 생성하기 위해서는 이름과 반지름이 반드시 필요합니다.
 * 캡슐화를 수행해주세요.
 * 원 객체를 3개 생성하여 리스트에 저장해주세요
 * 리스트에서 가장 넓이가 큰 원의 이름을 출력해주세요.
 * 단, 원의 넓이가 나중에 저장된 원이 출력되도록 해주세요
 *
 * +++) 원 객체들은 이름이 같다면 반지름이 달라도 같은 객체로 인정
 * 이름을 사용자에게 입력받아, 같은 객체의 개수를 세어 출력해주세요(오버라이딩 사용)
 * */

import java.util.ArrayList;

// 캡슐화는 private로 진행, 생성자, getter, setter 만들기
// 파이는 상수화 하고 생성자엣서 넓이는 반지름^2 * PI로 진행
class Circle {
    private String name;
    private int radius;
    private double area;
    private static final double PI = 3.14;

    //생성자
    Circle(String name, int radius) {
        this.name = name;
        this.radius = radius;
        this.area = this.radius * this.radius * Circle.PI;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        this.area = PI * radius * radius;
    }

    public double getArea() {
        return this.area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "name='" + this.name + '\'' +
                ", radius=" + this.radius +
                ", area=" + this.area +
                '}';
    }
}

public class Test01 {
    public static void main(String[] args) {
        /* 원 생성한거 받을 리스트 생성
        arraylist~~
         * 원 3개 생성해서 리스트에 추가
         * new circle 3개
         * 가장 큰 넓이를 가진 원 기본값 설정
         * 변수 하나 생성하고 datas의 0번째를 기본값으로 설정
         * 처음부터 하나씩 상승하면서 비교할 예정
         * 넓이 계산해서 가장 넓이가 큰 원 찾고 이름 출력
         * getter로 값 갖고 와서 찾는게 제일 베스트
         * 원의 넓이가 똑같을 때, 인덱스 뒤에 번호꺼를 출력
         * 뒤에서부터 검사하면 될 것 같음.*/

        // 원 받을 리스트 생성, 제네릭은 Circle로 지정
        ArrayList<Circle> datas = new ArrayList<>();

        // 원 이름과 반지름 길이 다르게 해서 생성
        datas.add(new Circle("A", 5));
        datas.add(new Circle("B", 9)); // B와 C 반지름 같게 설정
        datas.add(new Circle("C", 9));

        Circle maxArea = datas.get(0); //기본값 설정

        // datas.size()로 크기 설정하고 -1까지 해서 우리가 원하는 수로 지정
        // 넓이가 동일했을 때 나중에 저장된 원이 출력되도록 하는데, for문으로 돌리다 보면
        // 넓이가 동일해도 나중에 있는게 저장돼서 나옴
        for (int i = 0; i <= datas.size() - 1; i++) {
            if (datas.get(i).getArea() >= maxArea.getArea()) { // 넓이가 기본값보다 크면
                maxArea = datas.get(i); // 치환
            }
        }
        System.out.println("가장 큰 원의 이름: " + maxArea.getName()); // 가장 큰 원 이름 불러오기

    }

}
