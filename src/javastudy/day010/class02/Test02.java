package javastudy.day010.class02;

class Person {
    String name;
    static int money=10000; // 가족 계좌 정보 같은 개념
    Person(String name){
        this.name = name;
    }
    void pay(int money){
        if(money > Person.money){
            System.out.println("결제 실패");
            return; // 함수 더 이상 실행하면 안 됨
        }
        Person.money -= money;
        System.out.println(this.name + "님이 " + money + "원 결제했습니다.");
        System.out.println("잔액 : " + Person.money + "원");
    }
}

public class Test02 {
    public static void main(String[] args) {
        Person p1 = new Person("나");
        Person p2 = new Person("동생");
        Person p3 = new Person("엄마");
        Person p4 = new Person("아빠");

        p4.pay(5000);
        p3.pay(1000);
        p2.pay(4500);
        p1.pay(1000);
    }
}
