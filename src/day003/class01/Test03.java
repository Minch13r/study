package day003.class01;

import java.util.Random;

//  1. a부터 b까지 정수의 합을 출력(랜덤이라는 뜻)

public class Test03 {
    public static void main(String[] args) {
        Random random = new Random();
        //a와 b 모두 1~10까지 랜덤으로 지정
        //random.nextInt()는 0부터 index가 시작해서
        //1~10까지 랜덤으로 뽑을 생각이기에 +1 더해줌
        int a = random.nextInt(10) + 1;
        int b = random.nextInt(10) + 1;
        // a가 b보다 큰 경우 두 수 정렬
        int start = Math.min(a, b); //start는 a,b 중에 더 작은 값
        int end = Math.max(a, b); //end는 a,b 중에 더 큰 값

        // 합계를 0으로 초기화
        int sum=0;
        //반복문
        for(int i=start; i <= end; i++){
            sum += i;
        }
        // 합계 출력
        System.out.println("a값 : " + a + " b값 : " + b);
        System.out.println("합계" + sum);
    }
}
