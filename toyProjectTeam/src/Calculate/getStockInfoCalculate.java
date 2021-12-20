package Calculate;

import java.util.ArrayList;

import CreateMap.resultMap;
import MemberClass.StockIndex;
import MemberClass.StockMarketPrice;
import MemberClass.StockPriceToday;

public class getStockInfoCalculate { // Stock

	public ArrayList<StockMarketPrice> StockPrices = new ArrayList<StockMarketPrice>();
	public ArrayList<StockIndex> StockIndex = new ArrayList<StockIndex>();
	public ArrayList<StockPriceToday> StockPriceToday = new ArrayList<StockPriceToday>();

	public void getStockCalculate() {

		for (String key : resultMap.resultMap.keySet()) {
			String company = resultMap.resultMap.get(key); // 회사명 담아준다.
			if (company.equals("not")) {
				continue;
			} else {
				String text = Crolling.StockCrolling.getStocData(company); // 크롤링한것을 하나의 변수에 담는다.
				StockMarketPrice stockPrice = new StockMarketPrice();

				addStockIndex(text, company);// StockIndex를 추가해준다.
				addStockPriceToday(text, company);// StockPrice(현재가)를 추가해준다.

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

	private void addStockIndex(String text, String companyName) {
		StockIndex stocIndex = new StockIndex();
		int startIndex = 0;
		int lastIndex = 0;

		lastIndex = text.indexOf("추정PERlEPS") - 1;
		startIndex = (text.substring(0, text.indexOf("추정PERlEPS") - 1)).lastIndexOf(" ") + 1;
		stocIndex.setEps(text.substring(startIndex, lastIndex));

		lastIndex = text.indexOf("배당수익률") - 1;
		startIndex = text.substring(0, lastIndex).lastIndexOf(" ") + 1;
		stocIndex.setBps(text.substring(startIndex, lastIndex));

		lastIndex = 0;
		startIndex = text.lastIndexOf("PER") + 4;
		stocIndex.setPer(text.substring(text.lastIndexOf("PER") + 4).substring(0,
				text.substring(text.lastIndexOf("PER") + 4).indexOf(" ")));

		lastIndex = 0;
		startIndex = text.lastIndexOf("동일업종 PER") + 9;
		stocIndex.setBusinessPer((text.substring(text.lastIndexOf("동일업종 PER") + 9)).substring(0,
				(text.substring(text.lastIndexOf("동일업종 PER") + 9)).indexOf(" ")));

		lastIndex = 0;
		startIndex = text.indexOf("현재가") + 4;
		stocIndex.setPbr(String.format("%.2f",
				(Double.parseDouble(text.substring(text.indexOf("현재가") + 4)
						.substring(0, (text.substring(text.indexOf("현재가") + 4).indexOf(" "))).replaceAll(",", "")))
						/ (Double.parseDouble(stocIndex.getBps().replaceAll("[, 원]", "")))));

		stocIndex.setName(companyName);

		StockIndex.add(stocIndex);
	}

	private void addStockPriceToday(String text, String company) {

		StockPriceToday stockPriceToday = new StockPriceToday();
		int startIndex = 0;
		int lastIndex = 0;
		String scText = "";
		
		stockPriceToday.setCompanyName(company);//TODO 회사 이름 입력

		startIndex = text.indexOf("오늘의시세") + 6;// 주가
		scText = text.substring(startIndex);
		lastIndex = scText.indexOf("포인트") - 1;
		scText = scText.substring(0, lastIndex);
		stockPriceToday.setStockPrice(scText);

		startIndex = text.indexOf("시가") + 3;// 시가
		scText = text.substring(startIndex);
		lastIndex = scText.indexOf("고가") - 1;
		scText = scText.substring(0, lastIndex);
		stockPriceToday.setMarketPrice(scText);

		startIndex = text.indexOf("전일가") + 4;// 전일가
		scText = text.substring(startIndex);
		lastIndex = scText.indexOf("시가") - 1;
		scText = scText.substring(0, lastIndex);
		stockPriceToday.setYesterdayPrice(scText);

		lastIndex = text.indexOf("전일가") - 1; // 전일대비 수익률(%)
		startIndex = text.indexOf("전일대비") + 5;
		scText = text.substring(startIndex, lastIndex);
		startIndex = scText.indexOf(" ") + 1;
		scText = scText.substring(startIndex);
		startIndex = scText.indexOf(" ") + 1;
		scText = scText.substring(startIndex);
		startIndex = scText.indexOf(" ") + 1;
		scText = scText.substring(startIndex);
		stockPriceToday.setRateYesterday(scText);

		startIndex = text.indexOf("전일대비 ") + 5;// 전일대비 수익(변동)가
		scText = text.substring(startIndex);
		lastIndex = scText.indexOf("전일가");
		scText = scText.substring(0, lastIndex);
		lastIndex = scText.lastIndexOf(" ");
		scText = scText.substring(0, lastIndex);
		lastIndex = scText.lastIndexOf(" ");
		scText = scText.substring(0, lastIndex);
		lastIndex = scText.lastIndexOf(" ");
		scText = scText.substring(0, lastIndex);
		lastIndex = scText.lastIndexOf(" ");
		scText = scText.substring(0, lastIndex);
		stockPriceToday.setPreviousday(scText);//TODO set 추가

		startIndex = text.indexOf("거래량 ") + 4;// 거래량
		scText = text.substring(startIndex);
		lastIndex = scText.indexOf(" ");
		scText = scText.substring(0, lastIndex);
		stockPriceToday.setTradingVolume(scText);//TODO set 추가

		startIndex = text.indexOf("거래대금 ") + 6;// 거래대금
		scText = text.substring(startIndex);
		lastIndex = scText.indexOf(" ");
		scText = scText.substring(0, lastIndex);
		stockPriceToday.setTradingValue(scText);

		startIndex = text.indexOf("고가 ") + 3;// 고가
		scText = text.substring(startIndex);
		lastIndex = scText.indexOf(" ");
		scText = scText.substring(0, lastIndex);
		stockPriceToday.setHighPrice(scText);

		startIndex = text.indexOf("저가 ") + 3;// 저가
		scText = text.substring(startIndex);
		lastIndex = scText.indexOf(" ");
		scText = scText.substring(0, lastIndex);
		stockPriceToday.setLowPrice(scText);

		startIndex = text.indexOf("상한가 ") + 4;// 최고 상한가(이 주식의 가장 고점)
		scText = text.substring(startIndex);
		lastIndex = scText.indexOf(" ");
		scText = scText.substring(0, lastIndex);
		stockPriceToday.setMaximumPrice(scText);

		startIndex = text.indexOf("하한가 ") + 4;// 최저 하한가(이 주식의 가장 저점)
		scText = text.substring(startIndex);
		lastIndex = scText.indexOf(" ");
		scText = scText.substring(0, lastIndex);
		stockPriceToday.setMinimumPrice(scText);

		StockPriceToday.add(stockPriceToday);
	}

}