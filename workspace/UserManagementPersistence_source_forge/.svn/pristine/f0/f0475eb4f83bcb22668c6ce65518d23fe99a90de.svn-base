/**
 * 
 */
package org.db;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.bean.User;
import org.db.UserDBManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author maurizio
 *
 */
public class UserDBManagerTest {
	@Test
	public void test1() {
		System.out.println("#########");
		System.out.println("TEST SELECT");
		System.out.println("#########");
		int size = UserDBManager.getUsers().size();
		System.out.println("@Test --> size: " + size);
		assertTrue(size > 0);
	}

	@Test
	public void test2() {
		System.out.println("#########");
		System.out.println("TEST SELECT BY EMAIL");
		System.out.println("#########");
		User returnUser = UserDBManager.getUserByEmail("prova1@prova.it");
		System.out.println("@Test --> user by email: " + returnUser);
		assertTrue(returnUser != null);
	}

	@Test
	public void test3_isEmailOnDB_true() {
		System.out.println("#########");
		System.out.println("TEST IS EMAIL ON DB");
		System.out.println("#########");
		User u = UserDBManager.getUserByEmail("prova1@prova.it");
		System.out.println("@Test --> is email on DB: " + u);
		assertTrue(u != null);
	}

	@Test
	public void test3_isEmailOnDB_false() {
		System.out.println("#########");
		System.out.println("TEST IS EMAIL ON DB");
		System.out.println("#########");
		User u = UserDBManager.getUserByEmail("email_Che_Non_Ce@prova.it");
		System.out.println("@Test --> is email on DB: " + u);
		assertFalse(u != null);
	}

	@Test
	public void test4_updatePasswordByEmail() {
		System.out.println("#########");
		System.out.println("TEST UPDATE EMAIL");
		System.out.println("#########");

		User u = UserDBManager.getUserByEmail("prova1@prova.it");
		System.out.println("@Test --> password before: " + u.getPassword());

		boolean val = false;
		try {
			val = UserDBManager.updatePasswordByEmail("prova1@prova.it", "ciaociaociao");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("@Test --> update email: " + val);

		u = UserDBManager.getUserByEmail("prova1@prova.it");
		System.out.println("@Test --> password after: " + u.getPassword());

		val &= u.getPassword().equals("ciaociaociao");
		assertTrue(val);
	}

//	@Test
//	public void test5_insertUser() {
//		try {
//			org.entities.User user = new org.entities.User();
//			user.setEmail("daniele@ciao.it");
//			user.setPassword("ciao");
//			user.setFirstname("daniele");
//			user.setLastname("sprizzi");
//			user.setBorndate(new Date());
//			user.setRegdate(new Date());
//			user.setRole(10);
////		int rows = 0;
//		
//			rows = UserDBManager.insertUser(user);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("@Before --> inserted rows number: " + rows);
//		System.out.println("#########");
//		System.out.println("TEST INSERT USER REGISRATION");
//		System.out.println("#########");
//		assertTrue(rows == 1);
//	}

	private static int insertedNumber = 0;

//	@Before
//	public void insert() {
//		org.entities.User user = new org.entities.User();
//		user.setEmail("prova1@prova.it");
//		user.setPassword("password1234");
//		user.setFirstname("daniele");
//		user.setLastname("sprizzi");
//		user.setBorndate(new Date());
//		user.setRegdate(new Date());
//		user.setRole(10);
//		try {
//			insertedNumber = UserDBManager.insertUser(user);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("@Before --> inserted rows number: " + insertedNumber);
//	}
	@Before
	public void insert() {
		try {
			org.entities.User user = new org.entities.User();
			user.setEmail("prova1@prova.it");
			user.setPassword("password1234");
			user.setFirstname("daniele");
			user.setLastname("sprizzi");
			user.setBorndate(new Date());
			user.setRegdate(new Date());
			user.setRole(10);
			UserDBManager.insertUser(user);
			System.out.println("@Before --> inserted user: " + user.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@After
	public void cleanUsersDB() {
		int rows = UserDBManager.deleteAll();
		System.out.println("Database cleaned.... deleted rows number: " + rows);
	}

}
