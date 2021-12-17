package MemberClass;

public class StockMarketPrice {
	private String name = ""; // 회사이름
	private String stockPrice = ""; // 전일주가
	private String previousDay = ""; // 전일대비
	private String rateYesterDay = ""; // 전일대비수익률
	private String weekMaximum = ""; // 주 최고
	private String weekMinimum = ""; // 주 최저
	private String faceValue = ""; // 액면가
	private String marketCapitalization = ""; // 시가총액
	private String makeStockScore = ""; // 발행 주식 수

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(String stockPrice) {
		this.stockPrice = stockPrice;
	}

	public String getPreviousDay() {
		return previousDay;
	}

	public void setPreviousDay(String previousDay) {
		this.previousDay = previousDay;
	}

	public String getRateYesterDay() {
		return rateYesterDay;
	}

	public void setRateYesterDay(String rateYesterDay) {
		this.rateYesterDay = rateYesterDay;
	}

	public String getWeekMaximum() {
		return weekMaximum;
	}

	public void setWeekMaximum(String weekMaximum) {
		this.weekMaximum = weekMaximum;
	}

	public String getWeekMinimum() {
		return weekMinimum;
	}

	public void setWeekMinimum(String weekMinimum) {
		this.weekMinimum = weekMinimum;
	}

	public String getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(String faceValue) {
		this.faceValue = faceValue;
	}

	public String getMarketCapitalization() {
		return marketCapitalization;
	}

	public void setMarketCapitalization(String marketCapitalization) {
		this.marketCapitalization = marketCapitalization;
	}

	public String getMakeStockScore() {
		return makeStockScore;
	}

	public void setMakeStockScore(String maekStockScore) {
		this.makeStockScore = maekStockScore;
	}

	@Override
	public String toString() {
		return "StockMarketPrice [회사명=" + name + "| 전일주가=" + stockPrice + "| 전일대비=" + previousDay + "| 전일대비수익률="
				+ rateYesterDay + "| 주 최고값=" + weekMaximum + "| 주 최저값=" + weekMinimum + "| 액면가=" + faceValue + "| 시가총액="
				+ marketCapitalization + "| 발행 주식 수 =" + makeStockScore + "]";
	}

}
