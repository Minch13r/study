package javastudy.day001.class06;

public class Test2Post {
    public static void main(String[] args){
        int a = 5;
        int b = --a;
        int c = b++ * --a;
        int d = ++c / a;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
