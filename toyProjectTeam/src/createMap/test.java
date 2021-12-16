package createMap;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class test {

	public static void main(String[] args) throws IOException {
		String issunowUrl = "https://issuenow.vercel.app/";
		Document doc=null;
		doc = Jsoup.connect(issunowUrl).get();
		
		System.out.println(doc);
	}
	
}
