package javastudy.day008.class05;
//model은 배열에서 원하는거를 가져오는 것
public class Test01 {
    public static void selectAll(int[] datas){
        for(int v : datas){
            System.out.print(v+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] datas = new int[10];
        selectAll(datas);
    }
}