package org.proxima.cryptocurrency.okex;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.proxima.cryptocurrency.json.JSON_Okex;
import org.proxima.cryptocurrency.utils.GETRequestUtil;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.CryptoValute;

public class Okex {
	final static Logger logger = Logger.getLogger(Okex.class);

	// RENDO LA CLASSE IMPOSSIBILE DA ISTANZIARE..
	private Okex() {
	}

	// URL https://www.okex.com
	// GET /api/v1/future_index.do
	//
	// Example
	// # Request
	// GET https://www.okex.com/api/v1/future_index.do?symbol=btc_usd
	// # Response
	// {"future_index":471.0817}
	//
	// Return Values
	// future_index: current futures index price
	// Request Parameters
	// Parameter Description
	// symbol
	//
	// btc_usd ltc_usd eth_usd etc_usd bch_usd
	public static CryptoValute getBitcoinValue() throws Exception {
		JSON_Okex okex = getFutureValue("btc_usd");
//		Crypto Valute future = new CryptoValute();
		return null;
	}

	private static JSON_Okex getFutureValue(String future) throws Exception {
		String json = GETRequestUtil.sendGet("https://www.okex.com/api/v1/future_index.do?symbol=" + future,
				"application/x-www-form-urlencoded");
		logger.info(json);

		ObjectMapper objectMapper = new ObjectMapper();
		JSON_Okex futureValue = objectMapper.readValue(json, JSON_Okex.class);
		logger.info(futureValue.getFuture_index());
		
		return futureValue;
	}
}
