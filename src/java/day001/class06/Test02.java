package java.day001.class06;

public class Test02 {
    public static void main(String[] args){
        int a = 10;
        int b = a++;
        int c = ++a - --b;
        int d= b * c++;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }



}
