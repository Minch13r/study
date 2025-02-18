package java.day011.class02;

// [ 상속 ]
class Animal { // 상위 클래스, 부모 클래스
    String name;
    String type;
    void hello(){
        System.out.println("멍멍!");
    }
}
class Dog extends Animal { // 하위 클래스, 자식 클래스, 파생 클래스
    void play(){
        System.out.println("!!@#!@$!@%!@%");
    }
}

class Cat extends Animal {
    void sleep(){
        System.out.println("zzz......");
    }
}

public class Test03 {
    public static void main(String[] args) {
        Dog dog = new Dog();
    }
}
