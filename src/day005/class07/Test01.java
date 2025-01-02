package day005.class07;
// 정렬 알고리즘
// 버블, 삽입, 선택, 퀵
// why?
// 데이터 검색을 빠르고 효율적으로 하기위함!
public class Test01 { //bubble sort
    public static void main(String[] args) {
        // Bubble sort 1회전 정렬을 하면 가장 큰 수는 제자리를 찾아가게 되어있음
        // 2회전 정렬을 하면 두번째로 큰 값이 제자리를 찾아간다.
        // 5개의 데이터라면 4회전 정렬을 했을 때 모두 제자리를 찾는다.

        int[] datas = new int[5];
        datas[0]=7;
        datas[1]=10;
        datas[2]=5;
        datas[3]=3;
        datas[4]=2;

        System.out.print("배열 : ");
        for (int v: datas){
            System.out.print(v + " ");
        }
        System.out.println();

        for(int a=0; a<datas.length-1; a++) {
            // [7 10 5 3 2]
            for (int i = 0; i < datas.length - 1; i++) { //양옆 데이터끼리 비교하는 횟수
                if (datas[i] > datas[i + 1]) {
                    // 교환 알고리즘
                    int tmp = datas[i];
                    datas[i] = datas[i + 1];
                    datas[i + 1] = tmp;
                }
                ;
            }
            System.out.print((a+1)+"회전 정렬 완료 : ");
            for (int v : datas) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
