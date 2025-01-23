package day017.model;

public class ProductDTO {
    private static int NUM=1001;
    private int num; // PK
    private String name;
    private int price;
    private int stock;
    private int count;
    public ProductDTO(String name,int price,int stock) {
        this.num=ProductDTO.NUM++;
        this.name=name;
        this.price=price;
        this.stock=stock;
        this.count=0;
    }
    public ProductDTO(String name,int price,int stock,boolean flag) {
        this.name=name;
        this.price=price;
        this.stock=stock;
        this.count=0;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public String toString() {
        if(this.stock<=0) {
            return "품절상품";
        }
        return "ProductDTO [num=" + num + ", name=" + name + ", price=" + price + ", stock=" + stock + ", count="
                + count + "]";
    }
}
