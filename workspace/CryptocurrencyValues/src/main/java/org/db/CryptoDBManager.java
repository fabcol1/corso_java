package org.db;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import model.CryptoFrom;

public class CryptoDBManager extends DBManager {
	final static Logger logger = Logger.getLogger(CryptoDBManager.class);	

	public static CryptoFrom getCryptoFromById(int id) {
		CryptoFrom cryptoFrom = null;
		Session session = getSessionFactory().openSession();
		try {
			logger.debug("ID: " + id);
			cryptoFrom = session.get(CryptoFrom.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		session.close();
		return cryptoFrom;
	}
}
