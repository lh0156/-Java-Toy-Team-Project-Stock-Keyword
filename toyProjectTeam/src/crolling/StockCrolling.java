package crolling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class StockCrolling {
	
	public static void getStocData(String stocName) {
		
		String url ="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=";
		String addUrl="+주가";
		Document html;
		Elements sel;
		
		StockMarketPrice.setName(stocName);
		try {
			html = Jsoup.connect(url+stocName+addUrl).get();
			sel = html.select("div.ar_cont dt,dd");
			StringBuilder sb = new StringBuilder();
			for(Element e : sel) {
				sb.append(e.toString());
			}
			StockMarketPrice.setPreviousClose(((sb.substring(sb.indexOf("전일종가")+15).substring(0,(sb.substring(sb.indexOf("전일종가")+15).indexOf("\n"))))).trim());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
