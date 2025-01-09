package day007.class01;

public class Test02 {
    // 함수 선언, 정의
    public static void printNum(int num){
        num++;
        System.out.println("num = " + num);
    }
    public static void test(int a, int b){
        a += b;
        System.out.println("a = " + a);
    }

    public static void main(String[] args) {
        // 2유형(input o, output x)
        int num = 123;
        printNum(num); // 괄호 안에 값을 입력해야 출력 가능
        // 인자를 전달할 때 변수의 "값"만 전달
        // call by value 값에 의한 호출
        // 받아들이는 정보가 num 이라는 것이 아니라 123이라는 것만 받는 것
        // printNum 함수는 main함수 안에 있는 num 이라는 존재 자체를 모름
        System.out.println("최종 num = " + num);

        // 결과는 124, 123 순서로 출력됨
        // 맨처음에 123이 함수 printNum으로 넘어가고 num++를 통해 124로 저장
        // 이후 prinNum(num)을 통해 124출력
        // sout 최종 num은 main 함수 안에 있는 123이 출력됨(printNum 함수로 안 감)
        // main 함수와 printNum의 공간은 다름
        int a = 1;
        int b = 2;
        test(b, a);
        System.out.println("a, b = " + a + "," + b);
        // 각각 다른 함수에 위치하는 a와 b를 잘 확인하고 문제를 풀어야 함
    }
}
