/**
 * 
 */
package org.proxima.cc.clients;

import org.proxima.cc.entities.bitcoin.BitcoinHistorical;
import org.proxima.cc.entities.ethereum.EthereumHistorical;
import org.proxima.cc.entities.litecoin.LitecoinHistorical;
import org.proxima.cc.repository.bitcoin.BitcoinHistoricalRepository;
import org.proxima.cc.repository.ethereum.EthereumHistoricalRepository;
import org.proxima.cc.repository.litecoin.LitecoinHistoricalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author maurizio
 *
 */
@Component
public class CryptoManager {

	public static final String BITCORE_LABEL = "Bitcore";
	public static final String OKEX_LABEL    = "Okex";
	public static final String YOBIT_LABEL = "Yobit";
	public static final String LIVECOIN_LABEL = "Livecoin";
	public static final String BTCC_LABEL = "Btcc";
	public static final String BITSTAMP_LABEL = "Bitstamp";	
	public static final String WEX_LABEL = "Wex";
	
	public static final String USD_LABEL = "USD";
	public static final String EUR_LABEL = "Euro";

	
	
	@Autowired
	private BitcoinHistoricalRepository bitcoinJpaRepository;
	
	@Autowired
	private EthereumHistoricalRepository ethereumJpaRepository;
	
	@Autowired
	private LitecoinHistoricalRepository litecoinJpaRepository;
	
	public void insertBTC(CryptoCoinJSONInterface bji, Long currencyId, Long providerId) throws Exception {
		BitcoinHistorical b  = new BitcoinHistorical();
		b.setExchangevalue(bji.getExchangeValue());
		b.setExchangetime(bji.getTimestampAsLocalDateTime());
		b.setCryptoexchangevaluesproviderid(providerId);
		b.setCurrencyregistryid(currencyId);
		bitcoinJpaRepository.save(b);
	}
	
	public void insertETH(CryptoCoinJSONInterface ccji, Long currencyId, Long providerId) throws Exception {
		EthereumHistorical hist  = new EthereumHistorical();
		hist.setExchangevalue(ccji.getExchangeValue());
		hist.setExchangetime(ccji.getTimestampAsLocalDateTime());
		hist.setCryptoexchangevaluesproviderid(providerId);
		hist.setCurrencyregistryid(currencyId);
		ethereumJpaRepository.save(hist);
	}
	
	public void insertLTC(CryptoCoinJSONInterface ccji, Long currencyId, Long providerId) throws Exception {
		LitecoinHistorical hist  = new LitecoinHistorical();
		hist.setExchangevalue(ccji.getExchangeValue());
		hist.setExchangetime(ccji.getTimestampAsLocalDateTime());
		hist.setCryptoexchangevaluesproviderid(providerId);
		hist.setCurrencyregistryid(currencyId);
		litecoinJpaRepository.save(hist);
	}
	
	
}
