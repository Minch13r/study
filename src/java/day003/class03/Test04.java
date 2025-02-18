package java.day003.class03;

import java.util.Random;

// 4. 완전수란, 약수를 모두 더했을 때 자기자신이 되는 수를 말합니다.
// 랜덤정수(0~1000사이)가 완전수라면 "완전수입니다." 아니라면 "완전수가 아닙니다."를 출력해주세요.
public class Test04 {
    public static void main(String[] args) {
        // 완전수를 구하려면 약수를 모두 더한게 완전수여야 함.
        // 그러면 예를 들어서 10을 i로 나누면 0이 되는 그때 i를 모아둔다.
        // i를 모두 더하고 랜덤한 정수가 맞다면 그걸 맞다고  출력 아니면 아니라고 출력
        Random random = new Random(); //random 객체 생성
        int a = random.nextInt(1000) + 1; //0부터 999까지 형성돼서 1을 더해줘야 1~1000임
        int sum = 0; //합계 초기화
        for(int i=1; i<a; i++){ //1부터 a까지 1씩 상승
            if(a % i == 0){ //a를 i로 나눴을 때 몫이 0이면
                sum += i; //sum에다가 i를 더해준다.
            }
        }
        System.out.println("숫자 : " + a + "는");
        if(sum == a){ //합계가 a와 같으면 완전수
            System.out.println("완전수입니다.");
        } else { //합계가 a와 다르면 완전수가 아님
            System.out.println("완전수가 아닙니다.");
        }

    }
}
