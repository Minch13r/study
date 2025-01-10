package day009.class06;
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
    }
}
// getter, setter
// setter로 받고 getter로 return?
public class Test04 {
    public static void main(String[] args) {
        Car car01 = new Car(110);
        if(car01.speed> car01.maxspeed){
            System.out.println("자동차의 현재 속도는 " + car01.maxspeed + "입니다.");
        } else if (car01.speed < car01.maxspeed) {
            System.out.println("자동차의 현재 속도는 " + car01.speed + "입니다.");
        }
    }

}
