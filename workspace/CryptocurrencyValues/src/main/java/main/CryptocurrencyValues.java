package main;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import okex.Okex;

public class CryptocurrencyValues {

	public static void main(String[] args) {
		scheduledDBinsert();
	}

	private static void scheduledDBinsert() {
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleAtFixedRate(() -> {
			try {
				Okex.insertToDBfromOKEX();;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}, 2, 30, TimeUnit.SECONDS);
	}
	
	private static void scheduledDBinsertBTC() {
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleAtFixedRate(() -> {
			try {
				Okex.insertBTCtoDB();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}, 2, 30, TimeUnit.SECONDS);
	}
}
