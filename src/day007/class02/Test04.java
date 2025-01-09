package day007.class02;
// 4유형(input o, output 0)
public class Test04 {
    public static boolean test(int a,int b) {
        if(a+b > 10) {
            return true;
        }
        else {
            return false;
        }
    }

    public static double makeAvg(int a,int b) {
        double avg=(a+b)/2.0;
        return avg;
    }

    public static void main(String[] args) {

        if(test(1,10)) {
            System.out.println("a+b는 10 초과입니다.");
        }
        else {
            System.out.println("아닙니다.");
        }

        double avg=makeAvg(1,10);
        System.out.println("1과 10 합의 평균은 "+avg+"입니다.");

    }
}
