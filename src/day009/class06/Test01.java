package day009.class06;
/*1) 원 클래스를 선언해주세요
	   원 객체들은 이름과 반지름, 넓이를 가집니다.
	   넓이는 반지름 x 반지름 x 3.14로 계산합니다.
	   예를 들어,
	   도넛은(는) 반지름이 1입니다. 도넛의 넓이는 3.14입니다.
	   피자은(는) 반지름이 10입니다. 피자의 넓이는 314.0입니다.
	   */
class Circle{
    String name;
    int radius;
    double extent; // 멤버변수에서 절대 값 대입을 하면 안 됨.
    Circle(String name, int radius){
        this.name = name;
        this.radius = radius;
        this.extent = this.radius * this.radius * 3.14;
        // radius * radius보다 this.를 붙이는게 의미에 더 알맞음
        // this.는 '내' 반지름을 의미하는거기 때문.
    }
    void printCircleInfo() { // 클래스에서는 이렇게 함수 만든다. public static 이런거 아님.
        //공개 범위 맞춰줘서 public X, 객체이기에 static X
        System.out.println("원 이름 : " + this.name);
        System.out.println("반지름 : " + this.radius);
        System.out.println("넓이 : " + this.extent);
    }
}
public class Test01 {
    public static void main(String[] args) {
        Circle circle01 = new Circle("도넛", 1);
        Circle circle02 = new Circle("피자", 10);

        // 완벽하고 전형적인 OOP
        // 자기것만 출력하도록 하는 것.
        circle01.printCircleInfo();
        circle02.printCircleInfo();
//        System.out.println(circle01.name + "은(는) 반지름이 " + circle01.radius + "입니다." + circle01.name + "의 넓이는 " + circle01.extent + "입니다.");
//        System.out.println(circle02.name + "은(는) 반지름이 " + circle02.radius + "입니다." + circle02.name + "의 넓이는 " + circle02.extent + "입니다.");
    }
}
