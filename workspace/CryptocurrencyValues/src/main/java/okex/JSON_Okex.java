package okex;

import java.math.BigDecimal;
import java.util.Map;

public class JSON_Okex {
	private String date;
	private Map<String, BigDecimal> ticker;
	
	public String getDate() {
		return date;
	}
	public Map<String, BigDecimal> getTicker() {
		return ticker;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setTicker(Map<String, BigDecimal> ticker) {
		this.ticker = ticker;
	}
}