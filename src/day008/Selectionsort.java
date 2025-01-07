package day008;

import java.util.Random;
import java.util.Scanner;

public class Selectionsort {
    // 배열 출력을 위한 메소드
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 스캐너와 랜덤 객체 생성
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // 배열 크기 입력 받기 (최대 10개까지)
        int size = 0;
        while (true) {
            System.out.print("배열의 크기를 입력하세요 (1~10): ");
            size = scanner.nextInt();
            if (size > 0 && size <= 10) {
                break;
            }
            System.out.println("잘못된 크기입니다. 1~10 사이의 숫자를 입력해주세요.");
        }

        // 배열 생성
        int[] arr = new int[size];

        // 중복 없이 1~100 사이의 랜덤 숫자로 배열 채우기
        for (int i = 0; i < size; i++) {
            while (true) {
                boolean isDuplicate = false;
                arr[i] = random.nextInt(100) + 1; // 1~100 사이의 랜덤 숫자

                // 중복 검사
                for (int j = 0; j < i; j++) {
                    if (arr[j] == arr[i]) {
                        isDuplicate = true;
                        break;
                    }
                }

                if (!isDuplicate) {
                    break;
                }
            }
        }

        // 정렬 전 배열 출력
        System.out.println("\n정렬 전 배열:");
        printArray(arr);

        // 정렬 방식 선택
        int choice = 0;
        while (true) {
            System.out.println("\n정렬 방식을 선택하세요:");
            System.out.println("1. 오름차순");
            System.out.println("2. 내림차순");
            System.out.print("선택 >> ");
            choice = scanner.nextInt();

            if (choice == 1 || choice == 2) {
                break;
            }
            System.out.println("잘못된 선택입니다. 1 또는 2를 선택해주세요.");
        }

        // 선택 정렬 수행
        for (int i = 0; i < arr.length - 1; i++) {
            int targetIndex = i;

            // 최소값/최대값 찾기
            for (int j = i + 1; j < arr.length; j++) {
                if (choice == 1) { // 오름차순
                    if (arr[j] < arr[targetIndex]) {
                        targetIndex = j;
                    }
                } else { // 내림차순
                    if (arr[j] > arr[targetIndex]) {
                        targetIndex = j;
                    }
                }
            }

            // 값 교환
            if (targetIndex != i) {
                int temp = arr[i];
                arr[i] = arr[targetIndex];
                arr[targetIndex] = temp;
            }

            // 각 회차별 정렬 과정 출력
            System.out.printf("\n%d회전 후 배열:\n", i + 1);
            printArray(arr);
        }

        // 최종 정렬된 배열 출력
        System.out.println("\n최종 정렬된 배열:");
        printArray(arr);

        scanner.close();
    }
}