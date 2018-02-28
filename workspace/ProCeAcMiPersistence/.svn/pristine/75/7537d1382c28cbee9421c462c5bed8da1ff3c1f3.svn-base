/**
 * 
 */
package org.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.entities.User;
//import org.bean.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 * @author maurizio
 *
 */
public class UserDBManager extends DBManager {

	final static Logger logger = Logger.getLogger(UserDBManager.class);	

    
    public static List<User>  getAllUsers() {
		List <User>users=null;
		 
		 try {
			 
			 Session session = getSessionFactory().openSession();
			    CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			    CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
			    Root<User> root = criteriaQuery.from(User.class);
			    criteriaQuery.select(root);
			    Query<User> query = session.createQuery(criteriaQuery);
			    users = query.getResultList();
		
		    }catch (Exception e) {
			    logger.error(e.getStackTrace());
		}
		return users;
	}
	
    public static User getUserByEmail(String email) {
		System.out.println("email: " + email);
		User user = null;
		try {
			 
			 Session session = getSessionFactory().openSession();
			 CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			 CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
			 Root<User> root = criteriaQuery.from(User.class);
			 criteriaQuery.select(root);			 
			 criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("email"), email));
			 Query<User> query = session.createQuery(criteriaQuery);
			 user = query.getSingleResult();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	logger.error(e.getStackTrace());
	    }

		return user;
	}
	
	
	public static User getUserById(int id) {
		User user = null;
		Session session = getSessionFactory().openSession();
		try {
//			session.beginTransaction();
			user = session.get(User.class, id);
//			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		session.close();
		return user;

	}
	
	
	
	public static void updateUserById(int id, String email, String password, String firstName, String lastName,
			Date dateOfBirth) {

		Session session = getSessionFactory().openSession();
	    session.beginTransaction();	    
	
	    User user = session.get(User.class, id);
	    user.setEmail(email);
	    user.setPassword(password);
	    user.setFirstname(firstName);
	    user.setLastname(lastName);
	    user.setDateOfBirth(dateOfBirth);	    
	    session.update(user);
	    session.getTransaction().commit();
	    session.disconnect();
	    session.close();		

	}
	
	public static void updateImgPath(String email, String path) {
    	Session session = getSessionFactory().openSession();
	    session.beginTransaction();	    
	
	    org.entities.User user = UserDBManager.getByStringField("email", email);
	    user.setImgpath(path);
	    session.update(user);
	    session.getTransaction().commit();
	    session.disconnect();
	    session.close();
    }	

	public static void deleteUserById(int id) {
		Session session = getSessionFactory().openSession();
	    session.beginTransaction();	    
	
	    User user = session.get(User.class, id);
	    	    
	    session.delete(user);
	    session.getTransaction().commit();
	    session.disconnect();
	    session.close();
	}
	
	
	
	public static void insertUser(User user) throws Exception {
		Session session = getSessionFactory().openSession();
	    session.beginTransaction();	    
	    session.save(user);
	    session.getTransaction().commit();
	    session.close();
	}
	

	
	/**
	 * Metodo per aggiornare la password data un'email e la nuova password
	 * 
	 * @throws Exception
	 */
	public static void updatePasswordByEmail(String email, String newPassword) {
		Session session = getSessionFactory().openSession();
	    session.beginTransaction();	    
	
	    User user = UserDBManager.getByStringField("email", email);
	    user.setPassword(newPassword);
	    session.update(user);
	    session.getTransaction().commit();
	    session.disconnect();
	    session.close();
	}

	/**
	 *  METODO GENERICO PER AVERE UN RECORD DELLA TABELLA PASSANDOGLI IL NOME DEL CAMPO E IL 
	 *  VALORE DEL CAMPO.
	 *  ESEMPIO DI CHIAMATA è getByStringField("email", "emailchece@gmail.com");
	 *  ESTRAE L'OGGETTO USER DA DB CHE HA L'EMAIL "emailchece@gmail.com" NELLA COLONNA email.
	 */
	public static User getByStringField(String field, String value) {
		Session session = getSessionFactory().openSession();
	    CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<User> query = builder.createQuery(User.class);
	    Root<User> root = query.from(User.class);
	    query.select(root).where(builder.equal(root.get(field), value));
	    Query<User> q = session.createQuery(query);
	    User user = q.getSingleResult();
	    session.disconnect();
	    session.close();
	    return user;
	}
	
	
	
    public static int deleteAll() {
		
		
		int rows = 0;
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		rows = session.createQuery("delete from org.entities.User").executeUpdate();
		session.getTransaction().commit();
		
		session.close();
		return rows;

	}
	

		

}
