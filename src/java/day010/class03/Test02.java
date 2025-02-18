package java.day010.class03;

import java.util.Scanner;

/*
제품 클래스를 선언해주세요.
제품 필드는 번호,이름,가격,재고로 총 4개입니다.
번호는 1001부터 순차적으로 부여됩니다.
이름,가격은 사용자가 등록합니다.
재고는 미등록시 0개로 등록합니다.
제품의 상태를 출력할수있게 해주세요.
단, 제품의 재고가 0개면 '품절'이라고 출력해주세요.
재고를 사용자가 원하는만큼 추가할수있게 메서드를 구현해주세요.
*/
class Product {
    // 번호, 이름, 가격, 재고 선언
    // 번호는 1001부터 순차적으로 부여
    // 이름, 가격은 내가 알아서 등록
    // 재고는 미등록시 0개 등록(오버로딩)
    // 제품의 상태 출력
    // 제품의 재고가 0개면 품절, 함수로 선언
    // 함수를 통해 재고를 사용자가 원하는만큼 추가하게 해주기
    static int num = 1001; // 객체 관련 X
    int number; // 번호
    String name; // 이름
    int price; // 가격
    int cnt; // 재고(카운트)

    // 인자 다 있는 생성자
    Product(String name, int price, int cnt) {
        this.number = num++; // 1001부터 순차적으로
        this.name = name;
        this.price = price;
        this.cnt = cnt;
    }

    // 재고를 0으로 초기화
    Product(String name, int price) {
        this(name, price, 0); // 생성자 가져오기
    }

    // 제품 출력
    void productInfo() {
        System.out.println("제품의 번호는 " + this.number + "번 입니다.");
        System.out.println("제품의 이름은 " + this.name + "입니다.");
        System.out.println("제품의 가격은 " + this.price + "원 입니다.");
        if (this.cnt == 0) { // 재고가 0개면 품절
            System.out.println("현재 상태 : 품절");
        } else {
            System.out.println("제품의 재고의 개수는 " + this.cnt + "개 입니다.");
        }
    }

    // 사용자가 재고 추가
    void pluscnt() {
        Scanner scan = new Scanner(System.in);
        int amount;
        while (true) {  // 올바른 값이 입력될 때까지 반복
            System.out.print("추가할 재고의 수량을 입력해주세요: ");
            amount = scan.nextInt(); // 스캐너로 입력받기
            // 예외처리
            if (amount <= 0 || amount > 100) { // 0보다 같거나 작고 101 이상이며면 예외처리
                System.out.println("1~100 사이를 입력해주세요!");
                continue; // 가독성 향상
            }
            // 재고를 추가하고 반복문을 종료
            else {
                this.cnt += amount;
                System.out.println("재고가 " + amount + "개 추가됐습니다.");
                System.out.println("현재 재고 : " + this.cnt + "개");
                break;
            }
        }
    }
}

    public class Test02 {
        public static void main(String[] args) {
            Product p1 = new Product("노트북", 10, 5);
            Product p2 = new Product("마우스", 20);

            // p1 정보 출력
            p1.productInfo();
            System.out.println("================");

            // p2 정보 출력
            p2.productInfo();
            System.out.println("================");

            // 재고 추가
            p2.pluscnt();
            p2.productInfo();
        }
    }
