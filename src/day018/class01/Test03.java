package day018.class01;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test03 {
    public static void main(String[] args) {
        try {
            // 1. 웹페이지 연결
            String url = "https://flixpatrol.com/top10/netflix/south-korea/2025-01-31/";
            Document doc = Jsoup.connect(url).get();

            System.out.println("페이지 연결 성공!");

            // 2. 영화 제목이 있는 링크 선택 (table-td 클래스 내의 a 태그)
            Elements titleElements = doc.select("td.table-td a[href^='/title/']");

            // 3. 결과 출력
            int rank = 1;
            for (Element title : titleElements) {
                // 텍스트에서 Netflix original 텍스트를 제거하고 출력
                String titleText = title.text().replace("Netflix original", "").trim();
                System.out.println(rank + ". " + titleText);
                rank++;
            }

        } catch (Exception e) {
            System.out.println("오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
