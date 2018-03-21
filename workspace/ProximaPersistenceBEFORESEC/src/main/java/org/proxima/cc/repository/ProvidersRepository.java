package org.proxima.cc.repository;

import org.proxima.cc.entities.CryptoExchangeValuesProvider;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvidersRepository extends JpaRepository<CryptoExchangeValuesProvider, Long> {
	
	@Cacheable("findByLabel")
	CryptoExchangeValuesProvider findByLabel(String label);

}
