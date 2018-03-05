package org.db;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Bitcoin;
import model.Litecoin;

public class LitecoinDBManager extends DBManager {
	final static Logger logger = Logger.getLogger(LitecoinDBManager.class);	
	
	public static void insert(Litecoin l) {
		logger.info("INSERT LITECOIN - Litecoin parametro: " + l);
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();	    
	    session.save(l);
	    session.getTransaction().commit();
	    session.disconnect();
	    session.close();
	}
	
	public static List<Litecoin> selectAll() {
		List<Litecoin> litecoinFutures = null;
		try {
			SessionFactory factory = getSessionFactory();
			Session session = factory.openSession();
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Litecoin> criteriaQuery = criteriaBuilder.createQuery(Litecoin.class);
			Root<Litecoin> root = criteriaQuery.from(Litecoin.class);
			criteriaQuery.select(root);
			Query<Litecoin> query = session.createQuery(criteriaQuery);
			litecoinFutures = query.getResultList();
			session.disconnect();
			session.close();
		} catch (Exception e) {
			logger.error(e.getStackTrace());
		}
		return litecoinFutures;
	}
	
	public static int deleteAll() {
			int rows = 0;
			List<Litecoin> litecoinToDelete = selectAll();
			logger.debug("LITECOIN TO DELETE SIZE: " + litecoinToDelete.size());
			SessionFactory factory = getSessionFactory();
			Session session = factory.openSession();
			session.beginTransaction();
			for(Litecoin b : litecoinToDelete) {
				session.delete(b);
				rows++;
			}
			session.getTransaction().commit();
			session.disconnect();
			session.close();
			logger.debug("RETURN ROWS OF LTC DELETED: " + rows);
			return rows;
	}
	
	public static String selectAllToJSON() throws IOException {
		List<Litecoin> litecoinFutures = selectAll();
		logger.info("selectAllToJSON() - litecoinFutures : " + Arrays.toString(litecoinFutures.toArray()));

		 Gson gson = new Gson();
		 String jsonString = gson.toJson(litecoinFutures, new TypeToken<List<Litecoin>>(){}.getType());

		logger.info("selectAllToJSON() - :\n" + jsonString);
		return jsonString;
	}
}