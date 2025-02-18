package java.day002.class07;

public class Test03 {
    public static void main(String[] args) {
        int a = 5;
        int i = 0;    // 현재 행을 추적

        while (i < a) {
            int j = 0;  // 각 행에서 별을 찍기 위한 변수

            // 각 행에서 (5-i)개의 별을 찍는다
            while (j < a - i) {
                System.out.print("*"); //println 말고 print 해서 이어서 * 쓰게 함
                j++;
            }

            // 한 행이 끝나면 줄바꿈을 합니다
            System.out.println();
            i++;
        }
    }
}
