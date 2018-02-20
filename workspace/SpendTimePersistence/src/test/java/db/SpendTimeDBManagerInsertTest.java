package db;

import static org.junit.Assert.assertTrue;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SpendTimeDBManagerInsertTest {
	
	@Test
	public void test1_insertDip() throws ClassNotFoundException, SQLException {
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
		System.out.println(sp.getPrepopolatedValue());
		assertTrue(rows == 1);
	}
	
	@Before
	public void cleanDBPrevious() {
		int rows = SpendTimeDBManager.deleteAll();
		System.out.println("Database cleaned.... deleted rows number: " + rows);
	}
	
	@After
	public void cleanDBNext() {
		int rows = SpendTimeDBManager.deleteAll();
		System.out.println("Database cleaned.... deleted rows number: " + rows);
	}
}
