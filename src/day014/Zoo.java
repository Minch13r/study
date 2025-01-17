package day014;

import java.util.Random;
import java.util.Scanner;

// 동물 클래스 선언, AnimalCryImpl 파일 참조
abstract class Animal implements AnimalCryImpl {
    private String name; // 이름
    private int age; // 나이
    private String category; // 카테고리
    static Random rand = new Random(); // 랜덤객체

    //Getter, Setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    Animal(String name, int age, String category) { // 생성자
        this.name = name;
        this.age = age;
        this.category = category;
    }

    @Override // AnimalCryImpl 오버라이딩
    public abstract void cry(); // 우는 메서드

    @Override // toString 오버라이딩
    public String toString() {
        return "동물[" + "이름 = " + name + ", 나이 = " + age +
                ", 카테고리 = " + category + ']';
    }

    // 최대 랜덤 수 반환
    int returnRandomNum(int max) {
        // 자식 수 반환
        return rand.nextInt(max + 1);
    }
}

// 새끼는 어미 포유류와 함께 같이 들어온다는 가정
// 포유류 클래스 선언, 동물 상속
abstract class Mammal extends Animal {
    private int cubNumber; // 새끼수
    private String fur; // 털

    // 포유류 생성자, 부모 상속, 카테고리 포유류로 설정
    Mammal(String name, int age, int max) {
        super(name, age, "포유류");
        // 생성자에서 새끼 수를 랜덤으로 설정 (예: 최대 5마리)
        this.cubNumber = returnRandomNum(max);  // 최대 2마리까지 새끼 설정
        this.fur = furLength(); // 생성 시 털길이도 랜덤으로 생성

    }

    // Getter, Setter
    public String getFur() {
        return fur;
    }
    public void setFur(String fur) {
        this.fur = fur;
    }

    public int getCubNumber() {
        return cubNumber;
    }
    void setCubNumber(int cubNumber) {
        this.cubNumber = cubNumber;
    }

    // 총 마리수(어미 1마리 + 랜덤 생성 새끼 수)
    int sumNum() {
        return 1 + this.cubNumber;  // 어미 1마리 + 새끼 수
    }

    // 털길이 랜덤생성
    String furLength() {
        int furLength = returnRandomNum(2); // 0~2

        if (furLength == 0) {
            return "없음";
        } else if (furLength == 1) {
            return "짧음";
        } else {
            return "김";    // furLength가 2인 경우
        }
    }

    @Override
    public abstract void cry(); // 우는 메서드

    @Override
    public String toString() {
        return "포유류[" + "새끼수 = " + cubNumber + ", 털 길이 =" + fur + ']';
    }
}

// 파충류 클래스, 동물 상속
abstract class Reptiles extends Animal {
    private String scalePattern; // 비늘무늬
    private int eggNumber; // 알 개수

    // Getter, Setter
    public String getScalePattern() {
        return scalePattern;
    }

    public void setScalePattern(String scalePattern) {
        this.scalePattern = scalePattern;
    }

    public int getEggNumber() {
        return eggNumber;
    }

    public void setEggNumber(int eggNumber) {
        this.eggNumber = eggNumber;
    }

    Reptiles(String name, int age, int maxLay) {
        super(name, age, "파충류");
        // 비늘무늬 랜덤생성 메서드 호출
        this.scalePattern = returnRandomScalePatter();
        // 알 개수 랜덤생성 메서드 호출
        this.eggNumber = returnRandomNum(maxLay);
    }

    // 비늘무늬 랜덤생성 메서드
    public String returnRandomScalePatter() {
        int num = returnRandomNum(2);

        if (num == 0) {
            return "다이아몬드";
        } else if (num == 1) {
            return "빗살무늬";
        } else {
            return "점";
        }
    }

    // 울음소리 오버라이딩
    @Override
    public abstract void cry(); // 우는 메서드

    // 파충류 정보출력
    @Override
    public String toString() {
        return "파충류 [" + "비늘무늬 = " + scalePattern + ", 알 개수 = " + eggNumber + ']';
    }
}

// 낙타 클래스 선언, 포유류 상속
class Camel extends Mammal {
    private int hump;  // 혹 수

    //  혹 수와 나이를 받는 생성자로 수정
    Camel(int hump, int age) {
        // 최대 새끼수는 2마리
        super("낙타", age, 2);  // 부모 생성자 호출

        this.hump = hump;
    }

    // Getter, Setter
    public int getHump() {
        return hump;
    }

    public void setHump(int hump) {
        this.hump = hump;
    }

