//package java.day008.class05;
//
//import java.util.Random;
//import java.util.Scanner;
//
//public class Student {
//    // model 함수가 다 짜져있다는 가정 하에 View 진행
//    public static void printMenu() { // 메뉴 보여주는 함수
//        System.out.println("===== 학생부 프로그램 =====");
//        System.out.println("1. 전체출력");
//        System.out.println("2. 1등 출력");
//        System.out.println("3. 정보추가");
//        System.out.println("4. 정보변경");
//        System.out.println("0. 프로그램 종료");
//        System.out.println("========================");
//        System.out.print(">> ");
//    }
//
//    // 전체출력
//    public static void printList() {
//        if(cnt <= 0) {
//            System.out.println("출력할 데이터가 없습니다.");
//            return;
//        }
//        for(int i=0; i<cnt; i++) {
//            System.out.println((i+1) + "번 학생의 점수 : " + stuList[i] + "점");
//        }
//        System.out.println();
//    }
//
//    // 1등 출력
//    public static void printTop() {
//        if(cnt <= 0) {
//            System.out.println("출력할 데이터가 없습니다");
//            return;
//        }
//        int max = stuList[0];
//        int maxIndex = 0;
//        for(int i=1; i<cnt; i++) {
//            if(max < stuList[i]) {
//                max = stuList[i];
//                maxIndex = i;
//            }
//        }
//        System.out.println("1등은 " + (maxIndex + 1) + "번 학생, " + max + "점 입니다.");
//    }
//
//    // 점수 입력
//    public static int inputScore(Scanner sc) {
//        int score;
//        while(true) {
//            System.out.print("추가할 학생의 점수 입력 : ");
//            score = sc.nextInt();
//            if(score >= 0 && score <= 100) {
//                break;
//            }
//            System.out.println("0~100점 사이만 입력 가능합니다!");
//        }
//        return score;
//    }
//
//    // 학생 추가
//    public static boolean addStudent(Scanner sc) {
//        if(cnt >= LEN) {
//            System.out.println("학생부에 저장공간이 부족합니다.");
//            System.out.println("관리자에게 문의바랍니다.");
//            return false;
//        }
//
//        int score = inputScore(sc);
//        stuList[cnt] = score;
//        System.out.println("학생 정보 추가 완료!");
//        return true;
//    }
//
//    // 정보변경할 학생 번호 입력 함수
//    public static int inputStudentNumber(Scanner sc) {
//        int num;
//        while(true) {
//            System.out.print("정보변경할 학생의 번호 입력 : ");
//            num = sc.nextInt();
//            if(num >= 1 && num <= cnt) {
//                break;
//            }
//            System.out.println("해당 번호의 학생은 존재하지 않습니다!");
//        }
//        return num;
//    }
//
//    // 학생 점수 변경하는 함수
//    public static void modifyScore(Scanner sc, Random rand) {
//        if(cnt <= 0) {
//            System.out.println("변경할 데이터가 없습니다");
//            return;
//        }
//
//        int num = inputStudentNumber(sc);
//        int score;
//        while(true) {
//            score = rand.nextInt(101);
//            if (score != stuList[num-1]) {
//                break;
//            }
//        }
//        stuList[num-1] = score;
//        System.out.println(num + "번 학생의 점수가 " + score + "점으로 변경되었습니다.");
//    }
//
//    public static void printExit(){
//        System.out.println("프로그램을 종료합니다");
//    }
//
//    public static void printErr(){
//        System.out.println("잘못된 메뉴를 선택하셨습니다.");
//    }
//
//    // main 함수
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Random rand = new Random();
//
//        final int LEN = 3;
//        int[] stuList = new int[LEN];
//        int cnt = 0;
//
//        while(true) {
//            printMenu(); // 메뉴 출력
//            int action = sc.nextInt();
//
//            if(action == 0) { // 종료
//                printExit(); // 종료 함수
//                break;
//            }
//            else if(action == 1) {
//                printList(stuList, cnt);
//            }
//            else if(action == 2) {
//                printTop(stuList, cnt);
//            }
//            else if(action == 3) {
//                if(addStudent(stuList, cnt, LEN, sc)) {
//                    cnt++;
//                }
//            }
//            else if(action == 4) {
//                modifyScore(stuList, cnt, sc, rand);
//            }
//            else {
//                printErr();
//            }
//        }
//    }
//}
