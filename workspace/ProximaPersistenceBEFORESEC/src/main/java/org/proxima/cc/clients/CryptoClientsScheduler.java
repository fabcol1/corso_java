package org.proxima.cc.clients;

import org.apache.log4j.Logger;
import org.proxima.cc.clients.bitcore.Bitcore;
import org.proxima.cc.clients.bitstamp.Bitstamp;
import org.proxima.cc.clients.btcc.Btcc;
import org.proxima.cc.clients.livecoin.Livecoin;
import org.proxima.cc.clients.okex.Okex;
import org.proxima.cc.clients.wex.Wex;
import org.proxima.cc.clients.yobit.Yobit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CryptoClientsScheduler {
	final static Logger logger = Logger.getLogger(CryptoClientsScheduler.class);

	@Autowired
	private Okex okex;
	@Autowired
	private Yobit yobit;
	@Autowired
	private Bitstamp bitstamp;
	@Autowired
	private Btcc btcc;
	@Autowired
	private Bitcore bitcore;
	@Autowired
	private Livecoin livecoin;
	@Autowired
	private Wex wex;
	
	///////////////////////////////////////////
	// OKEX ///////////////////////
	///////////////////////////////////////////

	@Scheduled(cron = "0 0/3 * * * ?")
	public void insertBTCtoDBfromOKEX() throws Exception {
		logger.info("-----------------------------OKEX--------------------------------");
		okex.insertBTCtoDB();
		logger.info("------------------------------------------------------------------");

	}

	@Scheduled(cron = "0 1/3 * * * ?")
	public void insertLTCtoDBfromOKEX() throws Exception {
		logger.info("-----------------------------OKEX--------------------------------");
		okex.insertLTCtoDB();
		logger.info("------------------------------------------------------------------");
	}

	@Scheduled(cron = "0 2/3 * * * ?")
	public void insertETHtoDBfromOKEX() throws Exception {
		logger.info("-----------------------------OKEX--------------------------------");
		okex.insertETHtoDB();
		logger.info("------------------------------------------------------------------");
	}

	///////////////////////////////////////////
	// YOBIT ///////////////////////
	///////////////////////////////////////////

	@Scheduled(cron = "0 0/3 * * * ?")
	public void insertBTCtoDBfromYOBIT() throws Exception {
		logger.info("-----------------------------YOBIT--------------------------------");
		yobit.insertBTCtoDB();
		logger.info("------------------------------------------------------------------");
	}

	@Scheduled(cron = "0 1/3 * * * ?")
	public void insertLTCtoDBfromYOBIT() throws Exception {
		logger.info("-----------------------------YOBIT--------------------------------");
		yobit.insertLTCtoDB();
		logger.info("------------------------------------------------------------------");
	}

	@Scheduled(cron = "0 2/3 * * * ?")
	public void insertETHtoDBfromYOBIT() throws Exception {
		logger.info("-----------------------------YOBIT--------------------------------");
		yobit.insertETHtoDB();
		logger.info("------------------------------------------------------------------");
	}

	///////////////////////////////////////////
	// BITSTAMP ///////////////////////
	///////////////////////////////////////////

	@Scheduled(cron = "0 0/3 * * * ?")
	public void insertBTCtoDBfromBITSTAMP() throws Exception {
		logger.info("---------------------------BITSTAMP-------------------------------");
		bitstamp.insertBTCtoDB();
		logger.info("------------------------------------------------------------------");
	}

	@Scheduled(cron = "0 1/3 * * * ?")
	public void insertLTCtoDBfromBITSTAMP() throws Exception {
		logger.info("-------------------------BITSTAMP----------------------------");
		bitstamp.insertLTCtoDB();
		logger.info("------------------------------------------------------------------");
	}

	@Scheduled(cron = "0 2/3 * * * ?")
	public void insertETHtoDBfromBITSTAMP() throws Exception {
		logger.info("-------------------------BITSTAMP----------------------------");
		bitstamp.insertETHtoDB();
		logger.info("------------------------------------------------------------------");
	}
	///////////////////////////////////////////
	// BTCC ///////////////////////
	///////////////////////////////////////////

	@Scheduled(cron = "0 0/3 * * * ?")
	public void insertBTCtoDBfromBTCC() throws Exception {
		logger.info("---------------------------BTCC-----------------------------------");
		btcc.insertBTCtoDB();
		logger.info("------------------------------------------------------------------");
	}

	///////////////////////////////////////////
	// COINMARKETCAP ///////////////////////
	///////////////////////////////////////////

//	@Scheduled(cron = "0 0/3 * * * ?")
//	public void insertBTCtoDBfromCOINMARKETCAP() throws Exception {
//		logger.info("-------------------------COINMARKETCAP----------------------------");
//		coinmarketcap.insertBTCtoDB();
//		logger.info("------------------------------------------------------------------");
//	}
//
//	@Scheduled(cron = "0 1/3 * * * ?")
//	public void insertLTCtoDBfromCOINMARKETCAP() throws Exception {
//		logger.info("-------------------------COINMARKETCAP----------------------------");
//		coinmarketcap.insertLTCtoDB();
//		logger.info("------------------------------------------------------------------");
//	}
//
//	@Scheduled(cron = "0 2/3 * * * ?")
//	public void insertETHtoDBfromCOINMARKETCAP() throws Exception {
//		logger.info("-------------------------COINMARKETCAP----------------------------");
//		coinmarketcap.insertETHtoDB();
//		logger.info("------------------------------------------------------------------");
//	}

	///////////////////////////////////////////
	// BITCORE ///////////////////////
	///////////////////////////////////////////

	@Scheduled(cron = "0 0/3 * * * ?")
	public void insertBTCtoDBfromBITCORE() throws Exception {
		logger.info("-----------------------------BITCORE--------------------------------");
		bitcore.insertBTCtoDB();
		logger.info("------------------------------------------------------------------");

	}

	@Scheduled(cron = "0 1/3 * * * ?")
	public void insertLTCtoDBfromBITCORE() throws Exception {
		logger.info("-----------------------------BITCORE--------------------------------");
		bitcore.insertLTCtoDB();
		logger.info("------------------------------------------------------------------");
	}

	@Scheduled(cron = "0 2/3 * * * ?")
	public void insertETHtoDBfromBITCORE() throws Exception {
		logger.info("-----------------------------BITCORE--------------------------------");
		bitcore.insertETHtoDB();
		logger.info("------------------------------------------------------------------");
	}
	
	///////////////////////////////////////////
	// LIVECOIN ///////////////////////
	///////////////////////////////////////////

	@Scheduled(cron = "0 0/3 * * * ?")
	public void insertBTCtoDBfromLIVECOIN() throws Exception {
		logger.info("---------------------------LIVECOIN-----------------------------------");
		livecoin.insertBTCtoDB();
		logger.info("------------------------------------------------------------------");
	}
	
	@Scheduled(cron = "0 1/3 * * * ?")
	public void insertLTCtoDBfromLIVECOIN() throws Exception {
		logger.info("-----------------------------LIVECOIN--------------------------------");
		livecoin.insertLTCtoDB();
		logger.info("------------------------------------------------------------------");
	}

	@Scheduled(cron = "0 2/3 * * * ?")
	public void insertETHtoDBfromLIVECOIN() throws Exception {
		logger.info("-----------------------------LIVECOIN--------------------------------");
		livecoin.insertETHtoDB();
		logger.info("------------------------------------------------------------------");
	}
	
	///////////////////////////////////////////
	// WEX ///////////////////////
	///////////////////////////////////////////

	@Scheduled(cron = "0 0/3 * * * ?")
	public void insertBTCtoDBfromWex() throws Exception {
		logger.info("---------------------------WEX-----------------------------------");
		wex.insertBTCtoDB();
		logger.info("------------------------------------------------------------------");
	}
	
	@Scheduled(cron = "0 1/3 * * * ?")
	public void insertLTCtoDBfromWex() throws Exception {
		logger.info("-----------------------------WEX--------------------------------");
		wex.insertLTCtoDB();
		logger.info("------------------------------------------------------------------");
	}

	@Scheduled(cron = "0 2/3 * * * ?")
	public void insertETHtoDBfromWex() throws Exception {
		logger.info("-----------------------------WEX--------------------------------");
		wex.insertETHtoDB();
		logger.info("------------------------------------------------------------------");
	}
}
