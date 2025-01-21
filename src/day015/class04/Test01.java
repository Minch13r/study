package day015.class04;
/*
[1]
test.txt 파일에 1~100 사이의 정수를 하나 입력한 후 저장합니다.

사용자와 업다운게임을 진행합니다.
test.txt 파일에 저장된 정수가 80이라면,
1~100 사이의 정수입력 >> 50
업!
51~100 사이의 정수입력 >> 90
다운!
51~89 사이의 정수입력 >> 80
정답입니다!
총 3번만에 정답을 맞추셨습니다.
라고 출력해주세요.
그리고 "총 3번만에 정답을 맞추셨습니다."라는 내용의 result.txt 파일을 생성해주세요.

+) 오류사항에 대하여

1~90 사이의 정수입력 >> 91
잘못된 입력입니다! 범위에 맞게 입력해주세요!
1~19 사이의 정수입력 >> 사과
잘못된 입력입니다! 정수로 입력해주세요!

이렇게 오류 문구를 출력해주시고, 이는 정답맞추기 시도횟수 카운팅 대상이 아닙니다.

++) 1~5번만에 정답을 맞추면 금메달 이미지를,
6~번만에 정답을 맞추면 기본 이미지를 resource 폴더에 저장해주세요.
*/


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*===========================================================================*/
// 한글코딩
/*
test.txt 파일에 59 입력한채로 저장

"업다운게임을 진행합니다!"
FileReader로 읽으면 될 것 같음
try - catch 문으로 오류 잡아내고 숫자 판단하는거 진행
txt 파일 내에 있는거는 문자열, 정수형으로 형변환 해야 할 것 같음
사용자가 스캐너를 통해서 숫자를 입력하고 이를 num이라고 가정

1~100 사이의 정수 입력! num을 통해서 50입력함
업!이 나옴
업일 때 num+1 ~ 100 사이의 숫자를 입력하라고 출력
만약 90을 입력하면 다운!이 나옴
다운일 때 지난 num+1과 이번에 입력한 num-1을 통해 범위 출력
예를 들자면 51~89 사이의 정수 입력! 이런식으로
이런식으로 진행하면서 cnt 변수를 생성해서 게임을 한 번 진행할 때마다
카운트를 증가시킬 예정. 입력한 num 값이 FileReader를 통해 읽은 값과 동일하다면
그때 정답입니다! 총 cnt번만에 정답을 맞추셨습니다. 이런식으로 해서 몇번만에
답을 맞췄다고 출력. 그리고 "정답입니다! 총 cnt번만에 정답을 맞추셨습니다." 라는 내용의
result.txt 파일 생성

근데 입력할 때마다 try ~ catch 문을 써서 예외처리를 할거임
예를 들자면 1~90 사이의 정수를 입력하라고 했는데 0인 91을 넣으면
잘못된 입력입니다! 범위에 맞게 입력해주세요! 라고 하고
사과 이런식으로 문자열을 입력하면
잘못된 입력입니다! 정수로 입력해주세요! 라고 출력하게끔 진행

근데 이런 오류는 정답맞추기 시도횟수 카운팅 대상이 아니게끔 처리
카운트 개수가 1~5 사이면 금메달 이미지를, 6번 이상만에 정답을 맞추면
아무 이미지를 resource 폴더에 저장 */
public class Test01 {
    public static void main(String[] args) {
        String path = "D:\\new\\minch13r\\resource\\"; // 본인 test.txt 파일 경로 입력
        String fileName = "test.txt"; // test.txt 파일 불러오기

        // 파일 읽는 작업
        FileReader fr;
        // scope 이슈
        // msg는 파일 내에 있는 문자열을 읽을 변수임
        String msgStr;
        int msg; // txt 파일에 있는 내용을 정수화 할 변수

        // 파일 읽는 중
        try {
            fr = new FileReader(path + fileName);
            // scope issue로 같이 넣음
            BufferedReader br = new BufferedReader(fr);

            while (true) {
                msgStr = br.readLine();
                if (msgStr == null) {
                    break;
                    // EOF는 End of File이고 이게 파일 마지막에 숨겨져 있는데
                    // msgStr == null을 통해서 EOF를 찾고 그만 읽어도 된다고 말해줌
                }
//                System.out.println(msgStr); // 문자열 출력
                // 형변환 진행
                msg = Integer.parseInt(msgStr);
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다: " + path + fileName);
            e.printStackTrace();
        } catch (IOException e) {
            //throw new RuntimeException(e); //예외처리 미루기
            // main이기 때문에 예외처리 해줄 친구가 없어서
            System.out.println("파일 읽기 중 오류가 발생했습니다.");
            e.printStackTrace(); // 이게 더 나음, 바로 해결하는 형식
        }

        // 스캐너 객체 생성
        Scanner sc = new Scanner(System.in);

        System.out.println("업다운 게임을 진행합니다!");

        // 최대값 / 최소값 선언
        int min = 1;
        int max = 100;

        while(true){
            System.out.print("숫자 " + min + "~" + max + "사이의 숫자를 입력해주세요!\n>> ");
            // 입력받을 변수
            int num = sc.nextInt();
        }
    }
}
