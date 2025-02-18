package javastudy.day005.class02;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        // 사용자가 입력하는 값들을 저장해보기
        int[] datas = new int[3];
        Scanner sc = new Scanner(System.in);

        // datas.length
        // 길이, 사이즈, 요소의 개수
        for(int i=0; i<datas.length; i++){
            while(true){
                System.out.print((i+1) + "번째 정수 입력 >> ");
                datas[i]=sc.nextInt();

                if(datas[i]>0){ //종료조건
                    break;
                }
                System.out.print("양수만 입력해주세요!");
            }
        }
        System.out.print("[ ");
        for(int v:datas){
            System.out.print(v + " ");
        }
        System.out.print("]");
    }
}
