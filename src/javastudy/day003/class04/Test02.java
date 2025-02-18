package javastudy.day003.class04;

import java.util.Random;

public class Test02 {
    public static void main(String[] args) {
        //랜덤
        Random random = new Random();

        //0부터 시작하면 random.nextInt();를 그대로 써도 됨
        //1부터 시작하면 random.nextInt()+1; 을 하면 됨
        //2부터면 +2, 3부터면 +3 등 다양함

        /*랜덤 정수가 2개 있습니다.
        * 작은수에서 큰수까지 출력하면서 홀수만 출력하세요.
        * */
        int a = random.nextInt(10) + 1; //a값은 1~10
        int b = random.nextInt(10) + 1; //b값은 1~10

        int start = Math.min(a, b); //start는 a,b 중에 더 작은 값
        int end = Math.max(a, b); //end는 a,b 중에 더 큰 값

        for(int i=start; i<=end; i++){ //start 값부터 end값까지 1만큼 상승
            if(i%2==1){ //i를 2로 나누었을 때 나머지 값이 1인 경우
                System.out.println(i); //i를 출력
            }
        }
        System.out.println("시작값 : " + start);
        System.out.println("끝값 : " + end);
    }
}
