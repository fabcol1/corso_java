package org.proxima.cc.clients.yobit;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Arrays;

import org.proxima.cc.clients.GETRequestUtil;
import org.proxima.cc.entities.BitcoinHistorical;
import org.proxima.cc.repository.BitcoinHistoricalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Yobit {
	final static Logger logger = LoggerFactory.getLogger(Yobit.class);
	
	@Autowired
	private BitcoinHistoricalRepository bitcoinJpaRepository;
	
	private JSON_Yobit getYogit(String value) throws Exception {
		//https://yobit.net/api/3/ticker/
		String json = GETRequestUtil.sendGet(
				"https://yobit.net/api/3/ticker/"+value+"/", 
				"");
		logger.info(json);
		ObjectMapper obM = new ObjectMapper();
		JSON_Yobit yobit = obM.readValue(json, JSON_Yobit.class);
		logger.info(Arrays.toString(yobit.getBtc_usd().values().toArray()));
		return yobit;		
	}
	
	public void insertYogit() throws Exception {
		JSON_Yobit jsb = getYogit("btc_usd");
		int timeStampInt = jsb.getBtc_usd().get("updated").intValue();
		logger.info("TIMESTAMP INT: " + timeStampInt);
		BigDecimal last =  jsb.getBtc_usd().get("last");
		logger.info("LAST BITCOIN VALUE: " + last);
		
		BitcoinHistorical b = new BitcoinHistorical();
		
		LocalDateTime time = LocalDateTime.ofEpochSecond(timeStampInt, 0, ZoneOffset.UTC);
		time = LocalDateTime.ofInstant(time.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
		logger.info("TIME: " + time);
		
		b.setExchangevalue(last);
		b.setExchangetime(time);
		b.setCryptoexchangevaluesproviderid(new BigInteger("5"));
		b.setCurrencyregistryid(new BigInteger("2"));
		
		bitcoinJpaRepository.save(b);		
	}
	
	//@Scheduled(fixedRate = 60000)
	public void insertToDBfromBITSTAMP() throws Exception {
		insertYogit();
	}
}
