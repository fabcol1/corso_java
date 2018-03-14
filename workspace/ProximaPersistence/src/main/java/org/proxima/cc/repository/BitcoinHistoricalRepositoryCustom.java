package org.proxima.cc.repository;

import org.proxima.cc.entities.BitcoinHistoricalCustom;

public interface BitcoinHistoricalRepositoryCustom  {
	BitcoinHistoricalCustom findByLastExcangeByProviderIdAndCurrency (Long providerId, Long currencyId) ;
}
