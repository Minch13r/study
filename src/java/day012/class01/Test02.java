package java.day012.class01;

class Point {
    int x;
    Point(){
        this.x=10;
    }
    void printInfo(){
        System.out.println("점 ("+this.x+")");
    }
}

class ColorPoint extends Point {
    String color;
    ColorPoint(String color){
        // super;
        // 부모에게 이미 생성자가 있었기 때문에
        // 자식한테는 생성자를 안 넣어도 자동으로 호출되기 때문에
        // 생성자를 따로 생성하지 않아도 된다.
        this.color = color;
    }

    @Override
    void printInfo() {
        System.out.println(this.color+"점 ("+this.x+")");
    }
}


public class Test02 {
    public static void main(String[] args) {
        ColorPoint cp = new ColorPoint("분홍");
        cp.printInfo(); // 동적바인딩(자동으로 연결한다는 내용) -----> 다형성이 실현된다!
        // 오버라이딩 된 메소드를 호출하는 것이 동적바인딩
        // 오버라이딩은 부모에 있던거를 마음에 안 들어서 자식 위치에서 바꾼다고 생각하면 편함
    }
}
