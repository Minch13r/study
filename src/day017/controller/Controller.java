package day017.controller;

import day017.model.ProductDAO;
import day017.view.View;

public class Controller {
    private ProductDAO model;
    private View view;
    public Controller(){
        this.model = new ProductDAO();
        this.view = new View();
    }

    public void start(){
        // 어플 구현
        while(true){
            view.menuInfo();
            int command = view.inputCommand();

            if(command == 0){
                break;
            }

            // 제품 추가
            else if (command == 1) {
                String name = view.inputName();
                int price = view.inputPrice();
                int stock = view.inputStock();

                boolean flag = model.insert(name, price, stock);
                if(flag){
                    view.printTrue();
                }
                else {
                    view.printFalse();
                }
            }

            // 전체 데이터 출력
            else if (command == 2){
                view.printDatas(model.selectAll());
            }

            // 제품 구매
            else if (command == 3){
                // 번호 받아오기
                int num = view.inputNum();

                // 받아온 번호 보여주기
                view.printData(model.selectOne(num));

                // 몇개 살지 입력하기
                int count = view.inputCount();

                // 카운트 만큼 개수 변경하고, 성공인지 아닌지 출력
                boolean flag = model.update(num, count);
                if(flag){
                    view.printTrue();
                } else {
                    view.printFalse();
                }
            }

            // 제품 삭제
            else if (command == 4){
                view.printDatas(model.selectAll());
                // 번호 받아오기
                int num = view.inputNum();

                // 받아온 번호 넘겨주기
                view.printData(model.selectOne(num));

                // 성공인지 아닌지 출력
                boolean flag = model.delete(num);
                if(flag){
                    view.printTrue();
                } else {
                    view.printFalse();
                }
            }
        }
    }


}
