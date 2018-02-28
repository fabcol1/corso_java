package org.proxima.spendtime.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.db.DBManager;
import org.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.proxima.spendtime.entities.SpendTime;
import org.proxima.spendtime.entities.SpendTimeTip;
import org.proxima.spendtime.spendtime.utils.CurrentDate;

public class HibernateDBManager extends DBManager {
	
	public static boolean check = false;
	final static Logger logger = Logger.getLogger(HibernateDBManager.class);
	
	//*********************** INSERT ********************
	public static void insertSt(int userID, String data, int ora) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		SpendTime spend = new SpendTime();
		spend.setUserID(userID);
		spend.setData(data);
		spend.setOra(ora);
		session.save(spend);
		session.getTransaction().commit();
		 //Se l'inserimento va a buon fine CHECK diventa true
		check = true;
		session.close();
		System.out.println("sessione chiusa");
	}
	
	
	//************** Insert in SPENDTIMETIPS **********
	public static void insertStt(String label, String descrizione) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		SpendTimeTip spt = new SpendTimeTip();
		spt.setLabel(label);
		spt.setDescrizione(descrizione);
		session.save(spt);
		session.getTransaction().commit();
		 //Se l'inserimento va a buon fine CHECK diventa true
		check = true;
		session.close();
		System.out.println("sessione chiusa");
	}
	
	
	//******************SELECT * FROM Spendtime;******************
//	public static List<SpendTime> selectSp() {
//		Session session = getSessionFactory().openSession();
//		Transaction transaction  = session.beginTransaction();
//		List<SpendTime> sp = null;
//		try {
//			sp = session.createQuery("FROM Spendtime").list();
//			transaction.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//		return sp;		
//	}
//	
	public static List<SpendTime>  getAllSpendTimes() {
		List<SpendTime> items=null;
		 
		 try {
			 
			 Session session = getSessionFactory().openSession();
			    CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			    CriteriaQuery<SpendTime> criteriaQuery = criteriaBuilder.createQuery(SpendTime.class);
			    Root<SpendTime> root = criteriaQuery.from(SpendTime.class);
			    criteriaQuery.select(root);
			    Query<SpendTime> query = session.createQuery(criteriaQuery);
			    items = query.getResultList();
		
		    }catch (Exception e) {
			    logger.error(e.getStackTrace());
		}
		return items;
	}
	
