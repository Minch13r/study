package javastudy.day011.class03;

class Shape {
    String name;
    double area;
    Shape(String name){
        this.name = name;
        this.area = 0.0;
    }
    void draw(){
        System.out.println("모양대로 그림그리기");
    }
}

class Rect extends Shape {
    int x;
    int y;
    Rect(int x){
        this(x,x);
    }

    Rect(int x, int y){
        super("사각형");
        this.x = x;
        this.y = y;
    }

    @Override
    void draw(){
        System.out.println("사각형 그림 그리기");
    }
}

class Circle extends Shape {
    int radius;
    static final double PI=3.14;
    Circle(int radius){
        super("원");
        this.radius = radius;
        this.area = this.radius * this.radius * Circle.PI;
    }
    @Override
    void draw(){
        System.out.println("원 그림 그리기");
    }
}
public class Test02 {
}
