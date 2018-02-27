package org.proxima.survey.db;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;
import org.proxima.survey.entities.Survey;

public class SurveyUtilsTest {
	private Survey s;
	
	@Before
	public void beforeTest() {
		s = new Survey();
		s.setQuestion("This is just a test");
		s.setAnsa("Test");
		s.setAnsc("Test");
		s.setAnse("Test");
		s.setCansb(true);
		s.setCansd(true);
		s.setCansf(true);
	}
	
	@Test
	public void testInsert() {
		SurveyUtils.insertSurvey(s);
		int id = s.getId();
		Survey copy = copySurvey(s);
		s = new Survey();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		s = session.get(Survey.class, id);
		assertEquals(copy, s);
		session.getTransaction().commit();
		
		session.beginTransaction();
		session.delete(s);
		session.getTransaction().commit();
		
		session.close();
	}
	
	private Survey copySurvey(Survey s) {
		Survey survey = new Survey();
		survey.setQuestion(s.getQuestion());
		survey.setAnsa(s.getAnsa());
		survey.setAnsc(s.getAnsc());
		survey.setAnse(s.getAnse());
		survey.setCansb(s.getCansb());
		survey.setCansd(s.getCansd());
		survey.setCansf(s.getCansf());
		return survey;
		
	}
	
	@Test
	public void testSelect() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		
		Survey result = SurveyUtils.selectSurvey(s.getId());
		
		session.beginTransaction();
		session.delete(s);
		session.getTransaction().commit();
		session.close();
		
		assertEquals(s, result);
	}
	
	@Test
	public void testSelectAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		
		int size = SurveyUtils.selectAllSurveys().size();
		
		session.beginTransaction();
		session.delete(s);
		session.getTransaction().commit();
		session.close();
		
		assertTrue(size > 0);
	}
	
	@Test
	public void testDelete() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		
		session.beginTransaction();
		int size1 = session.createQuery("FROM Survey").list().size();
		session.getTransaction().commit();
		
		SurveyUtils.delete(s.getId());
		
		session.beginTransaction();
		int size2 = session.createQuery("FROM Survey").list().size();
		session.getTransaction().commit();
		
		assertTrue(size2 < size1);
	}
	
	@Test
	public void testUpdate() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		
		Survey updated = copySurvey(s);
		s.setQuestion("This is just a test for update");
		
		SurveyUtils.updateSurvey(s);
		int id = s.getId();
		s = new Survey();
		
		session.beginTransaction();
		Survey s = session.get(Survey.class, id);
		session.getTransaction().commit();
		assertNotEquals(updated, s);
		
		session.beginTransaction();
		session.delete(s);
		session.getTransaction().commit();
		session.close();
		
	}

}
