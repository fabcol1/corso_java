package org.proxima.cc.clients.btcc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

import org.proxima.cc.clients.CryptoCoinJSONInterface;

public class JSON_Btcc implements CryptoCoinJSONInterface{
	
	private Map<String, String> ticker;
	
	
	public Map<String, String> getTicker() {
		return ticker;
	}
	
	public void setTicker(Map<String, String> ticker) {
		this.ticker = ticker;
	}

	@Override
	public LocalDateTime getTimestampAsLocalDateTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getExchangeValue() {
		// TODO Auto-generated method stub
		return null;
	}
	
}


