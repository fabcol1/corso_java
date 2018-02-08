/**
 * 
 */
package org.proxima.com.usermanagment;

import static org.junit.Assert.assertTrue;

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
		System.out.println("#####  buybuub ubyuyub uyhyub ####");
		System.out.println("TEST SELECT");
		System.out.println("#########");
		int size = UserDBManager.getUsers().size() ;
		System.out.println("@Test --> size: " + size);
        assertTrue( size>0 );
	}
	
	@Test
	public void test2() {
		System.out.println("#########");
		System.out.println("TEST SELECT BY EMAIL");
		System.out.println("#########");
		User returnUser = UserDBManager.getUserByEmail ("prova1@prova.it"); 
		System.out.println("@Test --> user by email: " + returnUser);
        assertTrue( returnUser!=null );
	}

	private static int insertedNumber = 0;

	@Before
	public void insert() {
		insertedNumber = UserDBManager.insertNewUser("prova1@prova.it", "password1234", 10);
		System.out.println("@Before --> inserted rows number: " + insertedNumber);
	}
////
	@After
	public void cleanUsersDB () {
		int rows = new UserDBManager().deleteAll();
		System.out.println("Database cleaned.... deleted rows number: " + rows);
	}
}
