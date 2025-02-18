package javastudy.day015.class01;

import java.io.FileWriter;
import java.io.IOException;

// [ 파일 입출력 ]
// 1. 문서(.txt)로 실습
// 2. 이미지(.png, .jpg)로 실습
public class Test01 {
    public static void main(String[] args) {
        // 입력(input) : 컴퓨터에 저장되어있던 파일의 내용을 코드로 불러오기 -> R 읽기 모드
        // 출력(output) : 코드의 내용을 컴퓨터로 내보내기(컴퓨터에 저장시키기) -> W 쓰기 모드

        String path = "D:\\new\\minch13r\\resource\\";
        String fileName = "result.txt"; // 내보내기, 이름 지정
        String msg = "hello";

        //초기화 하지 않으면 닫기가 안 될 수 있기 때문에 null로 초기화
        FileWriter fw = null;
        //fw.write(msg)만 하면 오류날 수 있어서 try~catch문을 사용해야 함
        // 따로 하는것도 좋지만 depth 때문에 한꺼번에 묶어서 진행 가능.
        try {
            fw = new FileWriter(path + fileName);
            fw.write(msg);
        } catch (IOException e) { // 메모리가 부족할 수 있기 때문에
            e.printStackTrace(); // 예외처리를 하는거라고 생각하면 됨
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("로그 : 파일 쓰기(출력)가 완료되었습니다.");
        }
    }
}
