package org.proxima.cc.clients.wex;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Map;

import org.proxima.cc.clients.CryptoCoinJSONInterface;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JSON_Wex implements CryptoCoinJSONInterface{
	
	private Map<String, BigDecimal> btc_usd;
	private Map<String, BigDecimal> ltc_usd;
	private Map<String, BigDecimal> eth_usd;
	
	public Map<String, BigDecimal> getBtc_usd() {
		return btc_usd;
	}
	public Map<String, BigDecimal> getLtc_usd() {
		return ltc_usd;
	}
	public Map<String, BigDecimal> getEth_usd() {
		return eth_usd;
	}
	public void setBtc_usd(Map<String, BigDecimal> btc_usd) {
		this.btc_usd = btc_usd;
	}
	public void setLtc_usd(Map<String, BigDecimal> ltc_usd) {
		this.ltc_usd = ltc_usd;
	}
	public void setEth_usd(Map<String, BigDecimal> eth_usd) {
		this.eth_usd = eth_usd;
	}
	@Override
	public LocalDateTime getTimestampAsLocalDateTime() {
		Map<String, BigDecimal> coin_usd = null;
		if(btc_usd!=null) {
			coin_usd = btc_usd;
		} else if(eth_usd!=null) {
			coin_usd = eth_usd;
		} else if(ltc_usd!=null) {
			coin_usd = ltc_usd;
		}
		int timeStampInt = coin_usd.get("updated").intValue();
		
		LocalDateTime time = LocalDateTime.ofEpochSecond(timeStampInt, 0, ZoneOffset.UTC);
		time = LocalDateTime.ofInstant(time.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
		
		return time;
	}
	@Override
	public BigDecimal getExchangeValue() {
		Map<String, BigDecimal> coin_usd = null;
		if(btc_usd!=null) {
			coin_usd = btc_usd;
		} else if(eth_usd!=null) {
			coin_usd = eth_usd;
		} else if(ltc_usd!=null) {
			coin_usd = ltc_usd;
		}
		BigDecimal last =  coin_usd.get("last");
		
		return last;
	}
	
	

}