//********************** SELECT from SpendTimeTip ******************	
	public static List<SpendTimeTip> selectStt() {
		Session session = getSessionFactory().openSession();
		Transaction transaction  = session.beginTransaction();
		List<SpendTimeTip> sp = null;
		try {
			sp = session.createQuery("FROM SpendTimeTip").list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return sp;		
	}
	
	
	//********************** SELECT from SpendTimeTip ******************	
//		public static List<Spendtime> selectJOIN() {
//			Session session = getSessionFactory().openSession();
//			Transaction transaction  = session.beginTransaction();
//			String select = "FROM Spendtimetip INNER JOIN Spendtime ON Spendtimetip = Spendtime";
//			List<Spendtime> spj = null;
//			try {
//				spj = session.createQuery(select).list();
//				transaction.commit();
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				session.close();
//			}
//			return spj;		
//		}
		
		
//****************** SELECT id FROM Spendtime; ******************
	public static SpendTime selectById(int id) {
		Session session = getSessionFactory().openSession();
//	    transaction = session.beginTransaction();
	    
		SpendTime spend = null;
	    
//	    try {
//	         CriteriaBuilder builder = session.getCriteriaBuilder();
//	         CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
//	         Root<Spendtime> root = query.from(Spendtime.class);
//	         //query.select(SpendTime.class, root.get("id"));
//	         query.select(SpendTime.class, id);
//	         Query<Integer> q=session.createQuery(query);
//	         spend = q.getResultList();
	         
	         spend = session.get(SpendTime.class, id);
	         
//	         for (Integer i : spend) {
//	            System.out.println(i);
//	         }
//	         transaction.commit();
//	      } catch (Exception e) {
//	         e.printStackTrace();
//	         if (transaction != null) {
//	            transaction.rollback();
//	         }
//	      }
		return spend;
	}
	
	public static SpendTime selectByUserIdAndDate(int userId, String date) {
		SpendTime stToReturn = null ;
		try {			 
			 Session session = getSessionFactory().openSession();
			 CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			 CriteriaQuery<SpendTime> criteriaQuery = criteriaBuilder.createQuery(SpendTime.class);
			 Root<SpendTime> root = criteriaQuery.from(SpendTime.class);
//			 criteriaQuery.select(root);			 
			 List criteriaList = new ArrayList();

//			 Predicate userIdEqualPredicate = criteriaBuilder.equal(root.get("userID"), userId) ;
//			 criteriaList.add(userIdEqualPredicate);
//			 Predicate dateEqualPredicate = criteriaBuilder.equal(root.get("data"), date) ;
//			 criteriaList.add(dateEqualPredicate);
			 //criteriaQuery.where(criteriaBuilder.and((Predicate[])criteriaList.toArray()));
//			 criteriaQuery.where(criteriaBuilder.and(userIdEqualPredicate));
//			 criteriaQuery.where(criteriaBuilder.and(criteriaList.toArray(new Predicate[0])));
			 
			 Predicate userIdAndDateFilter = criteriaBuilder.and(
					 criteriaBuilder.equal( root.get("userID"), userId ),
					 criteriaBuilder.equal( root.get("data"), date )
					);
			 
			 criteriaQuery.where( criteriaBuilder.and( userIdAndDateFilter) );
			 
			 Query<SpendTime> query = session.createQuery(criteriaQuery);
			 stToReturn = query.getSingleResult();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	//logger.error(e.getStackTrace());
	    }
		return stToReturn;
	}
	
	
	//****************** SELECT * FROM Spendtime WHERE ID = 1; ******************
	public static List<SpendTime> selectByUserID(int userID) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
	    
	    List<SpendTime> byId = null;
	    
	    try {
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<SpendTime> query = builder.createQuery(SpendTime.class);
	         Root<SpendTime> root = query.from(SpendTime.class);
	         query.select(root).where(builder.equal(root.get("userID"), userID));
	         Query<SpendTime> q=session.createQuery(query);
	         byId = q.getResultList();
	         System.out.println("**** SIZE:   " + byId.size());
	         transaction.commit();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
		return byId;
	}
	
	
	//******************* SELECT ORA WHERE UserId = .. , data = .... ********************
	public static int selectOra(int userID, String data) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
	    
	    List<SpendTime> all = null;
	    int ora = 0;
	    try {
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<SpendTime> query = builder.createQuery(SpendTime.class);
	         Root<SpendTime> root = query.from(SpendTime.class);
	         query.select(root).where(builder.equal(root.get("userID"), userID)); //, builder.equal(root.get("data"), data));	         
	         Query<SpendTime> q=session.createQuery(query);	         
	         all = q.getResultList();
	         System.out.println("**** SIZE:   " + all.size());
	         transaction.commit();
	         for (SpendTime sp : all) {
				ora = sp.getOra();
			}
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
		return ora;
	}
	
	
	//****************** UpdateOra ***********************
	public static void updateOra(int userID, String data, int ora) {
			Session session = getSessionFactory().openSession();
			session.beginTransaction();

			SpendTime sp = new SpendTime();
			List<SpendTime> spend = getAllSpendTimes();
			for (SpendTime s : spend) {
				logger.debug("DATA "+s.getData().equals(data));
				logger.debug(s.getUserID() == userID);
				logger.debug(s.getUserID() == userID && s.getData().equals(data));
				if(s.getUserID() == userID && s.getData().equals(data)) {
					logger.debug("DENTRO IF");
					sp = s;
				}
			}
			logger.debug("FUORI FOR");

			sp.setOra(ora);
			session.update(sp);
			session.getTransaction().commit();
			session.close();
			System.out.println("sessione chiusa");
	}
	
	
	public static HashMap<String, Integer> getPrepopolatedValue () throws Exception {
		List<SpendTime> dip = getAllSpendTimes();
		HashMap<String, Integer> valori = new HashMap<String, Integer>();

		int sizeDip = dip.size();
		int giorno = Integer.parseInt(CurrentDate.giornoCorrente());
		if( sizeDip < giorno ) {
			for(int i=sizeDip; i< giorno; i++ ) {
				if(!dip.isEmpty())
					insertSt(dip.get(0).getUserID(), (i+1)+"-"+CurrentDate.dataCorrente(), 0);
			}
		}
		dip = getAllSpendTimes();
		sizeDip = dip.size();
		
		for(int i=0; i<sizeDip; i++) {
			valori.put(dip.get(i).getId()+"_"+dip.get(i).getData(), dip.get(i).getOra());
			logger.debug("chiave: " + dip.get(i).getId()+"_"+dip.get(i).getData() + " valore: " + valori.get(dip.get(i).getId()+dip.get(i).getData()));
		}
		logger.debug("Questa è la size dell'ArrayList: " + sizeDip);
		logger.debug("Size dell'HashMap: " + valori.size());
		return valori;
	} 
	
	
	public static int deletAll() {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		
		int rows = 0;
//		System.out.println(		select().get(0));
//		session.delete(select().get(0));
		
		Query q1 = session.createQuery ("DELETE FROM Spendtime");
        rows = q1.executeUpdate();
		session.getTransaction().commit();
		session.disconnect();
		session.close();
		System.out.println("TABELLA ELIMINATA");
		return rows;
	}
	
	 public static int deleteAllSpendTime() {
			
			
			int rows = 0;
			Session session = getSessionFactory().openSession();
			session.beginTransaction();
			rows = session.createQuery("delete from org.proxima.spendtime.entities.SpendTime").executeUpdate();
			session.getTransaction().commit();
			
			session.close();
			return rows;

		}
	
	
	public static void main(String[] args) throws Exception {
		SpendTime test = selectByUserIdAndDate(0, "20-02-2018");
		//System.out.println("test: " + test);
		logger.debug("test: " + test);
//		insertSt(1, "01-02-2018", 6);
//		insertSt(1, "02-02-2018", 4);
//		insertSt(1, "03-02-2018", 8);
//		
//		insertSt(2, "01-02-2018", 3);
//		insertSt(2, "02-02-2018", 2);
//		insertSt(2, "03-02-2018", 4);
//		
//		insertSt(3, "01-02-2018", 3);
//		insertSt(3, "02-02-2018", 2);
//		insertSt(3, "03-02-2018", 4);
//		
		List <SpendTime> a = getAllSpendTimes();
		System.out.println("************** SELECT");
		for (SpendTime o : a) {
			System.out.println("ID: "+ o.getId() + " DATA: "+ o.getData()+ " ORA: " + o.getOra());
		}
		
		List<SpendTimeTip> lista = selectStt();
		logger.debug("************************SELECT STT *********");
		for (SpendTimeTip spt : lista) {
			logger.debug("ID: " + spt.getId()+ " " + "LABEL: " + spt.getLabel() + " " + "DESCRIZIONE: " + spt.getDescrizione());
		}
		
//		List<Spendtime> join = selectJOIN();
//		logger.debug("******** JOIN **********");
//		for (Spendtime spj : join) {
//			logger.debug(spj.getSpendtimetip().toString());
//		}
//		
////		List<Integer> id = selectId();
////		System.out.println("***************** SELECT ID");
////		for (Integer sp : id) {
////			System.out.println(sp.toString());
////		}
//		
//		List<Spendtime>id2 = selectByUserID(1);
//		System.out.println("******************* selectByUserID");
//		for (Spendtime sp : id2) {
//			System.out.println(sp.getData() + " " + sp.getOra());
//		}
//		
//		
//		//List<Spendtime>id3 = selectOra(1, "1-02-2018");
//		int b = selectOra(1, "1-02-2018");
//		System.out.println("**********************selectByUserIDbyData");
//		System.out.println(b);
		
		//updateOra(1,"01-02-2018", 10);
		
//		deletAll();
	}
	
	
}
