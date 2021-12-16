package createMap;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import crolling.KeywordCrolling;

public class Check {
	private static String url = "https://search.naver.com/search.naver?where=news&sm=tab_jum&query=";
	private static String addUrl = "+관련주식";
	public static Map<String, String> resultMap;

	public static void checkKeyword() {
		
		resultMap = new HashMap<String, String>();
		
		try {
			for (int i = 0; i < KeywordCrolling.keyword.size(); i++) {
				Document d = Jsoup.connect(url + KeywordCrolling.keyword.get(i) + addUrl).get();
				String txt=d.body().text();
				count(txt, KeywordCrolling.keyword.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void count(String txt, String keyword) {

		for (String key : CreateMap.map.keySet()) {
			int index = -1;
			int count = 0;
			while (txt.indexOf(key, index) != -1) {
				index = txt.indexOf(key, index) + key.length() + 1;
				count++;
			}
			CreateMap.map.put(key, count);
		}
		int max = 0;
		for (String s : CreateMap.map.keySet()) {
			if (CreateMap.map.get(s) > max) {
				max = CreateMap.map.get(s);
			}
		}
		System.out.println(max);
		if(max!=0) {
			for (String s : CreateMap.map.keySet()) {
				if (CreateMap.map.get(s) == max) {
					resultMap.put(keyword, s);
				}
			}
		}else {
			resultMap.put(keyword, null);
		}
		CreateMap.clearValue();
	}

}
