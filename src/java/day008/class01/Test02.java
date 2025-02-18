package java.day008.class01;

import java.util.Scanner;

public class Test02 {
    // 1. 이미 완성된 코드를 뜯어오기
    public static int inputNum(){
        Scanner sc = new Scanner(System.in);
        int num;
        while(true) {
            System.out.print("정수입력 >> ");
            num = sc.nextInt();
            if(num>=1 && num<=100){
                break;
            }
        }
        return num;
    }

    // 2. 필요한 로직을 함수로 전달하기
    public static boolean isPrime(int num){
        int cnt=0; // 약수의 개수
        for(int i = 1; i <= num; i++){
            if(num % i == 0){
                cnt++;
            }
        }
        if(cnt == 2){
            return true;
        } return false;

    }
    public static void main(String[] args) {
        // 사용자에게 정수를 1개 입력받아서
        // 소수니? 확인해서
        // 소수라면 소수입니다.
        // 소수아니라면 소수 xxx 출력


        int num = inputNum();

        if(isPrime(num)){
            System.out.println("소수입니다.");
        } else {
            System.out.println("소수XXX");
        }
    }
}
