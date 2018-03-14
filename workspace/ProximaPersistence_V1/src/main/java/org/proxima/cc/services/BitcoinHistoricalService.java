package org.proxima.cc.services;

import java.time.LocalDateTime;
import java.util.List;
import org.proxima.cc.entities.BitcoinHistorical;
import org.proxima.cc.repository.BitcoinHistoricalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BitcoinHistoricalService {

	public static final Logger logger = LoggerFactory.getLogger(BitcoinHistoricalService.class);
	
	@Autowired
	private BitcoinHistoricalRepository bitcoinHistoricalRepository;
	
	public List<BitcoinHistorical> listAllBitcoinHistoricals() {
		return bitcoinHistoricalRepository.findAll();
	}
	
	public List<BitcoinHistorical> listAllLastDayBitcoinHistoricals() {
		LocalDateTime ldtNow = LocalDateTime.now() ;
		LocalDateTime ldt = ldtNow.minusDays(1);
		List<BitcoinHistorical> bitcoins = bitcoinHistoricalRepository.findAllByExchangetimeGreaterThan(ldt);
		return bitcoins;
	}
	public List<BitcoinHistorical> listAlllastMonthBitcoinHistoricals() {
		LocalDateTime ldtNow = LocalDateTime.now() ;
		LocalDateTime ldt = ldtNow.minusMonths(1);
		List<BitcoinHistorical> bitcoins = bitcoinHistoricalRepository.findAllByExchangetimeGreaterThan(ldt);
		return bitcoins;
	}
	public List<BitcoinHistorical> listAlllastYearBitcoinHistoricals() {
		LocalDateTime ldtNow = LocalDateTime.now() ;
		LocalDateTime ldt = ldtNow.minusYears(1);
		List<BitcoinHistorical> bitcoins = bitcoinHistoricalRepository.findAllByExchangetimeGreaterThan(ldt);
		return bitcoins;
	}
	
	public void insertBitcoinHistorical(final BitcoinHistorical bitcoin) {
		logger.info("Insert BitcoinHistorical: {}", bitcoin);
		bitcoinHistoricalRepository.save(bitcoin);
	}
}
