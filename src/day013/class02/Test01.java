package day013.class02;

class TV {
    Remote remote;
    void soundUp(){
        System.out.println("소리 ++");
    }
    void soundDown(){
        System.out.println("소리 --");
    }
    void powerOn(){
        System.out.println("ON");
    }
    void powerOff(){
        System.out.println("OFF");
    }
}

class Remote {
    void volumeUp(){
        System.out.println("소리 크게~~");
    }
    void volumeDown(){
        System.out.println("소리 작게...");
    }
    void turnOn(){
        System.out.println("전원 ON");
    }
    void turnOff(){
        System.out.println("전원 OFF");
    }
}

public class Test01 {
}
