/**
 * 
 */
package org.db;

import java.util.HashMap;
import java.util.Map;

import org.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;



/**
 * @author maurizio
 *
 */
public class HibernateUtil {
//	private static StandardServiceRegistry registry;
//	private static SessionFactory sessionFactory;
//
//	public static SessionFactory getSessionFactory() {
//		if (sessionFactory == null) {
//			try {
//				// Create registry
//				registry = new StandardServiceRegistryBuilder().configure().build();
//				// Create registry builder
////	            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
////
////	            // Hibernate settings equivalent to hibernate.cfg.xml's properties
////	            Map<String, String> settings = new HashMap<>();
////	            settings.put(Environment.DRIVER, "org.postgresql.Driver");
////	            settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/BORAJI");
////	            settings.put(Environment.USER, "postgres");
////	            settings.put(Environment.PASS, "admin");
////	            settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
////
////	            // Apply settings
////	            registryBuilder.applySettings(settings);
////
////	            // Create registry
////	            registry = registryBuilder.build();	            
//	            
//				// Create MetadataSources
//				MetadataSources sources = new MetadataSources(registry);
//
//				// Create Metadata
//				Metadata metadata = sources.getMetadataBuilder().build();
//
//				// Create SessionFactory
//				sessionFactory = metadata.getSessionFactoryBuilder().build();
//
//			} catch (Exception e) {
//				e.printStackTrace();
//				if (registry != null) {
//					StandardServiceRegistryBuilder.destroy(registry);
//				}
//			}
//		}
//		return sessionFactory;
//	}
//
//	public static void shutdown() {
//		if (registry != null) {
//			StandardServiceRegistryBuilder.destroy(registry);
//		}
//	}

	public static void main(String[] args) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		session.beginTransaction();
//
//		// Check database version
//		String sql = "select version()";
//
//		String result = (String) session.createNativeQuery(sql).getSingleResult();
//		System.out.println("######" + result);
//
//		session.getTransaction().commit();
//		session.close();
//		testIns2 ();
//		testIns3();
		testIns();
//		HibernateUtil.shutdown();
		 
	}
	
	
	
	
	
	
	public static void testIns () {
//        Session session = getSessionFactory().openSession();
//        session.beginTransaction();
//        User department = new User();
//        department.setEmail("12345678");
//        department.setPassword("12345678");
//        session.save(department);
//        session.getTransaction().commit();
//        session.close();
 
    }
	
	
	
	
	
	
	
	
//	public static void testIns2() {  
//		System.out.println("StoreData start...");
//	    //creating configuration object  
//	    Configuration cfg=new Configuration();  
//	    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
//	      
//	    //creating seession factory object  
//	    SessionFactory factory=cfg.buildSessionFactory();  
//	      
//	    //creating session object  
//	    Session session=factory.openSession();  
//	      
//	    //creating transaction object  
//	    Transaction t=session.beginTransaction();  
//	          
//	    User e1=new User();  
//	    e1.setEmail("TESTHIBERNATE");  
//	    e1.setPassword("efhwjwsfef");
////	    e1.setEmail("mmdd@dsjdj");
//	      
//	    session.persist(e1);//persisting the object  
//	      
//	    t.commit();//transaction is committed  
//	    session.close();  
//	      
//	    System.out.println("successfully saved");  
//	      
//	}  
	
//	public static void testIns3() {  
//		System.out.println("StoreData start...");
//	    //creating configuration object  
//	    Configuration cfg=new Configuration();  
//	    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
//	      
//	    //creating seession factory object  
//	    SessionFactory factory=cfg.buildSessionFactory();  
//	      
//	    //creating session object  
//	    Session session=factory.openSession();  
//	      
//	    //creating transaction object  
//	    Transaction t=session.beginTransaction();  
//	          
//	    User e1=new User();  
//	    e1.setEmail("TESTHIBERNATE");  
//	    e1.setPassword("efhwjwsfef");
////	    e1.setEmail("mmdd@dsjdj");
//	      
//	    session.persist(e1);//persisting the object  
//	      
//	    t.commit();//transaction is committed  
//	    session.close();  
//	      
//	    System.out.println("successfully saved");  
//	      
//	}  
}
