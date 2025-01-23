package day017.view;

import day017.model.ProductDTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class View {
    Scanner sc;
    public View(){
        sc = new Scanner(System.in);
    }

    public void printDatas(ArrayList<ProductDTO> datas){
        Iterator itr = datas.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }

    public void menuInfo(){
        System.out.println("1. 제품추가");
        System.out.println("2. 제품 전체 출력");
        System.out.println("3. 제품 구매");
        System.out.println("4. 제품 삭제");
    }

    public void printData(ProductDTO data) {
        System.out.println(data);
    }

    public int inputCommand(){
        System.out.print("메뉴번호 입력 >> ");
        return sc.nextInt();
    }

    public void printTrue(){
        System.out.println("성공!");
    }

    public void printFalse(){
        System.out.println("실패");
    }

    public String inputName(){
        System.out.print("제품명 입력 >> ");
        return sc.next();
    }

    public int inputPrice(){
        System.out.print("가격 입력 >> ");
        return sc.nextInt();
    }

    public int inputStock(){
        System.out.print("재고 입력 >> ");
        return sc.nextInt();
    }

    public int inputNum(){
        System.out.print("번호 입력 >> ");
        return sc.nextInt();
    }

    public int inputCount(){
        System.out.print("개수 입력 >> ");
        return sc.nextInt();
    }
}
