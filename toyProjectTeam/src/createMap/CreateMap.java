package createMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class CreateMap {

	public static HashMap<String,Integer> map;
	private static String path = ".\\신규상장기업현황.txt";
	
	public static void getMap() {
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
}