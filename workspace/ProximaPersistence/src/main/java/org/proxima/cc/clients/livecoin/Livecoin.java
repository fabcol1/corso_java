package org.proxima.cc.clients.livecoin;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.proxima.cc.clients.GETRequestUtil;
import org.proxima.cc.entities.BitcoinHistorical;
import org.proxima.cc.entities.EthereumHistorical;
import org.proxima.cc.entities.LitecoinHistorical;
import org.proxima.cc.repository.BitcoinHistoricalRepository;
import org.proxima.cc.repository.EthereumHistoricalRepository;
import org.proxima.cc.repository.LitecoinHistoricalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Livecoin {

	final static Logger logger = Logger.getLogger(Livecoin.class);

	@Autowired
	private BitcoinHistoricalRepository bitcoinHistoricalRepository;
	@Autowired
	private LitecoinHistoricalRepository litecoinHistoricalRepository;
	@Autowired
	private EthereumHistoricalRepository ethereumHistoricalRepository;

	private JSON_Livecoin getFutureValue(String future) throws Exception {
		String json = GETRequestUtil.sendGet("https://api.livecoin.net/exchange/ticker?currencyPair=" + future, "");
		System.out.println(json);
		ObjectMapper objectMapper = new ObjectMapper();
		JSON_Livecoin futureValue = objectMapper.readValue(json, JSON_Livecoin.class);
		logger.info(futureValue.getLast());
		return futureValue;
	}

	public void insertBTCtoDB() throws Exception {
		JSON_Livecoin lc = getFutureValue("BTC/USD");
		LocalDateTime currentDateTime = LocalDateTime.now();

		System.out.println("TIMESTAMP : " + currentDateTime);
		BigDecimal bigD = lc.getLast();

		System.out.println("LAST BITCOIN VAL: " + bigD);
		BitcoinHistorical b = new BitcoinHistorical();
		b.setExchangevalue(bigD);
		b.setExchangetime(currentDateTime);
		b.setCryptoexchangevaluesproviderid(new BigInteger("7"));
		b.setCurrencyregistryid(new BigInteger("2"));
		bitcoinHistoricalRepository.save(b);
	}

	public void insertLTCtoDB() throws Exception {
		JSON_Livecoin lc = getFutureValue("LTC/USD");
		LocalDateTime currentDateTime = LocalDateTime.now();

		System.out.println("TIMESTAMP : " + currentDateTime);
		BigDecimal bigD = lc.getLast();

		System.out.println("LAST LITECOIN VAL: " + bigD);
		LitecoinHistorical l = new LitecoinHistorical();
		l.setExchangevalue(bigD);
		l.setExchangetime(currentDateTime);
		l.setCryptoexchangevaluesproviderid(new BigInteger("7"));
		l.setCurrencyregistryid(new BigInteger("2"));
		litecoinHistoricalRepository.save(l);
	}
	
	public void insertETHtoDB() throws Exception {
		JSON_Livecoin lc = getFutureValue("ETH/USD");
		LocalDateTime currentDateTime = LocalDateTime.now();

		System.out.println("TIMESTAMP : " + currentDateTime);
		BigDecimal bigD = lc.getLast();

		System.out.println("LAST ETHEREUM VAL: " + bigD);
		EthereumHistorical e = new EthereumHistorical();
		e.setExchangevalue(bigD);
		e.setExchangetime(currentDateTime);
		e.setCryptoexchangevaluesproviderid(new BigInteger("7"));
		e.setCurrencyregistryid(new BigInteger("2"));
		ethereumHistoricalRepository.save(e);
	}

}
