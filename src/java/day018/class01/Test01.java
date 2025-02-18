package java.day018.class01;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Test01 {
    public static void main(String[] args) {
        // 크롤링 할 URL
        // 추출
        final String URL="https://www.coffeebeankorea.com/menu/list.asp?category=13";

        Document doc=null;
        try {
            doc=Jsoup.connect(URL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements elems=doc.select("span.kor");
        for(Element elem:elems) {
            String str=elem.text();
            System.out.println(str);
        }
    }
}