package javastudy.day010.class03;

/*
자동차 자료형을 제작해주세요.
자동차는 차 주인의 이름,현재속도,최대제한속도를 필드로 갖습니다.
차 주인정보는 미등록시 자동차를 할당할 수 없습니다.
현재속도는 최초 등록시 0으로 세팅됩니다.
최대제한속도는 미등록시 120으로 자동설정됩니다.
속도를 원하는만큼 높여주는 speedUp() 메서드와
10만큼 속도를 낮춰주는 speedDown() 메서드를 구현해주세요.
자동차는 최대제한속도를 초과하여 달릴수없습니다.
자동차의 현재속도를 출력할수있게 메서드를 구현해주세요.
*/

class Car {
    // 차 주인 이름, 현재속도, 최대제한속도 선언
    // 차 주인이름을 입력해야 자동차 할당 가능, 안 하면 할당 X
    // 최초 등록시 현재 속도는 0으로 세팅
    // 최대제한속도 미등록시 120으로 자동설정
    // 속도 올려주는 speedUp() 함수 선언
    // while()이랑 scanner를 통해서 입력받고 +=로 올려주기
    // 속도 10만큼 낮춰주는 speedDown() 함수 선언
    // 자동차 최대제한속도 못 넘게, 넘으면 최대속도로 표시
    // 함수로 현재속도 출력
    String name;
    int speed;
    int max;
    Car(String name){
        this(name, 120);
    }
    Car(String name, int max){
        this.name = name;
        this.speed = 0;
        this.max = max;
    }
    void speedUp(int speed){
        this.speed+=speed;
        if(this.speed>this.max){
            this.speed=this.max;
            System.out.println("과속주의!");
        }
        System.out.println("속도++");
    }

    void speedDown(){
        this.speed-=10;
        if(this.speed < 0){
            this.speed=0;
            System.out.println("멈춤...");
        }
        System.out.println("속도---");
    }

    void printInfo(){
        System.out.println(this.name+"님의현재속도 : " + this.speed);
    }

}

public class Test03 {
    public static void main(String[] args) {

    }
}
