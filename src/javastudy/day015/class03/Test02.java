package javastudy.day015.class03;

class Ticketting {
    static int ticket = 2;
    synchronized void pay(){ // 동기화 설정 ☆
        if(Ticketting.ticket <= 0){
            System.out.println("티켓구매실패!");
            return;
        }
        Ticketting.ticket--;
        System.out.println("티켓구매성공!");
    }
}

class Person implements Runnable {
    Ticketting t;
    Person (Ticketting t){
        this.t = t;
    }
    @Override
    public void run(){
        t.pay();
    }
}

public class Test02 {
    public static void main(String[] args) {
        // 티켓팅 객체는(티켓팅 할 장소) 오직 한개
        Ticketting t = new Ticketting();

        // 티켓팅 할 사람은 3명
        Thread t1 = new Thread(new Person(t));
        Thread t2 = new Thread(new Person(t));
        Thread t3 = new Thread(new Person(t));

        // 사람이 티켓팅 진행
        t1.start();
        t2.start();
        t3.start();
    }
}
