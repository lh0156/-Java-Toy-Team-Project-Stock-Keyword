package run;

import createMap.CreateMap;
import createMap.SecondCheck;
import crolling.KeywordCrolling;

public class Run {

	public static void main(String[] args) {
		
		KeywordCrolling.crolling();
		
		CreateMap.getMap();
		SecondCheck.SecondCheck();
		
	}
}