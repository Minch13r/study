package day014.class03;

/*
리스트에 1~10까지의 랜덤정수를 5개 저장해주세요.
단, 값 중복없이 해주세요.
사용자에게 정수를 1개 입력받아, 해당자리의 값을 0으로 변경합니다.

1. 컬렉션을 활용해 문제를 풀어주세요
2. 예외처리를 해주세요.
*/

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        ArrayList<Integer> datas = new ArrayList<>();

        // 랜덤 객체 생성
        Random rand = new Random();
        // 스캐너 객체 생성
        Scanner sc = new Scanner(System.in);

        // 1~10까지의 숫자를 리스트에 추가
        while (datas.size() < 5) { // 크기 5
            int num = rand.nextInt(10) + 1; // 1~10
            if (!datas.contains(num)) { // 중복 체크
                datas.add(num); // 랜덤 생성된 숫자 추가
            }
        }
        // 현재 리스트 출력
        System.out.println("현재 리스트 : " + datas);

        while (true) { // 언제 제대로 입력될지 몰라서 무한루프
            try {
                System.out.print("인덱스 번호를 입력해주세요 : ");
                int a = sc.nextInt();
                datas.set(a, 0); // 해당 인덱스의 값을 0으로 변경
                System.out.println("변경된 리스트 : " + datas);
                break;
            } catch (InputMismatchException e) {
                System.out.println("올바른 인덱스 번호를 입력해주세요!");
                sc.nextLine();
                continue;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("올바른 인덱스 번호를 입력해주세요!");
                sc.nextLine();
                continue;
            } catch (Exception e) {
                System.out.println("올바른 인덱스 번호를 입력해주세요!");
                sc.nextLine();
                continue;
            }
        }
    }
}
