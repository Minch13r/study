package java.day002.class05;
/*
1에서 8까지의 정수들중에서 8의 약수인 정수들만 출력
*/
public class Test03 {
    public static void main(String[] args) {
        int i = 1;
        while(i<=8){ // i를 8까지 반복
            if(8 % i == 0){ //8을 i로 나눴을 때 나머지가 0인 것
                System.out.println(i);
            }
            i++;
        }
    }
}
