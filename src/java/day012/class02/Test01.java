package java.day012.class02;

import java.util.Random;
import java.util.Scanner;

/*
플레이어(트레이너)가 있습니다.
트레이너는 1명당 최대 6마리의 포켓몬을 가질수있습니다.
트레이너는 이름을 가질수있습니다.
이름이 없는 트레이너는 '무명'으로 설정됩니다.
트레이너는 소유한 모든 포켓몬들의 상태를 출력할 수 있습니다.
소유한 포켓몬의 체력이 0이라면 [기절]을 출력해주세요.
트레이너는 자랑을 할 수 있습니다.
자랑하기를 실행하면 레벨이 가장 높은 포켓몬을 출력해주세요.
레벨이 가장 높은 포켓몬이 2마리 이상이라면 경험치가 높은 포켓몬이 출력됩니다.
경험치가 동일하면 먼저 저장된 포켓몬이 출력됩니다.
트레이너는 대결을 할 수 있습니다.
야생의 포켓몬을 만나면 내 포켓몬과 야생 포켓몬은 게임을 합니다.
야생 포켓몬을 만났을때, 야생 포켓몬과 게임할 포켓몬을 선택합니다.
게임에서 승리하면, 야생 포켓몬을 내 포켓몬으로 추가합니다.

포켓몬은 이름,체력,레벨,경험치가 있습니다.
포켓몬은 반드시 이름을 가져야합니다.
체력은 5, 레벨은 5, 경험치는 0으로 설정됩니다.
포켓몬은 게임을 할때마다 체력을 3 잃습니다.
포켓몬은 70% 확률로 게임을 성공합니다.
만약 게임에 실패한다면 즉시 체력을 3 잃습니다.
게임을 성공하면 50~300 사이의 랜덤 경험치를 획득합니다.
레벨업 할때마다 포켓몬 고유의 울음소리를 냅니다.
*/
class Player {
    private String name;            // 트레이너 이름
    private Pokemon[] dict;         // 포켓몬 배열
    // Pokemon 클래스에 있는 인자 갖고와야 해서 Pokemon 형식으로 선언
    // 이름 없는 생성자
    Player() {
        this("트레이너");    // 이름 없을 때 트레이너로 설정
    }

    // 이름 있는 생성자
    Player(String name) {
        this.name = name;
        this.dict = new Pokemon[6];  // 배열길이 6으로 설정
        this.dict[0] = new Pokemon("피카츄");    // 모든 트레이너는 피카츄 갖게 설정
    }

    // 포켓몬 정보 출력
    void printInfo() {
        System.out.println("==== " + this.name + "의 도감 ====");
        for (int i = 0; i < dict.length; i++) {
            if (dict[i] != null) {
                System.out.print((i + 1) + ". " + dict[i].getName());
                System.out.print(" [레벨: " + dict[i].getLevel() + "]");
                System.out.print(" [경험치: " + dict[i].getExp() + "]");
                if (dict[i].getHp() <= 0) {
                    System.out.println(" [기절]");
                } else {
                    System.out.println(" [체력: " + dict[i].getHp() + "]");
                }
                System.out.println("===============");
            }
        }
    }

    // 자랑하기 메서드
    Pokemon proudPokemon() {
        /*레벨 비교하기. 0번부터 5번 인덱스까지 비교
         * 0번 인덱스를 기준으로 두고 하나씩 비교
         * 가장 높은 레벨 찾아내기 이후 해당하는 포켓몬 출력
         * 만약 레벨이 같은게 있을 경우 exp 비교
         * 더 높은 exp 가진 포켓몬 출력
         * 만약 exp까지 같을 경우 앞에 있는 인덱스 번호를 가진 포켓몬 출력
         * */
        Pokemon pivot = dict[0];  // 0번 인덱스가 피봇

        for (int i = 1; i < dict.length; i++) {
            if (dict[i] != null) {  // 빈 슬롯이 아닌 경우에만 비교
                // 현재 포켓몬의 레벨이 더 높은 경우
                if (dict[i].getLevel() > pivot.getLevel()) {
                    pivot = dict[i]; // 높은 레벨이 있으면 교체
                }
                // 레벨이 같다면 경험치 비교
                else if (dict[i].getLevel() == pivot.getLevel())
                    if (dict[i].getExp() > pivot.getExp()) {
                        pivot = dict[i];
                    }
                // 경험치도 같을 때 앞에꺼 출력하는 코드를 안 적은 이유는
                // 이미 앞에서부터 비교하기 때문에 경험치가 같으면 앞에꺼 출력
            }
        }
        return pivot;
    }

