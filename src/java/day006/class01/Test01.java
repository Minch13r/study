    package java.day006.class01;
    //복습
    public class Test01 {
        public static void main(String[] args) {
            int [] datas = new int[3];
            //3가지 조건
            for(int i=0;i<3;i++){
                datas[i]=(i+1)*10;
            }
            for(int v : datas){
                System.out.print(v + " ");
            }
        }
    }
