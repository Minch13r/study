package day003.class01;
// 2. 10의 약수를 모두 출력해주세요.
// 2++. 10의 약수의 개수도 함께 출력해주세요.
public class Test04 {
    public static void main(String[] args) {
        // 카운트 초기화
        int count = 0;

        System.out.print("10의 약수 : ");
        // 10을 i로 나눴을 때 나머지가 0이 되는 것 출력
        for(int i = 1; i <= 10; i++) {
            if(10 % i == 0) {
                System.out.print(i + " ");
                count++;
            }
        }
        // 10의 약수의 개수를 출력하는데 count가 몇 번 반복됐는지 출력
        System.out.println("\n10의 약수의 개수 : " + count);
    }
}
