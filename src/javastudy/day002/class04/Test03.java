package javastudy.day002.class04;

public class Test03 {
    public static void main(String[] args) {
        // while은 90%가 무한루프
        // 무한루프는 반드시 "종료조건"과 함께 작성해야함!!!

        // 1부터 계속 출력, 10을 만나면 종료
        int i = 1;
        while(true){ // 무한루프
            if(i==10){ // 종료조건
                break;
                // 즉시 해당 반복문이 종료
            }
            System.out.println(i);
            i++;
        }
    }
}
