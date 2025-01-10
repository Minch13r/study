package day009.class06;
/*3) 상품 객체들을 다룰 예정입니다.
	   상품은 이름, 가격, 재고가 있습니다.
	   만약 재고를 설정하지 않으면 0개가 기본설정되도록 해주세요.
*/
class Object{ // 상품 클래스
    String name; // 이름
    int price; // 가격
    int cnt; // 재고
    Object(String name, int price, int cnt){
        this.name = name;
        this.price = price;
        this.cnt = cnt;
    }
    Object(String name, int price){ // 재고의 개수를 입력하지 않는 경우
        this.name = name;
        this.price = price;
        this.cnt = 0; // 0개가 기본설정
    }
}
public class Test03 {
    public static void main(String[] args) {
        Object object01 = new Object("홍삼", 10500, 5);
        Object object02 = new Object("치킨", 5000);

        System.out.println(object01.name + "의 가격은 " + object01.price + "원 입니다. 재고의 개수는 " + object01.cnt + "개 입니다.");
        System.out.println(object02.name + "의 가격은 " + object02.price + "원 입니다. 재고의 개수는 " + object02.cnt + "개 입니다.");
    }
}
