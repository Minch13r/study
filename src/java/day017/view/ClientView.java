package java.day017.view;

// 사용자 뷰
public class ClientView extends View {
    @Override
    public void menuInfo() {
        System.out.println("=== 사용자 메뉴 ===");
        System.out.println("1. 전체 제품 보기");
        System.out.println("2. 제품 검색");
        System.out.println("3. 제품 구매");
        System.out.println("0. 종료");
    }
}
