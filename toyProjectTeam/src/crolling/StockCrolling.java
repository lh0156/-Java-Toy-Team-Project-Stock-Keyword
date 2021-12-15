package crolling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class StockCrolling {
	private static String url ="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=";
	private static String addUrl="+주가";
	private static Document html;
	private static Elements sel;
	
	public static void getStocData(String stocName) {
		Stoc.setName(stocName);
		try {
			html = Jsoup.connect(url+stocName+addUrl).get();
			sel = html.select("div.ar_cont dt,dd");
			StringBuilder sb = new StringBuilder();
			for(Element e : sel) {
				sb.append(e.toString());
			}
			Stoc.setPreviousClose(((sb.substring(sb.indexOf("전일종가")+15).substring(0,(sb.substring(sb.indexOf("전일종가")+15).indexOf("\n"))))).trim());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
