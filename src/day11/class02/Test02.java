package day11.class02;

class Circle{
    private String name;
    private int radius;
    double area;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
        this.area = this.radius * this.radius * 3.14;
    }

    public double getArea() {
        return area;
    }
    public void setArea(double area) {
        this.area = area;
    }


    Circle(String name, int radius){
        this.name = name;
        this.radius = radius;
        this.area=this.radius*this.radius*3.14;
    }
}
public class Test02 {
    public static void main(String[] args) {
        // 1. 원 전체출력
        // 2. 원 1개 선택 반지름 바꾸고
        //    넓이 바뀐 것 확인

        Circle[] datas = new Circle[2];
        datas[0] = new Circle("도넛",1);
        datas[1] = new Circle("피자", 10);

        for(int i=0; i<datas.length; i++){
            System.out.println(datas[i].getName() + " " + datas[i].getArea());
        }

        int num = 1;
        datas[num-1].setRadius(100);
        System.out.println(datas[num-1].getArea());
    }
}
