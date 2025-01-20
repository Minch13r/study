package day013.class02;

// interface는 자식관계나 형제관계가 아닌 상황에서 같은 기능이 있을때 정의하기 위해서 사용
// interface는 모두 추상 메서드임
interface UsePhone {
    int MAX=100;
    public final static int MIN=0;
    void call(); // public abstract
}

class IPhone implements UsePhone {
    @Override
    public void call() {
        System.out.println("아이폰 통화");
    }
}

class AppleWatch implements UsePhone {
    @Override
    public void call() {
        System.out.println("전화통화연결");
    }
}

public class Test02 {
}
