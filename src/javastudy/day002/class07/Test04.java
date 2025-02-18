package javastudy.day002.class07;

public class Test04 {
    public static void main(String[] args) {
        int i = 1;        // 현재 행
        int max = 5;    // 총 행의 수

        while (i <= max) {
            int a = max - i;  // 공백의 개수
            int star = 1;               // 별의 개수

            // 공백 출력
            while (a > 0) {
                System.out.print(" ");
                a--;
            }

            // 별 출력
            while (star <= i) {
                System.out.print("*");
                star++;
            }

            System.out.println();
            i++;
        }
    }
}
