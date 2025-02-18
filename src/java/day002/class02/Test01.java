package java.day002.class02;

import java.util.Scanner;

/*
티모가 버스에 승차한다.
티모의 나이가 1~8세 라면 무료
9~19세 라면 900원
20~64세 라면 1500원
65세 이상이라면 무료다.
티모의 나이가 랜덤일때 얼마를 지불해야하는지 출력하세요.
ex1) (티모가 20세) 1500원을 지불해야합니다.
ex2) (티모가 7세) 0원을 지불해야합니다.
*/
public class Test01 {
    public static void main(String[] args) {
        //scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 티모 나이 입력하기
        System.out.println("나이를 입력해주세요 : ");
        int a = scanner.nextInt();

        // 버스비 객체 생성
        int bus;
        if(a>=0 && a<9){ // 1~8세 버스비 무료
            bus = 0;
        } else if (a>=9 && a<20) { // 9~19세 버스비 900원
            bus = 900;
        } else if (a>=20 && a<65) { // 20~65세 버스비 1500원
            bus = 1500;
        } else { // 65세 이상 버스비 무료
            bus = 0;
        }

        System.out.println("(티모는 " + a + "세)" + bus +" 원을 지불해야 합니다.");

        scanner.close(); //scanner 객체 닫기
    }
}
