package day007.class01;

import java.util.Random;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        // 내 포켓몬 도감
        String[] poList = new String[3]; // 포켓몬 3마리까지 들어갈 수 있게 선언
        String[] nicknames = new String[50]; // 닉네임 입력받을 배열
        nicknames[0] = "X"; // 꼬부기 별명 없다는걸로 지정
        int cnt = 0; // 포켓몬 아직 한 마리도 없는 상태

        poList[0] = "꼬부기"; // 나만의 이름 지정 가능 ex) "홍길동";
        cnt++;

        int[] poLvList = new int[3]; //레벨을 입력하는 배열
        poLvList[0]=5; // 꼬부기는 5레벨

        String[] pokemon = new String[5]; // 잡을 수 있는 포켓몬 배열
        pokemon[0] = "망나뇽";
        pokemon[1] = "피카츄";
        pokemon[2] = "뮤";
        pokemon[3] = "근육몬";
        pokemon[4] = "꼬마돌";

        while(true){
            System.out.println("===== 메 뉴 =====");
            System.out.println("1. 포켓몬 전체 출력");
            System.out.println("2. 포켓몬 잡기");
            System.out.println("3. 포켓몬 정보 출력");
            System.out.println("4. 포켓몬 시합");
            System.out.println("0. 게임 종료");
            System.out.println("================");
            System.out.print("메뉴 입력 >> ");
            int action = sc.nextInt();

            // 0번 누르면 게임 종료
            if(action==0){
                System.out.println("게임을 종료합니다.");
                break;
            }

            else if(action == 1){ // 1. 포켓몬 전체 출력
                System.out.println("=== 내 포켓몬 목록 ===");
                for(int i = 0; i<cnt; i++){ //cnt까지 증가해서 NULL 값 안 나오게 출력
                    if(nicknames[i] != null && !nicknames[i].equals("X")) { // 별명이 비어있지 않은 경우에만 True
                        // 이름과 별명 둘 다 나오게 함
                        System.out.println((i+1) + ". " + poList[i] + " (별명: " + nicknames[i] + ")");
                    } else {
                        System.out.println((i+1) + ". " + poList[i]); // 별명 없는 경우
                    }
                }
                System.out.println("================");
            }


            else if(action == 2){ // 2. 포켓몬 잡기

                if(cnt >= 3){ // 도감이 3마리 다 찼을 때
                    System.out.println("포켓몬 도감이 가득 찼습니다!");
                    System.out.println("새로운 포켓몬을 잡으려면 기존 포켓몬을 방출해야 합니다.");
                    System.out.println("===== 현재 보유 포켓몬 =====");
                    for(int i = 0; i < cnt; i++){ //보유 포켓몬 목록 출력
                        System.out.println((i+1) + ". " + poList[i] + "(별명: " + nicknames[i] + ")" + "(Lv." + poLvList[i] + ")");
                    }

                    //방출할 포켓몬 번호 입력, 방출 안 할 수 있게끔 처리
                    System.out.print("방출할 포켓몬 번호를 입력하세요 (취소: 0) >> ");
                    int num = sc.nextInt();

                    if(num == 0){ // 취소
                        System.out.println("포켓몬 잡기를 취소합니다.");
                        continue;
                    }

                    else if(num >= 1 && num <= cnt){ // 1보다 크고 같을때, 현재 cnt보다 작거나 같을 때 진행
                        System.out.println(poList[num-1] + "를 방출합니다...");
                        // 방출된 포켓몬의 자리를 뒤의 포켓몬들로 채움
                        for(int i = num-1; i < cnt-1; i++){
                            poList[i] = poList[i+1];
                            poLvList[i] = poLvList[i+1];
                        }
                        cnt--; //방출 시키면 cnt 숫자 줄어들게
                        // 위에 코드까지 방출 진행

                        // 방출 후 데려가기 진행
                        int randNum = rand.nextInt(5); // 0~4 출력
                        // 랜덤으로 1마리 튀어나오게
                        System.out.println("야생의 " + pokemon[randNum] + "이(가) 나타났다!");
                        System.out.println("몬스터 볼을 던질까? (YES, NO)");
                        System.out.print(">> ");
                        String ans = sc.next();

                        if (!ans.equalsIgnoreCase("yes")) {
                            System.out.println("도망쳤습니다....");
                            continue;
                        }

                        System.out.println("!!!!! 몬스터볼 던지기 !!!!!");
                        int rNum = rand.nextInt(100) + 1; // 1~100

                        if (rNum <= 30) { // 30% 확률로 실패
                            System.out.println("ㅠㅠ... 실패했습니다.");
                        }

                        else { // 70% 확률로 성공
                            System.out.println("신난다!!! " + pokemon[randNum] + "을(를) 잡았습니다!!");
                            System.out.print("별명을 지정하시겠습니까? (YES/NO) >> "); // 별명 지정
                            String nicknameChoice = sc.next(); // YES, NO 입력받기

                            if(nicknameChoice.equalsIgnoreCase("yes")) { // 별명 바꾸겠다고 한 경우
                                System.out.print("별명을 입력해주세요 >> ");
                                sc.nextLine(); // YES하고 입력하기 전에 버퍼를 비워야
                                // 내가 원하는 별명 입력 가능, 아니면 Enter만 입력됨
                                String nickname = sc.nextLine();
                                nicknames[cnt] = nickname; // 별명 배열의 cnt 인덱스에 해당하는 내용 별명으로 지정
                                System.out.println(pokemon[randNum] + "의 별명이 " + nickname + "으로 지정되었습니다!");
                            }

                            else { // 안 바꾸겠다고 하면 별명 지정X
                                nicknames[cnt] = null;
                            }

                            poList[cnt] = pokemon[randNum];
                            poLvList[cnt++] = rand.nextInt(4) + 1; // 레벨은 랜덤 지정 1~4 Lv
                        }
                    }

                    else {
                        System.out.println("잘못된 번호입니다.");
                        continue;
                    }
                }

                else if(cnt < 3){ // 도감이 다 안 찼을 때
                    int randNum = rand.nextInt(5); // 0~4 출력
                    // 랜덤으로 1마리 튀어나오게
                    System.out.println("야생의 " + pokemon[randNum] + "이(가) 나타났다!");
                    System.out.println("몬스터 볼을 던질까? (YES, NO)");
                    System.out.print(">> ");
                    String ans = sc.next();

                    if (!ans.equalsIgnoreCase("yes")) {
                        System.out.println("도망쳤습니다....");
                        continue;
                    }

                    System.out.println("!!!!! 몬스터볼 던지기 !!!!!");
                    int rNum = rand.nextInt(100) + 1; // 1~100
                    // 30% 확률로 실패
                    if (rNum <= 30) { //실패
                        System.out.println("ㅠㅠ... 실패했습니다.");
                    }
                    else { // 70% 확률로 성공
                        System.out.println("신난다!!! " + pokemon[randNum] + "을(를) 잡았습니다!!");
                        System.out.print("별명을 지정하시겠습니까? (YES/NO) >> "); // 별명 지정
                        String nicknameChoice = sc.next(); // YES, NO 입력받기

                        //YES, yes, Yes 까지는 가능하게 처리
                        if(nicknameChoice.equalsIgnoreCase("yes")) { // 별명 바꾸겠다고 한 경우
                            System.out.print("별명을 입력해주세요 >> ");
                            sc.nextLine(); // YES하고 입력하기 전에 버퍼를 비워야
                            // 내가 원하는 별명 입력 가능, 아니면 Enter만 입력됨
                            String nickname = sc.nextLine();
                            nicknames[cnt] = nickname; // 별명 배열의 cnt 인덱스에 해당하는 내용 별명으로 지정
                            System.out.println(pokemon[randNum] + "의 별명이 " + nickname + "으로 지정되었습니다!");
                        } else { // 안 바꾸겠다고 하면 별명 지정X
                            // YES 외에는 모두 다 NO 처리
                            nicknames[cnt] = "X";
                        }

                        poList[cnt] = pokemon[randNum];
                        poLvList[cnt++] = rand.nextInt(4) + 1; // 레벨은 랜덤 지정 1~4 Lv
                    }
                }
            }

            else if (action == 3) { // 3. 포켓몬 정보 출력
                System.out.println("=== 내 포켓몬 목록 ===");
                for(int i = 0; i<cnt; i++){ //cnt까지 증가해서 NULL 값 안 나오게 출력
                    if(nicknames[i] != null && !nicknames[i].equals("X")) { // 별명이 비어있지 않은 경우에만 True
                        // 이름과 별명 둘 다 나오게 함
                        System.out.println((i+1) + ". " + poList[i] + " (별명: " + nicknames[i] + ")");
                    } else {
                        System.out.println((i+1) + ". " + poList[i]); // 별명 없는 경우
                    }
                }
                System.out.println("================");
                int num;
                boolean flag = false;  // 유효한 입력인지 확인하는 플래그
                while(true) {
                    System.out.print("번호 입력 (취소: 0) >> ");
                    num = sc.nextInt();
                    if(num == 0){ // 취소했을 때 반복문 탈출
                        System.out.println("포켓몬 정보 출력을 중단합니다.");
                        break;
                    } else if (num >= 1 && num <= cnt) { // 1~cnt까지의 값 입력시
                        flag = true;  // 유효한 입력임을 표시
                        break;
                    }
                    System.out.println("없는 번호입니다!");
                }

                // 유효한 입력일 경우에만 포켓몬 정보 출력
                if(flag) {
                    System.out.println(poList[num-1] + "은(는) Lv." + poLvList[num-1] + " 입니다.");
                    if(nicknames[num-1].equals("X")) {
                        System.out.println(poList[num-1] + "의 별명이 지정되지 않았습니다.");
                    } else {
                        System.out.println(poList[num-1] + "의 별명은 " + nicknames[num-1] + " 입니다");
                    }
                }

            }


            else if (action == 4) { // 4. 포켓몬 시합
                while(true) {
                    // 포켓몬이 없는 경우 체크
                    if (cnt == 0) {
                        System.out.println("보유한 포켓몬이 없습니다!");
                        continue;
                    }

                    System.out.println("포켓몬 시합이 진행되었습니다. 어떤 포켓몬을 내보내시겠습니까?");
                    System.out.println("===== 목록 =====");
                    for (int i = 0; i < cnt; i++) { // 목록 출력
                        System.out.println((i + 1) + ". " + poList[i]);
                    }
                    System.out.println("===============");
                    System.out.print("목록에 해당하는 숫자를 입력해주세요 (취소: 0) >> ");
                    int num = sc.nextInt(); // 숫자 입력받기

                    // 입력값 유효성 검사, 도감에 있는 수에만 해당하게끔
                    if (num >= 1 && num <= cnt) {
                        System.out.println(num + "번 포켓몬은 " + poList[num - 1] + "입니다");

                        System.out.println("게임이 진행됩니다. \n\n\n");
                        // 시합 진행
                        int battleResult = rand.nextInt(100) + 1; // 1~100 확률 랜덤으로 뽑기
                        if (battleResult <= 50) { // 50% 확률로 승리
                            System.out.println(poList[num - 1] + "이(가) 승리했습니다!");
                            poLvList[num - 1]++; // 승리하면 레벨 업
                            System.out.println(poList[num - 1] + "의 레벨이 " + poLvList[num - 1] + "이 되었습니다!");
                        } else {
                            System.out.println(poList[num - 1] + "이(가) 패배했습니다...");
                        }
                        break;
                    } else if (num == 0) {
                        System.out.println("포켓몬 시합을 취소합니다.");
                        break;
                    } else { // 예외처리
                        System.out.println("잘못된 번호를 입력하셨습니다.");
                        continue;
                    }
                }
            }
        }
    }
}
