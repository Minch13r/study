package day002.class05;
/*
1부터 10까지 출력
*/
public class Test01 {
    public static void main(String[] args) {
        int i = 1;
        while(true){ //무한루프
            if(i == 11){
                break;
                // 11이 되면 종료
            }
            System.out.println(i);
            i++;
        }
    }
}
