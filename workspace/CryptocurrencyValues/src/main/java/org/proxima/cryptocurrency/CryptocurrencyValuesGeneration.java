package org.proxima.cryptocurrency;

import org.apache.log4j.Logger;
import org.proxima.cryptocurrency.okex.Okex;

public class CryptocurrencyValuesGeneration {
	final static Logger logger = Logger.getLogger(CryptocurrencyValuesGeneration.class);

	public static void main(String[] args) throws Exception {

		// CARICO I VALORI CHE PESCO DA OKEX API https://www.okex.com/
		// SUL DATABASE...
		Okex.getBitcoinValue();
	}

}
