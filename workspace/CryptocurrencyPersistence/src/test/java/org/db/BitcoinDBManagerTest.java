package org.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import model.Bitcoin;
import model.FromWhere;
import model.TipoValuta;

public class BitcoinDBManagerTest {
	final static Logger logger = Logger.getLogger(BitcoinDBManagerTest.class);	

	@Test
	public void insertBitcoinTest() {
		logger.info("###################################################################");
		logger.info("#################		TEST insertBitcoinTest     ################");
		logger.info("###################################################################");
	
		int size = BitcoinDBManager.selectAll().size();
		logger.info("@TEST insertBitcoinTest --> size: " + size);
		assertTrue(size > 0);
	}
	
	@Test
	public void testTipoValuta() {
		logger.info("###################################################################");
		logger.info("################	 TEST testTipoValuta            ################");
		logger.info("###################################################################");
	
		List<Bitcoin> btcLista = BitcoinDBManager.selectAll();
		logger.info("@TEST caricato lista: " + btcLista);
		TipoValuta tipov = btcLista.get(0).getTipoValuta();
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
	
		List<Bitcoin> btcLista = BitcoinDBManager.selectAll();
		logger.info("@TEST caricato lista: " + btcLista);
		FromWhere fromw = btcLista.get(0).getFromWhere();
		logger.info("@TEST FromWhere fromw: " + fromw);
		logger.info("@TEST FromWhere LABEL : " + fromw.getLabel());
		logger.info("@TEST TipoValuta WEB URL: " + fromw.getWeburl());

		assertTrue(fromw.getLabel().equals("Okex") && fromw.getWeburl().equals("https://www.okex.com/"));
	}
	
	@Test
	public void testSelectLast() {
		logger.info("###################################################################");
		logger.info("################	 TEST testselectLast            ################");
		logger.info("###################################################################");
	
		try {
			Bitcoin b = new Bitcoin();
//			INSERT INTO bitcoin(cambio_valore, data_valore, id_from, id_valuta) 
//				VALUES(10299.23, '2012-06-18 10:34:09', 1, 2);
			FromWhere fw = new FromWhere();
			fw.setId(1);
			
			TipoValuta tv = new TipoValuta();
			tv.setId(2);
			
			b.setId(75);
			b.setCambioValore(new BigDecimal(10299.23));
			b.setDataValore(LocalDateTime.of(1, 1, 1, 1, 1));
			b.setFromWhere(fw);
			b.setTipoValuta(tv);
			
			BitcoinDBManager.insert(b);
			logger.info("@Before --> inserted bitcoin: " + b);
		} catch (Exception e) {
			logger.error(e.getStackTrace());
		}
		
		List<Bitcoin> btcLista = BitcoinDBManager.selectLast();
		logger.info("@TEST caricato lista: " + btcLista);

		assertTrue(btcLista.get(0).getId() == 75 && btcLista.size()==1);
	}
		
	@Before
	public void insert() {
		try {
			Bitcoin b = new Bitcoin();
//			INSERT INTO bitcoin(cambio_valore, data_valore, id_from, id_valuta) 
//				VALUES(10299.23, '2012-06-18 10:34:09', 1, 2);
			FromWhere fw = new FromWhere();
			fw.setId(1);
			
			TipoValuta tv = new TipoValuta();
			tv.setId(2);
			
			b.setId(64);
			b.setCambioValore(new BigDecimal(10299.23));
			b.setDataValore(LocalDateTime.of(1, 1, 1, 1, 1));
			b.setFromWhere(fw);
			b.setTipoValuta(tv);
			
			BitcoinDBManager.insert(b);
			logger.info("@Before --> inserted bitcoin: " + b);
		} catch (Exception e) {
			logger.error(e.getStackTrace());
		}
	}
	
	@After
	public void deleteAll() {
		int rows = BitcoinDBManager.deleteAll();
		logger.info("@After -->	Database cleaned.... deleted rows number: " + rows);
	}
}
