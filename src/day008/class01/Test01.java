package day008.class01;

public class Test01 {
    public static void main(String[] args) {
        for(int i = 0; i < args.length; i++){
            System.out.println(args[i]);
        }

        System.out.println("-----");

        for(String v:args){
            System.out.println(v);
        }
    }
}
