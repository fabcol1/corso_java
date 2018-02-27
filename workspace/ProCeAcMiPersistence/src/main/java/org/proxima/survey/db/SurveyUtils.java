package org.proxima.survey.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.proxima.survey.entities.Survey;

public class SurveyUtils {
	
	public static void main(String args[]) {
		Survey s = new Survey();
		s.setQuestion("ciao a tutti!");
		s.setAnsa("e a te");
		s.setCansa(true);
		/*insertSurvey(s);
		System.out.println("ciaone 2222 " + s.getId());
		
		s.setQuestion("ciaone a te!");
		updateSurvey(s);*/
		List<Survey> results = selectAllSurveys();
		for (Survey survey : results) {
			System.out.println(survey.getId());
		}
	}
	
	/**
	 * Utility method to retrieve the Hibernate session object 
	 * @return
	 */
	private static Session getSession() {
		return HibernateUtil.getSessionFactory().openSession();
	}
	
	/**
	 * Utility method to close the Hibernate session
	 * @param session
	 */
	private static void closeSession(Session session) {
		session.close();
	}
	
	/**
	 * Public method to insert a survey on Database
	 * @param s
	 */
	public static int insertSurvey(Survey s) {
		Session session = getSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		closeSession(session);
		return s.getId();
	}
	
	/**
	 * Public method to update a survey on database
	 * @param s
	 */
	public static void updateSurvey(Survey s) {
		Session session = getSession();
		session.beginTransaction();
		
		session.update(s);
		session.getTransaction().commit();
		closeSession(session);
	}
	
	/**
	 * Public method to select a survey, given a particular id
	 * @param id
	 * @return
	 */
	public static Survey selectSurvey(int id) {
		Session session = getSession();
		session.beginTransaction();
		Survey selection = session.get(Survey.class, id);
		closeSession(session);
		return selection;
	}
	
	/**
	 * Public method to select all the surveys present in the Database
	 * @return
	 */
	public static List<Survey> selectAllSurveys() {
		List<Survey> surveysRes = new ArrayList<>();
		Session session = getSession();
		session.beginTransaction();
//		List<?> surveys = session.createQuery("FROM Survey").list();
//		for (Iterator<?> iterator = surveys.iterator(); iterator.hasNext();) {
//			surveysRes.add((Survey) iterator.next());
//		}
		//List<Survey> surveysRes2 = (List<Survey>)session.createQuery("FROM Survey").list();;
//		List<Survey> surveysRes2 = session.createQuery("FROM Survey").list();;
		surveysRes = session.createQuery("FROM Survey").list();;
		session.getTransaction().commit();
		return surveysRes;
	}
	
	/**
	 * Public method to delete a particular survey, given a particular id
	 * @param id
	 */
	public static void delete(int id) {
		Session session = getSession();
		session.beginTransaction();
		Survey survey = session.get(Survey.class, id);
		session.delete(survey);
		session.getTransaction().commit();
	}

}
