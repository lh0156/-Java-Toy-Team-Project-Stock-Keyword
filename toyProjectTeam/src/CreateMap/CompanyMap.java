package CreateMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class CompanyMap {

	public static HashMap<String,Integer> map;
	
	public static void getMap() {
		String path = ".\\신규상장기업현황.txt";
		
		map = new HashMap<String,Integer>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line = "";
			while((line=reader.readLine())!=null) {
				if(!(line.equals(" "))) {
					map.put(line, 0);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void clearValue(){
	      for(String s : map.keySet()) {
	         map.put(s, 0);
	      }
	   }
}