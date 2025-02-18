package java.day002.class02;

import java.util.Scanner;

/*
a,b,c 라는 랜덤한 정수가 3개 존재한다.
이중에서 가장 큰 정수의 값을 출력해주세요.
*/
public class Test02 {
    public static void main(String[] args) {
        //scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // a값 입력하기
        System.out.println("a값을 입력해주세요 : ");
        int a = scanner.nextInt();

        // b값 입력하기
        System.out.println("b값을 입력해주세요 : ");
        int b = scanner.nextInt();

        // c값 입력하기
        System.out.println("c값을 입력해주세요 : ");
        int c = scanner.nextInt();

        int max = a; //최대값 임의로 a로 설정
        if (b > max) { //b가 a보다 클 때
            max = b;
        }
        if (c > max){ //c가 a보다 클 때
            max = c;
        }
        System.out.println("최대값 : " + max); //최대값 출력

        scanner.close();
    }
}
