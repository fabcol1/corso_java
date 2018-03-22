package org.proxima.cc.clients;

import org.apache.log4j.Logger;
import org.proxima.cc.services.BitcoinHistoricalAverageService;
import org.proxima.cc.services.EthereumHistoricalAverageService;
import org.proxima.cc.services.LitecoinHistoricalAverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CryptoDBNormalizerScheduler {
	final static Logger logger = Logger.getLogger(CryptoDBNormalizerScheduler.class);

	@Autowired
	private BitcoinHistoricalAverageService bitcoinHistoricalAverageService;
	@Autowired
	private EthereumHistoricalAverageService ethereumHistoricalAverageService;
	@Autowired
	private LitecoinHistoricalAverageService litecoinHistoricalAverageService;
	
	@Scheduled(cron = "0 0 0 * * ?")
	public void lastDayBitcoinHistoricalsAverageScheduler() {
		logger.info("-----------------------------SCHEDULER LAST DAY VALUES BITCOIN--------------------------------");
		bitcoinHistoricalAverageService.lastDayBitcoinHistoricalsAverage();
		logger.info("------------------------------------------------------------------");
	}
	
	@Scheduled(cron = "0 0 0 * * ?")
	public void lastDayEthereumHistoricalsAverageScheduler() {
		logger.info("-----------------------------SCHEDULER LAST DAY VALUES ETHEREUM--------------------------------");
		ethereumHistoricalAverageService.lastDayEthereumHistoricalsAverage();
		logger.info("------------------------------------------------------------------");
	}
	
	@Scheduled(cron = "0 0 0 * * ?")
	public void lastDayLitecoinHistoricalsAverageScheduler() {
		logger.info("-----------------------------SCHEDULER LAST DAY VALUES LITECOIN--------------------------------");
		litecoinHistoricalAverageService.lastDayLitecoinHistoricalsAverage();
		logger.info("------------------------------------------------------------------");
	}
	
//	public static void main(String[] args)
//	 {
//	  CronSequenceGenerator cron1 = new CronSequenceGenerator("0 0 0 * * ?");
//	  Calendar cal = Calendar.getInstance();
//	  cal.add(Calendar.DATE, 2); // add two days to current date
//	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss"); 
//	  
//	  System.out.println("current date "+sdf.format(cal.getTime()));
//	  
//	  Date d = null;
//		for(int i = 0; i < 10000; i++) {
//			if(d==null) {
//				d =  cron1.next(cal.getTime()); 
//			} else {
//				d = cron1.next(d);
//			}
//			System.out.println("Next cron trigger date cron1 "+d);
//		}
//	 }
}