    // 울음소리 오버라이딩
    @Override
    public void cry() {
        System.out.println("우어우어어ㅓㅓㅓㅓ어ㅓㅓ…어어ㅓ어…ㅓㅓㅓ어");
    }

    // 정보 출력
    @Override
    public String toString() {
        return "이름 : 낙타\n" +
                "카테고리 : " + getCategory() + "\n" +
                "나이 : " + getAge() + "살\n" +
                "털 길이 : " + getFur() + "\n" +
                "혹 수 : " + this.hump + "\n" +
                "새끼 수 : " + getCubNumber() + "\n" +
                "전체 수 : " + sumNum();
    }
}

// 강아지 클래스 선언, 포유류 상속
class Dog extends Mammal {
    private String job; // 강아지 직업

    // 생성자
    Dog(String job, int age) {
        // 최대새끼수 5마리, 부모 생성자 호출
        super("강아지", age, 5);
        this.job = job;
    }

    // Getter, Setter
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    // 울음소리 오버라이딩
    @Override
    public void cry() {
        System.out.println("멍멍!");
    }

    // 강아지 정보 출력
    @Override
    public String toString() {
        return "이름 : 강아지\n" +
                "카테고리 : " + getCategory() + "\n" +
                "나이 : " + getAge() + "살\n" +
                "털 길이 : " + getFur() + "\n" +
                "직업 : " + this.job + "\n" +
                "새끼 수 : " + getCubNumber() + "\n" +
                "전체 수 : " + sumNum();
    }
}

// 거북이 클래스, 파충류 상속
class Turtle extends Reptiles {
    private int turtleSize; // 거북이 등껍질 크기

    // 거북이 생성자
    Turtle(int turtleSize, int age) {
        super("거북이", age, 10);
        this.turtleSize = turtleSize;
    }

    // Getter, Setter
    public int getTurtleSize() {
        return turtleSize;
    }
    public void setTurtleSize(int turtleSize) {
        this.turtleSize = turtleSize;
    }

    // 울음소리 오버라이딩
    @Override
    public void cry() {
        System.out.println("끡끡");
    }

    // 정보출력 오버라이딩
    @Override
    public String toString() {
        return "이름 : 거북이\n" +
                "카테고리 : " + getCategory() + "\n" +
                "나이 : " + getAge() + "살\n" +
                "비늘무늬 : " + getScalePattern() + "\n" +
                "등껍질 크기 : " + getTurtleSize() + "cm\n" +
                "알 수 : " + getEggNumber() + "개";
    }
}

// 도마뱀 클래스, 파충류 생성자
class Lizard extends Reptiles {
    private String tailRegen; // 꼬리재생여부 가능,불가능

    // 도마뱀 생성자
    Lizard(String tailRegen, int age) {
        // 부모 클래스 호출
        super("도마뱀", age, 3);
        this.tailRegen = tailRegen;
    }

    // 울음소리 오버라이딩
    @Override
    public void cry() {
        System.out.println("엥옝옝옝옝옝옝예");
    }

    // Getter, Setter
    public String getTailRegen() {
        return tailRegen;
    }
    public void setTailRegen(String tailRegen) {
        this.tailRegen = tailRegen;
    }

    // 정보출력 오버라이딩
    @Override
    public String toString() {
        return "이름 : 도마뱀\n" +
                "카테고리 : " + getCategory() + "\n" +
                "나이 : " + getAge() + "살\n" +
                "비늘무늬 : " + getScalePattern() + "\n" +
                "꼬리 재생여부 :" + getTailRegen() + "\n" +
                "알 개수 : " + getEggNumber() + "개" + "\n";
    }
}


