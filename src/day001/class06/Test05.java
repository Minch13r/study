package day001.class06;

public class Test05 {
    public static void main(String[] args) {
        // ★논리 연산자★
        int num = 30;

        // num이라는 변수가 1보다 크거나 같고 2보다 작니? => 그리고 and
        System.out.println(num >= 1 && num < 2);
        // num이라는 변수가 1이상이면서 -5 초과니? => 그리고 and
        System.out.println(num >= 1 && num > -5);
        // num이라는 변수가 -10보다 작다. 그리고 0이상이다. => 그리고 and
        System.out.println(num<-10 && num == 0);
        // num이라는 변수가 0초과거나 -1 미만이다. => 이거나, 혹은 or
        System.out.println(num > 0 || num < -1);
        // num이라는 변수가 10이상 혹은 0이 아니다. => 이거나, 혹은 or
        System.out.println(num >= 10 || num != 0);

    }
}
