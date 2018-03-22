package org.proxima.cc.repository.litecoin;

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
import org.proxima.cc.entities.litecoin.LitecoinHistorical;
import org.proxima.cc.entities.litecoin.LitecoinHistoricalCustom;
import org.springframework.stereotype.Repository;

@Repository
public class LitecoinHistoricalRepositoryImpl implements LitecoinHistoricalRepositoryCustom {

	public static final Logger logger = Logger.getLogger(LitecoinHistoricalRepositoryImpl.class);

	@PersistenceContext
	private EntityManager em;
	
	public LitecoinHistoricalCustom findLastExchangeByProviderIdAndCurrency (Long providerId, Long currencyId) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<LitecoinHistoricalCustom> query = null;
		query = cb.createQuery(LitecoinHistoricalCustom.class);
		Root<LitecoinHistorical> litecoinHistoricalTable = query.from(LitecoinHistorical.class);
		Root<CryptoExchangeValuesProvider> cryptoExchangeValuesProviderTable = query.from(CryptoExchangeValuesProvider.class);
		Root<CurrencyRegistry> currencyRegistryTable = query.from(CurrencyRegistry.class);
//		Root<AnagGeneric> tableAnagGenericForCurrency = query.from(AnagGeneric.class);
		List<Predicate> criteria = new ArrayList<Predicate>();
		criteria.add(cb.equal(litecoinHistoricalTable.get("cryptoexchangevaluesproviderid"), providerId));
		criteria.add(cb.equal(cryptoExchangeValuesProviderTable.get("id"), providerId));
		criteria.add(cb.equal(litecoinHistoricalTable.get("cryptoexchangevaluesproviderid"), cryptoExchangeValuesProviderTable.get("id")));
		criteria.add(cb.equal(litecoinHistoricalTable.get("currencyregistryid"), currencyId));
		criteria.add(cb.equal(currencyRegistryTable.get("id"), currencyId));
		criteria.add(cb.equal(currencyRegistryTable.get("id"), litecoinHistoricalTable.get("currencyregistryid")));
//		criteria.add(cb.equal(tableAccounts.get(Account_.accountTypeId), tableAnagGeneric.get(AnagGeneric_.anagId)));
//		criteria.add(cb.equal(tableAnagGeneric.get(AnagGeneric_.anagId), tableAnagGenericLang.get(AnagGenericLang_.id).get(AnagGenericLangPK_.anagId)));
//		criteria.add(cb.equal(tableAnagGenericForCurrency.get(AnagGeneric_.anagId), tableAccounts.get(Account_.currencyId)));
//		criteria.add(cb.equal(tableAnagGenericLang.get(AnagGenericLang_.id).get(AnagGenericLangPK_.cdLng), cdLng));

		query.where(criteria.toArray(new Predicate[criteria.size()]));
		query.orderBy(cb.desc(litecoinHistoricalTable.get("exchangetime")));
		TypedQuery<LitecoinHistoricalCustom> q = em.createQuery(query.multiselect(
				litecoinHistoricalTable.get("id"),
				litecoinHistoricalTable.get("cryptoexchangevaluesproviderid"), 
				litecoinHistoricalTable.get("currencyregistryid"),
				litecoinHistoricalTable.get("exchangetime"),
				litecoinHistoricalTable.get("exchangevalue"), 
				cryptoExchangeValuesProviderTable.get("imgpath"),
				cryptoExchangeValuesProviderTable.get("site"), 
				cryptoExchangeValuesProviderTable.get("label"),
				currencyRegistryTable.get("label"),
				currencyRegistryTable.get("symbol")
				));
		
		/*
		 * this.id = id;
		this.cryptoexchangevaluesproviderid=cryptoexchangevaluesproviderid;
		this.currencyregistryid=currencyregistryid;
		this.exchangetime=exchangetime;
		this.exchangevalue=exchangevalue;
		this.providerIconImgpath=providerIconImgpath;
		this.providerLabel=providerLabel;
		this.providerSite=providerSite;
		this.currencyLabel=currencyLabel;
		this.currencySymbol=currencySymbol;
		 */
		q.setMaxResults(1);
		LitecoinHistoricalCustom returnValue = q.getSingleResult();
		return returnValue ;
	}

	@Override
	public LitecoinHistoricalCustom findAverageByExchangetimeGreaterThanAndCryptoexchangevaluesproviderid(LocalDateTime ldt, Long id) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Double> query = cb.createQuery(Double.class);;
		Root<LitecoinHistorical> litecoinHistoricalTable = query.from(LitecoinHistorical.class);
		
		query.where(cb.and(cb.equal(litecoinHistoricalTable.get("cryptoexchangevaluesproviderid"), id), 
				cb.greaterThan(litecoinHistoricalTable.get("exchangetime"), ldt)));
		
		query.select(cb.avg(litecoinHistoricalTable.get("exchangevalue")));
		
		TypedQuery<Double> q = em.createQuery(query);
		Double returnValue = q.getSingleResult();
		logger.info("Double AVG: " + returnValue);
		LitecoinHistoricalCustom bhist = new LitecoinHistoricalCustom();
		if(returnValue!=null) {
			bhist.setExchangevalue(new BigDecimal(returnValue));
		}
		return bhist ;	
	}
	
}
