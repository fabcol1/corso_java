package org.proxima.cc.clients.yobit;

import org.apache.log4j.Logger;
import org.proxima.cc.clients.CryptoManager;
import org.proxima.cc.repository.CryptoCurrencyRegistryRepository;
import org.proxima.cc.repository.ProvidersRepository;
import org.proxima.cc.repository.bitcoin.BitcoinHistoricalRepository;
import org.proxima.cc.repository.ethereum.EthereumHistoricalRepository;
import org.proxima.cc.repository.litecoin.LitecoinHistoricalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Yobit {
	final static Logger logger = Logger.getLogger(Yobit.class);
	
	@Autowired
	private BitcoinHistoricalRepository bitcoinJpaRepository;
	@Autowired
	private LitecoinHistoricalRepository litecoinHistoricalRepository;
	@Autowired
	private EthereumHistoricalRepository ethereumHistoricalRepository;
	@Autowired
	private ProvidersRepository providersRepository;
	@Autowired
	private CryptoCurrencyRegistryRepository ccRegistryRepository;
	@Autowired
	private CryptoManager cm ;
	
	private JSON_Yobit getFutureValue(String future) throws Exception {
		String json = org.proxima.cc.clients.GETRequestUtil.sendGet(
				"https://yobit.net/api/3/ticker/" + future + "/",
				"");		
		logger.info(json);
		ObjectMapper objectMapper = new ObjectMapper();
		JSON_Yobit futureValue = objectMapper.readValue(json, JSON_Yobit.class);	

		return futureValue;
	}
	
	
	public void insertBTCtoDB() throws Exception {
		JSON_Yobit json = getFutureValue("btc_usd");
		logger.info(json);
		
		cm.insertBTC(json, ccRegistryRepository.findByLabel(CryptoManager.USD_LABEL).getId(),
				providersRepository.findByLabel(CryptoManager.YOBIT_LABEL).getId());
	}
	
	public void insertLTCtoDB() throws Exception {
		JSON_Yobit json = getFutureValue("ltc_usd");
		logger.info(json);
		
		cm.insertLTC(json, ccRegistryRepository.findByLabel(CryptoManager.USD_LABEL).getId(),
				providersRepository.findByLabel(CryptoManager.YOBIT_LABEL).getId());
	}
	
	public void insertETHtoDB() throws Exception {
		JSON_Yobit json = getFutureValue("eth_usd");
		logger.info(json);
		
		cm.insertETH(json, ccRegistryRepository.findByLabel(CryptoManager.USD_LABEL).getId(),
				providersRepository.findByLabel(CryptoManager.YOBIT_LABEL).getId());
	}

}
