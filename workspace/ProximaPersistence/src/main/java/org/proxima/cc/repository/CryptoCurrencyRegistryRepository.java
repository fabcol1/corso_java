/**
 * 
 */
package org.proxima.cc.repository;

import org.proxima.cc.entities.CurrencyRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author maurizio
 *
 */
@Repository
public interface CryptoCurrencyRegistryRepository extends JpaRepository<CurrencyRegistry, Long> {
	CurrencyRegistry findByLabel (String label);
}
