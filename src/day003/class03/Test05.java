package day003.class03;
//1부터 1000까지의 정수들중에서 완전수들을 출력해주세요.
public class Test05 {
    public static void main(String[] args) {
        //1부터 1000까지 1씩 상승 시키고
        //그 값의 약수를 구한다
        //약수가 모두 더해졌을 때 그 값과 같다면
        //그 수들을 모두 출력한다.
        for(int i=1; i<=1000; i++){ //1부터 1000까지 1씩 증가
            int sum=0; // 합계 0으로 초기화
            for(int j=1; j<=i/2; j++){ //j는 i의 절반, 이유는 본인을 제외한 약수 중 가장 큰거는 절반이기 때문
                if(i % j == 0 ){ //i를 j로 나눴을 때 나머지가 0인 것을 구함
                    sum += j; //구한 j값을 sum = sum + j를 반복
                }
            }

            if(sum == i){ // 합계가 i와 같은 것
                System.out.println("완전수는 " + sum + " 입니다"); //sum값 출력
            }
        }
    }
}
