package org.proxima.cc.clients.btcc;

import org.apache.log4j.Logger;
import org.proxima.cc.clients.CryptoManager;
import org.proxima.cc.clients.btcc.Btcc;
import org.proxima.cc.clients.btcc.JSON_Btcc;
import org.proxima.cc.repository.CryptoCurrencyRegistryRepository;
import org.proxima.cc.repository.ProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Btcc {
	
	final static Logger logger = Logger.getLogger(Btcc.class);

	@Autowired
	private ProvidersRepository providersRepository;
	@Autowired
	private CryptoCurrencyRegistryRepository ccRegistryRepository;
	@Autowired
	private CryptoManager cm ;
	
	private JSON_Btcc getFutureValue(String future) throws Exception {
		logger.info("DENTRO getFutureValue");
		String json = org.proxima.cc.clients.GETRequestUtil.sendGet(
				"https://spotusd-data.btcc.com/data/pro/ticker?symbol=" + future,
				"");		
		logger.info(json);
		ObjectMapper objectMapper = new ObjectMapper();
		logger.info(objectMapper);
		JSON_Btcc futureValue = objectMapper.readValue(json, JSON_Btcc.class);
		logger.info(futureValue);
//		logger.info(futureValue[0].getLast_updated());
//		logger.info(futureValue[0].getPrice_usd());
		return futureValue;
	}

	public void insertBTCtoDB() throws Exception {
		logger.info("DENTRO IL METODO");
		JSON_Btcc bji = getFutureValue("btcusd");
		logger.info(bji);
		cm.insertBTC(bji, 
				ccRegistryRepository.findByLabel(CryptoManager.USD_LABEL).getId(),
				providersRepository.findByLabel(CryptoManager.BTCC_LABEL).getId());
		logger.info("USCITA DAL METODO");
	}
	
	public void insertETHtoDB() throws Exception {
		JSON_Btcc obj = getFutureValue("ethereum");
		cm.insertETH(obj, 
				ccRegistryRepository.findByLabel(CryptoManager.USD_LABEL).getId(),
				providersRepository.findByLabel(CryptoManager.BTCC_LABEL).getId());
	}
	
	public void insertLTCtoDB() throws Exception {
		JSON_Btcc obj = getFutureValue("litecoin");
		cm.insertLTC(obj, 
				ccRegistryRepository.findByLabel(CryptoManager.USD_LABEL).getId(),
				providersRepository.findByLabel(CryptoManager.BTCC_LABEL).getId());
	}
}


