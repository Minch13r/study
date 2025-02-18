package java.day007.class05;

import java.util.Scanner;

public class Test {
    public static void printMenu() { // 프로그램 ui
        System.out.println("=====학생부 프로그램=====");
        System.out.println("1. 전체 출력");
        System.out.println("2. 1등 출력");
        System.out.println("3. 정보 추가");
        System.out.println("4. 정보 변경");
        System.out.println("0. 프로그램 종료");
        System.out.println("=========================");
    }

    public static int inputAction(int MENU) {
        // 사용자에게 정수값을 올바르게 입력받아서
        // main()으로 전달 ===>> return

        Scanner sc=new Scanner(System.in);
        int action;
        while(true) {
            System.out.print("메뉴 정수로 입력 >> ");
            action=sc.nextInt();
            if(0<=action && action<=MENU) { // 결합도를 낮춤 ★
                break;
            }
            System.out.println("잘못된 번호입니다!");
        }
        return action;
    }

    public static int inputScore() {
        // 사용자에게 정수인 점수값을 올바르게 입력받아서
        // main()으로 전달 ===>> return

        Scanner sc=new Scanner(System.in);
        int score;
        while(true) {
            System.out.print("점수 정수로 입력 >> ");
            score=sc.nextInt();
            if(0<=score && score<=100) {
                break;
            }
            System.out.println("잘못된 점수입니다!");
        }
        return score;
    }

    public static int inputNum(int cnt) {
        Scanner sc=new Scanner(System.in);
        // 정보변경할 학생의 번호를 입력받음
        int num; // scope 이슈 해결
        while(true) { // 사용자로부터 "입력"을 받으면? 유효성 검사!
            System.out.print("정보변경할 학생의 번호 입력 >> ");
            num=sc.nextInt();
            if(1<=num && num<=cnt) { // 종료조건
                break;
            }
            System.out.println("해당 번호의 학생은 존재하지않습니다!");
        }
        return num;
    }

    // T,F?
    // 가졌니,없니?
    // ~~이니,아니니?
    public static boolean isEmpty(int cnt) {
        if(cnt<=0) {
            System.out.println("학생부에 저장한 데이터가 없습니다!");
            return true;
        }
        return false;
    }

    public static boolean isFull(int cnt,int[] list) { // ☆
        if(cnt>=list.length) {
            System.out.println("학생부에 저장공간이 부족합니다!");
            return true;
        }
        return false;
    }

    public static void printStuList(int cnt,int[] stuList) {
        // 현재 저장된 학생들의 점수정보를 출력
        for(int i=0;i<cnt;i++) { // stuList.length => 학생부 자체의 크기
            System.out.println((i+1)+"번 학생의 점수 : "+stuList[i]+"점");
        }
    }

    public static void printMaxScore(int cnt,int[] stuList) {
        // 학생부 배열에서 점수가 가장 큰 학생을 찾아서
        //  --->> 최대값 찾기 알고리즘
        int max=stuList[0];
        int maxIndex=0;
        for(int i=1;i<cnt;i++) { // ★
            if(max<stuList[i]) {
                max=stuList[i];
                maxIndex=i;
            }
        }

        // 출력
        System.out.println("1등은 "+(maxIndex+1)+"번 학생, "+max+"점입니다.");
    }

    public static void addStudent(int cnt,int[] stuList) {
        // 입력받은 점수 정보를 배열에 저장
        stuList[cnt]=inputScore();

        // 저장완료! 안내
        System.out.println("학생 정보 추가 완료!");
    }



    public static void main(String[] args) {
        final int MENU=4; // 제공가능한 메뉴의 번호

        int[] stuList=new int[3]; // 학생부
        int cnt=0; // 현재 학생부에 저장된 학생 수

        while(true) {
            printMenu();

            int action=inputAction(MENU);

            if(action==0) { // 종료조건
                break;
            }
            else if(action==1) { // 전체 출력
                if(isEmpty(cnt)) { // UI/UX
                    continue;
                }

                printStuList(cnt,stuList);
            }
            else if(action==2) { // 1등 출력
                if(isEmpty(cnt)) { // UI/UX
                    continue;
                }

                printMaxScore(cnt,stuList);
            }
            else if(action==3) { // 정보 추가
                if(isFull(cnt,stuList)) { // 최대학생수만큼 저장된 상황이라면
                    continue;
                }

                addStudent(cnt++,stuList); // ★
            }
            else if(action==4) { // 정보 변경
                if(isEmpty(cnt)) { // UI/UX
                    continue;
                }

                int num=inputNum(cnt);

				/*
				// 어떤 점수로 변경할지 결정
				// 랜덤으로 변경
				int score; // scope 이슈 해결
				while(true) {
					score=rand.nextInt(101); // 0~100
					if(score != stuList[num-1]) { // 점수가 이전과 다르면
						break;
					}
				}
				stuList[num-1]=score;

				// 정보 변경 완료 안내
				System.out.println("학생 정보 변경 완료!");
				*/
            }

        }


    }
}