package day003.class01;

/*
1. 1부터 10까지 출력
2. 1~10중에서 짝수만 출력
3. 1~10 중에서 홀수만 출력하지 마세요
 */
public class Test02 {
    public static void main(String[] args) {
        for(int i=1; i<=10; i++){
            System.out.print(i+" ");
        }
        System.out.println();

        for(int i=1; i<=10; i++){
            if(i%2==0){
                System.out.print(i+" ");
            }
        }
        System.out.println();

        for(int i=1; i<=10; i++){
            if(i%2==1){
                continue;
            }
            System.out.print(i+" ");
        }
    }
}
