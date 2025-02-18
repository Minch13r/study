package javastudy.day007.class05;

import java.util.Random;
import java.util.Scanner;

public class Test01 {
    // 1. 어? ctrl C+V 했네?
    // 2. 함수 제작
    // 3. 코드 복붙
    // 4. 에러 발생 >>> 원인 파악
    // 5. 원인을 파악하여 input 생성
    // 6. output 확인
    // 7. main()에서 완성된 함수 호출
    public static void test02(int[] datas) {
        for(int v:datas) {
            System.out.print(v+" ");
        }
        System.out.println();
    }

    public static void test03(Scanner sc,int[] datas,Random rand) {
        int num;
        while(true) {
            System.out.print("번호 입력 >> ");
            num=sc.nextInt();
            if(1<=num && num<=datas.length) {
                break;
            }
            System.out.println("이상한 번호입니다!");
        }

        System.out.println("재시험보는중...");
        datas[num-1]=rand.nextInt(101);
        System.out.println("재시험 완료!");
    }

    public static void test04(int[] datas) {
        int max=datas[0];
        int maxIndex=0;
        for(int i=1;i<datas.length;i++) {
            if(max<datas[i]) {
                max=datas[i];
                maxIndex=i;
            }
        }
        System.out.println((maxIndex+1)+"번 학생이 1등입니다.");
        System.out.println(max+"점");
    }

    public static void main(String[] args) {

        int[] datas=new int[3];

        Scanner sc=new Scanner(System.in);
        Random rand=new Random();
        for(int i=0;i<datas.length;i++) {
            datas[i]=rand.nextInt(101); // 0~100
        }

        test02(datas);


        while(true) {
            System.out.println("1. 종료");
            System.out.println("2. 전체출력");
            System.out.println("3. 재시험(1명만)");
            System.out.println("4. 1등찾기"); // 1등이 여러명이면 번호가 제일 작은 학생 출력됨
            System.out.print(">> ");
            int action=sc.nextInt();

            if(action==1) {
                break;
            }
            else if(action==2) {
                test02(datas);
            }
            else if(action==3) {
                test03(sc,datas,rand);
            }
            else if(action==4) {
                test04(datas);
            }
        }
    }
}
