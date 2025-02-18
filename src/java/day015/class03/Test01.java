package java.day015.class03;

// [ 스레드 ]
// 프로세스, 스레드 <<< 자원(리소스, CPU, 메모리(공간))을 할당받으면!
// 프로세스, 프로그램, 어플리케이션, 스레드, S/W, 앱, 어플, ...

// 스레드를 구현하는 방법 01
// Thread 클래스를 "상속" 받아오기
class TestThread extends Thread {
    @Override
    public void run() {
        for(int i=1; i<=10; i++){
            System.out.println(i + ". 스레드 클래스를 상속받아 만들었습니다.");
        }
    }
}

// 스레드를 구현하는 방법 02
// 인터페이스를 구현하는 방법
class MyThread implements Runnable {
    @Override
    public void run() {
        for(int i=1; i<=10; i++){
            System.out.println(i + ". 인터페이스를 구현하여 만들었습니다.");
        }
    }
}

public class Test01 {
    public static void main(String[] args) {
        TestThread tt = new TestThread();
        tt.start();
        // tt.run이 아니라 start를 했더니 run 메서드가 나왔다.
        // cpu 안에 있는 스레드를 실행시켰더니 나온 것들
        // 스레드 안에 run을 만들고 start는 cpu를 실행
        // cpu 실행 -> 스레드 실행 -> run 메서드 호출

        // 인터페이스를 구현했다는 이유만으로는 thread가 될 수 없다.
        // 따라서, 진짜 스레드를 생성하고 내가 만든 유사 스레드를 넣어야 한다.
        MyThread mt = new MyThread();
        Thread t = new Thread(mt);
        t.start();
        // 결과가 이상하게 나오는데, 자원의 issue 때문에 그럼
        // 하드웨어가 자원을 어떻게 할당하는지 관해서 이렇게 나옴
        // 프로세스한테 명령하는거기 때문에 프로세스가 순서를 관리함
        // 그래서 실행할 때마다 순서가 계속 바뀜
    }
}
