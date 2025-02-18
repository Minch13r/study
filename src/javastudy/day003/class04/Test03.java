package javastudy.day003.class04;

import java.util.Random;

/* 10~99 사이의 정수가 있습니다.
* 숫자에 3,6,9가 들어가면
* 박수를 쳐주세요
* 안들어가면 숫자를 출력해주세요
* ex) 33 39 96은 짝짝
* ex) 13 짝
* ex) 11은 그냥 11*/
public class Test03 {
    public static void main(String[] args) {
        Random random = new Random();
        //십의 자리랑 일의 자리를 분리해서 3,6,9 맞춰야 할 것 같음
        //맞출 때마다 카운트를 올려서 카운트 횟수에 맞게 박수 출력
        for (int i = 0; i < 5; i++) {
            // 10~99 사이의 랜덤 숫자 생성
            int number = random.nextInt(90) + 10;

            // 십의 자리와 일의 자리 분리하고 진행
            int tens = number / 10;    // 십의 자리
            int ones = number % 10;    // 일의 자리

            // 박수 횟수 카운트
            int cnt = 0;

            if (tens == 3 || tens == 6 || tens == 9) { //십의 자리가 3,6,9일 때 카운트 +1
                cnt += 1;
            }

            if (ones == 3 || ones == 6 || ones == 9) { //일의 자리가 3,6,9일 때 카운트 +1
                cnt += 1;
            }

            if (cnt == 2) {
                System.out.println(number + "는 짝짝");
            } else if (cnt == 1) {
                System.out.println(number + "는 짝");
            } else {
                System.out.println(number);
            }
        }

    }
}
