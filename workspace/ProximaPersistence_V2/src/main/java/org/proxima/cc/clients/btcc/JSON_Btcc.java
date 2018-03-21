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
		logger.info("DENTRO getTicker");
		return ticker;
	}


	public void setTicker(Map<String, String> ticker) {
		logger.info("DENTRO setTicker");
		this.ticker = ticker;
	}


	public LocalDateTime getTimestampAsLocalDateTime () {
		
		logger.info("DENTRO getTimestampAsLocalDateTime");
		String timestamp = ticker.get("Timestamp");
		// taglio i millisecondi...
		timestamp = timestamp.substring(0, timestamp.length()-3);
		logger.info(timestamp);
		int timeStampInt = Integer.parseInt(timestamp);
		
		LocalDateTime epoch = LocalDateTime.ofEpochSecond(timeStampInt, 0, ZoneOffset.UTC);
		epoch = LocalDateTime.ofInstant(epoch.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
		
		logger.info(epoch);
		logger.info("FUORI getTimestampAsLocalDateTime");
		return epoch;
		
	}

	
	@Override
	public BigDecimal getExchangeValue () {
		logger.info("DENTRO getExchangeValue");
		String exchangeValue = ticker.get("Last");
		logger.info(exchangeValue);
		logger.info("RETURN");
		return new BigDecimal(exchangeValue);
		
	}
	
}


