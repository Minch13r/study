package day002.class05;
/*
1부터 10까지의 총합
*/
public class Test04 {
    public static void main(String[] args) {
        int i = 1;
        int sum = 0;
        while(i <= 10){ // i를 10까지 반복
            sum += i; // sum = sum + i, 총합에 계속 증가하는 i를 더하는 방식
            i++;
        }
        System.out.println(sum);
    }
}
