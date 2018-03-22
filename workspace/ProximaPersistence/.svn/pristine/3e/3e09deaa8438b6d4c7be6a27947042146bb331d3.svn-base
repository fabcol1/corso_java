
package org.proxima.cc.repository.ethereum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.proxima.cc.entities.CryptoExchangeValuesProvider;
import org.proxima.cc.entities.CurrencyRegistry;
import org.proxima.cc.entities.ethereum.EthereumHistorical;
import org.proxima.cc.entities.ethereum.EthereumHistoricalCustom;
import org.springframework.stereotype.Repository;


@Repository
public class EthereumHistoricalRepositoryImpl implements EthereumHistoricalRepositoryCustom {

	public static final Logger logger = Logger.getLogger(EthereumHistoricalRepositoryImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public EthereumHistoricalCustom findAverageByExchangetimeGreaterThanAndCryptoexchangevaluesproviderid(LocalDateTime ldt, Long id) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Double> query = cb.createQuery(Double.class);;
		Root<EthereumHistorical> ethereumHistoricalTable = query.from(EthereumHistorical.class);
		
		query.where(cb.and(cb.equal(ethereumHistoricalTable.get("cryptoexchangevaluesproviderid"), id), 
				cb.greaterThan(ethereumHistoricalTable.get("exchangetime"), ldt)));
		
		query.select(cb.avg(ethereumHistoricalTable.get("exchangevalue")));
		
		TypedQuery<Double> q = em.createQuery(query);
		Double returnValue = q.getSingleResult();
		logger.info("Double AVG: " + returnValue);

		EthereumHistoricalCustom bhist = new EthereumHistoricalCustom();
		if(returnValue!=null) {
			bhist.setExchangevalue(new BigDecimal(returnValue));
		}
		return bhist ;	
	}
	
}

