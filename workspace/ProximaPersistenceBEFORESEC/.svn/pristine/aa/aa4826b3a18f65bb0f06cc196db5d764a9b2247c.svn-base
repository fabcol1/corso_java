package org.proxima.cc.clients.wex;

import org.apache.log4j.Logger;
import org.proxima.cc.clients.CryptoManager;
import org.proxima.cc.repository.CryptoCurrencyRegistryRepository;
import org.proxima.cc.repository.ProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Wex {
	final static Logger logger = Logger.getLogger(Wex.class);

	@Autowired
	private ProvidersRepository providersRepository;
	@Autowired
	private CryptoCurrencyRegistryRepository ccRegistryRepository;
	@Autowired
	private CryptoManager cm;

	private JSON_Wex getFutureValue(String future) throws Exception {
		String json = org.proxima.cc.clients.GETRequestUtil.sendGet(
				"https://wex.nz/api/3/ticker/" + future + "/",
				"");		
		logger.info(json);
		ObjectMapper objectMapper = new ObjectMapper();
		JSON_Wex futureValue = objectMapper.readValue(json, JSON_Wex.class);	

		return futureValue;
	}
	
	
	public void insertBTCtoDB() throws Exception {
		JSON_Wex json = getFutureValue("btc_usd");
		logger.info(json);
		
		cm.insertBTC(json, ccRegistryRepository.findByLabel(CryptoManager.USD_LABEL).getId(),
				providersRepository.findByLabel(CryptoManager.WEX_LABEL).getId());
	}
	
	public void insertLTCtoDB() throws Exception {
		JSON_Wex json = getFutureValue("ltc_usd");
		logger.info(json);
		
		cm.insertLTC(json, ccRegistryRepository.findByLabel(CryptoManager.USD_LABEL).getId(),
				providersRepository.findByLabel(CryptoManager.WEX_LABEL).getId());
	}
	
	public void insertETHtoDB() throws Exception {
		JSON_Wex json = getFutureValue("eth_usd");
		logger.info(json);
		
		cm.insertETH(json, ccRegistryRepository.findByLabel(CryptoManager.USD_LABEL).getId(),
				providersRepository.findByLabel(CryptoManager.WEX_LABEL).getId());
	}
	
}