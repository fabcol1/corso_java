/**
 * 
 */
package org.proxima.rest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.proxima.entities.User;
import org.proxima.repository.UserRepository;
import org.proxima.rest.exception.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Sort;
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
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maurizio
 *
 */
@RestController
@RequestMapping("/api/user")
public class UserLoginRestController {

	private static final Logger logger = LoggerFactory.getLogger(UserLoginRestController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	
	@PostMapping(value="/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity loginUser 
	(@RequestBody final HashMap<String, String> loginData) {
//		Optional<User> optionalUser = userRepository.findByEmail(u.getEmail());
//		if (optionalUser.isPresent()) {
//            return new ResponseEntity<User>(new CustomErrorType(
//                    "Unable to create new user. A User with email "
//                    + u.getEmail() + " already exist."),HttpStatus.CONFLICT);
//		} else {
//		    userRepository.save(u);
		System.out.println(loginData.get("email"));
		System.out.println(loginData.get("password"));
		    return new ResponseEntity (HttpStatus.OK) ;
//		}
		
	}
		
}
