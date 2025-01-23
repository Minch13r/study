package day017.model;

import java.util.ArrayList;

public class ProductDAO {
    ArrayList<ProductDTO> datas;
    public ProductDAO() {
        datas=new ArrayList<>();

        datas.add(new ProductDTO("콜라",1200,5));
        datas.add(new ProductDTO("사이다",1100,2));
        datas.add(new ProductDTO("커피",600,1));
    }

    public ArrayList<ProductDTO> selectAll(){
        ArrayList<ProductDTO> datas=new ArrayList<>();
        for(ProductDTO data:this.datas) {
            String name=data.getName();
            int price=data.getPrice();
            int stock=data.getStock();
            datas.add(new ProductDTO(name,price,stock,false));
        }
        return datas;
    }
    public ProductDTO selectOne(int num){
        ProductDTO data=null;
        for(int i=0;i<datas.size();i++) {
            if(datas.get(i).getNum() == num) {
                String name=datas.get(i).getName();
                int price=datas.get(i).getPrice();
                int stock=datas.get(i).getStock();
                data=new ProductDTO(name,price,stock,false);
                break;
            }
        }
        return data;
    }

    public boolean insert(String name,int price,int stock) {
        try {
            datas.add(new ProductDTO(name,price,stock));
        }
        catch(Exception e) {
            System.out.println("로그 : ProductDAO insert()에서 발생한 예외입니다.");
            return false;
        }
        return true;
    }
    public boolean update(int num,int count) {
        for(int i=0;i<datas.size();i++) {
            if(datas.get(i).getNum() == num) {
                if(datas.get(i).getStock() < count) {
                    System.out.println("로그 : ProductDAO update()에서 발생한 false입니다. 재고가 부족합니다.");
                    return false;
                }
                datas.get(i).setStock(datas.get(i).getStock()-count);
                datas.get(i).setCount(datas.get(i).getCount()+count);
                return true;
            }
        }
        System.out.println("로그 : ProductDAO update()에서 발생한 false입니다. 해당 num은 없습니다.");
        return false;
    }
    public boolean delete(int num) {
        for(int i=0;i<datas.size();i++) {
            if(datas.get(i).getNum() == num) {
                datas.remove(i);
                return true;
            }
        }
        System.out.println("로그 : ProductDAO delete()에서 발생한 false입니다. 해당 num은 없습니다.");
        return false;
    }
}
