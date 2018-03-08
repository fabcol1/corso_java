package org.proxima.rest;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.proxima.entities.Bitcoin;
import org.proxima.repository.BitcoinJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bitcoin")
public class BitcoinRestController {
	public static final Logger logger = LoggerFactory.getLogger(BitcoinRestController.class);

	@Autowired
	private BitcoinJpaRepository bitcoinJpaRepository;
	
	@GetMapping("/")
	public ResponseEntity<List<Bitcoin>> listAllBitcoins() {
		List<Bitcoin> bitcoins = bitcoinJpaRepository.findAll();
		if (bitcoins.isEmpty()) {
			 return new ResponseEntity<List<Bitcoin>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Bitcoin>>(bitcoins, HttpStatus.OK);
	}
	
	@GetMapping("/lastDay")
	public ResponseEntity<List<Bitcoin>> listAllLastDayBitcoins() {
		LocalDateTime ldtNow = LocalDateTime.now() ;
		LocalDateTime ldt = LocalDateTime.of(ldtNow.getYear(), ldtNow.getMonth(), ldtNow.getDayOfMonth(), 0, 0) ;
		List<Bitcoin> bitcoins = bitcoinJpaRepository.findAllByDataValoreGreaterThan(ldt);
		if (bitcoins.isEmpty()) {
			 return new ResponseEntity<List<Bitcoin>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Bitcoin>>(bitcoins, HttpStatus.OK);
	}
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bitcoin> insertBitcoin(@Valid @RequestBody final Bitcoin bitcoin) {
		logger.info("Insert Bitcoin: {}", bitcoin);
		bitcoinJpaRepository.save(bitcoin);
		return new ResponseEntity<Bitcoin>(bitcoin, HttpStatus.CREATED);
	}
}
