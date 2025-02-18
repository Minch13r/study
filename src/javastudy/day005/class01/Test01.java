package javastudy.day005.class01;
/* 배열 : 데이터를 저장하는 자료형
배열의 3가지 조건
1. 서로 관련된 데이터
2. 같은 자료형
3. 개수를 분명히 알아야 함

[연산자 new]

*  */
public class Test01 {
    public static void main(String[] args) {
        // int num = 10; //4byte 만큼 저장
        // double d=3.14; //8byte 만큼 저장
//        int stu1=80;
//        int stu2=99;
//        int stu3=60;
//        int[] stu = new int[3];
//        for(int i=1; i<=3; i++){
//            System.out.println("학생 "+i+"은 "+stu1+"점 입니다.");
//        }

        int[] stuList = new int[3];
        // 변수명 예시를 stuArr stuList stuDatas
        // int는 정수형의 변수를 쓰고 싶다는 뜻, stuArr은 이름
        // new int[3]은 3칸만큼의공간을 갖고싶다라는 뜻
        stuList[0]=80;
        stuList[1]=99;
        stuList[2]=60;

//        System.out.println("학생 1의 점수는 "+stuList[0]+"점입니다.");
//        System.out.println("학생 2의 점수는 "+stuList[1]+"점입니다.");
//        System.out.println("학생 3의 점수는 "+stuList[2]+"점입니다.");

        for(int i=0;i<3;i++){ //i+1은 index 때문에 +1 해준거임
            System.out.println("학생 " + (i+1) + "의 점수는 "+stuList[i]+"점 입니다.");
        }

        for(int v : stuList){
            System.out.println(v);
        }
    }
}
