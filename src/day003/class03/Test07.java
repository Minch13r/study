package day003.class03;

import java.util.Scanner;

// 정수를 두개 입력해서
// 더 큰 정수를 출력해주세요.
public class Test07 {
    public static void main(String[] args) {
        int a;
        int b;
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력해주세요 : ");
        a=sc.nextInt();
        System.out.print("정수를 입력해주세요 : ");
        b=sc.nextInt();
        System.out.print("더 큰 수 : ");
        if(a>b){
            System.out.println(a);
            System.out.println(a + "가 " + b + "보다 더 " + (a-b) + "만큼 더 큽니다.");
        } else{
            System.out.print(b);
            System.out.println(b + "가" + a + "보다 더 " + (b-a) + "만큼 더 큽니다");
        }

    }
}
