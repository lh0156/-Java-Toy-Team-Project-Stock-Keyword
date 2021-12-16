package run;

import createMap.CreateMap;
import createMap.SecondCheck;
import crolling.KeywordCrolling;

public class Run {

	public static void main(String[] args) {
		
		KeywordCrolling.crolling();
		
		CreateMap.getMap();
		SecondCheck.SecondCheck();
<<<<<<< HEAD
=======
		System.out.println(Check.resultMap.toString());
		System.out.println("완료");
>>>>>>> Feature#1
		
	}
}