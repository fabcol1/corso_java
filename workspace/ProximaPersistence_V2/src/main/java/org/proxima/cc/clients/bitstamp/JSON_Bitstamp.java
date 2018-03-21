package org.proxima.cc.clients.bitstamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import org.proxima.cc.clients.CryptoCoinJSONInterface;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JSON_Bitstamp implements CryptoCoinJSONInterface{
	private String timestamp;
	private String last;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "JSON_Bitstamp [timestamp=" + timestamp + ", last=" + last + "]";
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	@Override
	public LocalDateTime getTimestampAsLocalDateTime() {
		String timeStamp = timestamp ;
//		logger.info("TIMESTAMP: " + timeStamp);
		int timeStampInt = Integer.parseInt(timeStamp);
//		logger.info("TIMESTAMP int: " + timeStampInt);
		LocalDateTime epoch = LocalDateTime.ofEpochSecond(timeStampInt, 0, ZoneOffset.UTC);
		epoch = LocalDateTime.ofInstant(epoch.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
//		logger.info("EPOCH: " + epoch);
		return epoch ;
	}

	@Override
	public BigDecimal getExchangeValue() {
		// TODO Auto-generated method stub
		return new BigDecimal(last);
	}
	
	

}