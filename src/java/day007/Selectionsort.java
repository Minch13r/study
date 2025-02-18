package java.day007;

import java.util.Random;
import java.util.Scanner;

public class Selectionsort {
    //배열의 크기를 사용자가 입력하는 함수
    public static int inputSize(Scanner scanner, int size) {
        while (true) {
            System.out.print("배열의 크기를 입력하세요 (1~10): ");
            size = scanner.nextInt(); // 배열 크기 입력받음
            if (size > 0 && size <= 10) { // 1부터 10 사이만 입력 가능
                break;
            }
            System.out.println("잘못된 크기입니다. 1~10 사이의 숫자를 입력해주세요.");
        }
        return size;
    }

    // 배열 안의 숫자를 랜덤으로 생성해주고, 중복 방지하는 함수
    public static void flagTest(int[] datas, Random random) {
        for (int i = 0; i < datas.length; i++) {
            while (true) {
                boolean flag = false; // boolean 형식으로 중복 확인
                datas[i] = random.nextInt(100) + 1; // 1~100 사이의 랜덤 숫자

                // 중복 검사
                for (int j = 0; j < i; j++) {
                    if (datas[j] == datas[i]) {
                        flag = true; // 중복인 경우
                        break; // 중복이면 다시 반복
                    }
                }

                // true로 설정해서 if문 통과
                if (!flag) { // 중복이 아닌 경우
                    break;
                }
            }
        }
    }

    // 배열 출력하는 함수
    public static void printArr(int[] datas) {
        for (int num : datas) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // 오름차순, 내림차순 선택하는 함수
    public static int ascOrdesc(int ans, Scanner scanner) {
        while (true) {
            System.out.println("\n정렬 방식을 선택하세요:");
            System.out.println("1. 오름차순");
            System.out.println("2. 내림차순");
            System.out.print("선택 >> ");
            ans = scanner.nextInt();

            if (ans == 1 || ans == 2) { // 1 또는 2가 아닐 경우
                break;
            }
            System.out.println("잘못된 선택입니다. 1 또는 2를 선택해주세요.");
        }
        return ans;
    }

    // 선택 정렬하고 n회차 별로 배열 출력하는 함수
    public static void selectionSort(int[] datas, int ans) {
        for (int i = 0; i < datas.length - 1; i++) {
            int targetIndex = i;

            // 오름차순 / 내림차순 선택하기
            for (int j = i + 1; j < datas.length; j++) {
                if (ans == 1) { // 오름차순
                    if (datas[j] < datas[targetIndex]) {
                        targetIndex = j;
                    }
                } else { // 내림차순  가독성 좋게 하려고 else 넣어둠
                    if (datas[j] > datas[targetIndex]) {
                        targetIndex = j;
                    }
                }
            }

            // 값 교환
            if (targetIndex != i) {
                int tmp = datas[i];
                datas[i] = datas[targetIndex];
                datas[targetIndex] = tmp;
            }

            // 각 회차별 정렬 과정 출력
            System.out.println((i + 1) + "회전 후 배열");
            printArr(datas);
        }
    }

    public static void main(String[] args) {

        // 스캐너와 랜덤 객체 생성
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int size = 0;  // 배열 크기

        size = inputSize(scanner, size);   //배열 크기 입력받기

        // 배열 생성
        int[] datas = new int[size]; //배열 크기 size를 넣음으로써 배열 크기 사용자 설정

        // 중복 없이 1~100 사이의 랜덤 숫자로 배열 채우기

        flagTest(datas, random); //중복 검사

        // 정렬 전 배열 출력
        System.out.println("\n정렬 전 배열:");
        printArr(datas);   //배열 출력

        // 정렬 방식 선택
        int ans = 0; // scope 이슈

        ans = ascOrdesc(ans, scanner);  //1. 오름차순, 2. 내림차순 입력 받기

        selectionSort(datas, ans);   // 선택 정렬 후 회전마다 출력

        // 최종 정렬된 배열 출력
        System.out.println("\n최종 정렬된 배열:");
        printArr(datas);   //배열 출력
    }
}