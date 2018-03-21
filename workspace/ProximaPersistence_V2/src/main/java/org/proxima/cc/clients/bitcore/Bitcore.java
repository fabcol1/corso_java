package org.proxima.cc.clients.bitcore;

import org.apache.log4j.Logger;
import org.proxima.cc.clients.CryptoManager;
import org.proxima.cc.repository.CryptoCurrencyRegistryRepository;
import org.proxima.cc.repository.ProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Bitcore {
	final static Logger logger = Logger.getLogger(Bitcore.class);

	@Autowired
	private ProvidersRepository providersRepository;
	@Autowired
	private CryptoCurrencyRegistryRepository ccRegistryRepository;
	@Autowired
	private CryptoManager cm ;

	private JSON_Bitcore getFutureValue(String future) throws Exception {
		String json = org.proxima.cc.clients.GETRequestUtil.sendGet(
				"https://api.coinmarketcap.com/v1/ticker/" + future + "/",
				"");		
		logger.info(json);
		ObjectMapper objectMapper = new ObjectMapper();
		JSON_Bitcore[] futureValue = objectMapper.readValue(json, JSON_Bitcore[].class);	
		logger.info(futureValue[0].getLast_updated());
//		logger.info(futureValue[0].getPrice_usd());
		return futureValue[0];
	}

	public void insertBTCtoDB() throws Exception {
		JSON_Bitcore bji = getFutureValue("bitcoin");
		cm.insertBTC(bji, 
				ccRegistryRepository.findByLabel(CryptoManager.USD_LABEL).getId(),
				providersRepository.findByLabel(CryptoManager.BITCORE_LABEL).getId());
	}
	
	public void insertETHtoDB() throws Exception {
		JSON_Bitcore obj = getFutureValue("ethereum");
		cm.insertETH(obj, 
				ccRegistryRepository.findByLabel(CryptoManager.USD_LABEL).getId(),
				providersRepository.findByLabel(CryptoManager.BITCORE_LABEL).getId());
	}
	
	public void insertLTCtoDB() throws Exception {
		JSON_Bitcore obj = getFutureValue("litecoin");
		cm.insertLTC(obj, 
				ccRegistryRepository.findByLabel(CryptoManager.USD_LABEL).getId(),
				providersRepository.findByLabel(CryptoManager.BITCORE_LABEL).getId());
	}
		
}