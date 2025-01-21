package day015.class04;
/*
[2]
가족 공동 계좌가 있습니다.
만원 저금이 되어있습니다.

엄마 / 아빠 / 동생 / 나
1000  2000  3000  5000

동기화 처리를 하셔서,
돈이 정상적으로 출금될수있도록 코딩해주세요.

+) 누가 얼마를 출금했습니다.
남은 금액은 ㅇㅇㅇ원입니다.
누가 얼마를 출금실패했습니다.
남은 금액은 ㅇㅇㅇ원입니다.
* */

/*
 * 클래스 두개 생성. 출금 클래스와 가족 클래스
 * 출금 클래스는 synchronized를 쓸 예정
 * 초기 금액이 있는데 가족 클래스를 통해 만들어진
 * 가족 중 누가 쓰는 금액에 따라 값을 달리 해야 하기 때문에
 * 변수 처리. 그러면 기존 금액 가족에 할당되는 금액을 빼고
 * 남은 금액을 출력해줘야 한다. 남은 금액이 0원보다 많으면
 * 출금이 가능하고 0원보다 적으면 출금이 불가능하다.
 *
 * 가족 클래스는 가족이름과 가족이 가지고 있는 금액을
 * 변수로 가지고 있어야 한다. 가족이 가지고 있는 금액은
 * 가족이름을 통해 출금 클래스에 접근할 수 있도록
 * 메소드를 만들어야 한다. 그리고 출금 클래스를 상속해
 * 출금 매개변수를 사용 가능하게끔 한다. 이후 스레드를 사용해
 * run과 start 그 형식으로 진행하면 될 것 같다.
 * */

class WithDraw {
    private int money = 10000; // 기본 금액

    // synchronized를 통해서 동기화 처리
    public synchronized void withDraw(int money, String name) {
        if (this.money >= money) { // 출금 가능
            this.money -= money;
            System.out.println(name + "님이 " + money + "원을 출금했습니다.");
            System.out.println("남은 금액은 " + this.money + "원입니다.");
        } else { // 출금 실패
            System.out.println(name + "님이 " + money + "원을 출금실패했습니다.");
            System.out.println("남은 금액은 " + this.money + "원입니다.");
        }
    }
}

class Family extends Thread {
    private String name; // 가족 이름
    private int money; // 가족이 가지고 있는 금액
    private WithDraw withDraw; // 출금 클래스를 통해 접근 가능

    // 생성자, withDraw를 통해 출금 클래스에 접근 가능
    public Family(String name, int money, WithDraw withDraw) {
        this.name = name;
        this.money = money;
        this.withDraw = withDraw;
    }

    // run 오버라이딩
    @Override
    public void run() {
        withDraw.withDraw(money, name);
    }

}

public class Test02 {
    public static void main(String[] args) {
        WithDraw wd = new WithDraw();

        // 가족 구성원 생성
        Family mom = new Family("엄마", 1000, wd);
        Family dad = new Family("아빠", 2000, wd);
        Family sister = new Family("동생", 3000, wd);
        Family me = new Family("나", 5000, wd);

        // 스레드 시작
        mom.start();
        dad.start();
        sister.start();
        me.start();
    }
}
