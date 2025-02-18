package java.day017.view;

// 관리자 뷰
public class AdminView extends View{
    @Override
    public void menuInfo() {
        System.out.println("=== 관리자 메뉴 ===");
        System.out.println("1. 제품 추가");
        System.out.println("2. 전체 제품 조회");
        System.out.println("3. 재고 관리");
        System.out.println("4. 제품 삭제");
        System.out.println("0. 종료");
    }
}
