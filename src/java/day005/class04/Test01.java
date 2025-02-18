package java.day005.class04;
/*
사용자가 얼만큼 입력할지 정하고, 값들을 저장하는데 입력한 값이 짝수면 저장안함
모두 저장되었다면 정수를 하나 더 입력받아서, 해당 번째에 저장된 정수 출력

6

11 31 123 123 -3 -1

2 --->> 31
 */

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        /* 배열의 크기를 정하고
         *  배열의 사이즈를 정하고
         *  배열의 길이를 정하고
         *  배열에 저장될 요소(elements)의 개수를 정하고*/
        Scanner sc=new Scanner(System.in);
        int len; // scope 이슈 해결
        while(true) {
            System.out.print("배열의 길이 입력 >> ");
            len=sc.nextInt();
            if(len>0) {
                break;
            }
            System.out.println("배열의 길이는 1이상이어야만합니다! 다시입력해주세요!");
        }
        int[] datas=new int[len];
        for(int i=0;i<datas.length;i++) {
            while(true) {
                System.out.print((i+1)+"번째 데이터 입력 >> ");
                datas[i]=sc.nextInt();
                if(datas[i]%2==1) { // 종료조건
                    break;
                }
                System.out.println("홀수만 입력가능합니다! 다시입력해주세요!");
            }
        }
        int num; // scope 이슈 해결
        while(true) {
            System.out.print("몇번째 데이터를 출력할까요? >> ");
            num=sc.nextInt();
            if(1<= num && num<=datas.length) { // 종료조건
                break;
            }
            System.out.println("배열에 존재하지않는 인덱스넘버입니다! 다시입력해주세요!");
        }
        for(int v:datas) {
            System.out.print(v+" ");
        }
        System.out.println();
        System.out.println(datas[num-1]);

    }
}
