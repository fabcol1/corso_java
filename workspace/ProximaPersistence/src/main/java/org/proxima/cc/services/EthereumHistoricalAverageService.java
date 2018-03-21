package org.proxima.cc.services;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.proxima.cc.entities.CryptoExchangeValuesProvider;
import org.proxima.cc.entities.ethereum.EthereumHistorical;
import org.proxima.cc.entities.ethereum.EthereumHistoricalAverage;
import org.proxima.cc.entities.ethereum.EthereumHistoricalCustom;
import org.proxima.cc.repository.ProvidersRepository;
import org.proxima.cc.repository.ethereum.EthereumHistoricalAverageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EthereumHistoricalAverageService {

	public static final Logger logger = Logger.getLogger(EthereumHistoricalAverageService.class);

	@Autowired
	private EthereumHistoricalAverageRepository ethereumHistoricalAverageRepository;
	@Autowired
	private EthereumHistoricalService ethereumHistoricalService;
	@Autowired
	private ProvidersRepository providersRepository;

	public void lastDayEthereumHistoricalsAverage() {

		List<CryptoExchangeValuesProvider> providers = providersRepository.findAll();
		logger.info(Arrays.toString(providers.toArray()));

		for(CryptoExchangeValuesProvider prov : providers) {
			logger.info("------------------------------------" + prov.getLabel() + "------------------------------------");
			EthereumHistorical min = ethereumHistoricalService.getMinLastDayEthereumHistoricals(prov.getId());
			EthereumHistorical max = ethereumHistoricalService.getMaxLastDayEthereumHistoricals(prov.getId());
			EthereumHistoricalCustom avg = ethereumHistoricalService.getAverageLastDayEthereumHistoricals(prov.getId());
			
			if(min!=null && max!=null && avg!=null) {
				logger.info("MIN: " + min.getExchangevalue());
				logger.info("MAX: " + max.getExchangevalue());
				logger.info("AVG: " + avg.getExchangevalue());

				EthereumHistoricalAverage btcAverage = new EthereumHistoricalAverage();
				btcAverage.setExchangedate(LocalDate.now());
				btcAverage.setExchangeaverage(avg.getExchangevalue());
				btcAverage.setExchangemax(max.getExchangevalue());
				btcAverage.setExchangemin(min.getExchangevalue());
				btcAverage.setCryptoexchangevaluesproviderid(prov.getId());
				btcAverage.setCurrencyregistryid(max.getCurrencyregistryid());
				
				logger.info("ETHEREUM HISTORICAL AVERAGE: " + btcAverage);
				
				ethereumHistoricalAverageRepository.save(btcAverage);
			}
			
		}
	}
}
