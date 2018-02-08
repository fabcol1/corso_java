package org.db;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DBManagerTest {
	@Test
	public void test1() {
		System.out.println("#########");
		System.out.println("TEST INSTANCE");
		System.out.println("#########");
		DBManager manager = null;
		boolean val = false;
		try {
			manager = new DBManager();
			val = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("@Manager -> " + manager);
		assertTrue(val);
	}
}
