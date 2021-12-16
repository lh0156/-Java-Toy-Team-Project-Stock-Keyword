package run;

import createMap.Check;
import createMap.CreateMap;
import createMap.SecondCheck;
import crolling.KeywordCrolling;
import crolling.Stoc;
import crolling.StockCrolling;

public class Run {

	public static void main(String[] args) {
		
		KeywordCrolling.crolling();
		
		
		CreateMap.getMap();
		SecondCheck.SecondCheck();
		System.out.println(Check.resultMap.toString());
		System.out.println("완료");
		
	}
}