package javastudy.day003.class02;

// 2중 for문
public class Test01 {
    public static void main(String[] args) {
        // 구구단
        for(int a=2;a<=9;a++){
            for(int i=1;i<=9;i++){
                System.out.println(a+" x "+i+" = "+(a*i));
            }
            System.out.println("-----------");
        }
    }
}
