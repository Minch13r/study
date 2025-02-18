package javastudy.day017.controller;

import javastudy.day017.model.ProductDAO;
import javastudy.day017.model.ProductDTO;
import javastudy.day017.view.View;
import java.util.ArrayList;

public class Controller {
    private ProductDAO model;
    private View view;
    private int realNum;
    ArrayList<ProductDTO> cart; // 장바구니m

    public Controller() {
        this.model = new ProductDAO();
        this.view = new View();
        this.realNum = 1001;
    }

    public void start() {
        while(true) {
            view.menuInfo();
            int command = view.inputCommand();

            if(command == 0) {
                break;
            }
            // 제품 추가
            else if(command == 1) {
                ProductDTO dto = new ProductDTO();
                dto.setName(view.inputName());
                dto.setPrice(view.inputPrice());
                dto.setStock(view.inputStock());
                dto.setNum(this.realNum++);

                boolean flag = model.insert(dto);
                if(flag) {
                    view.printTrue();
                }
                else {
                    view.printFalse();
                }
            }
            // 전체 제품 목록
            else if(command == 2) {
                ProductDTO dto = new ProductDTO();
                dto.setCondition("전체검색");
                ArrayList<ProductDTO> datas = model.selectAll(dto);
                view.printDatas(datas);
            }
            // 제품 구매
            else if(command == 3) {
                ProductDTO dto = new ProductDTO();
                dto.setNum(view.inputNum());

                // 제품 정보 확인
                ProductDTO data = model.selectOne(dto);
                view.printData(data);

                if(data != null) {
                    dto.setStock(view.inputCount());
                    dto.setCondition("재고변경");

                    boolean flag = model.update(dto);
                    if(flag) {
                        view.printTrue();
                    }
                    else {
                        view.printFalse();
                    }
                }
            }
            // 제품 삭제
            else if(command == 4) {
                // 전체 목록 출력
                ProductDTO dto = new ProductDTO();
                dto.setCondition("전체검색");
                ArrayList<ProductDTO> datas = model.selectAll(dto);
                view.printDatas(datas);

                // 삭제할 제품 선택
                dto = new ProductDTO();
                dto.setNum(view.inputNum());

                // 선택한 제품 정보 확인
                ProductDTO data = model.selectOne(dto);
                view.printData(data);

                if(data != null) {
                    boolean flag = model.delete(dto);
                    if(flag) {
                        view.printTrue();
                    }
                    else {
                        view.printFalse();
                    }
                }
            }
        }
    }
}
