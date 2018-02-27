/**
 * 
 */
package org.db;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.db.UserDBManager;
import org.entities.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author maurizio
 *
 */
public class UserDBManagerSelectByEmailTest {
	
	@Test
	public void test() {
		System.out.println("#########");
		System.out.println("TEST SELECT BY EMAIL");
		System.out.println("#########");
		User currentUser = UserDBManager.getUserByEmail("test@test.test");
		System.out.println("@Test SELECT BY EMAIL --> currentUser: " + currentUser);
		assertTrue(currentUser!= null);
	}

	@Before
	public void insert() {
		try {
			org.entities.User user = new org.entities.User();
			user.setEmail("test@test.test");
			user.setPassword("password1234");
			user.setFirstname("daniele");
			user.setLastname("sprizzi");
			user.setDateOfBirth(new Date());
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
