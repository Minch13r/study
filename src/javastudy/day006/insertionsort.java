package javastudy.day006;

public class insertionsort {
    public static void main(String[] args) {
        int[] datas = new int[5];
        datas[0] = 8;
        datas[1] = 5;
        datas[2] = 6;
        datas[3] = 2;
        datas[4] = 4;
        for(int i=1;i<datas.length;i++) {
            int key = datas[i];
            for(int j=i-1;j>=0;j--) {
                if(datas[j] > key) {
                    int tmp=datas[j];
                    datas[j]=datas[j+1];
                    datas[j+1]=tmp;
                }
            }

        }
        System.out.print("[ ");
        for(int v : datas){
            System.out.print(v + " ");
        }
        System.out.print("]");
    }
}
