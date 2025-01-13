package day010.class02;

import java.sql.SQLOutput;

// 모래성 게임
class Game {
    String name;
    static int gameScore = 100; // 공유자원, 클래스변수, 멤버변수 아니기에 여기서 초기화

    Game(String name) {
        this.name = name;
    }

    void play(int score) {
        System.out.println(this.name + "이(가) 게임을 시도합니다...");
        Game.gameScore -= score;
        System.out.println("남은 모래성 : " + Game.gameScore);
        if (Game.gameScore <= 0) {
            System.out.println(this.name + "이(가) 실패!");
        } else {
            System.out.println(this.name + "이(가) 성공!");
        }
    }
}

public class Test01 {
    public static void main(String[] args) {
        Game p1 = new Game("티모");
        Game p2 = new Game("럭스");
        Game p3 = new Game("아무무");

        p1.play(90);
        p2.play(5);
        p3.play(10); // 기존이 100인데
        // 티모랑 럭스가 95를 가져가서 아무무가 못 가져가기에
        // 아무무는 실패한다고 보면 됨
    }

}
