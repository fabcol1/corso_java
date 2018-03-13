package org.proxima.cc.services;

import java.time.LocalDateTime;
import java.util.List;
import org.proxima.cc.entities.LitecoinHistorical;
import org.proxima.cc.repository.LitecoinHistoricalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LitecoinHistoricalService {

	public static final Logger logger = LoggerFactory.getLogger(LitecoinHistoricalService.class);
	
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
		logger.info("Insert LitecoinHistorical: {}", litecoin);
		litecoinHistoricalRepository.save(litecoin);
	}
}
