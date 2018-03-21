package org.proxima.cc.clients.livecoin;

import org.apache.log4j.Logger;
import org.proxima.cc.clients.CryptoManager;
import org.proxima.cc.clients.GETRequestUtil;
import org.proxima.cc.repository.CryptoCurrencyRegistryRepository;
import org.proxima.cc.repository.ProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Livecoin {

	final static Logger logger = Logger.getLogger(Livecoin.class);

	@Autowired
	private ProvidersRepository providersRepository;
	@Autowired
	private CryptoCurrencyRegistryRepository ccRegistryRepository;
	@Autowired
	private CryptoManager cm;

	private JSON_Livecoin getFutureValue(String future) throws Exception {
		String json = GETRequestUtil.sendGet("https://api.livecoin.net/exchange/ticker?currencyPair=" + future, "");
		ObjectMapper objectMapper = new ObjectMapper();
		JSON_Livecoin futureValue = objectMapper.readValue(json, JSON_Livecoin.class);
		logger.info(futureValue.getLast());
		return futureValue;
	}
	
	public void insertBTCtoDB() throws Exception {
		JSON_Livecoin bji = getFutureValue("BTC/USD");
		cm.insertBTC(bji, 
				ccRegistryRepository.findByLabel(CryptoManager.USD_LABEL).getId(),
				providersRepository.findByLabel(CryptoManager.LIVECOIN_LABEL).getId());
	}

	
	public void insertETHtoDB() throws Exception {
		JSON_Livecoin obj = getFutureValue("ETH/USD");
		cm.insertETH(obj, 
				ccRegistryRepository.findByLabel(CryptoManager.USD_LABEL).getId(),
				providersRepository.findByLabel(CryptoManager.LIVECOIN_LABEL).getId());
	}
	
	public void insertLTCtoDB() throws Exception {
		JSON_Livecoin obj = getFutureValue("LTC/USD");
		cm.insertLTC(obj, 
				ccRegistryRepository.findByLabel(CryptoManager.USD_LABEL).getId(),
				providersRepository.findByLabel(CryptoManager.LIVECOIN_LABEL).getId());
	}

}
