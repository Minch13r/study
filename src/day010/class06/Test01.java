package day010.class06;

import java.util.Scanner;

// 객체 배열
class Student {
    static int studentNum=1001;
    int num; // PK 값은 사용자가 부여 xxx
    String name;
    int score;
    char grade;
    Student(String name){
        this(name,0);
    }
    Student(String name,int score){
        this.num=Student.studentNum++;
        this.name=name;
        this.score=score;
        this.setGrade();
        System.out.println("학생 정보 생성 완료!");
    }
    void printInfo() {
        System.out.println("번호 : "+this.num);
        System.out.println("이름 : "+this.name);
        System.out.println("점수 : "+this.score);
        System.out.println("등급 : "+this.grade);
    }
    void changeScore(int score) {
        this.score=score;
        this.setGrade();
        System.out.println("학생 정보 변경 완료!");
    }
    void setGrade() {
        this.grade='C';
        if(60<=this.score && this.score<80) {
            this.grade='B';
        }
        else if(80<=this.score) {
            this.grade='A';
        }
    }
}

public class Test01 {
    // '학생(객체)'와 무관한 기능 --->> 함수
    public static boolean isFull(int cnt,Student[] datas) {
        if( cnt>=datas.length ) {
            return true;
        }
        return false;
    }
    // 성적 입력 유효성 검사 --->> 함수 ===>> VIEW

    public static void main(String[] args) {

        Student[] datas=new Student[3];

        datas[0]=new Student("티모");
        datas[1]=new Student("모르가나",68);
        // 샘플 데이터

        int cnt=2;

        Scanner sc=new Scanner(System.in);
        while(true) {
            System.out.println("1. 전체출력");
            System.out.println("2. 번호로 학생 검색");
            System.out.println("3. 학생추가");
            System.out.println("4. 성적변경");

            System.out.println("5. 등급으로 학생 검색");
            System.out.println("6. 이름으로 학생 검색");
            System.out.println("0. 프로그램 종료");

            System.out.print(">> ");
            int menu=sc.nextInt();
            if(menu==0) {
                break;
            }
            else if(menu==1) {
                for(int i=0;i<cnt;i++) {
                    datas[i].printInfo();
                }
            }
            else if(menu==2) {
                System.out.print("번호입력 >> ");
                int num=sc.nextInt();

                // datas == 배열 == 학생부
                // datas[i] == 배열[인덱스번호] == 배열의 요소 == 학생 == 학생 객체
                // datas[i].num == 학생.번호 == 학생 객체.멤버변수
                boolean flag=false;

                for(int i=0;i<cnt;i++) {
                    if(num == datas[i].num) {
                        datas[i].printInfo();
                        flag=true;
                        break;
                    }
                }

                if(!flag) {
                    System.out.println("해당 학생은 없습니다...");
                }
            }
            else if(menu==3) {
                if(isFull(cnt,datas)) {
                    System.out.println("학생부 데이터에 저장공간이 없습니다!");
                    continue;
                }

                System.out.print("이름 입력 >> ");
                String name=sc.next();
                System.out.print("성적을 입력하시겠습니까? Y/N >> ");
                String ans=sc.next();
                if(ans.equals("Y")) {
                    System.out.print("성적 입력 >> ");
                    int score=sc.nextInt();
                    datas[cnt++]=new Student(name,score);
                }
                else {
                    datas[cnt++]=new Student(name);
                }
            }
            else if(menu==4) {
                System.out.print("번호입력 >> ");
                int num=sc.nextInt();

                // datas == 배열 == 학생부
                // datas[i] == 배열[인덱스번호] == 배열의 요소 == 학생 == 학생 객체
                // datas[i].num == 학생.번호 == 학생 객체.멤버변수
                boolean flag=false;

                int i; // scope 이슈 해결
                for(i=0;i<cnt;i++) {
                    if(num == datas[i].num) {
                        datas[i].printInfo();
                        flag=true;
                        break;
                    }
                }
                if(!flag) {
                    System.out.println("해당 학생은 없습니다...");
                    continue;
                }
                System.out.print("변경할 점수입력 >> ");
                int score=sc.nextInt();

                datas[i].changeScore(score);
            }

            // 등급으로 학생 검색
            else if(menu == 5){
                System.out.print("등급을 입력해주세요(A/B/C) >>");
                String ans = sc.next();
                boolean flag = false;

                //https://stackoverflow.com/questions/9159358/implicit-cast-to-string-tostring-and-int
                for(int i=0; i<cnt; i++) {
                    //배열은 char형식 ""를 추가해줌응로써 String으로 묵시적 형변환
                    if((datas[i].grade + "").equalsIgnoreCase(ans)) {
                        datas[i].printInfo();
                        flag = true;
                    }
                }
                if(!flag) {
                    System.out.println(ans + " 등급의 학생이 없습니다...");
                }


            }

            // 이름으로 학생 검색
            else if(menu == 6) {
                System.out.print("검색할 학생 이름을 입력해주세요 >> ");
                String ans = sc.next();
                boolean flag = false;

                for(int i=0; i<cnt; i++) {
                    if(datas[i].name.equals(ans)) {
                        datas[i].printInfo();
                        flag = true;
                    }
                }
                if(!flag) {
                    System.out.println(ans + " 학생은 존재하지 않습니다...");
                }
            }
        }














    }
}