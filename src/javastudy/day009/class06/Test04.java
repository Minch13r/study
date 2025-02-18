package javastudy.day009.class06;
/*     자동차 클래스를 구현해주세요.
	   자동차는 현재 속도를 보여줄 수 있고,
	   모든 자동차들은 최대 속도가 120을 넘길 수 없습니다.*/
class Car {
    // 120 넘을 수 있어, 근데 120 넘게 받으면 내보내는거는 120 내보내라는거
    // 그 어떤 수를 입력해도 최대 속도를 넘으면 120만 내보내기
    int speed;
    int maxspeed;
    Car(int speed){
        this.speed = speed;
        this.maxspeed = 120;

        if(this.speed > this.maxspeed){
            this.speed = this.maxspeed;
            System.out.println("모든 자동차들은 최대 속도가 " + this.maxspeed + "을 넘을 수 없습니다.");
        }
    }
}
public class Test04 {
}
