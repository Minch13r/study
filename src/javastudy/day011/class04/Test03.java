package javastudy.day011.class04;

import java.util.Random;

/*
 * 포켓몬 클래스가 있습니다.
 * 이름 별명 타입 레벨 경험치
 * 피카츄 츄 전기  5  0~100
 * 포켓몬 정보 출력 예쁘게 잘 될 수 있게
 * 별명만 지정가능
 * 별명을 지정안했다면 이름을 따라가게 설정
 * 기본 경험치 0 레벨 5
 *
 * 피카츄 파이리 꼬부기 ... <<<<<<<<<
 *
 * 포켓몬은 play() 50% 성고 ㅇ실패
 * 실패하면 앙무일 xxx
 * 성공하면 50~500 사이의 경험치 획든
 *
 * 레벨업 하면 울음소리() >> 피카피카 꼬북꼬북
 *
 * 3마리 생성
 * 각각 1번씩 게임
 * 배열 XXX
 * */
class Pokemon {
    private String name; // 이름
    private String nickname; // 별명
    private String type; // 타입(물,불,전기 등)
    private int level; // 레벨
    private int exp; // 경험치

    Pokemon(String name, String type) { // 별명X 오버로딩
        this(name, name, type);
    }

    Pokemon(String name, String nickname, String type) { //생성자
        this.name = name;
        this.nickname = nickname;
        this.type = type;
        this.level = 5;
        this.exp = 0;
    }

    /*
    오버로딩으로 별명 지정 안 했을 때 이름 따라가게  설정
    기본 경ㅇ험치 0 레벨 5로 지정ㅇ getter setter 쓰면 되려나
    피카츄랑 꼬부기 파이리 미리 만들기
    play() 성공이랑 실패는 반반 성공하면 50~500 랜덤 경험치 획득
    if(레벨업) 울음소리() >> 피카츄는 피카피카 이런식으로
    게임 1번씩 진행 배열은 쓰지 말 것
    */


    // 이름 Getter/Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 별명 Getter/Setter
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    // 타입 Getter/Setter
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // 레벨 Getter/Setter
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    // 경험치 Getter/Setter
    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    //울음소리
    void cry() {
        System.out.println("포켓몬이 운다");
    }

    void printInfo() { // 정보 출력 함수
        System.out.println("====================");
        System.out.println("이름: " + this.name);
        System.out.println("별명: " + this.nickname);
        System.out.println("타입: " + this.type);
        System.out.println("레벨: " + this.level);
        System.out.println("경험치: " + this.exp);
        System.out.println("====================");
    }

    // 게임 플레이 함수
    void play() {
        if (Math.random() <= 0.5) { // 50% 이하로 실패
            System.out.println(this.name + "[" + this.nickname + "]" + "와(과)의 놀이에 실패했습니다.");
            return; // 실패하면 그냥 끝
        }

        Random random = new Random();
        int Exp = random.nextInt(451) + 50; // 50~500 사이 경험치
        System.out.println(this.name + "[" + this.nickname + "]" + "와(과)의 놀이에 성공했습니다!");
        System.out.println("경험치를 " + Exp + " 만큼 획득했습니다!");

        this.exp += Exp;
        // 경험치가 100 이상인 동안 계속 레벨업
        // 얼마나 반복할 줄 모르기 때문에
        while (this.exp >= 100) {
            this.level++;
            this.exp -= 100;
            System.out.println("레벨업 완료! 현재 레벨: " + this.level);
            cry(); // 레벨업 할 때마다 울기
        }
    }
}

// 피카츄 상속
class Pika extends Pokemon {
    Pika(String nickname) {
        super("피카츄", nickname, "전기");
    }

    Pika() { // 별명 지정
        this("버스카드충");
    }

    @Override
    public void cry() {
        System.out.println("피카피카!");
    }
}

// 파이리 상속
class fire extends Pokemon {
    fire(String nickname) {
        super("파이리", nickname, "불"); // 기본설정, 별명 지정받기
    }

    fire() { // 별명 지정
        this("이파리");
    }

    @Override
    void cry() {
        System.out.println("초코파이!");
    }
}

// 꼬북이 상속
class turtle extends Pokemon {
    turtle(String nickname) {
        super("꼬부기", nickname, "물"); // 기본설정, 별명 지정받기
    }

    turtle() { // 별명 지정
        this("속이 거북");
    }

    @Override
    void cry() {
        System.out.println("꼬북꼬북!");
    }
}

public class Test03 {
    public static void main(String[] args) {
        Pokemon pika = new Pika("라이츄");
        Pokemon fire = new fire("파이어");
        Pokemon turtle = new turtle();  // 별명 없이 생성 예시

        // 게임 시작 전
        System.out.println("=== 게임 시작 전 포켓몬 정보 ===");
        pika.printInfo(); // 피카츄 정보
        fire.printInfo(); // 파이리 정보
        turtle.printInfo(); // 꼬북이 정보

        // 게임 진행 중
        System.out.println("\n=== 게임 진행 ===");
        pika.play(); // 피카츄 게임
        fire.play(); // 파이리 게임
        turtle.play(); // 꼬북ㅇ이 게임

        // 게임 종료 후
        System.out.println("\n=== 게임 후 포켓몬 정보 ===");
        pika.printInfo(); // 게임 후 피카츄 정보
        fire.printInfo(); // 게임 후 파이리 정보
        turtle.printInfo(); // 게임 후 꼬북이 정보
    }
}