    // 대결 메서드
    void randomBattle() {
        Scanner sc = new Scanner(System.in);
        // 야생 포켓몬
        Pokemon wildPoke = wildPokemon();
        System.out.println("야생의 " + wildPoke.getName() + "가 나타났습니다!");

        // 갖고 있는 포켓몬 목록 다 출력
        printInfo();

        // 몇 번 포켓몬 고를건지 입력받고 반환하기
        Pokemon pok = null;
        while (true) {
            System.out.print("어느 포켓몬을 고르시겠습니까? (1~6) :");
            int num = sc.nextInt();
            if (num < 1 || num > this.dict.length) {
                System.out.println("1~6 사이의 숫자를 입력해주세요");
                continue;
            }
            if (dict[num - 1] == null) {
                System.out.println("해당 슬롯에는 포켓몬이 없습니다.");
                continue;
            }
            if (!dict[num - 1].checkBattle()) {
                System.out.println("해당 포켓몬은 대결할 수 없습니다.");
                continue;
            }
            pok = dict[num - 1];
            break;
        }

        // 3. 대결 진행
        System.out.println(pok.getName() + "와(과) 대결을 시작합니다!");
        pok.playGame(); // 게임 진행
    }

    // 야생 포켓몬 저장 메서드
    Pokemon wildPokemon() {
        Random random = new Random();

        Pokemon[] wildPokemons = new Pokemon[3];
        wildPokemons[0] = new Pokemon("피카츄");
        wildPokemons[1] = new Pokemon("버터플");
        wildPokemons[2] = new Pokemon("고라파덕");

        int num = random.nextInt(wildPokemons.length);
        return wildPokemons[num];
    }

    // Getter,Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


class Pokemon {
    private String name;
    private int hp;
    private int level;
    private int exp;
    // 생성자
    Pokemon(String name) {
        this.name = name;
        this.hp = 5;
        this.level = 5;
        this.exp = 0;
    }

    // 게임 진행 메서드
    boolean playGame() {
        this.hp -= 3;  // 게임 진행시 기본적으로 체력 3 감소

        // 70% 확률로 성공 (0.0~1.0 사이의 난수가 0.7보다 작으면 성공)
        boolean a = Math.random() < 0.7;

        if (!a) {
            this.hp -= 3;  // 실패시 추가로 체력 3 감소
            return false;
        }

        Random rand = new Random();
        // 50~300 사이의 랜덤 경험치 획득
        int exp = (int) (rand.nextInt(251) + 50);
        addExp(exp);  // 경험치 메소드
        return true;
    }

    // 체력 상태 확인 메서드
    String checkHealth() {
        if (this.hp <= 0) { // hp가 0보다 작으면
            this.hp = 0; // 0으로 바꿈
            return "기절"; // 기절 반환
        }
        return "괜찮"; // 아니면 괜찮 반환
    }

    // 배틀여부 확인 메서드
    boolean checkBattle() {
        return this.hp >= 3;  // 체력이 3 이상이면 true 반환
    }

    // 경험치 관련 메서드
    void addExp(int exp) {
        this.exp += exp;

        while (this.exp >= 100) {  // 경험치가 100 이상이면 계속 레벨업
            this.level++;
            this.exp -= 100;
            System.out.println(this.name + "의 레벨이 " + this.level + "로 올랐습니다!");
            cry();
        }
    }

    // 울음소리
    void cry() {
        System.out.println("울부짖습니다.");
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
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

    void cry() {
        System.out.println("피카피카");
    }
}

class Butt extends Pokemon {
    Butt() {
        super("버터플");
    }

    void cry() {
        System.out.println("버터버터");
    }
}

class Gora extends Pokemon {
    Gora() {
        super("고라파덕");
    }

    void cry() {
        System.out.println("고라고라");
    }
}

public class Test01 {
}
