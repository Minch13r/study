package javastudy.day013.class02;

abstract class Pokemon {
    String name;
    String type;
    int lv;
    Pokemon(String name, String type){
        this.name = name;
        this.type = type;
        this.lv = 5;
    }
    abstract void attack();
    abstract void hello();
}

abstract class Water extends Pokemon{ // 물타입
    Water(String name){
        super(name, "물");
    }
    void attack(){
        System.out.println("물대포");
    }
    abstract void hello();
}

abstract class Fire extends Pokemon { // 불타입
     Fire(String name){
        super(name, "불");
    }
    void attack(){
        System.out.println("불꽃");
    }
    abstract void hello();
}

abstract class Psyduck extends Water{
    Psyduck(){
        super("고라파덕");
    }
}

public class Test {
}
