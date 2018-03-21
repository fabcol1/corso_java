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
import org.proxima.cc.entities.CryptoExchangeValuesProvider;
import org.proxima.cc.entities.CurrencyRegistry;
import org.proxima.cc.entities.ethereum.EthereumHistorical;
import org.proxima.cc.entities.ethereum.EthereumHistoricalCustom;
import org.springframework.stereotype.Repository;

@Repository
public class EthereumHistoricalRepositoryImpl implements EthereumHistoricalRepositoryCustom {

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
		EthereumHistoricalCustom bhist = new EthereumHistoricalCustom();
		bhist.setExchangevalue(new BigDecimal(returnValue));
		return bhist ;	
	}
	
//	@Override
//	public BitcoinHistoricalCustom findAverageByExchangetimeGreaterThanAndCryptoexchangevaluesproviderid(LocalDateTime ldt, Long id) {
//
//		  // Get Average Salary
////        CriteriaQuery<Double> criteriaQuery3 = builder.createQuery(Double.class);
////        Root<Employee> root3 = criteriaQuery3.from(Employee.class);
////        criteriaQuery3.select(builder.avg(root3.get("salary")));
////        Query<Double> query3 = session.createQuery(criteriaQuery3);
////        double avgSalary = query3.getSingleResult();
////        System.out.println("Average Salary = " + avgSalary);
//		
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<BitcoinHistoricalCustom> query = null;
//		query = cb.createQuery(BitcoinHistoricalCustom.class);
//		Root<BitcoinHistorical> bitcoinHistoricalTable = query.from(BitcoinHistorical.class);
//		List<Predicate> criteria = new ArrayList<Predicate>();
//		criteria.add(cb.equal(bitcoinHistoricalTable.get("cryptoexchangevaluesproviderid"), id));
//		criteria.add(cb.greaterThan(bitcoinHistoricalTable.get("exchangetime"), ldt));
//		
//		query.where(criteria.toArray(new Predicate[criteria.size()]));
//		
//		TypedQuery<BitcoinHistoricalCustom> q = em.createQuery(query.multiselect(
//				bitcoinHistoricalTable.get("id"),
//				bitcoinHistoricalTable.get("cryptoexchangevaluesproviderid"), 
//				bitcoinHistoricalTable.get("currencyregistryid"),
//				bitcoinHistoricalTable.get("exchangetime"),
//				cb.avg(bitcoinHistoricalTable.get("exchangevalue")).as(BigDecimal.class)));
//		
//		q.setMaxResults(1);
//		BitcoinHistoricalCustom returnValue = q.getSingleResult();
//		return returnValue ;	
//		}
	
}
