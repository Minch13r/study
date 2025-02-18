package java.day010.class01;

class Circle{
    String name;
    int radius;
    double area;
    static double PI=3.14; // 클래스 변수, static이 붙은 이뉴는 Circle 객체와 관련X
    // PI는 3.14 즉, 원주율이기 때문에 객체와는 관련이 없는거임
    // 객체가 생길 때 생기는게 아니라 원이 생길 때 생기는거라서 static이 붙는다고 생각하면 됨
    Circle(String name, int radius){
        this.name = name;
        this.radius = radius;
        this.area = this.radius * this.radius * Circle.PI;
    }
    void printInfo(){
        System.out.println(this.name + "은(는) " + this.area + "입니다.");
    }
}

public class Test04 {
    public static void main(String[] args) {
        Circle c1 = new Circle("도넛", 1);
        Circle c2 = new Circle("피자", 10);
        c1.printInfo();
        c2.printInfo();
    }
}
