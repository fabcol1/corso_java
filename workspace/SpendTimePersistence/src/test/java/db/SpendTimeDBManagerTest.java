package db;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SpendTimeDBManagerTest {
	
	@Test
	public void test2() {
		System.out.println("#########");
		System.out.println("TEST SELECT");
		System.out.println("#########");
		SpendTimeDBManager spDB = new SpendTimeDBManager();
		int size = 0;
		try {
			size = spDB.selectDb().size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("@Test --> size: " + size);
		assertTrue(size > 0);
	}
	
	
	@Test
	public void test3() throws ClassNotFoundException, SQLException {
		System.out.println("#########");
		System.out.println("TEST UpdateTime");
		System.out.println("#########");
		SpendTimeDBManager spDB = new SpendTimeDBManager();
		boolean prova = false;
		int prima = SpendTimeDBManager.selectByOra("14-02-2018");
		System.out.println("Ora precedente " + prima);
		
		spDB.updateDb("14-02-2018", 10);
		System.out.println("Update andato");
		
		int dopo = SpendTimeDBManager.selectByOra("14-02-2018");
		System.out.println("Ora successiva all'update "+ dopo);
		
		if (dopo == 10) {
			prova = true;
		}
		
		System.out.println("Update ORA andato a buon fine");
		assertTrue(prova);
	}
	
	
	@Test
	public void test4() {
		System.out.println("#########");
		System.out.println("TEST PrePOPULATEDdb");
		System.out.println("#########");
		SpendTimeDBManager spDB = new SpendTimeDBManager();
		int size = 0;
		try {
			size = spDB.getPrepopolatedValue().size();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println("@Test --> size: " + size);
		assertTrue(size > 0);
	}
	
	
	
	
	
	private static int insertedNumber = 0;
	
	@Before
	public void insert() throws Exception {
		SpendTimeDBManager sp = new SpendTimeDBManager();
		int rows = 0;
			sp.insertDb(1, "14-02-2018", 7);
			if(sp.check == true) {
				rows = 1;
			}
		System.out.println("@Before --> inserted rows number: " + rows);
		System.out.println("#########");
		System.out.println("TEST INSERT DIP");
		System.out.println("#########");
		assertTrue(rows == 1);
		System.out.println("@Before --> inserted rows number: " + insertedNumber);
	}
	
	@After
	public void cleanDB() {
		int rows = SpendTimeDBManager.deleteAll();
		System.out.println("Database cleaned.... deleted rows number: " + rows);
	}
}
