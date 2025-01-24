package day018.class02.Model;

public class KyochonDTO {
    private String menuName;    // 메뉴명
    private String description; // 설명
    private String price;      // 가격

    // 생성자
    public KyochonDTO(String menuName, String description, String price) {
        this.menuName = menuName;
        this.description = description;
        this.price = price;
    }

    // Getter,Setter
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getMenuName() {
        return menuName;
    }
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "================\n" +
                "메뉴명 : " + menuName + "\n" +
                "설명 : " + description + "\n" +
                "가격 : " + price + "원";
    }
}
