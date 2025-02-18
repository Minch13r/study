package java.day008.class02;

import java.util.Scanner;

// 1. 전체출력
// 2. 번호검색해서 해당학생정보출력
// 3. 학생추가
// 4. 번호 입력받고 해당학생 이름 변경하기
// 5. 학생 이름 입력받고 해당학생 정보 출력하기
// 0. 종료

public class Student {
    // VIEW
    // 메뉴입력
    public static int inputMenuNum() {
        final int MENU=5;
        int menu;
        Scanner sc=new Scanner(System.in);
        while(true) {
            System.out.println("===== 메뉴 =====");
            System.out.println("1. 전체출력");
            System.out.println("2. 번호검색해서 해당학생정보출력");
            System.out.println("3. 학생추가");
            System.out.println("4. 번호 입력받고 해당학생 이름 변경하기");
            System.out.println("5. 학생 이름 입력받고 해당학생 정보 출력하기.");
            System.out.println("0. 종료하기");
            System.out.println("===============");
            System.out.print("메뉴입력 >> ");
            menu=sc.nextInt();
            if(0<=menu && menu<=MENU) {
                break;
            }
            System.out.println("다시 입력해주세요!");
        }
        return menu;
    }

    // 전체출력
    public static void printStuList(String[] stuList,int len) {
        for(int i=0;i<len;i++) {
            System.out.println((i+1)+"번 학생 이름 : "+stuList[i]);
        }
    }

    // 번호 입력받기
    public static int inputStuNum(int len) { // 2번에서 쓰는 함수
        int num;
        Scanner sc=new Scanner(System.in);
        while(true) {
            System.out.print("학생번호입력 >> ");
            num=sc.nextInt();
            if(1<=num && num<=len) {
                break;
            }
            System.out.println("다시 입력해주세요!");
        }
        return num;
    }

    // 해당 번호 이름 출력
    public static void printStuInfo(int num,String name) {
        System.out.println(num+"번 학생의 이름은 "+name+"입니다.");
    }

    // 학생 추가
    public static String inputStuName() {
        Scanner sc=new Scanner(System.in);
        System.out.print("추가할 학생이름입력 >> ");
        String name=sc.next();
        return name;
    }

    // 문구 정보
    public static void printInfo() {
        System.out.println("학생 추가 완료!");
    }

    // 이름 변경하기
    public static String changeName(int num, String[] stuList){
        Scanner sc = new Scanner(System.in);
        System.out.print("변경할 이름 입력 >> ");
        String name = sc.next();
        stuList[num-1] = name;
        System.out.println("이름이 변경 되었습니다.");
        return name;
    }

    // 학생 이름 입력받고 검색하기
    public static void inputNameNSearch(String[] stuList, int cnt) {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색할 학생의 이름을 입력해주세요 >> ");
        String name = sc.next();

        boolean flag = false;
        for(int i=0; i<cnt; i++) {
            if(name.equals(stuList[i])) {
                System.out.println((i+1) + "번 학생 " + stuList[i] + "을(를) 찾았습니다.");
                flag = true;
                break;
            }
        }

        if(!flag) {
            System.out.println("해당 이름의 학생을 찾을 수 없습니다.");
        }
    }
    public static void printErr(String[] stuList){
        System.out.println("정원이 초과되었습니다. (최대 " + stuList.length + "명)");
    }


    public static void main(String[] args) {

        String[] stuList=new String[3];

        stuList[0]="티모"; // 샘플 데이터
        stuList[1]="오리아나";

        int cnt=2; //학생수

        int menu; //메뉴 목록

        while(true) {
            menu=inputMenuNum(); //메뉴 목록 보여주기

            if(menu==0) { // 0.종료하기
                System.out.println("종료합니다.");
                break;
            }

            else if(menu==1) { // 1. 전체출력
                printStuList(stuList,cnt);
            }

            else if(menu==2) { // 2. 번호검색해서 해당학생정보출력
                printStuList(stuList, cnt);
                int num=inputStuNum(cnt);

                String name=stuList[num-1];

                printStuInfo(num,name);
            }

            else if(menu==3) { // 3. 학생추가
                if (cnt >= stuList.length) {
                    printErr(stuList);
                }
                else {
                    String name = inputStuName();
                    stuList[cnt++] = name;
                    printInfo();
                }
            }

            else if(menu==4){ // 4. 번호 입력받고 해당학생 이름 변경하기
                printStuList(stuList,cnt);
                int num = inputStuNum(cnt);

                String name = changeName(num, stuList);

            }


            else if (menu==5) { // 5. 학생 이름 입력받고 해당학생 정보 출력하기
                inputNameNSearch(stuList, cnt); // 학생 이름 입력받고 출력
            }
        }


    }
}
