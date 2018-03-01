package okex;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.db.BitcoinDBManager;
import org.db.LitecoinDBManager;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Bitcoin;
import model.FromWhere;
import model.Litecoin;
import model.TipoValuta;
import utils.GETRequestUtil;

public class Okex {
	final static Logger logger = Logger.getLogger(Okex.class);

	// URL https://www.okex.com/api/v1/future_ticker.do
	//
	// Example
	// # Request
	// GET
	// https://www.okex.com/api/v1/future_ticker.do?symbol=btc_usd&contract_type=this_week
	// # Response
	// {
	// "date":"1411627632",
	// "ticker":{
	// "last":409.2,
	// "buy" :408.23,
	// "sell":409.18,
	// "high":432.0,
	// "low":405.71,
	// "vol":55168.0,
	// "contract_id":20140926012,
	// "unit_amount":100.0
	// }
	// }
	//
	// Return Values
	// buy: best bid
	// contract_id: contract ID
	// high: highest price
	// last: latest price
	// low: lowest price
	// sell: best ask
	// unit_amount: contract par value
	// vol: volume (in last 24 hours)
	// Request Parameters
	// Parameter Description
	// symbol
	//
	// btc_usd ltc_usd eth_usd etc_usd bch_usd
	//
	// contract_type
	//
	// this_week next_week quarter
	private static JSON_Okex getFutureValue(String future) throws Exception {
		// https://www.okex.com/api/v1/future_ticker.do?symbol=btc_usd&contract_type=this_week
		String json = GETRequestUtil.sendGet(
				"https://www.okex.com/api/v1/future_ticker.do?symbol=" + future + "&contract_type=this_week",
				"application/x-www-form-urlencoded");
		logger.info(json);
		ObjectMapper objectMapper = new ObjectMapper();
		JSON_Okex futureValue = objectMapper.readValue(json, JSON_Okex.class);
		logger.info(futureValue.getDate());
		logger.info(Arrays.toString(futureValue.getTicker().values().toArray()));
		return futureValue;
	}

	public static void insertBTCtoDB() throws Exception {
		JSON_Okex obj = getFutureValue("btc_usd");
		String timeStamp = obj.getDate();
		logger.info("TIMESTAMP: " + timeStamp);
		int timeStampInt = Integer.parseInt(timeStamp);
		logger.info("TIMESTAMP int: " + timeStampInt);
		BigDecimal last = obj.getTicker().get("last");
		logger.info("LAST BITCOIN VAL: " + last);

//		INSERT INTO bitcoin(cambio_valore, data_valore, id_from, id_valuta) 
//		VALUES(10299.23, '2012-06-18 10:34:09', 1, 2);
		Bitcoin b  = new Bitcoin();

		FromWhere fw = new FromWhere();
		fw.setId(1); // okex
		TipoValuta tv = new TipoValuta();
		tv.setId(2); // dollari
	
		b.setCambioValore(last);
//		LocalDateTime epoch = LocalDateTime.ofEpochSecond(1519905678, 0, ZoneOffset.UTC);
//		System.out.println(epoch);
//		System.out.println(LocalDateTime.ofInstant(epoch.toInstant(ZoneOffset.UTC), ZoneId.systemDefault()));
		LocalDateTime epoch = LocalDateTime.ofEpochSecond(timeStampInt, 0, ZoneOffset.UTC);
		epoch = LocalDateTime.ofInstant(epoch.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
		logger.info("EPOCH: " + epoch);

		b.setDataValore(epoch);
		b.setFromWhere(fw);
		b.setTipoValuta(tv);
		
		BitcoinDBManager.insert(b);
//		BitcoinDBManager.closeSessionFactory();
	}
	
	public static void insertLTCtoDB() throws Exception {
		JSON_Okex obj = getFutureValue("ltc_usd");
		String timeStamp = obj.getDate();
		logger.info("TIMESTAMP: " + timeStamp);
		int timeStampInt = Integer.parseInt(timeStamp);
		logger.info("TIMESTAMP int: " + timeStampInt);
		BigDecimal last = obj.getTicker().get("last");
		logger.info("LAST LITECOIN VAL: " + last);

//		INSERT INTO litecoin(cambio_valore, data_valore, id_from, id_valuta) 
//		VALUES(10299.23, '2012-06-18 10:34:09', 1, 2);
		Litecoin l  = new Litecoin();

		FromWhere fw = new FromWhere();
		fw.setId(1); // okex
		TipoValuta tv = new TipoValuta();
		tv.setId(2); // dollari
	
		l.setCambioValore(last);
//		LocalDateTime epoch = LocalDateTime.ofEpochSecond(1519905678, 0, ZoneOffset.UTC);
//		System.out.println(epoch);
//		System.out.println(LocalDateTime.ofInstant(epoch.toInstant(ZoneOffset.UTC), ZoneId.systemDefault()));
		LocalDateTime epoch = LocalDateTime.ofEpochSecond(timeStampInt, 0, ZoneOffset.UTC);
		epoch = LocalDateTime.ofInstant(epoch.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
		logger.info("EPOCH: " + epoch);

		l.setDataValore(epoch);
		l.setFromWhere(fw);
		l.setTipoValuta(tv);
		
		LitecoinDBManager.insert(l);
//		LitecoinDBManager.closeSessionFactory();
	}
	
	public static void insertToDBfromOKEX() throws Exception {
		insertBTCtoDB();
		insertLTCtoDB();
	}
}
