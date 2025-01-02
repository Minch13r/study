package day005.class06;
//최소값 찾기
public class Test02 {
    public static void main(String[] args) {
        int[] datas = new int[5];
        datas[0]=5;
        datas[1]=1;
        datas[2]=7;
        datas[3]=9;
        datas[4]=2;
        System.out.print("[ ");
        for(int v:datas){
            System.out.print(v+" ");
        }
        System.out.println("]");

        /* 최소값 단정짓기
        * min값이 저장된 인덱스
        * [1]부터 마지막 인덱스까지 돌면서
        * 최소값보다 작은 값이 존재하는지 확인
        * min보다 작은 값을 찾았을 때 min 재설정
        * min값 출력 및 인덱스 찾기*/

        int min = datas[0];
        int minIndex=0;
        for(int i=1; i<datas.length; i++){
            if(min > datas[i]){
                min=datas[i];
                minIndex=i;
            }
        }

        System.out.println(min);
        System.out.println("min의 인덱스 : " + minIndex);
    }
}
