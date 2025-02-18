package javastudy.day014.class01;

import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        /*
        int[] datas = new int[3];
        try {
            System.out.println(datas[3]);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("없는 인덱스 번호입니다!");
        }
        */

        int[] datas = {1, 2, 0, 3, 4};

        int a;
        int b;
        Scanner sc = new Scanner(System.in);


        try {
            System.out.println("정수를 2개 입력하세요");
            System.out.print(">>");
            a = sc.nextInt();
            System.out.print(">>");
            b = sc.nextInt();

            int res = datas[a] / datas[b];
            System.out.println("답은" + res);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("없는 인덱스입니다.");
        } catch (Exception e) { // 부모클래스는 맨 아래에 적어야 다른 예외처리가 가능
            e.printStackTrace();
        }
    }
}
