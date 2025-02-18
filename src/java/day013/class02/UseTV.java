package java.day013.class02;

// "인터페이스"
// : 클래스가 아님
// : 2개 이상의 클래스에서 공통의 기능(메서드)을 가져야할때.
// : 근데 같은 부모는 아닐 때.
// : 메서드 강제를 위해 사용
public interface UseTV {
    void soundUp(); // 추상메서드
    public abstract void soundDown();
}
