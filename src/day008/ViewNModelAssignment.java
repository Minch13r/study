package day008;

import java.util.Random;
import java.util.Scanner;

public class ViewNModelAssignment {
    public static int[] stuList = {10, 20, 0};

    public static int[] selectAll() {
        return stuList;
    }
    public static int selectOne(int num) {
        if(num<=0 || stuList.length<num) {
            return 0;
        }
        return stuList[num-1];
    }

    // model 함수가 다 짜져있다는 가정 하에 View 진행
    public static void printMenu() { // 메뉴 보여주는 함수
        System.out.println("===== 학생부 프로그램 =====");
        System.out.println("1. 전체출력");
        System.out.println("2. 1등 출력");
        System.out.println("3. 정보추가");
        System.out.println("4. 정보변경");
        System.out.println("0. 프로그램 종료");
        System.out.println("========================");
    }

    public static void printNum() {
    }

    // 학생이 존재하는 지 검사하는 함수
    public static boolean isStu(int cnt) {
        boolean flag = false; // 학생이 존재한다는 가정

        if(cnt <= 0) {
            flag = true;
            System.out.println("출력할 데이터가 없습니다");
        }

        return false;
    }

    // 전체출력
    public static void printList(int cnt) {
        for(int i=0; i<cnt; i++) {
            System.out.println((i+1) + "번 학생의 점수 : " + stuList[i] + "점");
        }
        System.out.println();
    }

    public static int inputAction() { // 메뉴 번호 입력 함수
        Scanner sc = new Scanner(System.in);

        int action;
        while(true) {
            System.out.print(">> ");
            action = sc.nextInt();

            if(0<=action && action<=4) {
                break;
            }

            System.out.println("옳지 않은 숫자 범위입니다!");
        }

        return action;
    }

    // 1등 출력
    public static void printTop(int maxIndex, int max) {
        System.out.println("1등은 " + (maxIndex + 1) + "번 학생, " + max + "점 입니다.");
    }

    // 점수 입력
    public static int inputScore() {
        Scanner sc = new Scanner(System.in);

        int score;
        while(true) {
            System.out.print("추가할 학생의 점수 입력 : ");
            score = sc.nextInt();
            if(score >= 0 && score <= 100) {
                break;
            }
            System.out.println("0~100점 사이만 입력 가능합니다!");
        }
        return score;
    }

    // 학생 추가
    public static void addStudent(int score) {
        System.out.println(score+"점 입력\n학생 정보 추가 완료!");
    }

    // 학생 허용치 초과 검사 함수
    public static boolean isLenFull(int cnt) {
        boolean flag = false;//깃발 변수 - 비초과상태 가정

        if(cnt >= selectAll().length) {
            flag = true;
            System.out.println("최대 학생 수입니다!");
        }

        return flag;
    }

    // 정보변경할 학생 번호 입력 함수
    public static int inputStudentNumber(int cnt) {
        Scanner sc = new Scanner(System.in);
        int num;
        while(true) {
            System.out.print("정보변경할 학생의 번호 입력 : ");
            num = sc.nextInt();
            if(num >= 1 && num <= cnt) {
                break;
            }
            System.out.println("해당 번호의 학생은 존재하지 않습니다!");
        }
        return num;
    }

    public static void printChangeScore(int num, int score) {
        System.out.println(num+"번 학생의 점수가 "+score+"점으로 변경되었습니다.");
    }

    public static void printExit(){
        System.out.println("프로그램을 종료합니다");
    }

    // 학생 랜덤 점수 저장하는 함수
    public static int modifyScore(int num) {
        Random rand = new Random();

        int ranScore;
        while(true) {
            ranScore = rand.nextInt(101); // 랜덤값 저장 변수

            if(selectOne(num) != ranScore) {
                break;
            }
        }

        return ranScore;
    }


    public static void main(String[] args) {
        int cnt = 0;

        while(true){
            printMenu();

            int action = inputAction(); // 입력 함수 호출

            if(action == 0) { // 종료조건
                printExit();
                break;
            }
            else if(action == 1) { // 전체 출력
                if(isStu(cnt)) { // UI/UX + if-else보다 continue가 뎁스를 줄이기 때문에 좋아한다.
                    continue;
                }

                printList(cnt);
            }
            else if(action == 2) { // 1등 점수 출력
                if(isStu(cnt)) { // UI/UX + if-else보다 continue가 뎁스를 줄이기 때문에 좋아한다.
                    continue;
                }

                // 학생부 배열에서 점수가 가장 큰 학생을 찾아서
                //   ---> 최댓값 찾기 알고리즘
                int max = stuList[0];
                int maxIndex = 0;

                for(int i=1; i<cnt; i++) {
                    if(max<stuList[i]) {
                        max = stuList[i];
                        maxIndex = i;
                    }
                }
                if(cnt > 0 && cnt <=3){
                printTop(maxIndex, max);
                }
            }
            else if(action == 3) { // 정보 추가
                if(isLenFull(cnt)) {
                    continue;
                }

                int score = inputScore();

                // 입력받은 점수 정보를 배열에 저장
                stuList[cnt++]= score;

                addStudent(score);
            }
            else if(action == 4) { // 정보 변경
                if(isStu(cnt)) { // UI/UX + if-else보다 continue가 뎁스를 줄이기 때문에 좋아한다.
                    continue;
                }

                printList(cnt);

                // 변경할 학생 번호 입력받기
                int num = inputStudentNumber(cnt);

                // 랜덤으로 점수값 저장
                int score = modifyScore(num);

                // 랜덤값으로 변경
                selectAll()[num-1] = score;

                printChangeScore(num, score);
            }


        }
    }

}
