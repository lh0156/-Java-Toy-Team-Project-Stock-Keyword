package Calculate;

import CreateMap.resultMap;

public class test {

	public static void main(String[] args) {

		String company = "삼성전자";

		String text = Crolling.StockCrolling.getStocData(company);

		System.out.println(text);
		
		int startIndex = 0;
		int lastIndex = 0;
		String scText = "";
		
		startIndex = text.indexOf("전일대비") + 5;
		scText = text.substring(startIndex);
		lastIndex = scText.indexOf("퍼센트");
		scText = scText.substring(0, lastIndex);
		lastIndex = scText.lastIndexOf(" ");
		scText = scText.substring(0, lastIndex);
		lastIndex = scText.lastIndexOf(" ");
		scText = scText.substring(0, lastIndex);
		lastIndex = scText.lastIndexOf(" ");
		scText = scText.substring(0, lastIndex);
		
		
		
		
		System.out.println(scText);
		
		
		
		

//		System.out.println(scText);
//		int startIndex = text.indexOf("현재가") + 4;
//		String scText = text.substring(startIndex);
//		scText = scText.substring(0, scText.indexOf(" "));
		

		
	}
}
