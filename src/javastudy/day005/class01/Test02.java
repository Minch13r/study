package javastudy.day005.class01;

import java.util.Random;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        // 사용자가 입력하는 값만큼 랜덤수 저장
        Scanner sc = new Scanner(System.in); //scanner 객체 생성
        Random rand = new Random(); //random 객체 생성

        int inputNum;
        while (true) { // 무한루프
            System.out.print("랜덤정수를 몇개 생성할까요? : ");
            inputNum = sc.nextInt(); //사용자가 입력하는 값

            if(inputNum>=0){ //종료 조건, 정상값이 입력됐을 때
                break;
            }
            System.out.println("0이상 정수를 입력해주세요!");
        }
        // 서로 관련된 데이터, 같은 자료형, 개수의 명확성(배열 3조건 만족 확인)
        int[] randList = new int[inputNum]; //동적할당

        for(int i=0; i<inputNum; i++){
            randList[i] = rand.nextInt(10); // 0~9
        }

        for(int v:randList){
            System.out.print(v+" ");
        }
    }
}
