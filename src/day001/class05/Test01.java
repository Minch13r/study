package day001.class05;

public class Test01 {
    public static void main(String[] args){

        // 변수
        // 값(데이터)을 저장할 수 있는 공간

        // 변수의 3요소
        // 1. 메모리 공간 => 데이터의 타입(자료형)을 미리 지정 ex) 4byte? 8byte?
        // 2. 메모리 주소 => 모든 메모리 공간에는 이름이 없을 수 있지만 주소는 있다! [hash]
        // 3. 변수이름(변수명) => 매번 주소를 부를 수 없기 때문에 개발자가 붙여준 이름(식별자)

        // 변수를 초기화했다.
        int num = 123;

        //변수를 선언, 정의했다.
        double data=0;

        String str;

        // 변수에 저장한 값 출력
        System.out.println(num);
        System.out.println(data);
    }
}
