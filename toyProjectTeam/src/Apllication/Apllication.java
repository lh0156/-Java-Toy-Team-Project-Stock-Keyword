package Apllication;

import Calculate.getStockInfoCalculate;
import CreateMap.CompanyMap;
import CreateMap.resultMap;
import Crolling.KeywordCrolling;
import View.MainView;

public class Apllication {

	public static void main(String[] args) {
		try {

			KeywordCrolling.crolling();// 키워드
			
			CompanyMap.getMap();// 회사 정보(최초)
			
				
			
			resultMap.checkKeyword();

			
			MainView mainView = new MainView();
			mainView.mainView();
			
			getStockInfoCalculate test = new getStockInfoCalculate ();
			
			test.getStockCalculate();
			
			System.out.println(test.StockPrices.get(0).getPreviousDay());
			
		} catch (Exception e) {

		}

	}
}