package org.proxima.cc.repository.bitcoin;

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
import org.proxima.cc.entities.bitcoin.BitcoinHistorical;
import org.proxima.cc.entities.bitcoin.BitcoinHistoricalCustom;
import org.springframework.stereotype.Repository;

@Repository
public class BitcoinHistoricalRepositoryImpl implements BitcoinHistoricalRepositoryCustom {

	public static final Logger logger = Logger.getLogger(BitcoinHistoricalRepositoryImpl.class);

	@PersistenceContext
	private EntityManager em;
	
	public BitcoinHistoricalCustom findLastExchangeByProviderIdAndCurrency (Long providerId, Long currencyId) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<BitcoinHistoricalCustom> query = null;
		query = cb.createQuery(BitcoinHistoricalCustom.class);
		Root<BitcoinHistorical> bitcoinHistoricalTable = query.from(BitcoinHistorical.class);
		Root<CryptoExchangeValuesProvider> cryptoExchangeValuesProviderTable = query.from(CryptoExchangeValuesProvider.class);
		Root<CurrencyRegistry> currencyRegistryTable = query.from(CurrencyRegistry.class);
//		Root<AnagGeneric> tableAnagGenericForCurrency = query.from(AnagGeneric.class);
		List<Predicate> criteria = new ArrayList<Predicate>();
		criteria.add(cb.equal(bitcoinHistoricalTable.get("cryptoexchangevaluesproviderid"), providerId));
		criteria.add(cb.equal(cryptoExchangeValuesProviderTable.get("id"), providerId));
		criteria.add(cb.equal(bitcoinHistoricalTable.get("cryptoexchangevaluesproviderid"), cryptoExchangeValuesProviderTable.get("id")));
		criteria.add(cb.equal(bitcoinHistoricalTable.get("currencyregistryid"), currencyId));
		criteria.add(cb.equal(currencyRegistryTable.get("id"), currencyId));
		criteria.add(cb.equal(currencyRegistryTable.get("id"), bitcoinHistoricalTable.get("currencyregistryid")));
//		criteria.add(cb.equal(tableAccounts.get(Account_.accountTypeId), tableAnagGeneric.get(AnagGeneric_.anagId)));
//		criteria.add(cb.equal(tableAnagGeneric.get(AnagGeneric_.anagId), tableAnagGenericLang.get(AnagGenericLang_.id).get(AnagGenericLangPK_.anagId)));
//		criteria.add(cb.equal(tableAnagGenericForCurrency.get(AnagGeneric_.anagId), tableAccounts.get(Account_.currencyId)));
//		criteria.add(cb.equal(tableAnagGenericLang.get(AnagGenericLang_.id).get(AnagGenericLangPK_.cdLng), cdLng));

		query.where(criteria.toArray(new Predicate[criteria.size()]));
		query.orderBy(cb.desc(bitcoinHistoricalTable.get("exchangetime")));
		TypedQuery<BitcoinHistoricalCustom> q = em.createQuery(query.multiselect(
				bitcoinHistoricalTable.get("id"),
				bitcoinHistoricalTable.get("cryptoexchangevaluesproviderid"), 
				bitcoinHistoricalTable.get("currencyregistryid"),
				bitcoinHistoricalTable.get("exchangetime"),
				bitcoinHistoricalTable.get("exchangevalue"), 
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
		BitcoinHistoricalCustom returnValue = q.getSingleResult();
//		List<BitcoinHistoricalCustom> tmp = q.getResultList();
//		return tmp;
		return returnValue ;
	}

	@Override
	public BitcoinHistoricalCustom findAverageByExchangetimeGreaterThanAndCryptoexchangevaluesproviderid(LocalDateTime ldt, Long id) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Double> query = cb.createQuery(Double.class);;
		Root<BitcoinHistorical> bitcoinHistoricalTable = query.from(BitcoinHistorical.class);
		
		query.where(cb.and(cb.equal(bitcoinHistoricalTable.get("cryptoexchangevaluesproviderid"), id), 
				cb.greaterThan(bitcoinHistoricalTable.get("exchangetime"), ldt)));
		
		query.select(cb.avg(bitcoinHistoricalTable.get("exchangevalue")));
		
		TypedQuery<Double> q = em.createQuery(query);
		Double returnValue = q.getSingleResult();
		logger.info("Double AVG: " + returnValue);

		BitcoinHistoricalCustom bhist = new BitcoinHistoricalCustom();
		if(returnValue!=null) {
			bhist.setExchangevalue(new BigDecimal(returnValue));
		}
		return bhist ;	
	}
}
