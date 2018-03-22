package org.proxima.cc.services;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.proxima.cc.entities.CryptoExchangeValuesProvider;
import org.proxima.cc.entities.litecoin.LitecoinHistorical;
import org.proxima.cc.entities.litecoin.LitecoinHistoricalAverage;
import org.proxima.cc.entities.litecoin.LitecoinHistoricalCustom;
import org.proxima.cc.repository.ProvidersRepository;
import org.proxima.cc.repository.litecoin.LitecoinHistoricalAverageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LitecoinHistoricalAverageService {

	public static final Logger logger = Logger.getLogger(LitecoinHistoricalAverageService.class);

	@Autowired
	private LitecoinHistoricalAverageRepository litecoinHistoricalAverageRepository;
	@Autowired
	private LitecoinHistoricalService litecoinHistoricalService;
	@Autowired
	private ProvidersRepository providersRepository;

	public void lastDayLitecoinHistoricalsAverage() {

		List<CryptoExchangeValuesProvider> providers = providersRepository.findAll();
		logger.info(Arrays.toString(providers.toArray()));

		for(CryptoExchangeValuesProvider prov : providers) {
			logger.info("------------------------------------" + prov.getLabel() + "------------------------------------");
			LitecoinHistorical min = litecoinHistoricalService.getMinLastDayLitecoinHistoricals(prov.getId());
			LitecoinHistorical max = litecoinHistoricalService.getMaxLastDayLitecoinHistoricals(prov.getId());
			LitecoinHistoricalCustom avg = litecoinHistoricalService.getAverageLastDayLitecoinHistoricals(prov.getId());
			
			if(min!=null && max!=null && avg!=null) {
				logger.info("MIN: " + min.getExchangevalue());
				logger.info("MAX: " + max.getExchangevalue());
				logger.info("AVG: " + avg.getExchangevalue());			
				LitecoinHistoricalAverage btcAverage = new LitecoinHistoricalAverage();
				btcAverage.setExchangedate(LocalDate.now());
				btcAverage.setExchangeaverage(avg.getExchangevalue());
				btcAverage.setExchangemax(max.getExchangevalue());
				btcAverage.setExchangemin(min.getExchangevalue());
				btcAverage.setCryptoexchangevaluesproviderid(prov.getId());
				btcAverage.setCurrencyregistryid(max.getCurrencyregistryid());
				
				logger.info("LITECOIN HISTORICAL AVERAGE: " + btcAverage);
				
				litecoinHistoricalAverageRepository.save(btcAverage);
			}
		}
	}
}
