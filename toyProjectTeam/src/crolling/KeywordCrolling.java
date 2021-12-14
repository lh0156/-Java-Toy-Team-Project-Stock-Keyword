package crolling;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class KeywordCrolling {

	private static String issunowUrl = "https://issuenow.vercel.app/";
	private static Document doc=null;
	private static Elements body;
	public static List<String> keyword = new ArrayList<String>();
	
	public KeywordCrolling(){
		try {
			doc = Jsoup.connect(issunowUrl).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		crolling();
	}

	private static void crolling() {
		body = doc.select("a.animate__animated");
		int count =0;
		for(Element e : body) {
			if(count==20) break;
			String s = e.toString();
			String word = s.substring((s.indexOf('>')+1),s.length()-4);
			keyword.add(word);
			count++;
		}
	}
}
