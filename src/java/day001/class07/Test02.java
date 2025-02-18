package java.day001.class07;

public class Test02 {
    public static void main(String[] args) {
        int a = 1;
        int b = ++a*2;
        int c = a-- * ++b;
        int d = a>1 || b!=3 ? 10:20;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
