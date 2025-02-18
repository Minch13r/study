package java.day002.class01;

import java.util.Scanner;

/*1. a와 b는 랜덤한 정수입니다

int a = 10;

int b = 20;

a와 b의 크기를 비교해서

- a가 크다면 a는 b보다 크다
- b가 크다면 a는 b보다 작다
- a와 b가 같다면 a와 b는 같다.
*/
public class Test03 {
    public static void main(String[] args) {
        //scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 첫 번째 정수 입력 받기
        System.out.println("첫 번째 정수를 입력하세요 : ");
        int a = scanner.nextInt();

        // 두 번째 정수 입력 받기
        System.out.println("두 번째 정수를 입력하세요 : ");
        int b = scanner.nextInt();

        String msg = "a는 b"; // 중복되는 문장 변수처리, memory leak 해결
        if(a > b) { //a가 b보다 클 때
            System.out.println(msg + "보다 크다.");
        } else if (a < b) { //a가 b보다 작을 때
            System.out.println(msg + "보다 작다.");
        } else { //a와 b가 같을 때
            System.out.println(msg + "는 같다.");
        }

        scanner.close();
    }
}
