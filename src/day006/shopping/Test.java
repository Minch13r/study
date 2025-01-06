package day006.shopping;

import java.util.Scanner;

/*[쇼핑몰 프로그램]

상품은 3개 고정, 이미 추가된 상태

1. 재고가 모두 출력됨.

    1번 상품 [2]개

    2번 상품 [3]개

    3번 상품 품절 << ☆

2. 상품을 선택

    3번 상품은 품절입니다.

    1번 상품을 구매하시겠습니까?

    1. 네  2. 아니오

    ⇒ 1번 상품 [1]개

3. 상품 재고 추가

    몇 번 상품 재고를 추가하시겠습니까? 3

    3번 상품 현재 재고 : 0개

    몇개 추가하시겠습니까? 5

    ⇒ 3번 상품 [5]개


자유롭게 코딩, CRUD 중에 무엇일지 주석으로 같이 작성*/
public class Test {
    public static void main(String[] args) {
        /* 스캐너 객체 생성
        *  인덱스를 상품번호라 생각하고 인덱스에 해당하는 재고를 저장
        *  배열[0]은 1개 배열[1]은 5개 배열[2]는 8개 이런식
        *  배열[1]은 사과 이런거라고 생각하면 될 것 같음
        *  그러면 배열 안에 [1, 5, 8] 이런식으로 저장되겠지
        *
        *  1. 재고를 전체 출력 - Read
        *  상품이 없을 때 유효성 검사를 통해 에러 출력
        *  재고가 있을 때 재고 전체를 출력
        *
        *  2. 상품 선택 - Read, Update
        *  재고 1번 => [?]개 이런식으로 전부 보여주고 몇번 선택할래? 물어보기
        *  0번 입력하면 뒤로 돌아가기 설정해주기
        *  1번 선택하면 1번 상품을 구매하시겠습니까? 출력
        *  1.네 2.아니오 에서 네 하면 1번 상품 [남아있는개수] 출력
        *  이상한거 선택한다고 하면 없다고 처리 후 다시 선택하게 하기
        *
        *  몇개 구매할지 물어보고 재고보다 적거나 같으면 구매하게 하고
        *  재고보다 많이 구매한다고 하면 재고는 [?]개 있습니다 다시 입력해주세요 처리
        *  아니오 선택하면 처음으로 돌아가게 하기
        *  이상한거 선택한다고 하면 없다고 처리 후 다시 선택하게 하기
        *  구매한 만큼 기존 재고에서 차감
        *
        *  3. 상품 재고 추가 - Update
        *  몇번 상품 재고를 추가하시겠습니까? 출력하고 몇개 입력받기
        *  0번 입력하면 뒤로 돌아가기 설정해주기
        *  상품 번호 잘못 입력하면 다시 입력받게 설정
        *  추가한다고 해놓고 -10 이런거 입력하면 안되니까 범위 설정
        *  추가했을 때 1조 개 1경 이렇게 써놓으면 에러나니까
        *  범위 설정하고 1만개 넘으면 양이 너무 많습니다. 관리자에게 문의해주세요
        *  [?]번 상품 현재 재고 : ?개 이렇게 출력하고
        *  몇개 추가하시겠습니까? 출력하고 몇개 입력받기
        *  현재 [?]번 상품 현재 재고 : ?개 출력해주기
        *
        *  4. 종료하기
        *  프로그램을 종료합니다 출력하고 종료시키기
        * */
        Scanner sc = new Scanner(System.in);

        int[] datas = new int[3]; //1. 티셔츠 2. 바지 3. 패딩
        datas[0] = 5; // 티셔츠
        datas[1] = 5; // 바지
        datas[2] = 5; // 패딩

        while(true){
            System.out.println("===== [쇼핑몰 프로그램] =====");
            System.out.println("1. 재고 전체 출력");
            System.out.println("2. 상품 구매");
            System.out.println("3. 상품 재고 추가");
            System.out.println("0. 종료하기");
            System.out.println("==========================");
            System.out.print("숫자를 입력해주세요 : ");
            int action = sc.nextInt();

            if(action == 0){ // 0. 종료하기
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            else if (action == 1){ // 1. 재고 전체 출력
                System.out.println("=========================="); //재고 출력 분리
                if (datas == null) { // 상품이 없을 때
                    System.out.println("상품이 없습니다. 다시 입력해주세요");
                    break;
                } else if (datas != null){ // 상품이 있으면
                    for(int i=0; i<datas.length; i++){ //재고 출력
                        System.out.println((i+1) + "번 상품 [" + datas[i] + "]개");
                    }
                    System.out.println("=========================="); //재고 출력 분리
                    System.out.println(); //줄바꿈
                }
            }

            // 2. 상품 구매
            else if (action == 2) {
                while(true) { // 구매 메뉴를 위한 반복문 추가
                    System.out.println("=== 재고 목록 ===");
                    for(int i=0; i<datas.length; i++){ //재고 출력
                        if(datas[i] == 0) { //품절 처리
                            System.out.println((i+1) + "번 상품 [품절]");
                        } else {
                            System.out.println((i+1) + "번 상품 [" + datas[i] + "개]");
                        }
                    }

                    System.out.println();
                    System.out.println("몇 번을 구매하시겠습니까? (0: 이전 메뉴)");
                    System.out.print(">>");

                    int res = sc.nextInt(); // 몇 번 재고를 구매할지 입력받기

                    // 0 입력시 이전 메뉴로
                    if(res == 0) {
                        System.out.println("이전 메뉴로 돌아갑니다.");
                        break;
                    }

                    //유효한 번호 외에 다른거 입력했을 때 예외처리
                    if(res < 1 || res > 3){
                        System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                        continue;
                    }

                    // 선택한 상품의 재고가 0개일 때
                    if(datas[res-1] == 0) {
                        System.out.println("죄송합니다. 해당 상품은 품절되었습니다.");
                        System.out.println("다른 상품을 선택해주세요.");
                        continue;
                    }

                    while(true) { //선택한 재고 불러옴
                        System.out.println(res + "번 상품을 구매하시겠습니까?\n1.네 2.아니오");
                        System.out.print("숫자를 입력해주세요 >> ");
                        int answer = sc.nextInt(); //몇개 구매할지 입력받음

                        if (answer == 2) { //아니오 누르면 다시 처음으로 돌아가게 함
                            break;  // 구매 취소시 상품 선택으로 돌아감
                        } else if (answer == 1) { //네 눌렀을 때
                            System.out.print("몇개를 구매하시겠습니까?\n >> ");
                            int quantity = sc.nextInt();

                            //인덱스는 0부터 시작하므로 선택한 수에서 1을 뺀다
                            int index = res - 1;

                            if (quantity > datas[index] || quantity < 0) {
                                System.out.println("재고가 부족합니다. 다시 입력해주세요");
                                continue;
                            } else if (quantity == 0) {
                                System.out.println("0개는 구매가 안 된 상태입니다. 다시 입력해주세요.");
                                continue;
                            } else if (quantity <= datas[index]) {
                                datas[index] = datas[index] - quantity; // 실제 재고 차감
                                System.out.println(quantity + "개 구매완료.");

                                // 구매 후 재고가 0이 되었을 때 품절처리
                                if(datas[index] == 0) {
                                    System.out.println("현재 " + res + "번 상품은 품절되었습니다.");
                                } else {
                                    System.out.println("현재 " + res + "번 상품의 재고는 [" + datas[index] + "] 개 있습니다.");
                                }
                                break; // 반복문 탈출
                            }
                        } else {
                            System.out.println("숫자를 잘못 입력하셨습니다. 다시 입력해주세요");
                            continue; //가독성 향상
                        }
                    }
                    break; //반복문 탈출해서 메인 메뉴로 돌아가기
                }
            }

            // 3. 상품 재고 추가
            else if (action == 3) {
                while(true) {
                    System.out.println("=== 상품 재고 ===");
                    // 현재 재고 상태 출력
                    for(int i = 0; i < datas.length; i++) {
                        System.out.println((i+1) + "번 재고 : " + datas[i] + "개");
                    }

                    System.out.print("몇 번 상품의 재고를 추가하시겠습니까? (0: 이전 메뉴)\n>> ");
                    int res = sc.nextInt();

                    // 이전 메뉴로 돌아가기
                    if(res == 0) {
                        break;
                    }

                    // 1번보다 작을 때, 3번보다 클 때 유효성 검사
                    if(res < 1 || res > 3) {
                        System.out.println("해당 번호는 없는 번호입니다. 다시 입력해주세요");
                        continue;
                    }

                    // 재고 몇개 추가할지 검사
                    System.out.print(res + "번 상품에 몇개의 재고를 추가할까요?\n>> ");
                    int quantity = sc.nextInt();

                    // 수량 유효성 검사
                    if(quantity < 0) { // 0보다 작을 때
                        System.out.println("음수는 입력할 수 없습니다. 다시 입력해주세요");
                        continue;
                    } else if(quantity == 0) { // 0을 입력했을 때
                        System.out.println("0은 추가되지 않습니다. 다시 입력해주세요");
                        continue;
                    } else if(quantity >= 100) { // 100보다 크거나 같을 때
                        System.out.println("창고가 모자랍니다. 관리자에게 문의해주세요");
                        continue;
                    }

                    // 재고 추가 및 결과 출력
                    datas[res - 1] += quantity; //-1을 해야 우리가 생각한 값이 나옴 인덱스는 0부터 시작
                    System.out.println(res + "번 상품의 현재 재고는 [" + datas[res - 1] + "]개 입니다.");
                    break; //반복문 탈출
                }
            }

            else { //없는 번호 눌렀을 때 유효성 검사
                System.out.println("잘못된 입력입니다! 다시 입력해주세요!");
            }
        }
    }
}