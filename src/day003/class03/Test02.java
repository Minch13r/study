package day003.class03;

// 2. 1부터 50까지의 정수중에서 소수들을 출력해주세요.
public class Test02 {
    public static void main(String[] args) {
        for(int i = 1; i<=50; i++){ //1부터 50 숫자 1씩 증가
            int count=0; //카운트 0으로 초기화
            for(int j=1; j<=i; j++){
                if(i % j ==0){ //i를 j로 나눴을 때 나머지가 0이 되는 수가 발견되면 카운트 증가
                    count++;
                }
            }
            if(count==2){ //약수가 1과 자신뿐인 숫자를 찾기 위해 카운트가 2개인 수를 찾는다.
                System.out.println("소수" + i);
            }
        }
    }
}
