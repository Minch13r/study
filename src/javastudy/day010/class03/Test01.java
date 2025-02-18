package javastudy.day010.class03;

import java.util.Random;

/*
책들을 생성할 수 있게 해주세요.
책의 속성은 제목,작가,가격으로 구성되어있습니다.
책을 생성할 때에는 제목을 무조건 등록해야합니다.
작가를 모를때에는 "작자미상"으로 등록합니다.
가격을 모를때에는 10000~20000원 사이로 등록해주세요.
단, 100원단위이하로는 설정하지않습니다.
ex) 만천원,만이천원 가능 / 만천오백원 불가능
책의 가격을 랜덤으로 재설정하거나,
사용자가 원하는가격으로 재설정할수있게 메서드를 구현해주세요.
책 정보를 출력해주세요.
*/
class Book {
    //제목, 작가, 가격 구성
    //오버로딩으로 작자미상 등록
    //가격 모를 때 랜덤으로 범위 선언 후 가격 지정((Random.nextInt(10) + 10) * 100)
    //조건문을 사용해서 가격 재설정
    String title; // 제목
    String author; // 작가
    int price; // 가격

    // 모든 정보 O
    Book(String title, String author, int price){
        this.title = title;
        this.author = author;
        this.price = price;
    }
    // 작가 정보 X
    Book(String title, int price){
        this(title, "작자미상", price);
    }

    // 가격 정보 X
    Book(String title, String author) {
        this(title, author, ((new Random()).nextInt(11) + 10) * 1000);
    }

    // 작가와 가격 정보 X
    Book(String title) {
        this(title, "작자미상", ((new Random()).nextInt(11) + 10) * 1000);
    }

    // 가격 랜덤
    void changeRandomPrice() {
        this.price = ((new Random()).nextInt(11) + 10) * 1000;
    }

    // 가격 직접 변경
    void changePrice(int price) {
        this.price = price;
    }

    // 책 정보 출력
    void bookInfo() {
        System.out.println("\n===== 책 정보 =====");
        System.out.println("제목 : " + title);
        System.out.println("작가 : " + author);
        System.out.println("가격 : " + price + "원");
        System.out.println("==================");
    }
    static void printChangeSout(){ // 객체랑 관련 없는 함수
        System.out.println("\n==============");
        System.out.println("★가격 변경 완료★");
        System.out.println("==============");
    }
}
public class Test01 {
    public static void main(String[] args) {
        Book book1 = new Book("궯뚧뤫쉡"); // 작가랑 가격 없는 내용 출력
        Book book2 = new Book("바보", "너"); // 가격만 없는 내용 출력
        Book book3 = new Book("변신", 12500); // 작가만 없는 내용 출력
        Book book4 = new Book("와우", "ㅋㅋ", 13000);

        book1.bookInfo();
        book2.bookInfo();
        book3.bookInfo();
        book4.bookInfo();

        Book.printChangeSout();

        book1.changeRandomPrice();
        book2.changePrice(13000);

        book1.bookInfo();
        book2.bookInfo();
        book3.bookInfo();
        book4.bookInfo();
    }
}
