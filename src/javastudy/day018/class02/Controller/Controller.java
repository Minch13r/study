package javastudy.day018.class02.Controller;

import javastudy.day018.class02.Model.Crawling;
import javastudy.day018.class02.Model.KyoChonDAO;
import javastudy.day018.class02.Model.KyochonDTO;
import javastudy.day018.class02.View.View;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private KyoChonDAO dao;
    private Crawling crawler;
    private Scanner sc;
    private View view;

    public Controller() {
        this.dao = new KyoChonDAO();
        this.crawler = new Crawling(dao);
        this.sc = new Scanner(System.in);
        this.view = new View();
    }

    public void appStart(){
        while(true){
            // 메뉴 보여줌
            view.showMainMenu();

            // 숫자 입력받기
            int num = view.inputNum();
            if(num == 0){
                view.printExit();
                break;
            }

            // 1. 메뉴 크롤링하기
            else if(num == 1){
                if(crawler.crawlMenuData()) {
                    view.printTrue();
                } else {
                    view.printFalse();
                }
            }

            // 2. 전체 메뉴 보기
            else if(num == 2){
                ArrayList<KyochonDTO> menus = dao.selectAll();
                if(menus.isEmpty()) {
                    view.printEmpty();
                } else {
                    view.printMenuList(menus);
                }
            }

            // 3. 메뉴 검색하기
            else if(num == 3){
                // view로부터 이름 입력받기
                String menuName = view.inputMenuName();

                // 이름 입력받은거 model에게 반환
                ArrayList<KyochonDTO> menus = dao.selectOne(menuName);
                // 메뉴가 해당하지 않으면
                if(menus == null) {
                    // 에러 메세지 출력
                    view.printNotFound();
                }
                else {
                    // 해당 내용 메뉴 출력
                    view.printMenu(menus);
                }
            }

            // 4. 메뉴 삭제하기
            else if(num == 4) {
                // view에 이름 입력하기
                String menuName = view.inputMenuName();
                // model에 이름 입력받은거 반환해서 선택
                ArrayList<KyochonDTO> menus = dao.selectOne(menuName);

                // 입력받으면 삭제 실행
                if(menus.isEmpty()) {
                    // 메뉴가 아무것도 없을 때 내용 출력
                    view.printNotFound();
                }
                else {
                    // 삭제 메서드 실행
                    dao.delete(menuName);
                    // 성공 메세지 출력
                    view.printTrue();
                }
            }
            // 다른거 입력했을 때
            else {
                view.inputElse();
            }

        }
    }
}
