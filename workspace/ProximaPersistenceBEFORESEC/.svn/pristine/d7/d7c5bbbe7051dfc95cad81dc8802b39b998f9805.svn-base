package org.proxima.cc.clients.bitstamp;

import org.apache.log4j.Logger;
import org.proxima.cc.clients.CryptoManager;
import org.proxima.cc.repository.CryptoCurrencyRegistryRepository;
import org.proxima.cc.repository.ProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Bitstamp {
	final static Logger logger = Logger.getLogger(Bitstamp.class);

	@Autowired
	private ProvidersRepository providersRepository;
	@Autowired
	private CryptoCurrencyRegistryRepository ccRegistryRepository;
	@Autowired
	private CryptoManager cm ;

	private JSON_Bitstamp getFutureValue(String future) throws Exception {
		String json = org.proxima.cc.clients.GETRequestUtil.sendGet(
				"https://www.bitstamp.net/api/v2/ticker/" + future,
				"");		
		logger.info(json);
		ObjectMapper objectMapper = new ObjectMapper();
		JSON_Bitstamp futureValue = objectMapper.readValue(json, JSON_Bitstamp.class);	
		logger.info(futureValue.getTimestampAsLocalDateTime());
		logger.info(futureValue.getLast().toString());
//		System.out.println(futureValue.toString());
		return futureValue;
	}

	public void insertBTCtoDB() throws Exception {
		JSON_Bitstamp bji = getFutureValue("btcusd");
		cm.insertBTC(bji, 
				ccRegistryRepository.findByLabel(CryptoManager.USD_LABEL).getId(),
				providersRepository.findByLabel(CryptoManager.BITSTAMP_LABEL).getId());
	}
	
	public void insertETHtoDB() throws Exception {
		JSON_Bitstamp obj = getFutureValue("ethusd");
		cm.insertETH(obj, 
				ccRegistryRepository.findByLabel(CryptoManager.USD_LABEL).getId(),
				providersRepository.findByLabel(CryptoManager.BITSTAMP_LABEL).getId());
	}
	
	public void insertLTCtoDB() throws Exception {
		JSON_Bitstamp obj = getFutureValue("ltcusd");
		cm.insertLTC(obj, 
				ccRegistryRepository.findByLabel(CryptoManager.USD_LABEL).getId(),
				providersRepository.findByLabel(CryptoManager.BITSTAMP_LABEL).getId());
	}
	
}
