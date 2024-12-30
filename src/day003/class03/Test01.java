package day003.class03;

import java.util.Random;

// 1. 소수란, 약수의 개수가 1과 자기자신뿐(2개)인 수를 말한다.
// 랜덤정수(0~100 사이)가 소수라면 "소수입니다." 소수가 아니라면 "소수가 아닙니다."를 출력해주세요.
public class Test01 {
    public static void main(String[] args) {
        //소수는 1과 자기자신이 곱했을 때 나오는거
        //반대로 약수가 1과 자기자신만 나오는 것
        Random random = new Random(); // random 객체 생성
        //1~100까지 범위 지정
        int a = random.nextInt(100) + 1;
        int count = 0;
        //1부터 랜덤으로 정해진 a까지 상승할 때 a를 i로 나누고 나머지 값이 0이 될 때 카운트
        for(int i=1; i<=a; i++){
            if(a % i == 0){
                count++;
            }
        }
        if(count==2){ //소수이므로 약수의 개수가 2개인 것만 소수로 분류
            System.out.println("숫자" + a + "은(는) 소수입니다.");
        } else { //2가 아닌 것은 소수가 아님
            System.out.println("숫자" + a + "은(는) 소수가 아닙니다.");
        }
    }
}
