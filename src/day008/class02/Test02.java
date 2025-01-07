package day008.class02;

import java.util.Random;

public class Test02 {
    public static void hello(){
        System.out.println("안녕하세요!");
    }
    public static int makeNum(){
        Random random = new Random();
        int num = random.nextInt(10)+1;
        return num;
    }

    public static void main(String[] args) {
        // 제 3유형(input x, output o)
        // 3유형은 return 이 있다고 생각하면 된다.
        // 함수에서 주고 있는게 없어 출력 X
        //System.out.println(hello());
        hello();
        System.out.println(makeNum());
    }
}
