package org.proxima.cc.repository.litecoin;

import java.time.LocalDateTime;
import java.util.List;

import org.proxima.cc.entities.bitcoin.BitcoinHistorical;
import org.proxima.cc.entities.litecoin.LitecoinHistorical;
import org.proxima.cc.repository.bitcoin.BitcoinHistoricalRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LitecoinHistoricalRepository extends JpaRepository<LitecoinHistorical, Integer>, JpaSpecificationExecutor<LitecoinHistorical>, LitecoinHistoricalRepositoryCustom {

	List<LitecoinHistorical> findAllByExchangetimeGreaterThan(LocalDateTime ldt);

	List<LitecoinHistorical> findAllByExchangetimeGreaterThanAndCryptoexchangevaluesproviderid(LocalDateTime ldt,
			Long id);

	LitecoinHistorical findFirstByExchangetimeGreaterThanAndCryptoexchangevaluesprovideridOrderByExchangevalueDesc(
			LocalDateTime ldt, Long id);

	// select * from bitcoinhistorical where cryptoexchangevaluesproviderid=7 AND
	// exchangetime > '2018-03-19 10:17:57.0' ORDER BY exchangevalue ASC LIMIT 1;
	// MIN
	LitecoinHistorical findFirstByExchangetimeGreaterThanAndCryptoexchangevaluesprovideridOrderByExchangevalueAsc(
			LocalDateTime ldt, Long id);

}
