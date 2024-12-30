package day003.class03;

//3. 1부터 50까지의 정수중에서 6의 배수들을 모두 출력하고 이들의 총합을 출력해주세요.
public class Test03 {
    public static void main(String[] args) {
        for(int i=1; i<=50; i++){
            //i / 6 했을 때 나머지가 0인 걸 찾아라
            if(i % 6 == 0){
                System.out.println("6의 배수 : " + i);
            }
        }
    }
}
