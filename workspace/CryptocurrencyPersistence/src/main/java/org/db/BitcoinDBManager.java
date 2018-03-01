package org.db;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import model.Bitcoin;

public class BitcoinDBManager extends DBManager {
	final static Logger logger = Logger.getLogger(BitcoinDBManager.class);	
	
	public static void insert(Bitcoin b) {
		logger.info("INSERT BITCOIN - Bitcoin parametro: " + b);
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();	    
	    session.save(b);
	    session.getTransaction().commit();
	    session.disconnect();
	    session.close();
	}
	
	public static List<Bitcoin> selectAll() {
		List<Bitcoin> bitcoinFutures = null;
		try {
			SessionFactory factory = getSessionFactory();
			Session session = factory.openSession();
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Bitcoin> criteriaQuery = criteriaBuilder.createQuery(Bitcoin.class);
			Root<Bitcoin> root = criteriaQuery.from(Bitcoin.class);
			criteriaQuery.select(root);
			Query<Bitcoin> query = session.createQuery(criteriaQuery);
			bitcoinFutures = query.getResultList();
			session.disconnect();
			session.close();
		} catch (Exception e) {
			logger.error(e.getStackTrace());
		}
		return bitcoinFutures;
	}
	
	public static int deleteAll() {
			int rows = 0;
			List<Bitcoin> bitcoinToDelete = selectAll();
			logger.debug("BIT COIN TO DELETE SIZE: " + bitcoinToDelete.size());
			SessionFactory factory = getSessionFactory();
			Session session = factory.openSession();
			session.beginTransaction();
			for(Bitcoin b : bitcoinToDelete) {
				session.delete(b);
				rows++;
			}
			session.getTransaction().commit();
			session.disconnect();
			session.close();
			logger.debug("RETURN ROWS OF BTC DELETED: " + rows);
			return rows;
	}
}
