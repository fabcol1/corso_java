package org.db;

import java.io.IOException;
import java.io.StringWriter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import json.LocalDateTimeAdapter;
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
		for (Bitcoin b : bitcoinToDelete) {
			session.delete(b);
			rows++;
		}
		session.getTransaction().commit();
		session.disconnect();
		session.close();
		logger.debug("RETURN ROWS OF BTC DELETED: " + rows);
		return rows;
	}

	public static String selectAllToJSON() throws IOException {
		List<Bitcoin> bitcoinFutures = selectAll();
		logger.info("selectAllToJSON() - bitcoinFutures : " + Arrays.toString(bitcoinFutures.toArray()));

		Gson gson = new GsonBuilder()
		        .setPrettyPrinting()
		        .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
		        .create();
//		 Gson gson = new Gson();
		 String jsonString = gson.toJson(bitcoinFutures, new TypeToken<List<Bitcoin>>(){}.getType());

		logger.info("selectAllToJSON() - :\n" + jsonString);
		return jsonString;
//		 METODO 1 --
//		 String json = gson.toJson(bitcoinFutures, new TypeToken<List<Bitcoin>>(){}.getType());

//		 METODO 2 --
//		 Bitcoin[] btcArray = gson.toJson(stringa, Bitcoin[].class);
//		 List<Bitcoin> btcList = Arrays.asList(btcArray);
	}
	
	public static String listToJSON(List<Bitcoin> bitcoinFutures) {
		logger.info("listToJSON() - bitcoinFutures : " + Arrays.toString(bitcoinFutures.toArray()));
		Gson gson = new GsonBuilder()
		        .setPrettyPrinting()
		        .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
		        .create();
		 String jsonString = gson.toJson(bitcoinFutures, new TypeToken<List<Bitcoin>>(){}.getType());
		logger.info("listToJSON() - :\n" + jsonString);
		return jsonString;
	}
	
	public static List<Bitcoin> selectLast() {
		List<Bitcoin> bitcoinFutures = null;
		try {
			SessionFactory factory = getSessionFactory();
			Session session = factory.openSession();
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Bitcoin> criteriaQuery = criteriaBuilder.createQuery(Bitcoin.class);
			Root<Bitcoin> root = criteriaQuery.from(Bitcoin.class);
			criteriaQuery.orderBy(criteriaBuilder.desc(root.get("id")));

			Query<Bitcoin> query = session.createQuery(criteriaQuery);
			bitcoinFutures = query.setMaxResults(1).getResultList();
			logger.info("selectLast() - : l'id massimo è: " + bitcoinFutures.get(0).getId());

			session.disconnect();
			session.close();
		} catch (Exception e) {
			logger.error(e.getStackTrace());
		}
		return bitcoinFutures;
	}
	
	public static List<Bitcoin> getOlderThanNDays( int days )
	{
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		
	    CriteriaQuery<Bitcoin> criteriaQuery = criteriaBuilder.createQuery( Bitcoin.class );
	    Root<Bitcoin> root = criteriaQuery.from( Bitcoin.class );

	    long today = System.currentTimeMillis();
	    long nDays = days * 24 * 60 * 60 * 1000;
	    long nDaysAgo = today - nDays;
	    
	    LocalDateTime nDaysAgoDate =
	    	    LocalDateTime.ofInstant(Instant.ofEpochMilli(nDaysAgo), ZoneId.systemDefault());

	    criteriaQuery.where( criteriaBuilder.and(criteriaBuilder.lessThanOrEqualTo( root.get("dataValore"), nDaysAgoDate )));

	    Query<Bitcoin> query = session.createQuery(criteriaQuery);
	    List<Bitcoin> list = query.getResultList();
	
	    return list;
}	

	public static void main(String[] args) {
		System.out.println(Arrays.toString(getOlderThanNDays(0).toArray()));
	}

}
