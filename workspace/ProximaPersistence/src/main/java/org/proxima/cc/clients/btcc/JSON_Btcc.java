package org.proxima.cc.clients.btcc;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.proxima.cc.clients.CryptoCoinJSONInterface;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JSON_Btcc implements CryptoCoinJSONInterface{
	
	final static Logger logger = Logger.getLogger(JSON_Btcc.class);
	
	private Map<String, String> ticker;
	
	public Map<String, String> getTicker() {
		return ticker;
	}


	public void setTicker(Map<String, String> ticker) {
		this.ticker = ticker;
	}


	public LocalDateTime getTimestampAsLocalDateTime () {
		
		String timestamp = ticker.get("Timestamp");
		// taglio i millisecondi...
		timestamp = timestamp.substring(0, timestamp.length()-3);
		int timeStampInt = Integer.parseInt(timestamp);
		
		LocalDateTime epoch = LocalDateTime.ofEpochSecond(timeStampInt, 0, ZoneOffset.UTC);
		epoch = LocalDateTime.ofInstant(epoch.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
		
		return epoch;
		
	}

	
	@Override
	public BigDecimal getExchangeValue () {
		String exchangeValue = ticker.get("Last");
		return new BigDecimal(exchangeValue);
		
	}
	
}


