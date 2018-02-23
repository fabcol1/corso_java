package org.db;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.bean.User;

import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;






public class UserDBManagerBOUpdateTest {

	@Before
	public void executeCleanAllAndInsertStments() {
        System.out.println("Executing executeCleanAllAndInsertStments.... ");
        int rows = UserDBManagerBO.deleteAll();
		System.out.println("Database cleaned.... deleted rows number: " + rows);
		int insertedNumber = 0;
		try {
			insertedNumber = UserDBManagerBO.executeInsertStment("tina@prox.com","pass123","Ernesty","Tinny","1987-12-08", "2018-02-08",10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("@Before --> inserted rows number: " + insertedNumber);
	}
//	
//	@After
//	public void cleanUsersDB() {
//		int rows = UserDBManagerBO.deleteAll();
//		System.out.println("Database cleaned.... deleted rows number: " + rows);
//	}
	
	
	
	@Test
	public void executeUpdateStmt() throws Exception {
		System.out.println("am excuting the update System");
		int insertedNumber = 0;
		 List<User> users= UserDBManagerBO.getAllUsers() ;
		  User curr = users.get(0);
		 String oldpass = curr.getPassword();
		  System.out.println( "old password "+curr.getPassword());
		  int u = UserDBManagerBO.executeUpdateStmt(curr.getId(),"Tinella", "kokosi", "pspor2", "skygilr@pcom", "1992-03-13","2018-02-09",12);
		  System.out.println(" --> show me updated row: " + u);
		 User curr2 = UserDBManagerBO.selectById((long)curr.getId());
		  System.out.println(curr2.getPassword());
		  System.out.println("@Test --> password after: " + curr2.getPassword());
		  assertTrue(u== 1);
	}
	@After
	public void cleanUsersDB1() {		int rows = UserDBManagerBO.deleteAll();
		System.out.println("Database cleaned.... deleted rows number: " + rows);
	}
	
		
	
	
	

}
