package org.proxima.cryptocurrency;

import static org.junit.Assert.assertEquals;

import org.db.CryptoDBManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.CryptoFrom;

public class CryptoDBManagerTest {

	@Test
	public void getCryptoFromID() {
//		https://www.okex.com
		System.out.println("###################################################################");
		System.out.println("#################		TEST getCryptoFromID       ################");
		System.out.println("###################################################################");
	
		CryptoFrom cryptoFrom = CryptoDBManager.getCryptoFromById(1);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@ CRYPTOFROM: " + cryptoFrom);
		assertEquals("https://www.okex.com", cryptoFrom.getFromWhere());
	}
	
	@Before
	public void insert() {
	}
	@After
	public void deleteAll() {
	}
}
