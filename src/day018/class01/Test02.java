package day018.class01;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Test02 {
    public static void main(String[] args) {
        // 크롤링 할 URL
        // 추출
        final String URL = "https://www.kyochon.com/menu/chicken.asp?code=18";

        Document doc = null;
        try {
            doc = Jsoup.connect(URL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 메뉴 정보가 있는 dl 태그를 선택합니다
        Elements elems = doc.select("dl.txt");
        // 각 메뉴 아이템을 순회하면서 메뉴명과 가격을 함께 출력합니다
        for (Element elem : elems) {
            // 메뉴명
            String menuName = elem.select("dt").text();
            // 설명
            String description = elem.select("dd").text();
            // 가격
            String price = elem.parent().select("p.money strong").text();

            System.out.println("================");
            System.out.println("메뉴명 : " + menuName);
            System.out.println("설명 : " + description);
            System.out.println("가격 : " + price + "원");
        }
        System.out.println("================");
    }
}