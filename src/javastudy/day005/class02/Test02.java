package javastudy.day005.class02;

import java.util.Random;

public class Test02 {
    public static void main(String[] args) {
        // 5개 정수를 입력하는데, 홀수들만 저장

        // Random 만들기

        // 5개의 정수를 저장할 배열공간 선언
        // 1번 정수 저장공간
        // 저장할건데, 만약에 홀수가 아니라면?
        // 다시 1번 정수 저장
        // 저장할건데, 만약에 홀수가 아니라면?
        // while 사용

        Random rand = new Random();
        int[] datas = new int[5];

        for(int i=0; i<datas.length; i++){
            while(true){
                datas[i]=rand.nextInt(10);
                if(datas[i]%2==1){ // 종료조건
                    break;
                }
            }
        }

        for(int v:datas){
            System.out.println(v + " ");
        }
    }
}
