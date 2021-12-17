package Apllication;

import Calculate.SecondCheck;
import Calculate.getStockInfoCalculate;
import CreateMap.CompanyMap;
import CreateMap.resultMap;
import Crolling.KeywordCrolling;
import Crolling.StockCrolling;
import MemberClass.StockMarketPrice;

public class Apllication {

	public static void main(String[] args) {
		try {

			System.out.println("test Massage");
			KeywordCrolling.crolling();// 키워드

			CompanyMap.getMap();// 회사 정보(최초)

			resultMap.checkKeyword();

			for (String key : resultMap.resultMap.keySet()) {
				String company = resultMap.resultMap.get(key); // 회사명 담아준다.
				System.out.println(company);
			}

		} catch (Exception e) {

		}

	}
}