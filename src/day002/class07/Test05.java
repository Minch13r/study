package day002.class07;

public class Test05 {
    public static void main(String[] args) {
        int i = 0; //현재 행
        int max = 5; //총 행

        while(i < max){
            int a = 0; //공백 출력
            while(a < i){
                System.out.print(" ");
                a++; //공백이 아래로 내려갈수록 많아지니까
            }

            int star = max - i; //별표 출력
            while(star > 0){
                System.out.print("*");
                star--; //별이 아래로 내려갈수록 적어지니까
            }

            System.out.println();
            i++;
        }
    }
}
