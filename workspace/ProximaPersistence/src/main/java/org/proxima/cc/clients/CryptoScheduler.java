package org.proxima.cc.clients;

import org.proxima.cc.clients.okex.Okex;
import org.proxima.cc.clients.yobit.Yobit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CryptoScheduler {

	@Autowired
	private Okex okex;
	@Autowired
	private Yobit yobit;
	
	///////////////////////////////////////////
	// OKEX				///////////////////////
	///////////////////////////////////////////
//	@Scheduled(cron = "0 0/3 * * * ?")
	public void insertBTCtoDBfromOKEX() throws Exception {
		okex.insertBTCtoDB();
	}
//	@Scheduled(cron = "0 1/3 * * * ?")
	public void insertLTCtoDBfromOKEX() throws Exception {
		okex.insertLTCtoDB();
	}
//	@Scheduled(cron = "0 2/3 * * * ?")
	public void insertETHtoDBfromOKEX() throws Exception {
		okex.insertETHtoDB();
	}
	
	///////////////////////////////////////////
	// YOBIT			///////////////////////
	///////////////////////////////////////////
//	@Scheduled(cron = "0 0/3 * * * ?")
	public void insertBTCtoDBfromYOBIT() throws Exception {
		yobit.insertBTCtoDB();
	}
//	@Scheduled(cron = "0 1/3 * * * ?")
	public void insertLTCtoDBfromYOBIT() throws Exception {
		yobit.insertLTCtoDB();
	}
//	@Scheduled(cron = "0 2/3 * * * ?")
	public void insertETHtoDBfromYOBIT() throws Exception {
		yobit.insertETHtoDB();
	}
}
