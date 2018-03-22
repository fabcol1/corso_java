package org.proxima.cc.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.proxima.cc.entities.CryptoExchangeValuesProvider;
import org.proxima.cc.entities.ethereum.EthereumHistorical;
import org.proxima.cc.entities.ethereum.EthereumHistoricalCustom;
import org.proxima.cc.repository.ProvidersRepository;
import org.proxima.cc.repository.ethereum.EthereumHistoricalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EthereumHistoricalService {

	public static final Logger logger = Logger.getLogger(EthereumHistoricalService.class);
	
	@Autowired
	private EthereumHistoricalRepository ethereumHistoricalRepository;
	@Autowired
	private ProvidersRepository providersRepository;
	
	public List<EthereumHistorical> listAllEthereumHistoricals() {
		return ethereumHistoricalRepository.findAll();
	}
	
	public List<EthereumHistorical> listAllLastDayEthereumHistoricals() {
		LocalDateTime ldtNow = LocalDateTime.now() ;
		LocalDateTime ldt = ldtNow.minusDays(1);
		List<EthereumHistorical> ethereums = ethereumHistoricalRepository.findAllByExchangetimeGreaterThan(ldt);
		return ethereums;
	}
	public List<EthereumHistorical> listAllLastDayEthereumHistoricals(Long id) {
		LocalDateTime ldtNow = LocalDateTime.now();
		LocalDateTime ldt = ldtNow.minusDays(1);
		List<EthereumHistorical> ethereums = ethereumHistoricalRepository.findAllByExchangetimeGreaterThanAndCryptoexchangevaluesproviderid(ldt, id);
		return ethereums;
	}
	public List<EthereumHistorical> listAllLastWeekEthereumHistoricals() {
		LocalDateTime ldtNow = LocalDateTime.now() ;
		LocalDateTime ldt = ldtNow.minusWeeks(1);
		List<EthereumHistorical> ethereums = ethereumHistoricalRepository.findAllByExchangetimeGreaterThan(ldt);
		return ethereums;
	}
	public List<EthereumHistorical> listAlllastMonthEthereumHistoricals() {
		LocalDateTime ldtNow = LocalDateTime.now() ;
		LocalDateTime ldt = ldtNow.minusMonths(1);
		List<EthereumHistorical> ethereums = ethereumHistoricalRepository.findAllByExchangetimeGreaterThan(ldt);
		return ethereums;
	}
	public List<EthereumHistorical> listAlllastYearEthereumHistoricals() {
		LocalDateTime ldtNow = LocalDateTime.now() ;
		LocalDateTime ldt = ldtNow.minusYears(1);
		List<EthereumHistorical> ethereums = ethereumHistoricalRepository.findAllByExchangetimeGreaterThan(ldt);
		return ethereums;
	}
	
	public void insertEthereumHistorical(final EthereumHistorical ethereum) {
		logger.info("Insert EthereumHistorical: {} " + ethereum);
		ethereumHistoricalRepository.save(ethereum);
	}
	
	public EthereumHistoricalCustom getLastExcangeByProviderIdAndCurrencyId(Long providerId, Long currencyId) {
		return ethereumHistoricalRepository.findLastExchangeByProviderIdAndCurrency(providerId, currencyId);
	}
	
	
	
	public List<EthereumHistoricalCustom> getLastExchangeValuesByCurrencyId(Long currencyId) {
		
     	List<EthereumHistoricalCustom> toReturn = new ArrayList<EthereumHistoricalCustom>();
		
		List <CryptoExchangeValuesProvider> provList = providersRepository.findAll();
		System.out.println(provList.size());
		
		System.out.println("ciclo sulla lista dei provider");
		for (int i = 0; i<provList.size(); i++) {
			
			long provId = provList.get(i).getId();
			System.out.println("aggiungo ogni provider a lista");
			//per ogni provider faccio bitcoinHistoricalRepository.findByLastExcangeByProviderIdAndCurrency(providerId, currencyId);
			//ed aggiungo il risultato alla lista "toReturn..."	
			try {
				
			
			toReturn.add(ethereumHistoricalRepository.findLastExchangeByProviderIdAndCurrency(provId, currencyId));
			
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		
		}
			
		return toReturn;
	}
	
	public EthereumHistorical getMinLastDayEthereumHistoricals(Long id) {
		LocalDateTime ldtNow = LocalDateTime.now();
		LocalDateTime ldt = ldtNow.minusDays(1);
		EthereumHistorical ethereum = ethereumHistoricalRepository
					.findFirstByExchangetimeGreaterThanAndCryptoexchangevaluesprovideridOrderByExchangevalueAsc(ldt,
							id);
		return ethereum;
	}
	
	public EthereumHistorical getMaxLastDayEthereumHistoricals(Long id) {
		LocalDateTime ldtNow = LocalDateTime.now();
		LocalDateTime ldt = ldtNow.minusDays(1);
		EthereumHistorical ethereum = ethereumHistoricalRepository
					.findFirstByExchangetimeGreaterThanAndCryptoexchangevaluesprovideridOrderByExchangevalueDesc(ldt,
							id);
		return ethereum;
	}
	
	public EthereumHistoricalCustom getAverageLastDayEthereumHistoricals(Long id) {
		LocalDateTime ldtNow = LocalDateTime.now();
		LocalDateTime ldt = ldtNow.minusDays(1);
		EthereumHistoricalCustom ethereum  = ethereumHistoricalRepository
					.findAverageByExchangetimeGreaterThanAndCryptoexchangevaluesproviderid(ldt, id);
		return ethereum;
	}
}
