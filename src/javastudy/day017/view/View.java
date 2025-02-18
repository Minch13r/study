package javastudy.day017.view;

import javastudy.day017.model.ProductDTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class View {
    Scanner scanner;
    public View() {
        scanner=new Scanner(System.in);
    }

    public void printDatas(ArrayList<ProductDTO> datas) {
        Iterator itr=datas.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
    public void menuInfo(){
        System.out.println("1. 제품추가");
        System.out.println("2. 전체출력");
        System.out.println("3. 제품 구매");
        System.out.println("4. 제품 삭제");
        System.out.println("0. 종료");
    }

    public void printData(ProductDTO data) {
        System.out.println(data);
    }

    public void printTrue() {
        System.out.println("성공!");
    }
    public void printFalse() {
        System.out.println("실패...");
    }

    public int inputCommand() {
        System.out.print("메뉴번호입력 >> ");
        return scanner.nextInt();
    }
    public String inputName() {
        System.out.print("제품명입력 >> ");
        return scanner.next();
    }
    public int inputPrice() {
        System.out.print("가격입력 >> ");
        return scanner.nextInt();
    }
    public int inputStock() {
        System.out.print("재고입력 >> ");
        return scanner.nextInt();
    }
    public int inputNum() {
        System.out.print("번호입력 >> ");
        return scanner.nextInt();
    }
    public int inputCount() {
        System.out.print("구매수량입력 >> ");
        return scanner.nextInt();
    }
}
