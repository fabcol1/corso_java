package org.proxima.cc.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.proxima.cc.entities.LitecoinHistorical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LitecoinHistoricalRepository extends JpaRepository<LitecoinHistorical, Integer> {

	List<LitecoinHistorical> findAllByExchangetimeGreaterThan (LocalDateTime ldt) ;
	
}
