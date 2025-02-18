package java.day007.class01;

public class Test01 {
    // 함수끼리는 {} 블록 코드가 겹치지 않는다.
    // 함수 선언, 정의
    public static void hello(){
        System.out.println("안녕하세요! ㅎㅎ");
    }

    // 1유형(input x, output x)
    public static void printNum(){
        int num = 1234;
        System.out.println(num);
    }

    public static void main(String[] args) {
        // 함수를 호출한다.
        // 호출을 해야 함수 사용이 가능하다.
        hello();

        printNum();
    }
}