package Apllication;

import Calculate.getStockInfoCalculate;
import CreateMap.CompanyMap;
import CreateMap.resultMap;
import Crolling.KeywordCrolling;
import View.MainView;

public class Apllication {

	public static void main(String[] args) {
		try {

			System.out.println("test Massage");
			KeywordCrolling.crolling();// 키워드

			CompanyMap.getMap();// 회사 정보(최초)
			MainView p = new MainView();
			resultMap.checkKeyword();
			
			MainView v =new MainView();
//			v.printPopularKeyworda();
			v.mainView();
			for (String key : resultMap.resultMap.keySet()) {
				String company = resultMap.resultMap.get(key); // 회사명 담아준다.
			}
			
			getStockInfoCalculate test = new getStockInfoCalculate ();
			
			test.getStockCalculate();
			
		} catch (Exception e) {

		}
		

	}
}