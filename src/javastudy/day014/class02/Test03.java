package javastudy.day014.class02;

public class Test03 {
    // 예외 일부러 발생시키기
    // 예외 만들기
    // 예외 미루기 ◀
    //  : 실제로 예외가 발생한 곳에서 예외를 처리하는 것 xxx
    //    해당 함수(메서드, 객체)를 호출한 곳엥서 예외를 처리하는 것 O

    // 제가 함수 주인인데요,
    // 인덱스 값을 저한테주면 그 인덱스에 해당하는값을 전달해주는 함수
    public static int kim(int index) throws Exception { // 예외처리를 강제하는 키워드
        int[] datas = {11,22,33};
        return datas[index];
    }
    public static void main(String[] args) {
        int num;
        try {
            num = kim(3); // 반드시 예외처리를 해야 함
        } catch (Exception e) {
            System.out.println("정확한 인덱스로 호출해야 합니다");
        }
//        System.out.println(num);

        for(int i=0; i<10; i++){
            System.out.println("*");
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
