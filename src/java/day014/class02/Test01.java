package java.day014.class02;

import java.util.InputMismatchException;
import java.util.Scanner;

// 정수를 1개 입력해주세요
public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        while(true) {
            System.out.print("정수입력 >> ");
            try {
                num = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("다시 입력!");
                //버퍼 비우기
                sc.nextLine();
            }
        }
        System.out.println("num = " + num);

    }
}
