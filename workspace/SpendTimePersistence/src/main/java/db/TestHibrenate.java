package db;

import org.hibernate.SessionFactory;

public class TestHibrenate {
	
	private static SessionFactory sessionFactory;
	
	
//	public void insert() {
//		Session session = 
	
	
	
	
	
	
	
	
//*************************************  METODO VECCHIO *****************************************************
//	private EntityManagerFactory emf;
//	private EntityManager em;
//	
//	public TestHibrenate(String persistenceUnitName) {
//		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
//		em = emf.createEntityManager();
//	}
//	
//	public void insert(Object o) {
//		em.getTransaction().begin();;
//		em.persist(o);
//		em.getTransaction().commit();
//		em.close();
//	}
//	
//	public static void main(String[] args) throws Exception {
//	Spendtime sp = new Spendtime();
//	sp.setId(1);
//	sp.setData("20-02-2018");
//	sp.setOra(8);
//	TestHibrenate th = new TestHibrenate("SpendTimePersistence");
//	th.insert(sp);
//}
	
	
	
//	************************ METODO CHE UTILIZZA IL FILE XML *********************************
//	private SessionFactory sessionFactory;
//	
//	protected void setUp() throws Exception {
//		//Otteniamo una session Factory configurata tramite l'xml
//		sessionFactory = new Configuration().configure().buildSessionFactory();
//	}
//	
//	protected void shutDown() throws Exception {
//		if(sessionFactory != null) {
//			sessionFactory.close();
//		}
//	}
//	
//	public void test() {
//		Spendtime sp = new Spendtime();
//		sp.setId(1);
//		sp.setData("20-02-2018");
//		sp.setOra(8);
//		//Inserisco gli elementi di spendTime nel db
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		session.save(sp);
//		session.getTransaction().commit();
//		session.close();
//	}
//	

	
}
