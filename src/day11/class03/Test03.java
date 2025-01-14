package day11.class03;
/*
* Animal 부모 클래스 ( 종, 이름)
* 만약, 이름을 붙여주지 않으면 이름이 종을 따라가게 해주세요
* 모든 동물은 eat() 밥을 먹습니다.
* Dog       Cat
* play()    sleep()
*
* 강아지만이 가지는, 고양이만이 가지는 특성을 하나씩 더 추가해주세요!
* */
class Animal{
    String type;
    String name;

    Animal(String type, String name){
        this.type = type;
        this.name = name;
    }
    Animal(String type){
        this(type, type);
    }
    void eat(){
        System.out.println("밥을 먹습니다.");
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

class Dog extends Animal {
    int size; // 강아지 크기

    Dog(String name){
        super("강아지", name);
        this.size = 100;
    }
    Dog(){ // 기본 생성자
        super("강아지");
        this.size = 100;
    }
    @Override
    void eat(){
        System.out.println(this.name + " 이(가) 밥을 먹습니다.");
    }

    void play(){
        System.out.println(this.name + " 이(가) 놀고 있습니다.");
    }

    void sleep(){
        System.out.println(this.name + " 이(가) 자고 있습니다.");
    }
}

class Cat extends Animal {
    int size;

    Cat(String name){
        super("고양이", name);
        this.size = 35;
    }
    Cat(){
        super("고양이");
        this.size = 35;
    }
    @Override
    void eat(){
        System.out.println(this.name + " 이(가) 밥을 먹습니다.");
    }

    void play(){
        System.out.println(this.name + " 이(가) 놀고 있습니다.");
    }

    void sleep(){
        System.out.println(this.name + " 이(가) 자고 있습니다.");
    }
}

public class Test03 {
    public static void main(String[] args) {
        Dog dog1 = new Dog("멍멍이");
        Dog dog2 = new Dog();
        Cat cat1 = new Cat("야옹이");
        Cat cat2 = new Cat();

        dog1.eat();
        dog1.play();
        dog1.sleep();

        cat1.eat();
        cat1.play();
        cat1.sleep();

        dog2.eat();
        dog2.play();
        dog2.sleep();

        cat2.eat();
        cat2.play();
        cat2.sleep();
    }
}
