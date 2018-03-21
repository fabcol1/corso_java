package org.proxima.cc.repository.litecoin;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import org.proxima.cc.entities.bitcoin.BitcoinHistorical;
import org.proxima.cc.entities.litecoin.LitecoinHistorical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LitecoinHistoricalRepository extends JpaRepository<LitecoinHistorical, Integer> {

	List<LitecoinHistorical> findAllByExchangetimeGreaterThan (LocalDateTime ldt) ;
	List<LitecoinHistorical> findAllByExchangetimeGreaterThanAndCryptoexchangevaluesproviderid(LocalDateTime ldt, Long id);
	
}