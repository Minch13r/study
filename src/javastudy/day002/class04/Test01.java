package javastudy.day002.class04;

// 제어문
// 2. 반복문
// 1. while 2. for
public class Test01 {
    public static void main(String[] args) {
        int i=1;
        while(i<=3){
            // 조건식이 참일 때 계속
            // i가 3보다 작거나 같을 때 계속
            System.out.println("i= " + i);
            i++;
        } //while의 마지막블록은 절대 뚫고 나올 수 없고 다시 처음으로 돌아감
        System.out.println("최종 i= " + i);
    }
}
