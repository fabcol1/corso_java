package org.proxima.cc.clients.okex;

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
public class Okex {
	final static Logger logger = LoggerFactory.getLogger(Okex.class);

	@Autowired
	private BitcoinHistoricalRepository bitcoinJpaRepository;

	private JSON_Okex getFutureValue(String future) throws Exception {
		// https://www.okex.com/api/v1/future_ticker.do?symbol=btc_usd&contract_type=this_week
		String json = org.proxima.cc.clients.GETRequestUtil.sendGet(
				"https://www.okex.com/api/v1/future_ticker.do?symbol=" + future + "&contract_type=this_week",
				"application/x-www-form-urlencoded");
		logger.info(json);
		ObjectMapper objectMapper = new ObjectMapper();
		JSON_Okex futureValue = objectMapper.readValue(json, JSON_Okex.class);
		logger.info(futureValue.getDate());
		logger.info(Arrays.toString(futureValue.getTicker().values().toArray()));
		return futureValue;
	}

	public void insertBTCtoDB() throws Exception {
		JSON_Okex obj = getFutureValue("btc_usd");
		String timeStamp = obj.getDate();
		logger.info("TIMESTAMP: " + timeStamp);
		int timeStampInt = Integer.parseInt(timeStamp);
		logger.info("TIMESTAMP int: " + timeStampInt);
		BigDecimal last = obj.getTicker().get("last");
		logger.info("LAST BITCOIN VAL: " + last);

		BitcoinHistorical b  = new BitcoinHistorical();
		
		LocalDateTime epoch = LocalDateTime.ofEpochSecond(timeStampInt, 0, ZoneOffset.UTC);
		epoch = LocalDateTime.ofInstant(epoch.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
		logger.info("EPOCH: " + epoch);

		b.setExchangevalue(last);
		b.setExchangetime(epoch);
		b.setCryptoexchangevaluesproviderid(new BigInteger("1"));
		b.setCurrencyregistryid(new BigInteger("2"));
		
		bitcoinJpaRepository.save(b);
		
	}
	
//	@Scheduled(fixedRate = 60000)
	public void insertToDBfromOKEX() throws Exception {
		insertBTCtoDB();
	}
}
