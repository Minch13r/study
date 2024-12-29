package day002.class05;
/*
5부터 10까지 정수를 모두 출력. 홀수는 X
*/
public class Test02Plus {
    public static void main(String[] args) {
        int i = 5;
        while(i <=10 ){ // i가 10까지 반복
            if(i % 2 != 0){ // i를 2로 나누었을 때 몫이 0이 아닐 때
                i++; // i를 1 상승
                continue; // 계속 반복
            }
            System.out.println(i);
            i++;
        }
    }
}
