package day015.class01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test02 {
    public static void main(String[] args) {
        String path = "D:\\new\\minch13r\\resource\\";
        String fileName = "result.txt";

        // 버퍼라는 공간에 저장해뒀다가 다시 넘어가는데
        // BufferedReader는 버퍼 공간을 열어주는 열할
        FileReader fr;
        try {
            fr = new FileReader(path + fileName);
            // scope issue로 같이 넣음
            BufferedReader br = new BufferedReader(fr);

            while(true){
                String msg=br.readLine();
                if(msg == null){
                    break;
                    // EOF는 End of File이고 이게 파일 마지막에 숨겨져 있는데
                    // msg == null을 통해서 EOF를 찾고 그만 읽어도 된다고 말해줌
                }
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            //throw new RuntimeException(e); //예외처리 미루기
            // main이기 때문에 예외처리 해줄 친구가 없어서
            e.printStackTrace(); // 이게 더 나음, 바로 해결하는 형식
        }
    }
}
