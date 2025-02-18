    package javastudy.day005.class06;
    // 최대값 찾기 알고리즘
    public class Test01 {
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
            System.out.print("]");

            // 1. [0]에 있는 값이 최대값일거라고 단정짓기
            int max=datas[0];
            int maxIndex=0; //max값이 저장된 인덱스 위치

            // 2. [1]부터 마지막 인덱스까지 돌면서,
            // 최대값보다 큰 값이 있는지 확인
            for(int i=1; i<datas.length; i++){
                if(max < datas[i]){
                    // 3. max가 잘못 설정된 경우
                    // 즉, max보다 큰 값을 찾은 경우
                    // max 재설정
                    max = datas[i];
                    maxIndex=i;
                }
            }
            System.out.println(max);
            System.out.println("max의 인덱스 : "+maxIndex);
        }
    }
