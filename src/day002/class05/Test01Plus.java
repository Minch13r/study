package day002.class05;
/*
10부터 1까지 출력
*/
public class Test01Plus {
    public static void main(String[] args) {
        int i = 10;
        while(true){ //무한루프
            if(i==0){
                break; //i가 0이 되면 종료
            }
            System.out.println(i);
            i--;
        }
    }
}
