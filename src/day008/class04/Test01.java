package day008.class04;

import java.util.Random;

/*
* 다음의 요구사항을 수행하는 함수를 제작하시오.
* 또한, 그 함수가 제 몇 유형인지 작성하시오.
* */
public class Test01 {
    // 제 1 유형 input x output x
    // 1~10 사이의 랜덤정수를 화면에 출력하는 함수
    // 단순 출력이 대부분 1유형
    public static void test01(){
        Random rand = new Random();
        int num = rand.nextInt(10)+1;
        System.out.println(num);
    }

    // 제 2 유형 input o output x
    // main에서 num 정수를 입력받아와 홀수 짝수 여부를 출력
    // ~를 받아오는 input에 대한 힌트가 있음. 결과는 X(return 이런거)
    public static void test02(int num){
        if(num%2==1){
            System.out.println("홀수");
        } else {
            System.out.println("짝수");
        }
    }

    // 제 3 유형 input x output o
    // 1~10 사이의 랜덤정수를 main으로 반환하는 함수
    public static int test03(){
        Random rand = new Random();
        int num = rand.nextInt(10) + 1;
        return num;
    }

    // 제 4 유형 input o output o
    // main으로부터 정수값을 2개 입력받아와 더 큰 정수를 반환하는 함수
    // 단, 둘의 크기가 같다면 그 정수를 그대로 반환
    public static int test04(int a, int b){
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        test01();

        test02(10);

        int num=test03();
        System.out.println(num);

        System.out.println(test04(1,20));
    }
}
