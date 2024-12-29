package day002.class05;
/*
1부터 100까지의 정수들을 모두 더해가면서 그 총합을 출력
단, 총합이 50을 초과하면 총합을 그만 출력
*/
public class Test04Plus {
    public static void main(String[] args) {
        int i = 1;
        int sum = 0;

        while (i <= 100) {  // 1부터 100까지 반복
            sum += i;    // 현재 숫자를 총합에 더함

            if (sum > 50) {  // 총합이 50을 초과하면
                break;       // 반복문 종료
            }

            System.out.println("현재 숫자: " + i + ", 현재까지의 총합: " + sum);
            i++;
        }
    }
}
