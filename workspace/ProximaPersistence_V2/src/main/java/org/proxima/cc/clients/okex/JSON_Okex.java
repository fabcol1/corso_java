package org.proxima.cc.clients.okex;

import java.math.BigDecimal;
import java.time.*;
import java.util.Map;
import org.apache.log4j.Logger;
import org.proxima.cc.clients.CryptoCoinJSONInterface;

public class JSON_Okex implements CryptoCoinJSONInterface {
	Logger logger = Logger.getLogger(JSON_Okex.class);
	
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
	
	@Override
	public LocalDateTime getTimestampAsLocalDateTime() {
		String timeStamp = date;
		logger.info("TIMESTAMP: " + timeStamp);
		int timeStampInt = Integer.parseInt(timeStamp);
		logger.info("TIMESTAMP int: " + timeStampInt);
		LocalDateTime epoch = LocalDateTime.ofEpochSecond(timeStampInt, 0, ZoneOffset.UTC);
		epoch = LocalDateTime.ofInstant(epoch.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
		logger.info("EPOCH: " + epoch);
		return epoch;
	}
	
	@Override
	public BigDecimal getExchangeValue() {
		BigDecimal b = ticker.get("last");
		logger.info("LAST VALUE: " + b);
		return b;
	}
}