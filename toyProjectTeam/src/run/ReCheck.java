package run;

import java.util.HashMap;
import java.util.Map;

import createMap.CreateMap;
import crolling.Check;
import crolling.KeywordCrolling;

public class ReCheck {
	private static Map<String,Integer> checkMap = new HashMap<String,Integer>();
	
	public static Object check() {
		KeywordCrolling.crolling();
		CreateMap.getMap();
		Check.checkKeyword();
		for(String s : Check.resultMap.keySet()) {
			if(!checkMap.containsKey(s)) {
				checkMap.put(s, 0);
			}else {
				checkMap.put(s, checkMap.get(s)+1);
			}
			for(String s2 :checkMap.keySet()) {
				if(checkMap.get(s2)>3) {
					CreateMap.map.remove(s2);
					System.out.println("check");
					return check();
				}else {
					return null;
				}
			}
		}
		return null;
	}
}
