package day005.class02;

import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        // 5개의 정수를 입력
        // 총합과 평균

        int[] datas = new int[5];

        Scanner sc = new Scanner(System.in);

        for(int i=0; i<datas.length; i++){
            System.out.print((i+1)+ "번째 정수입력 >> ");
            datas[i]=sc.nextInt();
        }
        int total=0;
        double avg;

        for(int v : datas){
            total += v;
        }

        avg = total*1.0/datas.length;
        System.out.println("총합 : " + total);
        System.out.println("평균 : " + avg);
    }
}
