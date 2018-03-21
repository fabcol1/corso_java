/**
 * 
 */
package org.proxima.rest;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.crypto.Data;

import org.apache.log4j.Logger;
import org.proxima.entities.User;
import org.proxima.entities.Userlogintoken;
import org.proxima.repository.UserRepository;
import org.proxima.repository.UserTokenRepository;
import org.proxima.rest.exception.CustomErrorType;
import org.proxima.rest.service.UserService;
import org.proxima.util.MailUtility;
import org.proxima.util.RandomPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * @author maurizio
 *
 */
@RestController
@RequestMapping("/api/usertoken")
public class UserTokenRestController {

	final static Logger logger = Logger.getLogger(UserTokenRestController.class);

	@Autowired
	private UserTokenRepository userTokenRepository;

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Userlogintoken> generateToken(@RequestBody final User u) {
		// genero token
		String newGeneratedToken = RandomPassword.generate();
		Userlogintoken ult = new Userlogintoken();
		// setto token
		ult.setEmail(u.getEmail());
		ult.setGeneratedToken(newGeneratedToken);
		LocalDateTime ldt = LocalDateTime.now();
		ldt = ldt.plusHours(1);
		ult.setExpirationDate(ldt.toString());
		// salvo token
		userTokenRepository.save(ult);
		// invio email con token
		String tokenURL = "http://localhost:8080/recovery-userPasswordPt2/" + newGeneratedToken;
		String mess = "Clicca sul seguente link per effettuare il recupero password: " + tokenURL;
		MailUtility.sendSimpleMail(u.getEmail(), "Procedura di recupero password", mess);
		return new ResponseEntity<Userlogintoken>(ult, HttpStatus.CREATED);

	}

	@GetMapping("/getToken/{token}")
	public ResponseEntity<Userlogintoken> getLoginTokenByToken(@PathVariable("token") final String token) {

		Optional<Userlogintoken> optionalUserlogintoken = userTokenRepository.findByGeneratedToken(token);
		LocalDateTime ldt = LocalDateTime.now();
		if (optionalUserlogintoken.isPresent()) {
			// se data attuale è maggiore di data token allora è scaduto. CONVERTIRE stringa in data per confronto con now()
			if(true) {
				return new ResponseEntity<Userlogintoken>(optionalUserlogintoken.get(), HttpStatus.OK);

			}else {
				return new ResponseEntity<Userlogintoken>(HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<Userlogintoken>(HttpStatus.NOT_FOUND);
		}
	}
}
