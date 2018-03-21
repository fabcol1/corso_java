package org.proxima.cc.clients.okex;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.proxima.cc.clients.CryptoManager;
import org.proxima.cc.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Okex {
	final static Logger logger = Logger.getLogger(Okex.class);

	@Autowired
	private ProvidersRepository providersRepository;
	@Autowired
	private CryptoCurrencyRegistryRepository ccRegistryRepository;
	@Autowired
	private CryptoManager cm;
	
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
		JSON_Okex bji = getFutureValue("btc_usd");
		cm.insertBTC(bji, 
				ccRegistryRepository.findByLabel(CryptoManager.USD_LABEL).getId(),
				providersRepository.findByLabel(CryptoManager.OKEX_LABEL).getId());
	}
	
	public void insertLTCtoDB() throws Exception {
		JSON_Okex obj = getFutureValue("ltc_usd");
		cm.insertLTC(obj, 
				ccRegistryRepository.findByLabel(CryptoManager.USD_LABEL).getId(),
				providersRepository.findByLabel(CryptoManager.OKEX_LABEL).getId());
	}
	
	public void insertETHtoDB() throws Exception {
		JSON_Okex obj = getFutureValue("eth_usd");
		cm.insertETH(obj, 
				ccRegistryRepository.findByLabel(CryptoManager.USD_LABEL).getId(),
				providersRepository.findByLabel(CryptoManager.OKEX_LABEL).getId());
	}
}