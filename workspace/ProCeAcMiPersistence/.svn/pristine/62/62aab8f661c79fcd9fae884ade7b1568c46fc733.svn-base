package org.db;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.bean.User;
import org.db.UserDBManager;
import org.db.UserLoginTokenDBManager;
import org.entities.UserLoginToken;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserLoginTokenDBManagerTest {
	
	
	
	@Test
	public void test1() throws Exception {
		boolean insertedSuccess = false;
		try {
			System.out.println("#########");
			System.out.println("AAA TEST CREAZIONE TOKEN CON SCADENZA");
			System.out.println("#########");
			UserLoginTokenDBManager.setTokenDataUser("provatest1@prova.com");
	//		UserLoginToken
			insertedSuccess = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(insertedSuccess);
	}
	
	@Test
	public void test2() throws Exception {
		System.out.println("#########");
		System.out.println("PROVA TOKEN ATTIVO");
		System.out.println("#########");
		UserLoginTokenDBManager.setTokenDataUser("provatest1@prova.com");
		UserLoginToken u = UserLoginTokenDBManager.getUserLoginTokenByEmail("provatest1@prova.com");
		System.out.println("TEST 2 " + u);
		String s = u.getExpirationDate();
		System.out.println("TEST 3 " + s);
	
		assertTrue(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(s).before(new Date()));
	}
	
	@Test
	public void test3() throws Exception {
		System.out.println("#########");
		System.out.println("PROVA TOKEN SCADUTO");
		System.out.println("#########");
		UserLoginTokenDBManager.setTokenDataUser("provatest1@prova.com");
		UserLoginToken u = UserLoginTokenDBManager.getUserLoginTokenByEmail("provatest1@prova.com");
		
		String s = u.getExpirationDate();
		System.out.println("String s = u.isTokenExpired(): " + s);
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		
		Date myDate = format.parse(s);
		System.out.println("String s = u.isTokenExpired(): 2 - " + s);
		Calendar cal = Calendar.getInstance();
        cal.setTime(myDate);
        cal.add(Calendar.MINUTE, 5);
        myDate = cal.getTime();
		
		assertTrue(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(s).before(myDate));
	}

	@After
	public void cleanUsersDB() {
		int rows = UserLoginTokenDBManager.deleteAll();
		System.out.println("Database cleaned.... righe cancellate: " + rows);
	}

}
