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
		
		
		startIndex = text.indexOf("하한가 ") + 4;//최저 하한가(이 주식의 가장 저점)
		scText = text.substring(startIndex);
		lastIndex = scText.indexOf(" ");
		scText= scText.substring(0, lastIndex);
		
		
		System.out.println(scText);

	}
}
