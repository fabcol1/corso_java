package org.proxima.cc.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.proxima.cc.entities.CryptoExchangeValuesProvider;
import org.proxima.cc.entities.litecoin.LitecoinHistorical;
import org.proxima.cc.entities.litecoin.LitecoinHistoricalCustom;
import org.proxima.cc.repository.ProvidersRepository;
import org.proxima.cc.repository.litecoin.LitecoinHistoricalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LitecoinHistoricalService {

	public static final Logger logger = Logger.getLogger(LitecoinHistoricalService.class);
	
	@Autowired
	private LitecoinHistoricalRepository litecoinHistoricalRepository;
	@Autowired
	private ProvidersRepository providersRepository;
	
	public List<LitecoinHistorical> listAllLitecoinHistoricals() {
		return litecoinHistoricalRepository.findAll();
	}
	
	public List<LitecoinHistorical> listAllLastDayLitecoinHistoricals() {
		LocalDateTime ldtNow = LocalDateTime.now() ;
		LocalDateTime ldt = ldtNow.minusDays(1);
		List<LitecoinHistorical> litecoins = litecoinHistoricalRepository.findAllByExchangetimeGreaterThan(ldt);
		return litecoins;
	}
	public List<LitecoinHistorical> listAllLastDayLitecoinHistoricals(Long id) {
		LocalDateTime ldtNow = LocalDateTime.now();
		LocalDateTime ldt = ldtNow.minusDays(1);
		List<LitecoinHistorical> litecoins = litecoinHistoricalRepository
				.findAllByExchangetimeGreaterThanAndCryptoexchangevaluesproviderid(ldt, id);
		return litecoins;
	}
	public List<LitecoinHistorical> listAllLastWeekLitecoinHistoricals() {
		LocalDateTime ldtNow = LocalDateTime.now() ;
		LocalDateTime ldt = ldtNow.minusWeeks(1);
		List<LitecoinHistorical> litecoins = litecoinHistoricalRepository.findAllByExchangetimeGreaterThan(ldt);
		return litecoins;
	}	
	public List<LitecoinHistorical> listAllLastWeekLitecoinHistoricals(Long id) {
		LocalDateTime ldtNow = LocalDateTime.now();
		LocalDateTime ldt = ldtNow.minusWeeks(1);
		List<LitecoinHistorical> litecoins = litecoinHistoricalRepository
				.findAllByExchangetimeGreaterThanAndCryptoexchangevaluesproviderid(ldt, id);
		return litecoins;
	}
	public List<LitecoinHistorical> listAlllastMonthLitecoinHistoricals() {
		LocalDateTime ldtNow = LocalDateTime.now() ;
		LocalDateTime ldt = ldtNow.minusMonths(1);
		List<LitecoinHistorical> litecoins = litecoinHistoricalRepository.findAllByExchangetimeGreaterThan(ldt);
		return litecoins;
	}
	public List<LitecoinHistorical> listAlllastYearLitecoinHistoricals() {
		LocalDateTime ldtNow = LocalDateTime.now() ;
		LocalDateTime ldt = ldtNow.minusYears(1);
		List<LitecoinHistorical> litecoins = litecoinHistoricalRepository.findAllByExchangetimeGreaterThan(ldt);
		return litecoins;
	}
	
	public LitecoinHistoricalCustom getLastExcangeByProviderIdAndCurrencyId(Long providerId, Long currencyId) {
		return litecoinHistoricalRepository.findLastExchangeByProviderIdAndCurrency(providerId, currencyId);
	}
	
    public List<LitecoinHistoricalCustom> getLastExchangeValuesByCurrencyId(Long currencyId) {
		
     	List<LitecoinHistoricalCustom> toReturn = new ArrayList<LitecoinHistoricalCustom>();
		
		List <CryptoExchangeValuesProvider> provList = providersRepository.findAll();
		System.out.println(provList.size());
		
		System.out.println("ciclo sulla lista dei provider");
		for (int i = 0; i<provList.size(); i++) {
			
			long provId = provList.get(i).getId();
			
			System.out.println("aggiungo ogni provider a lista");
			//per ogni provider faccio litedcoinHistoricalRepository.findByLastExcangeByProviderIdAndCurrency(providerId, currencyId);
			//ed aggiungo il risultato alla lista "toReturn..."	
			try {
			toReturn.add(litecoinHistoricalRepository.findLastExchangeByProviderIdAndCurrency(provId, currencyId));
			}catch (Exception e) {
				e.printStackTrace();

				}

		}
		System.out.println(toReturn);	
		return toReturn;
	}
	
	public void insertLitecoinHistorical(final LitecoinHistorical litecoin) {
		logger.info("Insert LitecoinHistorical: {} " + litecoin);
		litecoinHistoricalRepository.save(litecoin);
	}

	public LitecoinHistorical getMinLastDayLitecoinHistoricals(Long id) {
		LocalDateTime ldtNow = LocalDateTime.now();
		LocalDateTime ldt = ldtNow.minusDays(1);
		LitecoinHistorical litecoin = litecoinHistoricalRepository
					.findFirstByExchangetimeGreaterThanAndCryptoexchangevaluesprovideridOrderByExchangevalueAsc(ldt,
							id);
		return litecoin;
	}
	
	public LitecoinHistorical getMaxLastDayLitecoinHistoricals(Long id) {
		LocalDateTime ldtNow = LocalDateTime.now();
		LocalDateTime ldt = ldtNow.minusDays(1);
		LitecoinHistorical litecoin = litecoinHistoricalRepository
					.findFirstByExchangetimeGreaterThanAndCryptoexchangevaluesprovideridOrderByExchangevalueDesc(ldt,
							id);
		return litecoin;
	}
	
	public LitecoinHistoricalCustom getAverageLastDayLitecoinHistoricals(Long id) {
		LocalDateTime ldtNow = LocalDateTime.now();
		LocalDateTime ldt = ldtNow.minusDays(1);
		LitecoinHistoricalCustom litecoin  = litecoinHistoricalRepository
					.findAverageByExchangetimeGreaterThanAndCryptoexchangevaluesproviderid(ldt, id);
		return litecoin;
	}
}
