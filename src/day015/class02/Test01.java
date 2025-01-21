package day015.class02;

import java.io.*;

public class Test01 {
    public static void main(String[] args) {
        // 1. 원본 이미지를 코드로 불러오기
        // 2. 복사 이미지를 특정 경로에 작성하기
        String img = "D:\\new\\minch13r\\resource\\test.png";
        // destination 의 줄임말, 복사된 이미지가 도착할 곳
        String dest = "D:\\new\\minch13r\\resource\\test - 복사본.png";

        FileOutputStream fw = null;
        try {
            FileReader fr = new FileReader(img);
            fw = new FileOutputStream(dest);

            // 코드의 길이가 얼마나 길지 모름
            while (true) {
                int character = fr.read(); // 한글자씩 읽음
                if (character == -1) { // EOF는 null 을 넣는다고 했는데
                    // character를 정수형으로 선언해서 -1로 선언
                    // 이유는 EOF가 정수형으로 보면 0이 아니라 -1임
                    break;
                }
                fw.write(character); // 한글짜씩 읽은거 쓰기
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("로그 : 이미지 복붙 완료");
        }
    }
}
