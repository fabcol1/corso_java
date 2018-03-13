package org.proxima.cc.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.proxima.cc.entities.EthereumHistorical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EthereumHistoricalRepository extends JpaRepository<EthereumHistorical, Integer> {

	List<EthereumHistorical> findAllByExchangetimeGreaterThan (LocalDateTime ldt) ;
	
}
