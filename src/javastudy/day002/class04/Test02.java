package javastudy.day002.class04;

public class Test02 {
    public static void main(String[] args) {
//        // 1부터 5까지 정수중에서
//        // 홀수인것만 출력해주세요.
//
//        int i = 1;
//        while(i<=5){
//            if(i%2 == 1){
//                System.out.println(i);
//            }
//            i++;
//        }


        // while문을 잘못 작성하게되면
        // 무한루프에 빠지게 되니 조심
        int i = 0;
        while(i<=10){
            i++;
            if(i%2==0){
                continue;
                // continue를 만나면
                // 즉시 반복문의 처음으로 이동
            }
            System.out.println(i);
            i++;
        }
    }
}
