package study;
/*판매량 클래스를 선언해주세요.
판매량 클래스는 음식 이름, 음식 금액, 총 주문 개수, 계산 금액을 가집니다.
계산 금액은 음식금액x총 주문 개수로 계산합니다.
출력 예시-
스파게티의 판매량은 총 2개로 24000원입니다.
*/
class Sales{
    String foodName;
    int foodPrice;
    int totalOrder;
    int totalMonut;
    public Sales(String foodName, int foodPrice, int totalOrder){
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.totalOrder = totalOrder;
        this.totalMonut = this.totalOrder * this.foodPrice;
        System.out.println(foodName + "의 판매량은 총 " + totalOrder + "개로 " + totalMonut + "원 입니다.");
    }
}
public class Test01 {
    public static void main(String[] args) {
        Sales sales = new Sales("스파게티", 12000, 2);
    }
}
