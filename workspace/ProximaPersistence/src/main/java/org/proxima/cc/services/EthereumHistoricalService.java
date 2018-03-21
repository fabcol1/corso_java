package org.proxima.cc.services;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.proxima.cc.entities.ethereum.EthereumHistorical;
import org.proxima.cc.entities.ethereum.EthereumHistoricalCustom;
import org.proxima.cc.repository.ethereum.EthereumHistoricalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EthereumHistoricalService {

	public static final Logger logger = Logger.getLogger(EthereumHistoricalService.class);

	@Autowired
	private EthereumHistoricalRepository ethereumHistoricalRepository;

	public List<EthereumHistorical> listAllEthereumHistoricals() {
		return ethereumHistoricalRepository.findAll();
	}

	public List<EthereumHistorical> listAllLastDayEthereumHistoricals() {
		LocalDateTime ldtNow = LocalDateTime.now();
		LocalDateTime ldt = ldtNow.minusDays(1);
		List<EthereumHistorical> ethereums = ethereumHistoricalRepository.findAllByExchangetimeGreaterThan(ldt);
		return ethereums;
	}

	public List<EthereumHistorical> listAllLastDayEthereumHistoricals(Long id) {
		LocalDateTime ldtNow = LocalDateTime.now();
		LocalDateTime ldt = ldtNow.minusDays(1);
		List<EthereumHistorical> ethereums = ethereumHistoricalRepository
				.findAllByExchangetimeGreaterThanAndCryptoexchangevaluesproviderid(ldt, id);
		return ethereums;
	}

	public List<EthereumHistorical> listAllLastWeekEthereumHistoricals() {
		LocalDateTime ldtNow = LocalDateTime.now();
		LocalDateTime ldt = ldtNow.minusWeeks(1);
		List<EthereumHistorical> ethereums = ethereumHistoricalRepository.findAllByExchangetimeGreaterThan(ldt);
		return ethereums;
	}

	public List<EthereumHistorical> listAlllastMonthEthereumHistoricals() {
		LocalDateTime ldtNow = LocalDateTime.now();
		LocalDateTime ldt = ldtNow.minusMonths(1);
		List<EthereumHistorical> ethereums = ethereumHistoricalRepository.findAllByExchangetimeGreaterThan(ldt);
		return ethereums;
	}

	public List<EthereumHistorical> listAlllastYearEthereumHistoricals() {
		LocalDateTime ldtNow = LocalDateTime.now();
		LocalDateTime ldt = ldtNow.minusYears(1);
		List<EthereumHistorical> ethereums = ethereumHistoricalRepository.findAllByExchangetimeGreaterThan(ldt);
		return ethereums;
	}

	public void insertEthereumHistorical(final EthereumHistorical ethereum) {
		logger.info("Insert EthereumHistorical: {} " + ethereum);
		ethereumHistoricalRepository.save(ethereum);
	}

	public EthereumHistorical getMinLastDayEthereumHistoricals(Long id) {
		LocalDateTime ldtNow = LocalDateTime.now();
		LocalDateTime ldt = ldtNow.minusDays(1);
		EthereumHistorical ethereum = null;
		try {
			ethereum = ethereumHistoricalRepository
					.findFirstByExchangetimeGreaterThanAndCryptoexchangevaluesprovideridOrderByExchangevalueAsc(ldt,
							id);
			logger.info("Valore: " + ethereum);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

		return ethereum;
	}

	public EthereumHistorical getMaxLastDayEthereumHistoricals(Long id) {
		LocalDateTime ldtNow = LocalDateTime.now();
		LocalDateTime ldt = ldtNow.minusDays(1);
		EthereumHistorical ethereum = null;
		try {
			ethereum = ethereumHistoricalRepository
					.findFirstByExchangetimeGreaterThanAndCryptoexchangevaluesprovideridOrderByExchangevalueDesc(ldt,
							id);
			logger.info("Valore: " + ethereum);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return ethereum;
	}

	public EthereumHistoricalCustom getAverageLastDayEthereumHistoricals(Long id) {
		LocalDateTime ldtNow = LocalDateTime.now();
		LocalDateTime ldt = ldtNow.minusDays(1);
		EthereumHistoricalCustom ethereum = null;
		try {
			ethereum = ethereumHistoricalRepository
					.findAverageByExchangetimeGreaterThanAndCryptoexchangevaluesproviderid(ldt, id);
			logger.info("Valore: " + ethereum);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return ethereum;
	}
}
