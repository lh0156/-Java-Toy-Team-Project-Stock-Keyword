package MemberClass;

public class StockPriceToday {
	
	private String companyName ="";//TODO 이름 추가
	private String stockPrice = ""; // 주가
	private String yesterdayPrice = ""; // 전일 주가
	private String rateYesterday = ""; // 전일대비 수익률 ex: 0.26~%
	private String previousday = ""; // 전일대비 수익가 ex: 상승 200원
	private String tradingValue = ""; // 거래 대금(ex: 914,987백만)
	private String marketPrice = ""; // 시가
	private String tradingVolume = ""; // 거래량(11,802,949)
	private String highPrice = ""; // 고가
	private String lowPrice = ""; // 저가
	private String maximumPrice = ""; // 최고 상한가
	private String minimumPrice = ""; // 최저 하한가

	public String getCompanyName() {//TODO 이름 추가
		return companyName;
	}

	public void setCompanyName(String companyName) {//TODO 이름 추가
		this.companyName = companyName;
	}
	public String getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(String stockPrice) {
		this.stockPrice = stockPrice;
	}

	public String getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(String marketPrice) {
		this.marketPrice = marketPrice;
	}

	public String getYesterdayPrice() {
		return yesterdayPrice;
	}

	public void setYesterdayPrice(String yesterdayPrice) {
		this.yesterdayPrice = yesterdayPrice;
	}

	public String getRateYesterday() {
		return rateYesterday;
	}

	public void setRateYesterday(String rateYesterday) {
		this.rateYesterday = rateYesterday;
	}

	public String getPreviousday() {
		return previousday;
	}

	public void setPreviousday(String previousday) {
		this.previousday = previousday;
	}

	public String getTradingVolume() {
		return tradingVolume;
	}

	public void setTradingVolume(String tradingVolume) {
		this.tradingVolume = tradingVolume;
	}

	public String getTradingValue() {
		return tradingValue;
	}

	public void setTradingValue(String tradingValue) {
		this.tradingValue = tradingValue;
	}

	public String getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(String highPrice) {
		this.highPrice = highPrice;
	}

	public String getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(String lowPrice) {
		this.lowPrice = lowPrice;
	}

	public String getMaximumPrice() {
		return maximumPrice;
	}

	public void setMaximumPrice(String maximumPrice) {
		this.maximumPrice = maximumPrice;
	}

	public String getMinimumPrice() {
		return minimumPrice;
	}

	public void setMinimumPrice(String minimumPrice) {
		this.minimumPrice = minimumPrice;
	}

	@Override
	public String toString() {
		return "StockPriceNow [stockPrice=" + stockPrice + ", marketPrice=" + marketPrice + ", yesterdayPrice="
				+ yesterdayPrice + ", rateYesterday=" + rateYesterday + ", previousday=" + previousday
				+ ", tradingVolume=" + tradingVolume + ", tradingValue=" + tradingValue + ", highPrice=" + highPrice
				+ ", lowPrice=" + lowPrice + ", maximumPrice=" + maximumPrice + ", minimumPrice=" + minimumPrice
				+ ", getStockPrice()=" + getStockPrice() + ", getMarketPrice()=" + getMarketPrice()
				+ ", getYesterdayPrice()=" + getYesterdayPrice() + ", getRateYesterday()=" + getRateYesterday()
				+ ", getPreviousday()=" + getPreviousday() + ", getTradingVolume()=" + getTradingVolume()
				+ ", getTradingValue()=" + getTradingValue() + ", getHighPrice()=" + getHighPrice() + ", getLowPrice()="
				+ getLowPrice() + ", getMaximumPrice()=" + getMaximumPrice() + ", getMinimumPrice()="
				+ getMinimumPrice() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
