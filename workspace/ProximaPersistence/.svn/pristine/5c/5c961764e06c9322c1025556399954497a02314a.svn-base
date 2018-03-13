package org.proxima.cc.rest;

import java.util.List;
import javax.validation.Valid;

import org.proxima.cc.entities.BitcoinHistorical;
import org.proxima.cc.services.BitcoinHistoricalService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bitcoin")
public class BitcoinHistoricalRestController {
	public static final Logger logger = LoggerFactory.getLogger(BitcoinHistoricalRestController.class);

    @Autowired
    BitcoinHistoricalService bitcoinHistoricalService;
	
	@GetMapping("/")
	public ResponseEntity<List<BitcoinHistorical>> listAllBitcoinHistoricals() {
		List<BitcoinHistorical> bitcoins = bitcoinHistoricalService.listAllBitcoinHistoricals();
		if (bitcoins.isEmpty()) {
			 return new ResponseEntity<List<BitcoinHistorical>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<BitcoinHistorical>>(bitcoins, HttpStatus.OK);
	}
	
	@GetMapping("/lastDay")
	public ResponseEntity<List<BitcoinHistorical>> listAllLastDayBitcoinHistoricals() {
		List<BitcoinHistorical> bitcoins = bitcoinHistoricalService.listAllLastDayBitcoinHistoricals();
		if (bitcoins.isEmpty()) {
			 return new ResponseEntity<List<BitcoinHistorical>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<BitcoinHistorical>>(bitcoins, HttpStatus.OK);
	}
	
	@GetMapping("/lastMonth")
	public ResponseEntity<List<BitcoinHistorical>> listAlllastMonthBitcoinHistoricals() {
		List<BitcoinHistorical> bitcoins = bitcoinHistoricalService.listAlllastMonthBitcoinHistoricals();
		if (bitcoins.isEmpty()) {
			 return new ResponseEntity<List<BitcoinHistorical>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<BitcoinHistorical>>(bitcoins, HttpStatus.OK);
	}
	
	@GetMapping("/lastYear")
	public ResponseEntity<List<BitcoinHistorical>> listAlllastYearBitcoinHistoricals() {
		List<BitcoinHistorical> bitcoins = bitcoinHistoricalService.listAlllastYearBitcoinHistoricals();
		if (bitcoins.isEmpty()) {
			 return new ResponseEntity<List<BitcoinHistorical>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<BitcoinHistorical>>(bitcoins, HttpStatus.OK);
	}
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BitcoinHistorical> insertBitcoinHistorical(@Valid @RequestBody final BitcoinHistorical bitcoin) {
		bitcoinHistoricalService.insertBitcoinHistorical(bitcoin);
		return new ResponseEntity<BitcoinHistorical>(bitcoin, HttpStatus.CREATED);
	}
}
