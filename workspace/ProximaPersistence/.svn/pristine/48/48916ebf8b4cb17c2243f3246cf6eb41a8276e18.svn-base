package org.proxima.cc.services;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.proxima.cc.entities.bitcoin.BitcoinHistorical;
import org.proxima.cc.entities.litecoin.LitecoinHistorical;
import org.proxima.cc.repository.litecoin.LitecoinHistoricalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LitecoinHistoricalService {

	public static final Logger logger = Logger.getLogger(LitecoinHistoricalService.class);
	
	@Autowired
	private LitecoinHistoricalRepository litecoinHistoricalRepository;
	
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
	
	public void insertLitecoinHistorical(final LitecoinHistorical litecoin) {
		logger.info("Insert LitecoinHistorical: {} " + litecoin);
		litecoinHistoricalRepository.save(litecoin);
	}
}
