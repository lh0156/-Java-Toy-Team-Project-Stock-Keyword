package run;

import createMap.CreateMap;
import crolling.Check;
import crolling.KeywordCrolling;

public class run {

	public static void main(String[] args) {
//		KeywordCrolling kc = new KeywordCrolling();
//		CreateMap.getMap();
//		for(String s : CreateMap.map.keySet()) {
//			System.out.println(s);
//		}
		Check.checkKeyword();
		System.out.println(Check.resultMap);
	}
}
