package org.proxima.cc.clients.btcc;

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
public class Btcc {
	
	final static Logger logger = LoggerFactory.getLogger(Btcc.class);

	@Autowired
	private BitcoinHistoricalRepository bitcoinJpaRepository;

	private JSON_Btcc getFutureValue(String future) throws Exception {
		String json = org.proxima.cc.clients.GETRequestUtil.sendGet(
				"https://spotusd-data.btcc.com/data/pro/ticker?symbol=" + future, "");
		System.out.println(json);
		ObjectMapper objectMapper = new ObjectMapper();
		JSON_Btcc futureValue = objectMapper.readValue(json, JSON_Btcc.class);
		logger.info(Arrays.toString(futureValue.getTicker().values().toArray()));
		return futureValue;
	}

	public void insertBTCtoDB() throws Exception {
		JSON_Btcc btcc = getFutureValue("BTCUSD");
		String timeStamp = btcc.getTicker().get("Timestamp").substring(0,10);
        int timeStampInt = Integer.parseInt(timeStamp);
		System.out.println("TIMESTAMP : " + timeStamp);
		String last = btcc.getTicker().get("Last").toString();
		BigDecimal bigD = new BigDecimal (last);
		
		System.out.println("LAST BITCOIN VAL: " + last);

		BitcoinHistorical b  = new BitcoinHistorical();
		
		LocalDateTime epoch = LocalDateTime.ofEpochSecond(timeStampInt, 0, ZoneOffset.UTC);
		epoch = LocalDateTime.ofInstant(epoch.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
		System.out.println("EPOCH: " + epoch);

		b.setExchangevalue(bigD);
		b.setExchangetime(epoch);
		b.setCryptoexchangevaluesproviderid(new BigInteger("3"));
		b.setCurrencyregistryid(new BigInteger("2"));
		
		bitcoinJpaRepository.save(b);
		
	}
	
//	@Scheduled(fixedRate = 60000)
	public void insertToDBfromBTCC() throws Exception {
		System.out.println("CIAO BELLI####################################");
		insertBTCtoDB();
	}
}


