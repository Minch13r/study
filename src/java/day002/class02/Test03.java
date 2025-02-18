package java.day002.class02;

import java.util.Random;

/*
사과는 1300원이다. 사과를 랜덤하게 구매한다.
사과는 한명당 최대 3개까지 구매할수있다.
손님은 50000원으로 사과를 구매하려고 시도한다.
이때 손님이 지불해야할 사과의 금액과 거스름돈을 출력하세요.
*/
public class Test03 {
    public static void main(String[] args) {
        int apple = 1300;    // 사과 가격
        int money = 50000;   // 손님이 가진 돈
        int max = 3;         // 최대 구매 가능 개수

        Random random = new Random(); // random 객체 생성
        int count = random.nextInt(max) + 1; //nextInt는 n-1까지 나오기 때문에 +1을 통해 1,2,3을 나오게끔 함

        int total = apple * count; //전체 가격

        if (money >= total) { //전체 값보다 돈이 많으면 출력 가능
            int change = money - total; // 거스름돈 = 가진돈 - 사과값
            System.out.println("구매한 사과 개수: " + count + "개");
            System.out.println("지불해야 할 금액: " + total + "원");
            System.out.println("거스름돈: " + change + "원");
        } else { //유효성 검사(돈이 없으면 못 사기 때문에 넣었음)
            System.out.println("돈이 부족합니다.");
            System.out.println("필요한 금액: " + total + "원");
            System.out.println("보유 금액: " + money + "원");
        }
    }
}
