package day017.model;

import java.util.ArrayList;

public class ProductDAO {
    private ArrayList<ProductDTO> datas;
    private int realNum;
    public ProductDAO(){
        datas = new ArrayList<>();
        realNum = 1001;

        datas.add(new ProductDTO(realNum++, "콜라", 1200, 5));
        datas.add(new ProductDTO(realNum++, "사이다", 1100, 2));
        datas.add(new ProductDTO(realNum++, "커피", 600, 1));
    }

    public ArrayList<ProductDTO> selectAll(){
        ArrayList<ProductDTO> datas = new ArrayList<>();
        for(ProductDTO data : this.datas){
            datas.add(new ProductDTO(data.getNum(),
                    data.getName(),
                    data.getPrice(),
                    data.getStock()));
        }
        return datas;
    }

    public ProductDTO selectOne(int num){
        for(int i=0; i<datas.size(); i++){
            if(datas.get(i).getNum() == num){
                int realNum = datas.get(i).getNum();
                String name=datas.get(i).getName();
                int price=datas.get(i).getPrice();
                int stock=datas.get(i).getStock();
            }
        }
        return null;
    }


    public boolean insert(String name, int price, int stock){
        try {
            datas.add(new ProductDTO(realNum++, name, price, stock));
        } catch (Exception e){
            System.out.println("로그 : ProductDAO insert()에서 발생한 예외입니다.");
            return false;
        }
        return true;
    }

    public boolean update(int num, int count){
        // 제품을 찾아서 재고를 줄이고 판매량을 증가
        for(int i=0; i< datas.size(); i++){
            // 번호가 같은 경우 찾음
            if(datas.get(i).getNum() == num){
                // 빼야하는 재고수가 기존 재고보다 더 많으면 안되므로 유효성 검사
                if(datas.get(i).getStock() < count){
                    System.out.println("로그 : ProductDAO update()에서 발생한 false입니다. 재고가 부족합니다.");
                    return false;
                }
                // 원래재고 - 빼야하는 재고수
                datas.get(i).setStock(datas.get(i).getStock() - count);
                // 판매량 확인해야 하기 때문에 count 더해줌
                datas.get(i).setCount(datas.get(i).getCount() + count);
                return true;
            }
        }
        System.out.println("로그 : ProductDAO update()에서 발생한 false입니다. 해당 num은 없습니다");
        return false;
    }

    public boolean delete(int num){
        for(int i=0; i<this.datas.size(); i++){
            if(num == this.datas.get(i).getNum()){
                this.datas.remove(i);
                return true;
            }
        }
        return false;
    }
}
