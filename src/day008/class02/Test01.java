package day008.class02;

public class Test01 {
    public static void test01(){
        int a = 1;
        int b = 2;
        System.out.println("4 a= " + a);
        System.out.println("4 b= " + b);
    }

    public static void test02(int b, int a){
        System.out.println("5 a= " + a);
        System.out.println("5 b= " + b);
        a++;
        b++;
    }

    public static void test03(int a){
        System.out.println("6 a= " + a);
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        test01();
        System.out.println("1 a= " + a);
        System.out.println("1 b= " + b);
        test02(a,b); // a,b를 넣었지만 함수에서는 int b, int a임
        System.out.println("2 a= " + a);
        System.out.println("2 b= " + b);
        test03(a++); // 함수호출과 ++ 연산도 진행
        System.out.println("3 a= " + a);
        System.out.println("3 b= " + b);
    }
}
