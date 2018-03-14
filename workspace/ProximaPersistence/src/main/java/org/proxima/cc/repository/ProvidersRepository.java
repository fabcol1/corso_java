package org.proxima.cc.repository;
import java.util.List;

import org.proxima.cc.entities.CryptoExchangeValuesProvider;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ProvidersRepository extends JpaRepository<CryptoExchangeValuesProvider, Long> {
	
	
	List<CryptoExchangeValuesProvider> findProviderByLabel (String name);
	
	
	
}
