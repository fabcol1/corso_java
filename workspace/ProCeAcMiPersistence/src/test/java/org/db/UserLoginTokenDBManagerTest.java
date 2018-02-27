package org.db;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.bean.User;
import org.db.UserDBManager;
import org.entities.UserLoginToken;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserLoginTokenDBManagerTest {
	
	
	
//	@Test
//	public void test1() throws Exception {
//		System.out.println("#########");
//		System.out.println("TEST CREAZIONE TOKEN CON SCADENZA");
//		System.out.println("#########");
//		int x = UserLoginTokenDBManager.setTokenDataUser("provatest1@prova.com");
//		assertTrue( x == 1);
//	}
	
//	@Test
//	public void test2() throws Exception {
//		System.out.println("#########");
//		System.out.println("PROVA TOKEN ATTIVO");
//		System.out.println("#########");
//		System.out.println("TEST 1 " + UserLoginTokenDBManager.setTokenDataUser("provatest1@prova.com"));
//		UserLoginToken u = UserLoginTokenDBManager.getUserByEmailToken("provatest1@prova.com");
//		System.out.println("TEST 2 " + u);
//		String s = u.isTokenExpired();
//		System.out.println("TEST 3 " + s);
//	
//		assertTrue(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(s).before(new Date()));
//	}
	
//	@Test
//	public void test3() throws Exception {
//		System.out.println("#########");
//		System.out.println("PROVA TOKEN SCADUTO");
//		System.out.println("#########");
//		UserLoginTokenDBManager.setTokenDataUser("provatest1@prova.com");
//		UserLoginToken u = UserLoginTokenDBManager.getUserByEmailToken("provatest1@prova.com");
//		
//		String s = u.isTokenExpired();
//		System.out.println("String s = u.isTokenExpired(): " + s);
//		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
//		
//		Date myDate = format.parse(s);
//		System.out.println("String s = u.isTokenExpired(): 2 - " + s);
//		Calendar cal = Calendar.getInstance();
//        cal.setTime(myDate);
//        cal.add(Calendar.MINUTE, 5);
//        myDate = cal.getTime();
//		
//		assertTrue(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(s).before(myDate));
//	}

	@After
	public void cleanUsersDB() {
		int rows = UserLoginTokenDBManager.deleteAll();
		System.out.println("Database cleaned.... righe cancellate: " + rows);
	}

}
