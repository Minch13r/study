package day018.class02.Model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Crawling {
    private KyoChonDAO dao;
    final String URL = "https://www.kyochon.com/menu/chicken.asp?code=18";

    public Crawling(KyoChonDAO dao) {
        this.dao = dao;
    }

    public boolean crawlMenuData() {
        try {
            // 웹 페이지 연결
            Document doc = Jsoup.connect(URL).get();

            // 메뉴 정보 추출
            Elements menuItems = doc.select("dl.txt");

            for (Element item : menuItems) {
                // 메뉴명, 설명, 가격 추출
                String menuName = item.select("dt").text();
                String description = item.select("dd").text();
                String price = item.parent().select("p.money strong").text();

                KyochonDTO menuDTO = new KyochonDTO(menuName, description, price);
                dao.insert(menuDTO);
            }
            // 호출 성공하면 true
            return true;

        } catch (IOException e) {
            System.out.println("[로그] 크롤링 중 오류 발생: " + e.getMessage());
            // 호출 실패하면 false
            return false;
        }
    }
}