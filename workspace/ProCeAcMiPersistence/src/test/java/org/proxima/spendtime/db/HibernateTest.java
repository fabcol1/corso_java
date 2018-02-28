package org.proxima.spendtime.db;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.proxima.spendtime.db.HibernateDBManager;

public class HibernateTest {
	
	final static Logger logger = Logger.getLogger(HibernateDBManager.class);
	
	@Test
	public void testSelect() {
		logger.debug("#########");
		logger.debug("TEST SELECT");
		logger.debug("#########");
		int size = 0;
		try {
			size = HibernateDBManager.getAllSpendTimes().size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("@Test --> size: " + size);
		assertTrue(size > 0);
	}
	
	
	@Test
	public void test3() throws Exception {
		logger.debug("#########");
		logger.debug("TEST UpdateOra");
		logger.debug("#########");
		boolean prova = false;
		int prima = HibernateDBManager.selectOra(1,"14-02-2018");
		logger.debug("Ora precedente " + prima);
		
		HibernateDBManager.updateOra(1,"14-02-2018", 10);
		logger.debug("Update andato");
		
		int dopo = HibernateDBManager.selectOra(1,"14-02-2018");
		logger.debug("Ora successiva all'update "+ dopo);
		
		if (dopo == 10) {
			prova = true;
		}
		
		logger.debug("Update ORA andato a buon fine");
		assertTrue(prova);
	}
	
	
	@Test
	public void test4() {
		logger.debug("#########");
		logger.debug("TEST prepopulatedDB");
		logger.debug("#########");
		int size = 0;
		try {
			size = HibernateDBManager.getPrepopolatedValue().size();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		logger.debug("@Test --> size: " + size);
		assertTrue(size > 0);
	}

	
	private static int insertedNumber = 0;
	
	@Before
	public void insert() throws Exception {
		int rows = 0;
		HibernateDBManager.insertSt(1, "14-02-2018", 7);
			if(HibernateDBManager.check == true) {
				rows = 1;
			}
			logger.debug("@Before --> inserted rows number: " + rows);
			logger.debug("#########");
			logger.debug("TEST INSERT DIP");
			logger.debug("#########");
		assertTrue(rows == 1);
		logger.debug("@Before --> inserted rows number: " + insertedNumber);
	}
	
	
	@After
	public void cleanDB() {
		int rows = HibernateDBManager.deleteAllSpendTime();
		logger.debug("Database cleaned.... deleted rows number: " + rows);
	}
}
