package javastudy.day001.class07;

public class Test03 {
    public static void main(String[] args) {
        int num = 10;

        if(num%2 == 0) { // num이 짝수일 때
            System.out.println("짝수");
        } else { //num이 홀수일 때
            System.out.println("홀수");
        }

        int point = 1000;
        //유저가 대부분 브론즈에 위치
        //브론즈 판단 제어문을 상단에 배치, 누수 방지
        if(point<5000){
            System.out.println("브론즈");
        } else if (point<10000) {
            System.out.println("골드");
        } else {
            System.out.println("에메랄드 이상");
        }
    }
}
