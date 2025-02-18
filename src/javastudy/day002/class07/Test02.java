package javastudy.day002.class07;

public class Test02 {
    public static void main(String[] args) {
        int i = 1;

        while (i <= 5) {  // 5줄을 만들기 위한 외부 while문
            int j = 1;   // 별을 찍기 위한 변수

            while (j <= i) {  // 현재 행 번호만큼 별을 찍는 내부 while문
                System.out.print("*"); //println 말고 print 해서 이어서 * 쓰게 함
                j++;
            }

            System.out.println();  // 줄바꿈
            i++;
        }
    }
}
