package day008.class04;

import java.util.Scanner;

/*
1) 사용자가 입력하는 정수가 짝수라면 main으로 반환하는 함수.
   단, 입력한 정수가 짝수가 아니라면 다시 입력을 받는다.
2) 사용자가 입력하는 문자열을 화면에 출력하는 함수
3) main의 num 정수값을 입력받아 약수들을 출력하는 함수
4) 1~10사이의 랜덤정수를 main으로부터 2개 입력받아
   둘의 합이 홀수라면 T, 짝수라면 F를 반환하는 함수
*/
public class Test02 {
    // 함수1
    // 사용자가 입력하는 정수가 짝수라면 main으로 반환하는 함수.
    // 단, 입력한 정수가 짝수가 아니라면 다시 입력을 받는다.
    // input x, output o -> 3유형
    public static int test01(){
        Scanner sc = new Scanner(System.in);
        System.out.print("짝수를 입력하세요 : ");

        while(true) { // 무한루프, 반복횟수 불분명
            int num = sc.nextInt();
            if (num % 2 == 0) { // 나머지가 0인경우, 짝수
                System.out.println("짝수가 입력되었습니다.");
                return num; //main 함수의 num으로 반환
            }
            else { // 나머지가 1인 경우, 홀수
                System.out.print("짝수가 아닙니다. 다시 입력주세요 : ");
                continue; //가독성향상
            }
        }
        // 나는 return num을 안에 넣었지만 보편적인 경우에는 return num을 바깥으로 뺀다
        // return num 대신에 break;를 넣음
    }

    //함수2
    //사용자가 입력하는 문자열을 화면에 출력하는 함수
    // 1유형
    public static void test02(){
        Scanner sc = new Scanner(System.in); //스캐너 객체 생성
        System.out.print("문자열을 입력해주세요 : ");
        String ans = sc.next(); //문자열 입력받기
        System.out.println(ans); //문자열 출력
    }

    //함수3
    //main의 num 정수값을 입력받아 약수들을 출력하는 함수
    //input o, output x -> 2유형
    public static void test03(int num){
        int i = 1;
        System.out.print(num+"의 약수 : ");
        while(i<=num){ // i를 num까지 반복
            if(num % i == 0){ //8을 i로 나눴을 때 나머지가 0인 것
                System.out.print(i+" ");
            }
            i++;
        }
        System.out.println(); //줄바꿈
    }

    //함수4
    //1~10사이의 랜덤정수를 main으로부터 2개 입력받아
    //둘의 합이 홀수라면 T, 짝수라면 F를 반환하는 함수
    // input o, output o => 4유형
    public static boolean test04(int a, int b){
        if((a+b)%2 == 0){ //짝수인경우
            System.out.println("a+b는 " + (a+b) + "(으)로 짝수입니다.");
            return false;
        } else{ //홀수인경우
            System.out.println("a+b는 " + (a+b) + "(으)로 홀수입니다.");
            return true;
        }
    }

    public static void main(String[] args) {
        //함수 1 검증
        int num = 10;
        System.out.println("기본 num은 " + num + "입니다.");
        System.out.println("사용자가 입력하는 정수가 짝수라면 main으로 반환하는 함수");
        System.out.println("단, 입력한 정수가 짝수가 아니라면 다시 입력을 받는다.\n");
        num = test01();
        System.out.print("입력된 값 : " + num);
        System.out.println("\n====================");

        //함수 2 검증
        System.out.println("사용자가 입력하는 문자열을 화면에 출력하는 함수입니다.");

        test02();
        System.out.println("====================");

        //함수 3
        System.out.println("main의 num 정수값을 입력받아 약수들을 출력하는 함수\n");
        System.out.println("저장된 num값 : "+ num);
        test03(num);
        System.out.println("====================");

        //함수 4
        System.out.println("1~10 사이의 랜덤정수를 main으로부터 2개를 입력받았을 때");
        System.out.println("둘의 합이 홀수라면 T, 짝수라면 F를 반환하는 함수\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("정수1을 입력하세요 : ");
        int a = sc.nextInt();
        System.out.print("정수2를 입력하세요 : ");
        int b = sc.nextInt();
        test04(a,b);
        System.out.println("====================");
    }
}
