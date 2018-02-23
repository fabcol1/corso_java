package org.db;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.bean.User;

import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;






public class UserDBManagerBOSelectAllTest {
	@Test
	public void test1()throws Exception {
		System.out.println("#########");
		System.out.println("TEST SELECT");
		System.out.println("#########");
		int size = UserDBManagerBO.getAllUsers().size();
		System.out.println("@Test --> size: " + size);
		assertTrue(size > 0);
	}
	@Before
	public void executeInsertStment() {

		int insertedNumber = 0;
		try {
			insertedNumber = UserDBManagerBO.executeInsertStment("tina@prox.com","pass123","Ernesty","Tinny","1987-12-08", "2018-02-08",10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("@Before --> inserted rows number: " + insertedNumber);
	}
	
	@After
	public void cleanUsersDB() {
		System.out.println("Executing cleanUsersDB...");
		int rows = UserDBManagerBO.deleteAll();
		System.out.println("Database cleaned.... deleted rows number: " + rows);
	}
	
	
}
