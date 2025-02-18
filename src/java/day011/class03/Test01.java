package java.day011.class03;

class Person {
    private String name;
    Person(String name){
        this.name = name;
    }
    void hello(){
        System.out.println("안녕하세요!");
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}

class Student extends Person{
    int score;
    Student(String name){
        this(name,0);
    }
    Student(String name, int score){
        super(name);
        this.score = score;
    }

    @Override // 어노테이션 annotation
    void hello(){ // 부모 크래스가 가진 메서드를
        System.out.println("ㅎㅇㅎㅇ"); // 자식 클래스의 특성에 맞게 재정의
    } // 메서드 재정의 == 오버라이딩 : 상속 관계에서만 발생, 메서드 시그니쳐가 동일

    void hello(String msg){ // 오버로딩
        System.out.println(msg); // 오버로딩과 오버라이딩 구분하는거 중요 ★
    }
    public int getScore(){
        return score;
    }
    public void setScore(int score){
        this.score = score;
    }
}
public class Test01 {
    public static void main(String[] args) {
        Student s = new Student("홍길동", 81);
        System.out.println(s.getName());
        s.hello();
        s.setScore(90);
    }
}
