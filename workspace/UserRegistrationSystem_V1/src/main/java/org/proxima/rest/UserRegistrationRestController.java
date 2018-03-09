package org.proxima.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.proxima.entities.User;
import org.proxima.error.CustomErrorType;
import org.proxima.repository.UserJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserRegistrationRestController {

	public static final Logger logger = LoggerFactory.getLogger(UserRegistrationRestController.class);

	@Autowired
	private UserJpaRepository userJpaRepository;

	@GetMapping("/")
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = userJpaRepository.findAll();
		if (users.isEmpty()) {
			 return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@Valid @RequestBody final User user) {
		logger.info("Creating User: {}", user);
		if (userJpaRepository.findByEmail(user.getEmail()) != null) {
			logger.error("Unable to create new user. A User with email {} already exist.", user.getEmail()); 
			return new ResponseEntity<User>(new CustomErrorType(
					 "Unable to create new user. A User with email "
							 + user.getEmail() + " already exist."), HttpStatus.CONFLICT);
		}
		userJpaRepository.save(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") final Integer id) {
		Optional<User> user = userJpaRepository.findById(id);
		if(!user.isPresent()) {
			return new ResponseEntity<User>(new CustomErrorType("User with id " + id + " not found"),
											HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user.get(), HttpStatus.OK);
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@PathVariable("id") final Integer id, @RequestBody User user) {
		// fetch user based on id and set it to currentUser object of type UserDTO
		Optional<User> currentUserOptional = userJpaRepository.findById(id);
		
		if (!currentUserOptional.isPresent()) {
			 return new ResponseEntity<User>(
					 new CustomErrorType("Unable to update. User with id "
							 	+ id + " not found."), HttpStatus.NOT_FOUND);
		} 
		User currentUser = currentUserOptional.get();
		// update currentUser object data with user object data
		currentUser.setFirstname(user.getFirstname());
		currentUser.setLastname(user.getLastname());
		currentUser.setEmail(user.getEmail());
		currentUser.setDateofbirth(user.getDateofbirth());
		currentUser.setImgpath(user.getImgpath());
		currentUser.setPassword(user.getPassword());
		// save currentUser object
		userJpaRepository.saveAndFlush(currentUser);
		// return ResponseEntity object
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") final Integer id) {
		Optional<User> currentUserOptional = userJpaRepository.findById(id);
		if (!currentUserOptional.isPresent()) {
			 return new ResponseEntity<User>(
					 new CustomErrorType("Unable to delete. User with id "
							 + id + " not found."), HttpStatus.NOT_FOUND);
			 }
		userJpaRepository.deleteById(id);
		return new ResponseEntity<User>(new CustomErrorType("Deleted User with id "
						+ id + "."), HttpStatus.OK);
	}
	
//	@DeleteMapping("/")
//	public ResponseEntity<User> deleteAll() {
//	 userJpaRepository.deleteAll();
//	 return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//	}
}
