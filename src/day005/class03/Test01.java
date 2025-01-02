package day005.class03;

import java.util.Scanner;

/* 사용자가 얼만큼 입력할지 정하고, 값들을 저장하는데 입력한 값이 짝수면 저장안함
*  모두 저장되었다면 정수를 하나 더 입력받아서, 해당 번째에 저장된 정수 출력
*  5
*  10 20 30 40 50
*  2 => 20*/
public class Test01 {
    public static void main(String[] args) {
        /* scanner 객체 생성
        *  값들을 저장할 배열 선언
        *  for(int i=0; i<=datas.length; i++) 이렇게 증가시키면서
        *  인덱스 값마다 정수 입력받기
        *  짝수면 저장 안 함
        *  모두 저장됐을 때, 정수 하나 더 입력받기
        *  입력받은 값에 해당하는 몇번째 위치한 것 출력
        * */

        Scanner scanner = new Scanner(System.in);
        int[] datas = new int[5]; // 값이 저장될 배열 선언

        for(int i=0; i<datas.length; i++){ //배열 길이만큼 늘어남
            while(true) {
                System.out.print((i + 1) + "번째 정수를 입력해주세요 : ");
                int input = scanner.nextInt();

                if(input % 2 == 0) { //짝수는 저장 안 됨, 유효성 검사
                    System.out.println("짝수는 저장되지 않습니다. 다시 입력해주세요.");
                    continue;  // while문의 처음으로 돌아가 다시 입력받음
                }

                // 홀수인 경우에만 배열에 저장하고 while문 종료
                datas[i] = input;
                break;
            }
        }

        System.out.print("[ ");
        for(int v:datas) {
            System.out.print(v+" ");
        }
        System.out.print(" ] ");

        System.out.println(); //줄바꿈

        while(true) { // 원하는 위치 확인하기 위해서 얼마나 반복할지 몰라서 while로 무한루프
            //오타가 나면 다시 해야하니까 불분명 때문에 while 쓰는거임
            System.out.print("몇번째 위치에 해당한 숫자를 알고 싶으신가요? : ");
            int num = scanner.nextInt(); //원하는 위치 입력받기

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
