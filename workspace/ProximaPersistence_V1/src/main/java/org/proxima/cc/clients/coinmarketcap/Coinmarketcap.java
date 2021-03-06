package org.proxima.cc.clients.coinmarketcap;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Arrays;

import org.proxima.cc.entities.BitcoinHistorical;
import org.proxima.cc.repository.BitcoinHistoricalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Coinmarketcap {
	final static Logger logger = LoggerFactory.getLogger(Coinmarketcap.class);
	
	@Autowired
	private BitcoinHistoricalRepository bitcoinJpaRepository;
	
	private JSON_Coinmarketcap getFutureValue(String future) throws Exception {
		// https://www.okex.com/api/v1/future_ticker.do?symbol=btc_usd&contract_type=this_week
		String json = org.proxima.cc.clients.GETRequestUtil.sendGet(
				"https://api.coinmarketcap.com/v1/ticker/"+future+"/",
				"");
		logger.info(json);
		ObjectMapper objectMapper = new ObjectMapper();
		JSON_Coinmarketcap[] futureValue = objectMapper.readValue(json, JSON_Coinmarketcap[].class);
		logger.info("LU:" + futureValue[0].getLast_updated());
		logger.info(futureValue[0].getPrice_usd());
		return futureValue[0];
	}
	//metodo per inserimento valori sul database
	public void insertBTCtoDB() throws Exception {
		
		JSON_Coinmarketcap obj = getFutureValue("bitcoin");
		String timeStamp = obj.getLast_updated();
		logger.info("TIMESTAMP: " + timeStamp);
		int timeStampInt = Integer.parseInt(timeStamp);
		logger.info("TIMESTAMP int: " + timeStampInt);
		
		BigDecimal last = new BigDecimal(obj.getPrice_usd());
		logger.info("LAST BITCOIN VAL: " + last);

		BitcoinHistorical b  = new BitcoinHistorical();
		
		LocalDateTime epoch = LocalDateTime.ofEpochSecond(timeStampInt, 0, ZoneOffset.UTC);
		epoch = LocalDateTime.ofInstant(epoch.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
		logger.info("EPOCH: " + epoch);

		b.setExchangevalue(last);
		b.setExchangetime(epoch);
		b.setCryptoexchangevaluesproviderid(new BigInteger("4"));
		b.setCurrencyregistryid(new BigInteger("1"));
		
		bitcoinJpaRepository.save(b);
		
	}
	
//	@Scheduled(fixedRate = 60000)
	public void insertToDBfromCoinmarketcap() throws Exception {
		insertBTCtoDB();
	}
	
	
	
}
