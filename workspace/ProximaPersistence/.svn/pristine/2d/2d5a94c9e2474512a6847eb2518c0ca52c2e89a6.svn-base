package org.proxima.cc.rest;

import java.util.List;
import javax.validation.Valid;

import org.proxima.cc.entities.litecoin.LitecoinHistorical;
import org.proxima.cc.entities.litecoin.LitecoinHistoricalCustom;
import org.proxima.cc.services.LitecoinHistoricalService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/litecoin")
public class LitecoinHistoricalRestController {
	public static final Logger logger = LoggerFactory.getLogger(LitecoinHistoricalRestController.class);

    @Autowired
    LitecoinHistoricalService litecoinHistoricalService;
	
	@GetMapping("/")
	public ResponseEntity<List<LitecoinHistorical>> listAllLitecoinHistoricals() {
		List<LitecoinHistorical> litecoins = litecoinHistoricalService.listAllLitecoinHistoricals();
		if (litecoins.isEmpty()) {
			 return new ResponseEntity<List<LitecoinHistorical>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<LitecoinHistorical>>(litecoins, HttpStatus.OK);
	}
	
	@GetMapping("/lastDay")
	public ResponseEntity<List<LitecoinHistorical>> listAllLastDayLitecoinHistoricals() {
		List<LitecoinHistorical> litecoins = litecoinHistoricalService.listAllLastDayLitecoinHistoricals();
		if (litecoins.isEmpty()) {
			 return new ResponseEntity<List<LitecoinHistorical>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<LitecoinHistorical>>(litecoins, HttpStatus.OK);
	}
	
	@GetMapping("/lastDay/{cryptoexchangevaluesproviderid}")
	public ResponseEntity<List<LitecoinHistorical>> listAllLastDayBitcoinHistoricals(
			@PathVariable("cryptoexchangevaluesproviderid") final long cryptoexchangevaluesproviderId) {
		List<LitecoinHistorical> litecoins = litecoinHistoricalService
				.listAllLastDayLitecoinHistoricals(cryptoexchangevaluesproviderId);
		if (litecoins.isEmpty()) {
			return new ResponseEntity<List<LitecoinHistorical>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<LitecoinHistorical>>(litecoins, HttpStatus.OK);
	}
	
	@GetMapping("/lastWeek")
	public ResponseEntity<List<LitecoinHistorical>> listAllLastWeekLitecoinHistoricals() {
		List<LitecoinHistorical> litecoins = litecoinHistoricalService.listAllLastWeekLitecoinHistoricals();
		if (litecoins.isEmpty()) {
			 return new ResponseEntity<List<LitecoinHistorical>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<LitecoinHistorical>>(litecoins, HttpStatus.OK);
	}
	
	@GetMapping("/lastWeek/{cryptoexchangevaluesproviderid}")
	public ResponseEntity<List<LitecoinHistorical>> listAllLastWeekLitecoinHistoricals(@PathVariable("cryptoexchangevaluesproviderid") final long cryptoexchangevaluesproviderId) {
		List<LitecoinHistorical> litecoins = litecoinHistoricalService.listAllLastWeekLitecoinHistoricals(cryptoexchangevaluesproviderId);
		if (litecoins.isEmpty()) {
			 return new ResponseEntity<List<LitecoinHistorical>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<LitecoinHistorical>>(litecoins, HttpStatus.OK);
	}
	
	@GetMapping("/lastMonth")
	public ResponseEntity<List<LitecoinHistorical>> listAlllastMonthLitecoinHistoricals() {
		List<LitecoinHistorical> litecoins = litecoinHistoricalService.listAlllastMonthLitecoinHistoricals();
		if (litecoins.isEmpty()) {
			 return new ResponseEntity<List<LitecoinHistorical>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<LitecoinHistorical>>(litecoins, HttpStatus.OK);
	}
	
	@GetMapping("/lastYear")
	public ResponseEntity<List<LitecoinHistorical>> listAlllastYearLitecoinHistoricals() {
		List<LitecoinHistorical> litecoins = litecoinHistoricalService.listAlllastYearLitecoinHistoricals();
		if (litecoins.isEmpty()) {
			 return new ResponseEntity<List<LitecoinHistorical>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<LitecoinHistorical>>(litecoins, HttpStatus.OK);
	}
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LitecoinHistorical> insertLitecoinHistorical(@Valid @RequestBody final LitecoinHistorical litecoin) {
		litecoinHistoricalService.insertLitecoinHistorical(litecoin);
		return new ResponseEntity<LitecoinHistorical>(litecoin, HttpStatus.CREATED);
	}
	
	@GetMapping("/lastvalue/{cryptoexchangevaluesproviderId}/{currencyRegistryId}")
	public ResponseEntity<LitecoinHistoricalCustom> lastExcangeValueForProviderAndCurrency(
			@PathVariable("cryptoexchangevaluesproviderId") final long cryptoexchangevaluesproviderId,
			@PathVariable("currencyRegistryId") final long currencyRegistryId) {
		LitecoinHistoricalCustom toReturn = litecoinHistoricalService
				.getLastExcangeByProviderIdAndCurrencyId(cryptoexchangevaluesproviderId, currencyRegistryId);
		if (toReturn == null) {

			return new ResponseEntity<LitecoinHistoricalCustom>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<LitecoinHistoricalCustom>(toReturn, HttpStatus.OK);
	}

	

	@GetMapping("/lastvalues/{currencyRegistryId}")
	public ResponseEntity<List<LitecoinHistoricalCustom>> lastExchangeValuesForCurrency(
			@PathVariable("currencyRegistryId") final long currencyRegistryId) {
		
		System.out.println("inizio");
		List<LitecoinHistoricalCustom> toReturn = litecoinHistoricalService.getLastExchangeValuesByCurrencyId(currencyRegistryId);
		
		if (toReturn == null) {

			return new ResponseEntity<List<LitecoinHistoricalCustom>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<LitecoinHistoricalCustom>>(toReturn, HttpStatus.OK);
	}
	
}
