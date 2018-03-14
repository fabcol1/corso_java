package org.proxima.cc.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.proxima.cc.entities.BitcoinHistorical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BitcoinHistoricalRepository extends JpaRepository<BitcoinHistorical, Integer> {

	List<BitcoinHistorical> findAllByExchangetimeGreaterThan (LocalDateTime ldt) ;
	
}
