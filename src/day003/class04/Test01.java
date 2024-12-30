    package day003.class04;

    import java.util.Scanner;

    //정수 3개를 입력하고 3개의 합과 평균을 출력하세요
    public class Test01 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in); //scanner 객체 생성

            System.out.println("1번째 숫자를 입력해주세요 : ");
            int a = scanner.nextInt();//숫자 입력 받기
            System.out.println("2번째 숫자를 입력해주세요 : ");
            int b = scanner.nextInt();//숫자 입력 받기
            System.out.println("3번째 숫자를 입력해주세요 : ");
            int c = scanner.nextInt();//숫자 입력 받기

            int sum = a + b + c; // 총합은 a,b,c를 모두 더한 것

            //명시적 형변환
            //double avg = (double)(a + b+ c) / 3; //평균은 a,b,c를 더하고 3개를 나눈 것. (double)을 통해 정수를 실수화
            //명시적 형변환은 메모리에 타격이 갈 수 있어 묵시적 형변환을 추천함
            double avg = sum/3.0; //묵시적 형변환(.0을 붙이는거를 묵시적 형변환이라고 함)
            System.out.println("합 : " + sum);
            System.out.println("평균 : " + avg);
        }
    }
