package org.proxima.cc.repository.bitcoin;

import java.time.LocalDateTime;
import java.util.List;

import org.proxima.cc.entities.bitcoin.BitcoinHistorical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BitcoinHistoricalRepository extends JpaRepository<BitcoinHistorical, Integer>, JpaSpecificationExecutor<BitcoinHistorical>, BitcoinHistoricalRepositoryCustom {

	List<BitcoinHistorical> findAllByExchangetimeGreaterThan (LocalDateTime ldt);
	List<BitcoinHistorical> findAllByExchangetimeGreaterThanAndCryptoexchangevaluesproviderid(LocalDateTime ldt, Long id);

	//	select * from bitcoinhistorical where cryptoexchangevaluesproviderid=7 AND exchangetime > '2018-03-19 10:17:57.0' ORDER BY exchangevalue DESC LIMIT 1;
	// MAX
	BitcoinHistorical findFirstByExchangetimeGreaterThanAndCryptoexchangevaluesprovideridOrderByExchangevalueDesc(LocalDateTime ldt, Long id);
	
	//	select * from bitcoinhistorical where cryptoexchangevaluesproviderid=7 AND exchangetime > '2018-03-19 10:17:57.0' ORDER BY exchangevalue ASC LIMIT 1;
	// MIN
	BitcoinHistorical findFirstByExchangetimeGreaterThanAndCryptoexchangevaluesprovideridOrderByExchangevalueAsc(LocalDateTime ldt, Long id);

	//	select AVG(exchangevalue) from bitcoinhistorical where cryptoexchangevaluesproviderid=7 AND exchangetime > '2018-03-19 11:23:03.0';
	// AVERAGE 
//	BitcoinHistorical findAverageByExchangetimeGreaterThanAndCryptoexchangevaluesproviderid(LocalDateTime ldt, Long id);
	
}
