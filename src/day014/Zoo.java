package day014;

import java.util.Random;
import java.util.Scanner;

// 인터페이스를 쓰는 이유 : 지금은 강제해야 할 메서드 수가 적지만, 나중에 그 수가 많아지면 한 곳에서 관리하는게
// 유지보수에 용이해 따로 interface 파일을 사용했고 참조했습니다.

// 클래스 내부 순서 1. 멤버변수 혹은 클래스 변수 | 2. 생성자 | 3. 메서드 | 4. getter/setter | 5. toString

// 동물 클래스 선언, AnimalCryImpl 파일 참조
// abstract 클래스를 쓰는 이유는 객체 생성을 막기위해서 추상화 시켰습니다.
// 자녀 클래스(Camel, Dog, Turtle, Lizard)만 객체 생성이 가능해야 하기 때문입니다.
abstract class Animal implements AnimalCryImpl {
    // 접근제어자 멤버변수
    // private를 쓴 이유는 내부에서만 참조 가능하고 외부에서 참조가 불가능하게 하기 위해서 사용
    // 이 접근제어자를 사용했기 때문에 getter와 setter로 값을 정의 및 가져오게끔 해봤습니다.
    private String name; // 멤버변수 이름
    private int age; // 멤버변수 나이
    private String category; // 멤버변수 카테고리
    static Random rand = new Random(); // 클래스변수 랜덤 객체 선언
    // random을 왜 클래스변수를 썼냐면, 랜덤객체를 계속 선언하면 memory leak가 발생하기 때문에
    // 이를 막기 위해 가장 상위 클래스에 클래스변수로 선언했습니다.

    Animal(String name, int age, String category) { // 생성자
        this.name = name;
        this.age = age;
        this.category = category;
    }

    @Override // AnimalCryImpl 오버라이딩
    // 인터페이스에서는 void cry라 선언했지만
    // 사실상 public abstract가 생략된 것이기에 사라진 것이 아니므로
    // 오버라이딩의 조건인 메서드 시그니처가 똑같아야 하기 때문에
    // public abstract를 붙이고 오버라이딩을 진행했습니다.
    public abstract void cry(); // 우는 메서드

    // 최대 랜덤 수 반환
    int returnRandomNum(int max) {
        // 인자를 정수형 max로 선언해서
        // 랜덤으로 자식 수 반환
        return rand.nextInt(max + 1);
    }

