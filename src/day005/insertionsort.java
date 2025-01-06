package day005;

import java.util.Random;
import java.util.Scanner;

public class insertionsort {
    public static void main(String[] args) {

        // Random 클래스를 사용하여 난수 생성
        Random rand = new Random();
        // Scanner 클래스를 사용하여 사용자 입력 받기
        Scanner sc = new Scanner(System.in);

        // 배열의 크기를 저장할 변수
        int num;

        // 배열의 크기가 1~10 사이가 될 때까지 반복
        while (true) {
            System.out.print("배열의 개수를 입력해주세요(1~10사이 입력) : ");
            num = sc.nextInt();

            // 배열의 크기가 1~10 사이라면 반복문 종료
            if (0 < num && num <= 10) {
                break;
            }
            // 배열의 크기가 10을 초과하면 1~10 사이의 값을 입력하라고 안내
            if (num > 10) {
                System.out.println("1~10 까지의 값을 입력해주세요");
            }
            // 배열의 크기가 0 이하라면 0보다 큰 값을 입력하라고 안내
            else {
                System.out.println("0보다 큰 값을 입력해주세요");
            }
        }

        // 사용자가 입력한 크기의 배열 생성
        int[] datas = new int[num];

        // 중복되지 않는 1~10 사이의 랜덤 숫자로 배열 채우기
        for (int i = 0; i < num; i++) {
            while (true) {
                datas[i] = rand.nextInt(10) + 1;
                boolean flag = false; // 중복이 아닌 상태

                // 내 앞 인덱스까지 비교해서 중복이면 flag를 true로 변경하고 반복문 탈출
                for (int j = 0; j < i; j++) {
                    if (datas[i] == datas[j]) {
                        flag = true;
                        break;
                    }
                }
                // 중복이 없다면 반복문 탈출
                // 중복방지
                if (!flag) {
                    break;
                }
            }
        }

        // 초기 배열 출력
        System.out.print("정렬 전: [ ");
        for (int v : datas) {
            System.out.print(v + " ");
        }
        System.out.println("]");

        // 삽입 정렬 알고리즘 적용
        for (int i = 1; i < datas.length; i++) {
            int key = datas[i];
            int j;
            for (j = i; j > 0 && datas[j - 1] > key; j--) {
                datas[j] = datas[j - 1];
            }
            datas[j] = key;
        }

        // 정렬된 배열 출력
        System.out.print("정렬 후: [ ");
        for (int v : datas) {
            System.out.print(v + " ");
        }
        System.out.println("]");
    }
}