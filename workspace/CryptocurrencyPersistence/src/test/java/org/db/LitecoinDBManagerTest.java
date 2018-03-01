package org.db;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.FromWhere;
import model.Litecoin;
import model.TipoValuta;

public class LitecoinDBManagerTest {
	final static Logger logger = Logger.getLogger(LitecoinDBManagerTest.class);	

	@Test
	public void insertLitecoinTest() {
		logger.info("###################################################################");
		logger.info("#################		TEST insertLitecoinTest     ################");
		logger.info("###################################################################");
	
		int size = LitecoinDBManager.selectAll().size();
		logger.info("@TEST insertLitecoinTest --> size: " + size);
		assertTrue(size > 0);
	}
	
	@Test
	public void testTipoValuta() {
		logger.info("###################################################################");
		logger.info("################	 TEST testTipoValuta            ################");
		logger.info("###################################################################");
	
		List<Litecoin> ltcLista = LitecoinDBManager.selectAll();
		logger.info("@TEST caricato lista: " + ltcLista);
		TipoValuta tipov = ltcLista.get(0).getTipoValuta();
		logger.info("@TEST TipoValuta tipov: " + tipov);
		logger.info("@TEST TipoValuta LABEL: " + tipov.getLabel());
		logger.info("@TEST TipoValuta SYMBOL: " + tipov.getSimbolo());

		assertTrue(tipov.getLabel().equals("USD") && tipov.getSimbolo().equals("$"));
	}
	
	@Test
	public void testFromWhere() {
		logger.info("###################################################################");
		logger.info("################	 TEST testFromWhere             ################");
		logger.info("###################################################################");
	
		List<Litecoin> ltcLista = LitecoinDBManager.selectAll();
		logger.info("@TEST caricato lista: " + ltcLista);
		FromWhere fromw = ltcLista.get(0).getFromWhere();
		logger.info("@TEST FromWhere fromw: " + fromw);
		logger.info("@TEST FromWhere LABEL : " + fromw.getLabel());
		logger.info("@TEST TipoValuta WEB URL: " + fromw.getWeburl());

		assertTrue(fromw.getLabel().equals("Okex") && fromw.getWeburl().equals("https://www.okex.com/"));
	}
	
	@Before
	public void insert() {
		try {
			Litecoin l = new Litecoin();
//			INSERT INTO litecoin(cambio_valore, data_valore, id_from, id_valuta) 
//				VALUES(10299.23, '2012-06-18 10:34:09', 1, 2);
			FromWhere fw = new FromWhere();
			fw.setId(1);
			
			TipoValuta tv = new TipoValuta();
			tv.setId(2);
			
			l.setCambioValore(new BigDecimal(10299.23));
			l.setDataValore(LocalDateTime.now());
			l.setFromWhere(fw);
			l.setTipoValuta(tv);
			
			LitecoinDBManager.insert(l);
			logger.info("@Before --> inserted litecoin: " + l);
		} catch (Exception e) {
			logger.error(e.getStackTrace());
		}
	}
	
	@After
	public void deleteAll() {
		int rows = LitecoinDBManager.deleteAll();
		logger.info("@After -->	Database cleaned.... deleted rows number: " + rows);
	}
}
