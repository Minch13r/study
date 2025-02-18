package javastudy.day015.class04;
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


import java.io.*;
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

근데 입력할 때마다 먼저 범위 조절을 해놔서 예외처리를 할거임
예를 들자면 1~90 사이의 정수를 입력하라고 했는데 0인 91을 넣으면
잘못된 입력입니다! 범위에 맞게 입력해주세요! 라고 하고
사과 이런식으로 문자열을 입력하면
잘못된 입력입니다! 정수로 입력해주세요! 라고 출력하게끔 진행

근데 이런 오류는 정답맞추기 시도횟수 카운팅 대상이 아니게끔 처리
카운트 개수가 1~5 사이면 금메달 이미지를, 6번 이상만에 정답을 맞추면
아무 이미지를 resource 폴더에 저장 */
public class Test01 {
    public static void main(String[] args) {
        // 경로
//        String path = "C:\\Users\\3333c\\Desktop\\school\\ACADEMY\\resource\\";
        String path = "D:\\new\\minch13r\\resource\\"; // 본인 test.txt 파일 경로 입력
        // 파일 이름
        String fileName = "test.txt"; // test.txt 파일 불러오기

        // 파일 읽는 작업
        FileReader fr;
        // 파일 쓰는 작업
        FileWriter fw;

        // scope 이슈
        // msg는 파일 내에 있는 문자열을 읽을 변수임
        String msgStr;

        int msg=0; // txt 파일에 있는 내용을 정수화 할 변수

        // 파일 읽기
        try {
            // FileReader는 파일 읽는 것
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
                msg = Integer.parseInt(msgStr); // parseInt는 static이 붙어 있어서 new 안 해도 됨
            }
        } catch (FileNotFoundException e) { // 파일이 없을 때 예외처리
            System.out.println("파일을 찾을 수 없습니다: " + path + fileName);
            e.printStackTrace();
        } catch (IOException e) { // 파일 읽기 중 오류가 발생했을 때 예외처리
            //throw new RuntimeException(e); //예외처리 미루기
            // main이기 때문에 예외처리 해줄 친구가 없어서
            System.out.println("파일 읽기 중 오류가 발생했습니다.");
            e.printStackTrace(); // 이게 더 나음, 바로 해결하는 형식
        }

        // 스캐너 객체 생성
        Scanner sc = new Scanner(System.in);

        System.out.println("업다운 게임을 진행합니다!");

        // 최대값 / 최소값 / 카운트 선언
        int min = 1;
        int max = 100;
        int cnt = 0;

        // 제대로 된 숫자를 얼만큼 입력할지 몰라서 while로 무한루프
        while(true) {
            System.out.print("숫자 " + min + "~" + max + "사이의 숫자를 입력해주세요!\n>> ");
            int num = sc.nextInt();

            // 범위 체크
            // 최소값이 num 보다 크거나 최대값이 num 보다 작으면
            // OR을 써서 둘 중 하나라도 True면 오류나게 진행
            if(num < min || num > max) {
                System.out.println("잘못된 입력입니다! 범위에 맞게 입력해주세요!");
                continue;
            }

            // 올바른 범위의 입력일 때만 카운트 증가
            // 올바른 범위의 입력이 아니면 카운트 증가하지 않음
            cnt++;

            // 정답일 때
            if (num == msg) {
                System.out.println("정답입니다! " + cnt + "번 만에 맞추셨습니다!");
                // 게임이 끝난 후, 시도 횟수에 따라 이미지 복사
                try {
                    // 원본 이미지
                    String sourceImage;
                    // 복사본 이미지
                    String targetImage;
                    if (cnt <= 5) { // 5번 이하로 정답을 맞추면
                        //C:\Users\3333c\Desktop\school\ACADEMY\java\goldmedal.png
                        sourceImage = "D:\\new\\minch13r\\resource\\goldmedal.jpg";
                        targetImage = path + "goldmedal_1.jpg";
                        System.out.println("축하합니다! 금메달 획득!");
                    } else { // 6번 이상으로 정답을 맞추면
                        sourceImage = "D:\\new\\minch13r\\resource\\fire.png";
                        targetImage = path + "fire_1.png";
                        System.out.println("아쉽네요! 다음에 더 잘해봐요!");
                    }

                    // 파일 읽기와 쓰기 객체 생성
                    // stream 형식으로 해야 더 복사가 잘 됨. 오류 나서 해결
                    FileInputStream fis = new FileInputStream(sourceImage);
                    FileOutputStream fos = new FileOutputStream(targetImage);

                    // 한 글자씩 읽어서 복사
                    while (true) {
                        int data = fis.read();
                        if (data == -1) { // 파일의 끝에 도달하면 종료
                            break;
                        }
                        fos.write(data);
                    }
                    // 파일 닫기
                    fis.close();
                    fos.close();

                    System.out.println("이미지가 성공적으로 저장되었습니다!");
                } catch (Exception e) {
                    System.out.println("파일 복사 중 오류 발생");
                }
                break;
            } else if (num > msg) { // txt 파일 안 있는 숫자가 입력한 값보다 작으면
                System.out.println("Down!");
                max = num - 1; // 최대값은 num - 1이여야 범위가 줄음
            } else { // txt 파일 안 있는 숫자가 입력한 값보다 크면
                System.out.println("Up!");
                min = num + 1; // 최소값은 num + 1이여야 범위가 줄음
            }
        }
    }
}
