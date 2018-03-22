package org.proxima.cc.repository.litecoin;

import java.time.LocalDateTime;

import org.proxima.cc.entities.litecoin.LitecoinHistoricalCustom;

public interface LitecoinHistoricalRepositoryCustom {

	LitecoinHistoricalCustom findLastExchangeByProviderIdAndCurrency(Long providerId, Long currencyId);

	// select AVG(exchangevalue) from bitcoinhistorical where
	// cryptoexchangevaluesproviderid=7 AND exchangetime > '2018-03-19 11:23:03.0';
	// AVERAGE
	LitecoinHistoricalCustom findAverageByExchangetimeGreaterThanAndCryptoexchangevaluesproviderid(LocalDateTime ldt,
			Long id);

}
