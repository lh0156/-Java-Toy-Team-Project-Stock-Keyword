package Calculate;

import java.util.ArrayList;

import CreateMap.resultMap;
import MemberClass.StockIndex;
import MemberClass.StockMarketPrice;

public class getStockInfoCalculate { // Stock

	public ArrayList<StockMarketPrice> StockPrices = new ArrayList<StockMarketPrice>();
	public ArrayList<StockIndex> StockIndex = new ArrayList<StockIndex>();
	
	
	public void getStockCalculate() {

		for (String key : resultMap.resultMap.keySet()) {
			String company = resultMap.resultMap.get(key); // 회사명 담아준다.
			if (company.equals("not")) {
				continue;
			} else {
				String text = Crolling.StockCrolling.getStocData(company); // 크롤링한것을 하나의 변수에 담는다.

				StockMarketPrice stockPrice = new StockMarketPrice();

				stockPrice.setName(company);// 회사이름

				int startIndex = text.indexOf("현재가") + 4;
				String scText = text.substring(startIndex);
				scText = scText.substring(0, scText.indexOf(" ")); // 주가
				stockPrice.setStockPrice(scText);// 전일 주가

				startIndex = text.indexOf("전일대비") + 5;
				scText = text.substring(startIndex);
				int lastIndex = scText.indexOf("퍼센트");
				scText = scText.substring(0, lastIndex);
				lastIndex = scText.lastIndexOf(" ");
				scText = scText.substring(0, lastIndex);
				lastIndex = scText.lastIndexOf(" ");
				scText = scText.substring(0, lastIndex);
				lastIndex = scText.lastIndexOf(" ");
				scText = scText.substring(0, lastIndex);
				stockPrice.setPreviousDay(scText);// 전일 대비

				startIndex = text.indexOf("전일대비") + 5;
				scText = text.substring(startIndex);
				startIndex = scText.indexOf(" ") + 1;
				scText = scText.substring(startIndex);
				startIndex = scText.indexOf(" ") + 1;
				scText = scText.substring(startIndex);
				lastIndex = scText.indexOf("퍼센트") - 1;
				scText = scText.substring(0, lastIndex);
				stockPrice.setRateYesterDay(scText);// 전일대비수익률

				lastIndex = text.indexOf("PER") - 1;
				scText = text.substring(0, lastIndex);
				startIndex = scText.lastIndexOf(" ") + 1;
				scText = scText.substring(startIndex);
				stockPrice.setWeekMaximum(scText);// 주 최고

				startIndex = text.indexOf("최저") + 3;
				scText = text.substring(startIndex);
				lastIndex = scText.indexOf(" ");
				scText = scText.substring(0, lastIndex);
				stockPrice.setWeekMinimum(scText);// 주 최저

				startIndex = text.indexOf("매매단위") + 5;
				scText = text.substring(startIndex);
				lastIndex = scText.indexOf(" ");
				scText = scText.substring(0, lastIndex);
				stockPrice.setFaceValue(scText);// 액면가

				startIndex = text.indexOf("시가총액 시가총액") + 10;
				scText = text.substring(startIndex);
				lastIndex = scText.indexOf("시가총액순위");
				scText = scText.substring(0, lastIndex);
				stockPrice.setMarketCapitalization(scText);// 시가총액

				startIndex = text.indexOf("상장주식수") + 6;
				scText = text.substring(startIndex);
				lastIndex = scText.indexOf(" ");
				scText = scText.substring(0, lastIndex);
				stockPrice.setMakeStockScore(scText);// 발행 주식 수(상장 주식 수)
				
				StockPrices.add(stockPrice);
			}
		}
	}
	
	private void addStockIndex(String text,String companyName) {
	      StockIndex stocIndex = new StockIndex();
	      int startIndex = 0;
	      int lastIndex = 0;   
	      
	      lastIndex=text.indexOf("추정PERlEPS")-1;
	      startIndex =(text.substring(0,text.indexOf("추정PERlEPS")-1)).lastIndexOf(" ")+1;
	      stocIndex
	      .setEps(text.substring(startIndex,lastIndex));
	      
	      lastIndex=text.indexOf("배당수익률")-1; 
	      startIndex=text.substring(0,lastIndex).lastIndexOf(" ")+1;
	      stocIndex
	      .setBps(text.substring(startIndex,lastIndex));
	      
	      lastIndex=0;
	      startIndex=text.lastIndexOf("PER")+4;
	      stocIndex
	      .setPer(text.substring(text.lastIndexOf("PER")+4)
	            .substring(0,text.substring(text.lastIndexOf("PER")+4).indexOf(" ")));
	      
	      lastIndex=0;
	      startIndex=text.lastIndexOf("동일업종 PER")+9;
	      stocIndex.setBusinessPer((text.substring(text.lastIndexOf("동일업종 PER")+9))
	            .substring(0,(text.substring(text.lastIndexOf("동일업종 PER")+9)).indexOf(" ")));
	      
	      lastIndex=0;
	      startIndex=text.indexOf("현재가")+4;
	      stocIndex.setPbr(String.format("%.2f",(Double.parseDouble(text.substring(text.indexOf("현재가")+4)
	                     .substring(0,(text.substring(text.indexOf("현재가")+4)
	                     .indexOf(" "))).replaceAll(",","")))
	                     /(Double.parseDouble(stocIndex.getBps().replaceAll("[, 원]","")))));
	      
	      stocIndex.setName(companyName);
	      
	      StockIndex.add(stocIndex);
	   }



}