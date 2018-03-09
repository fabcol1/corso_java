package org.proxima.rest;

import java.time.LocalDateTime;
import java.util.List;
import javax.validation.Valid;
import org.proxima.entities.BitcoinHistorical;
import org.proxima.repository.BitcoinHistoricalRepository;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bitcoin")
public class BitcoinHistoricalRestController {
	public static final Logger logger = LoggerFactory.getLogger(BitcoinHistoricalRestController.class);

	@Autowired
	private BitcoinHistoricalRepository bitcoinHistoricalRepository;
	
	@GetMapping("/")
	public ResponseEntity<List<BitcoinHistorical>> listAllBitcoinHistoricals() {
		List<BitcoinHistorical> bitcoins = bitcoinHistoricalRepository.findAll();
		if (bitcoins.isEmpty()) {
			 return new ResponseEntity<List<BitcoinHistorical>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<BitcoinHistorical>>(bitcoins, HttpStatus.OK);
	}
	
	@GetMapping("/lastDay")
	public ResponseEntity<List<BitcoinHistorical>> listAllLastDayBitcoinHistoricals() {
		LocalDateTime ldtNow = LocalDateTime.now() ;
		LocalDateTime ldt = ldtNow.minusDays(1);

		List<BitcoinHistorical> bitcoins = bitcoinHistoricalRepository.findAllByExchangevalueGreaterThan(ldt);
		if (bitcoins.isEmpty()) {
			 return new ResponseEntity<List<BitcoinHistorical>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<BitcoinHistorical>>(bitcoins, HttpStatus.OK);
	}
	
	@GetMapping("/lastMonth")
	public ResponseEntity<List<BitcoinHistorical>> listAlllastMonthBitcoinHistoricals() {
		LocalDateTime ldtNow = LocalDateTime.now() ;
		LocalDateTime ldt = ldtNow.minusMonths(1);
		
		List<BitcoinHistorical> bitcoins = bitcoinHistoricalRepository.findAllByExchangevalueGreaterThan(ldt);
		if (bitcoins.isEmpty()) {
			 return new ResponseEntity<List<BitcoinHistorical>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<BitcoinHistorical>>(bitcoins, HttpStatus.OK);
	}
	
	@GetMapping("/lastYear")
	public ResponseEntity<List<BitcoinHistorical>> listAlllastYearBitcoinHistoricals() {
		LocalDateTime ldtNow = LocalDateTime.now() ;
		LocalDateTime ldt = ldtNow.minusYears(1);
		
		List<BitcoinHistorical> bitcoins = bitcoinHistoricalRepository.findAllByExchangevalueGreaterThan(ldt);
		if (bitcoins.isEmpty()) {
			 return new ResponseEntity<List<BitcoinHistorical>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<BitcoinHistorical>>(bitcoins, HttpStatus.OK);
	}
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BitcoinHistorical> insertBitcoinHistorical(@Valid @RequestBody final BitcoinHistorical bitcoin) {
		logger.info("Insert BitcoinHistorical: {}", bitcoin);
		bitcoinHistoricalRepository.save(bitcoin);
		return new ResponseEntity<BitcoinHistorical>(bitcoin, HttpStatus.CREATED);
	}
}
