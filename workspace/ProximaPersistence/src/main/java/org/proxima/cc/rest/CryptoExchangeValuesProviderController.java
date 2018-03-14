package org.proxima.cc.rest;

import java.util.List;

import org.proxima.cc.entities.CryptoExchangeValuesProvider;
import org.proxima.cc.repository.ProvidersRepository;
import org.proxima.rest.UserRegistrationRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/provider")
public class CryptoExchangeValuesProviderController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserRegistrationRestController.class);
	
	
	@Autowired
	private ProvidersRepository providerRepository;
	
	
	@GetMapping("/")
	public ResponseEntity<List<CryptoExchangeValuesProvider>> findAllCryptoExchangeValueProvider () {
		logger.debug("CryptoExchangeValue find all providers - START");
		List<CryptoExchangeValuesProvider> providers = (List<CryptoExchangeValuesProvider>)providerRepository.findAll();
		if (providers.isEmpty()) {
	        return new ResponseEntity<List<CryptoExchangeValuesProvider>>(HttpStatus.NO_CONTENT);
	    }
		return new ResponseEntity<List<CryptoExchangeValuesProvider>> (providers, HttpStatus.OK) ;
	}

	
	
	
	
	
	
	
	
	
	
	

}
