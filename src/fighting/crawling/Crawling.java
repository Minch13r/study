package fighting.crawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.CoffeeDTO;

public class Crawling {
	public static ArrayList<CoffeeDTO> makeSample() { 
		final String URL="https://www.coffeebeankorea.com/menu/list.asp?category=13";

		Document doc=null;
		try {
			doc=Jsoup.connect(URL).get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		ArrayList<CoffeeDTO> datas=new ArrayList<>();
		int NUM=1001;

		Elements elems=doc.select("span.kor");
		Iterator<Element> itr=elems.iterator();
		Elements elems2=doc.select("dd");
		Iterator<Element> itr2=elems2.iterator();
		while(itr.hasNext()) {
			String name=itr.next().text();
			///System.out.println(name);
			
			String detail=itr2.next().text();
			///System.out.println(detail);
			itr2.next(); // 열량
			itr2.next(); // 나트륨
			itr2.next(); // 탄수화물
			itr2.next(); // 당
			itr2.next(); // 단백질
			itr2.next(); // 카페인
			itr2.next(); // 포화지방
			
			///System.out.println();

			CoffeeDTO data=new CoffeeDTO();
			data.setNum(NUM++);
			data.setName(name);
			data.setDetail(detail);
			datas.add(data);
		}

		for(CoffeeDTO coffee:datas) {
			///System.out.println(coffee);
		}
		
		return datas;
	}
}
