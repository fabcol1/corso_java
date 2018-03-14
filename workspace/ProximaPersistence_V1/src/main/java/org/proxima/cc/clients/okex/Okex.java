package org.proxima.cc.clients.okex;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.proxima.cc.entities.BitcoinHistorical;
import org.proxima.cc.entities.EthereumHistorical;
import org.proxima.cc.entities.LitecoinHistorical;
import org.proxima.cc.repository.BitcoinHistoricalRepository;
import org.proxima.cc.repository.EthereumHistoricalRepository;
import org.proxima.cc.repository.LitecoinHistoricalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Okex {
	final static Logger logger = LoggerFactory.getLogger(Okex.class);

	@Autowired
	private BitcoinHistoricalRepository bitcoinHistoricalRepository;
	@Autowired
	private LitecoinHistoricalRepository litecoinHistoricalRepository;
	@Autowired
	private EthereumHistoricalRepository ethereumHistoricalRepository;
	
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
		
		bitcoinHistoricalRepository.save(b);
	}
	
	public void insertLTCtoDB() throws Exception {
		JSON_Okex obj = getFutureValue("ltc_usd");
		String timeStamp = obj.getDate();
		logger.info("TIMESTAMP: " + timeStamp);
		int timeStampInt = Integer.parseInt(timeStamp);
		logger.info("TIMESTAMP int: " + timeStampInt);
		BigDecimal last = obj.getTicker().get("last");
		logger.info("LAST LITECOIN VAL: " + last);

		LitecoinHistorical l  = new LitecoinHistorical();
		
		LocalDateTime epoch = LocalDateTime.ofEpochSecond(timeStampInt, 0, ZoneOffset.UTC);
		epoch = LocalDateTime.ofInstant(epoch.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
		logger.info("EPOCH: " + epoch);

		l.setExchangevalue(last);
		l.setExchangetime(epoch);
		l.setCryptoexchangevaluesproviderid(new BigInteger("1"));
		l.setCurrencyregistryid(new BigInteger("2"));
		
		litecoinHistoricalRepository.save(l);
	}
	
	public void insertETHtoDB() throws Exception {
		JSON_Okex obj = getFutureValue("eth_usd");
		String timeStamp = obj.getDate();
		logger.info("TIMESTAMP: " + timeStamp);
		int timeStampInt = Integer.parseInt(timeStamp);
		logger.info("TIMESTAMP int: " + timeStampInt);
		BigDecimal last = obj.getTicker().get("last");
		logger.info("LAST ETHEREUM VAL: " + last);

		EthereumHistorical e  = new EthereumHistorical();
		
		LocalDateTime epoch = LocalDateTime.ofEpochSecond(timeStampInt, 0, ZoneOffset.UTC);
		epoch = LocalDateTime.ofInstant(epoch.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
		logger.info("EPOCH: " + epoch);

		e.setExchangevalue(last);
		e.setExchangetime(epoch);
		e.setCryptoexchangevaluesproviderid(new BigInteger("1"));
		e.setCurrencyregistryid(new BigInteger("2"));
		
		ethereumHistoricalRepository.save(e);
	}
	
	@Scheduled(cron = "0 0/3 * * * ?")
	public void insertBTCtoDBfromOKEX() throws Exception {
		insertBTCtoDB();
	}
	@Scheduled(cron = "0 1/3 * * * ?")
	public void insertLTCtoDBfromOKEX() throws Exception {
		insertLTCtoDB();
	}
	@Scheduled(cron = "0 2/3 * * * ?")
	public void insertETHtoDBfromOKEX() throws Exception {
		insertETHtoDB();
	}
	
//	public static void main(String[] args)
//	 {
//	  CronSequenceGenerator cron1 = new CronSequenceGenerator("0 2/3 * * * ?");
//	  Calendar cal = Calendar.getInstance();
//	  cal.add(Calendar.DATE, 2); // add two days to current date
//	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss"); 
//	  
//	  System.out.println("current date "+sdf.format(cal.getTime()));
//	  
//	  Date d = null;
//		for(int i = 0; i < 10; i++) {
//			if(d==null) {
//				d =  cron1.next(cal.getTime()); 
//			} else {
//				d = cron1.next(d);
//			}
//			System.out.println("Next cron trigger date cron1 "+d);
//		}
//	 }
}
