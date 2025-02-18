package javastudy.day003.class03;

import java.util.Scanner;

// 입력
// Scanner 객체 생성
public class Test06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //scanner 객체는 애당초 존재하지 않아 new를 통해 선언해줘야 함.

        System.out.print("정수를 입력하세요 : ");
        int num = sc.nextInt(); // 정수를 입력하겠다.
        System.out.println(num);

        System.out.print("실수를 입력하세요 : ");
        double d = sc.nextDouble(); // 실수를 입력하겠다.
        System.out.println(d);

        System.out.println("문자열을 입력하세요 : ");
        String str = sc.next();
        System.out.println(str);
    }
}
