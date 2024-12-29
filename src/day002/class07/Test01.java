package day002.class07;

public class Test01 {
    public static void main(String[] args) {
        int i = 0;

        while (i < 5) {  // 5줄을 만들기 위한 외부 while문
            int j = 0;  // 열을 카운트하는 변수
            while (j < 5) {  // 각 줄에 5개의 별을 찍기 위한 내부 while문
                System.out.print("*"); //println 말고 print 해서 이어서 * 쓰게 함
                j++;
            }

            System.out.println();  // 한 줄이 끝나면 줄바꿈
            i++;
        }
    }
}
