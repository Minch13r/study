package java.day003.class04;

import java.util.Random;
import java.util.Scanner;

/*
정수 2개를 입력합니다. 정수1~정수2 사이의 랜덤수를 3개 출력해주세요. 단, 랜덤숫자끼리 중복X
*/
public class exam {
    public static void main(String[] args) {
        /* scanner 객체 선언
           a,b 변수 선언하고 scanner.nextInt() 해서 입력 가능하게끔 해줌
           Math.min(a,b)로 a와 b중에 작은값 지정, Math.max(a,b)로 큰값 지정
           랜덤 배열이 들어갈 리스트 선언
           3개의 랜덤 숫자 뽑기
           중복될 때 min 값을 1 내려서 정렬
           중복 없으면 리스트에 저장하고 다음으로 넘어감
           결과출력
        * */
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // 두 정수 입력받기
        System.out.print("첫 번째 정수를 입력하세요: ");
        int a = scanner.nextInt();
        System.out.print("두 번째 정수를 입력하세요: ");
        int b = scanner.nextInt();

        // a와 b 중에 작은값과 큰 값 지정
        int min = Math.min(a, b);
        int max = Math.max(a, b);

        //리스트 생성 안 하고 쭉 뽑아낼 수 있었지만
        // 결과를 저장할 리스트 생성
        int[] num = new int[3];

        // 3개의 랜덤 숫자 생성
        for(int i = 0; i < 3; i++) {
            while(true) {
                // 랜덤 숫자 생성
                int randomNum = random.nextInt(max - min + 1) + min; //+1을 해야 내가 원하는 숫자가 나옴
                //보통 내가 생각한 숫자는 1부터 시작하지만 nextInt로 받으면 인덱스가 0부터 시작

                // 중복 체크
                int cnt = 0;
                //리스트에 있는값과 같으면 카운트 상승
                for(int j = 0; j < i; j++) {
                    if(num[j] == randomNum) {
                        cnt++;
                    }
                }

                // 중복이 없으면 리스트에 저장하고 다음 숫자로 넘어감
                if(cnt == 0) {
                    num[i] = randomNum;
                    break;
                }
            }
        }

        // 결과 출력
        System.out.println("생성된 랜덤 숫자:");
        for(int number : num) {
            System.out.println(number);
        }

        scanner.close();
    }

}
