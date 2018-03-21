package org.proxima.cc.clients.bitcore;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import org.proxima.cc.clients.CryptoCoinJSONInterface;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JSON_Bitcore implements CryptoCoinJSONInterface {
	private String price_usd;
	private String last_updated;

	public void setPrice_usd(String price_usd) {
		this.price_usd = price_usd;
	}

	public String getLast_updated() {
		return last_updated;
	}

	public void setLast_updated(String last_updated) {
		this.last_updated = last_updated;
	}
	
	public LocalDateTime getTimestampAsLocalDateTime () {
		String timeStamp = last_updated ;
//		logger.info("TIMESTAMP: " + timeStamp);
		int timeStampInt = Integer.parseInt(timeStamp);
//		logger.info("TIMESTAMP int: " + timeStampInt);
		LocalDateTime epoch = LocalDateTime.ofEpochSecond(timeStampInt, 0, ZoneOffset.UTC);
		epoch = LocalDateTime.ofInstant(epoch.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
//		logger.info("EPOCH: " + epoch);
		return epoch ;
		
	}
	public BigDecimal getExchangeValue () {
		return new BigDecimal(price_usd);
		
	}
	
	@Override
	public String toString() {
		return "JSON_Bitcore [timestamp=" + last_updated + ", last=" + price_usd + "]";
	}

}