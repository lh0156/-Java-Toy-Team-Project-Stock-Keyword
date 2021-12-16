package run;

import createMap.Check;
import createMap.CreateMap;
import createMap.SecondCheck;
import crolling.KeywordCrolling;
import crolling.Stoc;
import crolling.StockCrolling;

public class Apllication {

	public static void main(String[] args) {
		
		System.out.println("test Massage");
		KeywordCrolling.crolling();
		
		CreateMap.getMap();
		SecondCheck.SecondCheck();
<<<<<<< HEAD:toyProjectTeam/src/run/Run.java
		System.out.println(Check.resultMap.toString());
		System.out.println("완료");
=======
		
		System.out.println("완료 되었습니다");
		
>>>>>>> b9ea4e6f4a1fb7ee071ab77061048d571541597e:toyProjectTeam/src/run/Apllication.java
		
	}
}