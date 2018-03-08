package org.proxima.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.proxima.entities.Bitcoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BitcoinJpaRepository extends JpaRepository<Bitcoin, Integer> {

	List<Bitcoin> findAllByDataValoreGreaterThan (LocalDateTime ldt) ;
	
}
