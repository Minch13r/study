package javastudy.day001.class06;

public class Test01 {
    public static void main(String[] args){
        int n1 = 10;
        int n2 = 3;
        int n3 = n1/n2; // 몫연산자
        int n4 = n1 % n2; // 나머지 연산자

        // ++n1은 n1+1과 같음
        int n5 = ++n1; //증감 연산자
        int n6 = --n2;

        System.out.println("n3 = " + n3);
        System.out.println("n4 = " + n4);
        System.out.println("n5 = " + n5);
        System.out.println("n6 = " + n6);

    }
}
