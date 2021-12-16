package run;

import createMap.Check;
import createMap.CreateMap;
import createMap.SecondCheck;
import crolling.KeywordCrolling;
import crolling.StockMarketPrice;
import crolling.StockCrolling;

public class Apllication {

	public static void main(String[] args) {
		
		System.out.println("test Massage");
		KeywordCrolling.crolling();
		
		CreateMap.getMap();
		
		Check.checkKeyword();
		System.out.println(Check.txt.length());
		
		
		System.out.println("완료 되었습니다");
		
		System.out.println(Check.resultMap);
	}
}