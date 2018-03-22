package org.proxima.cc.services;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.proxima.cc.entities.CryptoExchangeValuesProvider;
import org.proxima.cc.entities.bitcoin.BitcoinHistorical;
import org.proxima.cc.entities.bitcoin.BitcoinHistoricalAverage;
import org.proxima.cc.entities.bitcoin.BitcoinHistoricalCustom;
import org.proxima.cc.repository.ProvidersRepository;
import org.proxima.cc.repository.bitcoin.BitcoinHistoricalAverageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BitcoinHistoricalAverageService {

	public static final Logger logger = Logger.getLogger(BitcoinHistoricalAverageService.class);

	@Autowired
	private BitcoinHistoricalAverageRepository bitcoinHistoricalAverageRepository;
	@Autowired
	private BitcoinHistoricalService bitcoinHistoricalService;
	@Autowired
	private ProvidersRepository providersRepository;

	public void lastDayBitcoinHistoricalsAverage() {

		List<CryptoExchangeValuesProvider> providers = providersRepository.findAll();
		logger.info(Arrays.toString(providers.toArray()));

		for(CryptoExchangeValuesProvider prov : providers) {
			logger.info("------------------------------------" + prov.getLabel() + "------------------------------------");
			BitcoinHistorical min = bitcoinHistoricalService.getMinLastDayBitcoinHistoricals(prov.getId());
			BitcoinHistorical max = bitcoinHistoricalService.getMaxLastDayBitcoinHistoricals(prov.getId());
			BitcoinHistoricalCustom avg = bitcoinHistoricalService.getAverageLastDayBitcoinHistoricals(prov.getId());
			
			if(min!=null && max!=null && avg!=null) {
				logger.info("MIN: " + min.getExchangevalue());
				logger.info("MAX: " + max.getExchangevalue());
				logger.info("AVG: " + avg.getExchangevalue());			
				BitcoinHistoricalAverage btcAverage = new BitcoinHistoricalAverage();
				btcAverage.setExchangedate(LocalDate.now());
				btcAverage.setExchangeaverage(avg.getExchangevalue());
				btcAverage.setExchangemax(max.getExchangevalue());
				btcAverage.setExchangemin(min.getExchangevalue());
				btcAverage.setCryptoexchangevaluesproviderid(prov.getId());
				btcAverage.setCurrencyregistryid(max.getCurrencyregistryid());
				
				logger.info("BITCOIN HISTORICAL AVERAGE: " + btcAverage);
				
				bitcoinHistoricalAverageRepository.save(btcAverage);
			}
		}
	}
	
//	@Scheduled(fixedRate=3000000)
//	public void lastDayBitcoinHistoricalsAverage() {
//		// chiamate per ottenere tutti gli id
//		List<CryptoExchangeValuesProvider> providers = providersRepository.findAll();
//		logger.info(Arrays.toString(providers.toArray()));
//		// itero sugli id e calcolo la media, max e min 
//		
//		for(CryptoExchangeValuesProvider prov : providers) {
//			List<BitcoinHistorical> btclist = bitcoinHistoricalService.listAllLastDayBitcoinHistoricals(prov.getId());
//			int size = btclist.size();
//			logger.info(size);
//
//			if(size>0) {
//				Long providerId = btclist.get(0).getCryptoexchangevaluesproviderid();
//				Long currencyId = btclist.get(0).getCurrencyregistryid();
//				
//				BigDecimal min = btclist.get(0).getExchangevalue();
//				BigDecimal max = btclist.get(0).getExchangevalue();
//				BigDecimal media = new BigDecimal(0);
//
//				logger.info("ID: " + providerId);
//
//				logger.info("MIN 0: " + min);
//				logger.info("MAX 0: " + max);
//				logger.info("Media 0: " + media);
//
//				for(BitcoinHistorical btc : btclist) {
//
//					BigDecimal currentVal = btc.getExchangevalue();
//					//incremento la media
//					media = media.add(currentVal);
//
//					//aggiorno max
//					if(currentVal.compareTo(max) == 1) {
//						max = currentVal;
//					
//					}
//					//aggiorno min
//					if(currentVal.compareTo(min) == -1) {
//						min = currentVal;
//					}
//				}
//				media = media.divide(new BigDecimal(size), 4, RoundingMode.HALF_UP );
////				2, RoundingMode.HALF_UP)
////				where 2 is precision and RoundingMode.HALF_UP is rounding mode
//				logger.info("MAX FINE: " + max);
//				logger.info("MIN FINE: " + min);
//				logger.info("Media FINE: " + media);
//			}
//			//faccio la insert 
//			//cancello vecchi valori.
//		
//		}
//	
//	}
	

}
