package day014.class01;

public class Test01 {
    public static void main(String[] args) {
        int a=10;
        int b=0;

        // 로그1 까지 수행되고 그 다음줄은 실행이 안돼서 catch 쪽으로 이동함
        try {
            // 예외가 발생할 수 있는 코드
            System.out.println("로그 1");
            System.out.println(a/b);
            System.out.println("로그 2");
        } catch(ArithmeticException e){
            // 예외발생시 수행될 코드
            System.out.println("0으로는 나누기 연산을 수행할 수 없습니다.");
            System.out.println("0");
        }

        finally {
            // 예외 발생여부와 무관하게 항상 수행되는 코드
            System.out.println("항상 출력되는 코드");
        }
//        if(b!=0) {
//            System.out.println(a / b);
//        } else {1
//            System.out.println("0으로 나누기 연산을 수행할 수 없습니다.");
//        }
    }
}
