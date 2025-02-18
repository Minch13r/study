package java.day006.student;

import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        /* 학생부 프로그램은 무한루프로 진행, 종료 하려면 사용자가 원해야해서
        * */
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        //배열 선언(학생부 내용 등록)
        final int LEN=3; //학생부에 저장될 수 있는 최대 학생 수 상수화
        int[] stuList = new int[LEN]; //학생부
        int cnt = 0; //현재 학생부에 저장된 학생 수

        while(true){
            System.out.println("===== 학생부 프로그램 =====");
            System.out.println("1. 전체출력");
            System.out.println("2. 1등 출력");
            System.out.println("3. 정보추가");
            System.out.println("4. 정보변경");
            System.out.println("0. 프로그램 종료");
            System.out.println("========================");
            System.out.print(">> ");
            int action = sc.nextInt();

            if(action == 0){ // 종료조건
                System.out.println("프로그램을 종료합니다");
                break;
            }

            else if (action == 1) { // 전체출력
                // 현재 저장된 학생들의 점수정보를 출력
                if(cnt<=0){ // UI/UX, 학생부에 학생이 없는 경우, ==0을 해도 되지만
                    //오류가 난 경우 -1이 될 수 있기에 <=이 더 낫다. 변수 차단
                    System.out.println("출력할 데이터가 없습니다.");
                    continue; //굳이 안 써도 되지만 continue를 쓰면 가독성이 좋아짐
                    // else를 안 써도 되기 때문이다.
                }
                for(int i=0; i<cnt; i++) { //stuList.length를 쓰면 안됨.
                    //학생부에 저장된 학생 수를 출력해야 하는데
                    //학생부의 크기를 출력하면 안 되기 때문이다
                    System.out.println((i+1) + "번 학생의 점수 : " + stuList[i] + "점");
                }
                System.out.println();
            }

            else if (action == 2) { // 1등 출력
                // 다른 학생들과 비교해서 가장 높은 점수를 출력
                // 오름차순으로 정렬하고 가장 뒤에 있는거를 뽑아내면 될 것 같음
                if(cnt<=0){
                    System.out.println("출력할 데이터가 없습니다");
                    continue;
                }
                int max=stuList[0];
                int maxIndex=0;
                for(int i=1; i<cnt; i++){
                    if(max<stuList[i]){
                        max=stuList[i];
                    }
                }
                System.out.println("1등은 " + (maxIndex + 1) + "번 학생, " + max + "점 입니다.");
            }

            else if (action == 3) { // 정보추가
                if(cnt >= LEN) { //최대학생수만큼 저장된 상황이라면
                    System.out.println("학생부에 저장공간이 부족합니다.");
                    System.out.println("관리자에게 문의바랍니다.");
                    continue;
                }
                int score; //scope 이슈
                while(true) {
                    // 사용자로부터 학생의 점수를 입력
                    System.out.print("추가할 학생의 점수 입력 : ");
                    score = sc.nextInt();
                    if(score >=0 && score <= 100){
                        break;
                    }
                    System.out.println("0~100점 사이만 입가능합니다!");
                }
                // 입력받은 점수 정보를 배열에 저장
                stuList[cnt] = score;
                cnt++; //한 명 더 입력 받았기 때문에 카운트 증가
                // 저장완료! 안내
                System.out.println("학생 정보 추가 완료!");
            }

            else if (action == 4) { // 정보변경
                if(cnt <= 0){ // 학생부에 학생이 한명도 없다면
                    System.out.println("변경할 데이터가 없습니다");
                    continue;
                }

                // 정보변경할 학생의 번호를 입력받음

                int num; //scope 이슈
                while(true) { // 사용자로부터 입력을 받으면? 유효성 검사!
                    System.out.print("정보변경할 학생의 번호 입력 : ");
                    num = sc.nextInt();
                    if(num >= 1 && num <= cnt){ //입련 번호가 존재하는지 확인
                        break;
                    }
                    System.out.println("해당 번호의 학생은 존재하지 않습니다!");
                }
                // 어떤 점수로 변경할지 결정
                // 랜덤으로 변경
                int score;
                while(true) {
                    score = rand.nextInt(101); // 0~100 중 랜덤으로 돌림
                    if (score != stuList[num-1]){ // 점수가 이전과 다르면
                        break;
                    }
                }
                stuList[num-1]=score;
                // 정보 변경 완료 안내
                System.out.println("학생 정보 변경 완료!");
            }

            else { //유효성 검사
                System.out.println("잘못된 입력입니다! 다시 입력해주세요!");
            }
        }
    }
}
