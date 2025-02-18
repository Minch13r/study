package javastudy.day017.model;

import java.util.ArrayList;

public class ProductDAO {
    ArrayList<ProductDTO> datas;
    public ProductDAO() {
        datas=new ArrayList<>();

        datas.add(new ProductDTO(1001,"콜라",1200,5));
        datas.add(new ProductDTO(1002,"사이다",1100,2));
        datas.add(new ProductDTO(1003,"커피",600,1));
    }

    public ArrayList<ProductDTO> selectAll(ProductDTO dto) {
        ArrayList<ProductDTO> datas = new ArrayList<>();
        if(dto.getCondition().equals("전체검색")) {
            for(int i=0; i<this.datas.size(); i++) {
                int num = this.datas.get(i).getNum();
                String name = this.datas.get(i).getName();
                int price = this.datas.get(i).getPrice();
                int stock = this.datas.get(i).getStock();
                datas.add(new ProductDTO(num, name, price, stock));
            }
        }
        else if(dto.getCondition().equals("이름검색")) {
            for(int i=0; i<this.datas.size(); i++) {
                if(this.datas.get(i).getName().contains(dto.getName())) {
                    int num = this.datas.get(i).getNum();
                    String name = this.datas.get(i).getName();
                    int price = this.datas.get(i).getPrice();
                    int stock = this.datas.get(i).getStock();
                    datas.add(new ProductDTO(num, name, price, stock));
                }
            }
        }
        return datas;
    }

    public ProductDTO selectOne(ProductDTO dto) {
        ProductDTO data = null;
        for(int i=0; i<this.datas.size(); i++) {
            if(dto.getNum() == this.datas.get(i).getNum()) {
                int num = this.datas.get(i).getNum();
                String name = this.datas.get(i).getName();
                int price = this.datas.get(i).getPrice();
                int stock = this.datas.get(i).getStock();
                data = new ProductDTO(num, name, price, stock);
                break;
            }
        }
        return data;
    }

    public boolean insert(ProductDTO dto) {
        try {
            int num = dto.getNum();
            String name = dto.getName();
            int price = dto.getPrice();
            int stock = dto.getStock();
            this.datas.add(new ProductDTO(num, name, price, stock));
        }
        catch(Exception e) {
            System.out.println("[MODEL 로그] : insert() 수행중에 예외발생");
            return false;
        }
        return true;
    }

    public boolean update(ProductDTO dto) {
        for(int i=0; i<this.datas.size(); i++) {
            if(this.datas.get(i).getNum() == dto.getNum()) {
                if(dto.getCondition().equals("재고변경")) {
                    int currentStock = this.datas.get(i).getStock();
                    int updateAmount = dto.getStock();
                    if(currentStock < updateAmount) {
                        return false;
                    }
                    this.datas.get(i).setStock(currentStock - updateAmount);
                    int currentCount = this.datas.get(i).getCount();
                    this.datas.get(i).setCount(currentCount + updateAmount);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean delete(ProductDTO dto) {
        for(int i=0; i<this.datas.size(); i++) {
            if(dto.getNum() == this.datas.get(i).getNum()) {
                this.datas.remove(i);
                return true;
            }
        }
        return false;
    }
}