public class Zoo {
    // 동물 전체 출력 함수
    public static void printAnimalInfo(Animal[] animals) {
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null) {  // null 체크 필요, 없으면 출력 안 해도 되니까
                System.out.println("\n=== " + (i + 1) + "번째 동물 정보 ===");
                System.out.println(animals[i].toString());
            }
        }
    }


    // main 함수
    public static void main(String[] args) {
        // 배열 선언 길이 4
        Animal[] animals = new Animal[4];

        // 샘플 데이터
        animals[0] = new Camel(2, 5); // 낙타,  혹 2개, 나이 5살
        animals[1] = new Dog("경찰견", 3); // 강아지, 직업 경찰견, 나이 3살
        animals[2] = new Lizard("가능", 3); // 도마뱀, 재생 가능, 나이 3살
        animals[3] = new Turtle(8, 6); // 거북이, 크기 8cm, 나이 6살

        // 스캐너 객체 선언
        Scanner sc = new Scanner(System.in);

        // 랜덤 객체 선언
        Random rand = new Random();

        // 동물 유무 유효성 검사, 무한 루프
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] == null) { // 배열이 비어있으면
                System.out.println("동물이 없습니다.");
                break; // 동물이 없으면 종료
            }
        }
        // 메뉴 관련 반복문, 무한루프
        while (true) {
            System.out.println("===== 메뉴판 =====");
            System.out.println("1. 동물 전체 출력");
            System.out.println("2. 가장 나이가 많은 동물 정보 출력");
            System.out.println("3. 이름 검색하여 정보 출력");
            System.out.println("4. ★★★ 오늘 하루 행운의 동물은? ★★★");
            System.out.println("0. 종료");
            System.out.print("숫자를 입력해주세요(0~4) \n>> ");
            int num = sc.nextInt(); // 스캐너로 숫자 입력

            if(num < 0 || 4 < num) { // 옳지 않은 메뉴번호 입력
                System.out.println("잘못된 입력입니다! 숫자를 다시 입력해주세요."); // 에러 안내
                continue; // 처음으로
            }
            else if (num == 0) { // 0. 종료 기능
                System.out.println("종료됩니다.");
                break; // 내부 while 탈출
            }
            else if (num == 1) { // 1. 동물 전체 출력
                printAnimalInfo(animals); // 동물 전체 출력 함수 호출
                continue;
            }
            else if (num == 2) { // 2. 가장 나이가 많은 동물 정보 출력
                Animal pivot = animals[0]; // 0번 인덱스가 피봇
                for (int i = 1; i < animals.length; i++) {
                    if (animals[i].getAge() > pivot.getAge()) { // i번 인덱스가 pivot보다 크면?
                        pivot = animals[i]; // pivot은 i번 인덱스의 값으로 저장
                        System.out.println("가장 나이가 많은 동물 정보 출력!!");
                        System.out.println(animals[i].toString()); // 해당 동물 정보 출력
                    }
                }
            }
            else if (num == 3) { // 3. 이름 검색하여 정보 출력
                while (true) { // 언제까지 입력할지 몰라서 무한루프
                    System.out.print("동물 이름을 입력해주세요 (종료는 0 입력) >> ");
                    String ans = sc.next();
                    // 0 입력시 검색 종료(뒤로 가게)
                    if (ans.equals("0")) {
                        break;
                    }
                    boolean flag = true;  // 동물을 찾았는지 확인하는 플래그
                    for (int i = 0; i < animals.length; i++) {
                        if (animals[i].getName().contains(ans)) {
                            System.out.println("\n=== 검색된 동물 정보 ===");
                            System.out.println(animals[i].toString());  // 배열에 해당하는 정보 출력
                            flag = false;  // 동물을 찾았으므로 false로 변경
                        }
                    }

                    if (flag) {  // 동물을 못 찾은 경우에만 메시지 출력
                        System.out.println("입력하신 이름의 동물이 없습니다.");
                    }
                }
            }
            else if (num == 4) { // 4. 행운의 동물 랜덤으로 출력
                int randNum = rand.nextInt(4); // 0~3번 인덱스
                animals[randNum].cry(); // 동물 울음소리
                // 해당 번호 동물 이름 호출
                System.out.println("오늘 하루 행운의 동물은 " + animals[randNum].getName() + "입니다.");

                // 대답 언제까지 제대로 입력할 줄 몰라서 while 무한루프
                while(true) {
                    System.out.print(animals[randNum].getName() + "의 정보를 보시겠습니까? (Y/N)\n>> ");
                    String ans = sc.next();
                    //유효성 검사, y랑 n 아니면 다시 입력하게 선언
                    if(!ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("n")){
                        System.out.println("잘못 입력하셨습니다 다시 입력해주세요");
                        continue; // 가독성 향상
                    }
                    // y 대/소문자 상관없이 정보 확인해줌
                    else if(ans.equalsIgnoreCase("y")){
                        System.out.println("정보를 확인합니다\n");
                        // 랜덤숫자에 해당하는 인덱스에 위치한 정보 출력
                        System.out.println(animals[randNum].toString());
                        break;
                    }
                    // n 대/소문자 상관없이 정보 확인 안 하고 반복문 탈출
                    else if (ans.equalsIgnoreCase("n")){
                        System.out.println("정보를 확인하지 않습니다.");
                        // 반복문 탈출
                        break;
                    }
                }
            }
        }
    }
}
