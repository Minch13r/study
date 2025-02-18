package java.day002.class05;
/*
5부터 10까지 정수중에서 짝수를 출력
*/
public class Test02 {
    public static void main(String[] args) {
        int i = 5; // 시작은 5부터
        while(i<=10){ // i가 10과 같거나 작을 때까지 반복
            if(i%2==0){ // i를 2로 나누었을 때 나머지가 0이면 출력
                System.out.println(i);
            }
            i++;
        }
    }
}