    //Getter, Setter
    public String getName() {
        // IDE에서는 자동으로 생성해주지 않지만
        // 저희는 공부하는 입장이고, 이게 어디를 참조하고 있는지
        // 명확하게 표현하기 위해서 getter에도 this를 붙여봤습니다.
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getCategory() {
        return this.category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    @Override // toString 오버라이딩
    // toString 오버라이딩을 진행한 이유는 실제로 쓰이지는 않지만
    // 만약에 값을 호출했을 때 hash 상태로 값이 나오기 때문에
    // 따로 오버라이딩을 진행해 표현해놨습니다.
    // 여기도 똑같이 this를 통해 자기자신을 가르키는 형식으로 진행시켜놨습니다.
    public String toString() {
        return "동물[" + "이름 = " + this.name + ", 나이 = " + this.age +
                ", 카테고리 = " + this.category + ']';
    }
}

// 새끼는 어미 포유류와 함께 같이 들어온다는 가정
// 포유류 클래스 선언, 동물 상속
abstract class Mammal extends Animal {
    private int cubNumber; // 새끼수
    private String fur; // 털

    // 포유류 생성자, 부모 상속, 카테고리 포유류로 설정
    Mammal(String name, int age, int max) {
        // 자식 생성자는 부모생성자를 가장 먼저 호출하기 때문에
        // 제일 위에 써준다.
        super(name, age, "포유류");
        // 생성자에서 새끼 수를 랜덤으로 설정 (예: 최대 5마리)
        // 함수에도 this가 생략되어 있어서 공부하는 입장이기에 this를 붙였습니다.
        this.cubNumber = this.returnRandomNum(max);  // 최대 2마리까지 새끼 설정
        this.fur = this.furLength(); // 생성 시 털길이도 랜덤으로 생성

    }

    // 총 마리수(어미 1마리 + 랜덤 생성 새끼 수)
    // 정수형을 반환해주기 때문에 int로 선언했습니다.
    int sumNum() {
        return 1 + this.cubNumber;  // 어미 1마리 + 새끼 수
    }

    // 털길이 랜덤생성
    // 문자열을 반환해주기 때문에 String 형식으로 선언
    String furLength() {
        // 털길이를 0~2 중 숫자를 랜덤으로 받아서
        // 털길이의 특징을 해당하는 숫자의 문자열을 반환해 나타냈습니다
        int furLength = this.returnRandomNum(2); // 0~2

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

    // Getter, Setter
    public String getFur() {
        return this.fur;
    }
    public void setFur(String fur) {
        this.fur = fur;
    }

    public int getCubNumber() {
        return this.cubNumber;
    }
    void setCubNumber(int cubNumber) {
        this.cubNumber = cubNumber;
    }

    // 동적바인딩
    // 부모에게 있는걸 자식이 끌어와서 부모걸 무시하고 자기 걸 쓰는 것
    @Override
    public String toString() {
        return this.getCategory() + "[새끼수 = " + this.cubNumber + ", 털 길이 =" + this.fur + ']';
    }
}

// 파충류 클래스, 동물 상속
abstract class Reptiles extends Animal {
    private String scalePattern; // 비늘무늬
    private int eggNumber; // 알 개수

    // 멤버변수에는 maxLay가 없지만 왜 썼냐면 super 를 통해서
    // 부모생성자를 호출해서 랜덤 관련 객체를 사용할 수 있게 했습니다.
    // 가장 상위 클래스에 선언을 해서 상속을 통해 재사용이 가능합니다.
    // 유지보수에 용이하게 코드를 짰습니다.
    Reptiles(String name, int age, int maxLay) {
        super(name, age, "파충류"); // 부모 생성자 호출
        // 비늘무늬 랜덤생성 메서드 호출
        this.scalePattern = this.returnRandomScalePatter();
        // 알 개수 랜덤생성 메서드 호출
        this.eggNumber = this.returnRandomNum(maxLay);
    }

    // 비늘무늬 랜덤생성 메서드
    public String returnRandomScalePatter() {
        // 0~2 사이의 숫자를 랜덤으로 출력해서
        // 숫자에 해당하는 문자열을 반환하도록 했습니다.
        int num = this.returnRandomNum(2);

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

    // Getter, Setter
    public String getScalePattern() {
        return this.scalePattern;
    }

    public void setScalePattern(String scalePattern) {
        this.scalePattern = scalePattern;
    }

    public int getEggNumber() {
        return this.eggNumber;
    }

    public void setEggNumber(int eggNumber) {
        this.eggNumber = eggNumber;
    }

    // 파충류 정보출력
    @Override
    public String toString() {
        return this.getCategory() + "[비늘무늬 = " + this.scalePattern + ", 알 개수 = " + this.eggNumber + ']';
    }
}

// 낙타 클래스 선언, 포유류 상속
class Camel extends Mammal {
    private int hump;  // 혹 수

    // 혹 수와 나이를 받는 생성자로 수정
    Camel(int hump, int age) {
        // 최대 새끼수는 2마리로 설정
        super("낙타", age, 2);  // 부모 생성자 호출
        this.hump = hump;
    }

    // 울음소리 오버라이딩
    @Override
    public void cry() {
        System.out.println("우어우어어ㅓㅓㅓㅓ어ㅓㅓ…어어ㅓ어…ㅓㅓㅓ어");
    }

    // Getter, Setter
    public int getHump() {
        return this.hump;
    }

    public void setHump(int hump) {
        this.hump = hump;
    }

    // 정보 출력
    @Override
    public String toString() {
        return "이름 :" + this.getName() + "\n" +
                "카테고리 : " + this.getCategory() + "\n" +
                "나이 : " + this.getAge() + "살\n" +
                "털 길이 : " + this.getFur() + "\n" +
                "혹 수 : " + this.hump + "\n" +
                "새끼 수 : " + this.getCubNumber() + "\n" +
                "전체 수 : " + this.sumNum();
    }
}

// 강아지 클래스 선언, 포유류 상속
class Dog extends Mammal {
    private String job; // 강아지 직업

    // 생성자
    Dog(String job, int age) {
        // 최대새끼수 5마리로 설정, 부모 생성자 호출
        super("강아지", age, 5);
        this.job = job;
    }

    // 울음소리 오버라이딩
    @Override
    public void cry() {
        System.out.println("멍멍!");
    }

    // Getter, Setter
    public String getJob() {
        return this.job;
    }
    public void setJob(String job) {
        this.job = job;
    }

    // 강아지 정보 출력
    @Override
    public String toString() {
        return "이름 :" + this.getName() + "\n" +
                "카테고리 : " + this.getCategory() + "\n" +
                "나이 : " + this.getAge() + "살\n" +
                "털 길이 : " + this.getFur() + "\n" +
                "직업 : " + this.job + "\n" +
                "새끼 수 : " + this.getCubNumber() + "\n" +
                "전체 수 : " + this.sumNum();
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

    // 울음소리 오버라이딩
    @Override
    public void cry() {
        System.out.println("끡끡");
    }

    // Getter, Setter
    public int getTurtleSize() {
        return this.turtleSize;
    }
    public void setTurtleSize(int turtleSize) {
        this.turtleSize = turtleSize;
    }

    // 정보출력 오버라이딩
    @Override
    public String toString() {
        return "이름 :" + this.getName() + "\n" +
                "카테고리 : " + this.getCategory() + "\n" +
                "나이 : " + this.getAge() + "살\n" +
                "비늘무늬 : " + this.getScalePattern() + "\n" +
                "등껍질 크기 : " + this.getTurtleSize() + "cm\n" +
                "알 수 : " + this.getEggNumber() + "개";
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
        return this.tailRegen;
    }
    public void setTailRegen(String tailRegen) {
        this.tailRegen = tailRegen;
    }

    // 정보출력 오버라이딩
    @Override
    public String toString() {
        return "이름 :" + this.getName() + "\n" +
                "카테고리 : " + this.getCategory() + "\n" +
                "나이 : " + this.getAge() + "살\n" +
                "비늘무늬 : " + this.getScalePattern() + "\n" +
                "꼬리 재생여부 :" + this.getTailRegen() + "\n" +
                "알 개수 : " + this.getEggNumber() + "개" + "\n";
    }
}


public class Zoo {
    // 동물 전체 출력 함수
    // animals의 배열 길이만큼 반복하게 설정
    // i+1을 한 이유는 실제 인덱스는 0부터 시작하기에 우리가 원하는 숫자인 1부터 시작하기 위해서 적었습니다.
    public static void printAnimalInfo(Animal[] animals) {
        for (int i = 0; i < animals.length; i++) {
            // NPE 체크
            if (animals[i] != null) {  // null 체크 필요, 없으면 출력 안 해도 되니까
                System.out.println("\n=== " + (i + 1) + "번째 동물 정보 ===");
                System.out.println(animals[i].toString()); // 해당 인덱스의 동물 정보 출력
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

        // 스캐너와 랜덤 객체를 계속 new 해주면 memory leak가 발생하기 때문에
        // while문 바깥에다가 생성해줬습니다.

        // 스캐너 객체 선언
        Scanner sc = new Scanner(System.in);

        // 랜덤 객체 선언
        // 클래스에서 쓰는 Random 객체와는 다르게 main 함수에서 사용하기에 새로 선언
        Random rand = new Random();

        // 동물 유무 유효성 검사
        boolean hasAnimalFlag = false; // 동물이 없는 상태로 가정
        for (Animal animal : animals) {
            if (animal != null) { // 동물이 있으면
                hasAnimalFlag = true; // true로 값변환
                break; // for문 종료
            }
        }

        // true로 내려오면 false로 진행되기 때문에 if문이 실행이 안 됨
        if (!hasAnimalFlag) { // 동물이 없으면 false가 그대로 내려와 true진행
            System.out.println("동물이 하나도 없습니다."); // 에러안내
            return; // 종료
        }

        // 메뉴(기능) 관련 반복문, 무한루프
        while (true) {
            System.out.println("===== 메뉴판 =====");
            System.out.println("1. 동물 전체 출력");
            System.out.println("2. 가장 나이가 많은 동물 정보 출력");
            System.out.println("3. 이름 검색하여 정보 출력");
            System.out.println("4. ★★★ 오늘 하루 행운의 동물은? ★★★");
            System.out.println("0. 종료");
            System.out.print("숫자를 입력해주세요(0~4) \n>> ");
            int num = sc.nextInt(); // 스캐너로 숫자 입력

            if(num < 0 || 4 < num) { // 옳지 않은 메뉴번호 입력, 유효성 검사
                System.out.println("잘못된 입력입니다! 숫자를 다시 입력해주세요."); // 에러 안내
                continue; // 메뉴 처음으로, 가독성 향상
            }
            else if (num == 0) { // 0. 종료 기능
                System.out.println("종료됩니다."); // 종료안내 UI/UX
                break; // while 탈출
            }
            else if (num == 1) { // 1. 동물 전체 출력
                printAnimalInfo(animals); // 동물 전체 출력 함수 호출
                continue; // 메뉴 처음으로, 가독성 향상
            }
            else if (num == 2) { // 2. 가장 나이가 많은 동물 정보 출력
                Animal pivot = animals[0]; // 0번 인덱스가 피봇으로 기준
                for (int i = 1; i < animals.length; i++) {
                    if (animals[i].getAge() > pivot.getAge()) { // i번 인덱스가 pivot보다 크면?
                        pivot = animals[i]; // pivot은 i번 인덱스의 값으로 저장
                        System.out.println("가장 나이가 많은 동물 정보 출력!!"); // UI/UX
                        System.out.println(animals[i].toString()); // 해당 동물 정보 출력
                    }
                }
            }
            else if (num == 3) { // 3. 이름 검색하여 정보 출력
                while (true) { // 언제까지 입력할지 몰라서 무한루프
                    // 유일하게 계속 반복되기 때문에 종료 0번을 따로 둬서 사용자가 원할 때 탈출할 수 있게
                    // 편리성을 좀 더 높여봤습니다.
                    System.out.print("동물 이름을 입력해주세요 (종료는 0 입력) >> ");
                    String ans = sc.next(); // 동물 이름도 입력받고 숫자도 입력받아야 해서 String
                    // 0 입력시 검색 종료(뒤로 가게)
                    if (ans.equals("0")) { // "0"으로 넣어서 정수를 입력하는 것처럼 보이지만 실제로는 문자열임을 설정
                        // tip. 원시타입과 원시타입이 아닌 자료형은 ==으로 비교가 안돼서 .equals 사용
                        break;
                    }
                    boolean hasStringContainsFlag = false;  // 동물을 찾았는지 확인하는 플래그
                    // 못 찾았다고 가정
                    for (int i = 0; i < animals.length; i++) {
                        // ans.contains(animals[i].getName()) 일 경우, ans에서 저 배열에 포함된 값을 비교하게 되니까
                        // 비교하는 위치(앞, 뒤)가 중요하기 때문에 유의해야 한다.
                        if (animals[i].getName().contains(ans)) { // contain을 사용해 문자 하나만 해당해도 출력하게끔 진행
                            System.out.println("\n=== 검색된 동물 정보 ===");

                            System.out.println(animals[i].toString());  // 배열에 해당하는 정보 출력
                            hasStringContainsFlag = true;  // 동물을 찾았으므로 false로 변경
                        }
                    }

                    if (!hasStringContainsFlag) {  // 동물을 못 찾은 경우에만 메시지 출력
                        System.out.println("입력하신 이름의 동물이 없습니다.");
                    }
                }
            }
            // else로 진행해도 되는데 확장할 경우 가독성을 위해서 else if (num == 4)로 진행
            else if (num == 4) { // 4. 행운의 동물 랜덤으로 출력
                int randNum = rand.nextInt(4); // 0~3번 인덱스
                animals[randNum].cry(); // 동물 울음소리
                // 해당 번호 동물 이름 호출

                // 이름 불러오기, UI/UX
                System.out.println("오늘 하루 행운의 동물은 " + animals[randNum].getName() + "입니다.");

                // 대답 언제까지 제대로 입력할 줄 몰라서 while 무한루프
                while(true) {
                    System.out.print(animals[randNum].getName() + "의 정보를 보시겠습니까? (Y/N)\n>> ");
                    String ans = sc.next();
                    //유효성 검사, y랑 n 아니면 다시 입력하게 선언, y랑 n 둘 다 대/소문자 상관없이 확인
                    if(!ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("n")){
                        System.out.println("잘못 입력하셨습니다 다시 입력해주세요"); // 에러
                        continue; // 가독성 향상
                    }
                    // y 대/소문자 상관없이 정보 확인해줌
                    else if(ans.equalsIgnoreCase("y")){
                        System.out.println("정보를 확인합니다\n"); // UI/UX
                        // 랜덤숫자에 해당하는 인덱스에 위치한 정보 출력
                        // .toString()을 사용 안 해도 자동호출 돼서 정상적으로 실행이 되지만
                        // 공부하는 입장이기 때문에 진행
                        System.out.println(animals[randNum].toString());
                        break; // 반복문 탈출
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
