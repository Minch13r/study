package java.day009.class04;

    class Pokemon{ // 1. class는 기본단위
    String name; // 2. 자료형
    String type;
    int level; // 4. 멤버변수(파란색 글씨)

    Pokemon(){ // 6. 생성자의 역할 == 멤버변수 초기화
        this.name="피카츄"; // 7. 클래스명과 이름이 동일해야 함
        // class에서 만든 변수와 동일해야 한다는 것
        this.type="전기";
        this.level=5; // 8. this == 자기자신객체
        // 길동이가 길동이 책을 갖고 왔다는 어색
        // 내가 내 책을 갖고 왔다. 할 때 '내'를 가르킨다.
        // 이름 충돌 방지.
        System.out.println("기본생성자 호출");
    }

    // 생성자의 특징은 new를 선언할때마다 생성된다.
    // 9. 기본 생성자는 다른 생성자가 한개라도 작성되면 즉시 제공 XXX
        // 자바에서는 디폴트 생성자를 자동으로 생성해주는데 다른 생성자가 만들어지면 제공 안 한 다는 뜻
    Pokemon(String name, String type){
        this.name=name;
        this.type=type;
        this.level=5;
        System.out.println("생성차 호출");
    }
    // 10. 생성자 오버로딩
        // 오버로딩을 하면 기본 생성자를 못 쓰게 된다.
        // 생성자 오버로딩을 하는 이유는 객체를 다양한 방식으로 생성하기 위해서다.
        // 피자를 예시로 들었을 때 치즈만 든 치즈 피자, 치즈와 토핑이 든 피자
        // 사이즈를 선택하는 피자 등 다양하기 때문에 생성자 오버로딩을 한다.
}

public class Test01 {
    public static void main(String[] args) {
        Pokemon pika = new Pokemon();
        Pokemon pai = new Pokemon("파이리", "불꽃");
        // 3. 객체화(인스턴스화) → 생성자 함수
        // 설계도를 갖고 실제 물건(객체)를 만드는 것
        // 항상 new 키워드를 사용하고 객체화 시 반드시 생성자는 호출된다.
        // 하나의 클래스로 여러 객체를 만들 수 있고 각 객체는 독립적인 메모리 공간을 갖는다.
        // 5. pika == 객체 == 붕어빵
    }
}
