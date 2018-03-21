package org.proxima.cc.clients.livecoin;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.proxima.cc.clients.CryptoCoinJSONInterface;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown= true)
public class JSON_Livecoin implements CryptoCoinJSONInterface {
	
	private BigDecimal last;

	public BigDecimal getLast() {
		return last;
	}

	public void setLast(BigDecimal last) {
		this.last = last;
	}
	
	public LocalDateTime getTimestampAsLocalDateTime () {
		LocalDateTime currentDateTime = LocalDateTime.now();
		return currentDateTime ;
	}
	
	public BigDecimal getExchangeValue () {
		return last;	
	}
	
}


