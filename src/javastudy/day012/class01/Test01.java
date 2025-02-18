package javastudy.day012.class01;

// 상속 관계에서의 객체 배열
// [ 다형성 ]
class Pokemon {
    private String name;
    private int level;
    private int exp;

    Pokemon(String name) {
        this.name = name;
        this.level = 5;
        this.exp = 0;
    }

    void play() {
        int exp = 74;
        this.exp += exp;
        if (this.exp >= 100) {
            this.level++;
            this.exp -= 100;
            this.hello(); // "다형성"이 실현되었다.
            // 메서드를 수행하는 주어(주체)가 어떤 객체인지에 따라
            // 다른 기능이 수행되는 현상
        }
    }

    void hello() {
        System.out.println("울음소리 출력");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

}

class Pika extends Pokemon {
    Pika() {
        super("피카츄");
    }

    @Override
    void hello() {
        System.out.println("피카피카");
    }
}

class Butterfree extends Pokemon {
    Butterfree() {
        super("버터플");
    }

    @Override
    void hello() {
        System.out.println("버터프rrrrrr");
    }
}

class Psyduck extends Pokemon {
    Psyduck() {
        super("고라파덕");
    }

    @Override
    void hello() {
        System.out.println("파덕파덕");
    }
}

public class Test01 {
    public static void main(String[] args) {
        Pokemon[] datas = new Pokemon[3];
        datas[0] = new Pika();
        datas[1] = new Butterfree();
        datas[2] = new Psyduck();

        for (int a = 0; a < 2; a++) {
            for (int i = 0; i < datas.length; i++) {
                // 객체 식별은 속성으로 할 수 없음
                // instanceof 연산자 -> 이 클래스의 instance니? 라고 질문
                if (datas[i] instanceof Pika) {
                    datas[i].hello(); // 다형성
                }
            }
        }
    }
}
