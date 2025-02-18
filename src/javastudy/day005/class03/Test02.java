package javastudy.day005.class03;

import java.util.Random;
import java.util.Scanner;

/* 사용자가 얼만큼 입력할지 정하고, 5개의 정수를 랜덤으로 중복없이 저장
*  모두 저장되었다면 정수를 하나 더 입력받아서, 해당 번째에 저장된 정수 출력*/
public class Test02 {
    public static void main(String[] args) {
        /* 스캐너와 랜덤 객체 생성
        *  값들을 저장할 배열선언
        *  new int[3] 이런것보다 [변수} 하고 scanner로 값 받는게 나을 것 같음
        *  for(int i=0; i<datas.length; i++)을 통해 5개의 정수 랜덤으로 저장
        *  배열크기가 정수의 범위보다 크면 출력이 어려우니 배열+1로 정의하는게 좋을 것 같음
        *  중복있을 시 다시 진행, 이후 랜덤으로 중복없이 저장
        *  중복 카운트를 만들어서 중복되면 다시 하게 하고 카운트가 0 일 때 저장시킴
        *  저장된 후, 정수를 하나 더 입력받고, 해당 번째에 저장된 정수 출력*/

        // scanner와 random 객체 생성
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // 값들을 저장할 배열을 선언하고 배열 크기는 입력받기
        System.out.print("배열의 크기를 입력하세요: ");
        int size = sc.nextInt();
        int[] datas = new int[size];

        // 랜덤 숫자 저장
        for (int i = 0; i < datas.length; i++) {
            //랜덤 정수 범위를 1~10으로 지정해놓으면 배열 크기가 20을 입력 받으면 중복없이 숫자를 뽑을 수가 없음
            int randomNum = rand.nextInt(size + 1) + 1; // 1부터 배열 크기보다 1만큼 큰 숫자 사이 랜덤 숫자

            // 중복 검사
            int count = 0;
            for (int j = 0; j < i; j++) {
                if (datas[j] == randomNum) {
                    i--; // 중복이면 i를 감소시켜 현재 위치에 다시 저장하도록 함
                    count++; // 중복이 발견되면 count 증가
                    break;
                }
            }
            // 중복이 없을 경우에만 배열에 저장
            if (count == 0) {
                datas[i] = randomNum;
            }
        }

        System.out.print("[ ");
        for(int v:datas) {
            System.out.print(v+" "); //배열이 어떻게 저장되었는지 보여줌
        }
        System.out.print("]");
        System.out.println(); // 줄바꿈

        while(true) { // 원하는 위치 확인하기 위해서 얼마나 반복할지 몰라서 while로 무한루프
            //오타가 나면 다시 해야하니까 불분명 때문에 while 쓰는거임
            System.out.print("몇번째 위치에 해당한 숫자를 알고 싶으신가요? : ");
            int num = sc.nextInt(); //원하는 위치 입력받기

            if(num > 0 && num <= datas.length) { //원하는 위치가 1보다 크고 배열의 길이보다 작거나 같아야 함
                System.out.println("["+datas[num-1]+"]"); //인덱스가 0부터 시작하기 때문에
                //1번째부터 출력을 위해 num-1을 입력
                //num이 1일 때 [num] ex) [1] = 두번째 위치 출력
                //num이 1일 때 [num-1] ex) [0] = 첫번째 위치 출력
                break; // 올바른 입력을 받았으므로 반복문 종료
            } else { // 잘못된 숫자를 입력하면 다시 입력할 수 있게 유효성 검사
                System.out.println("잘못된 위치를 입력하셨습니다.");
                continue; // 다음 반복으로 넘어가서 다시 입력받기
            }
        }
    }
}
