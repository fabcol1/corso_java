package org.proxima.rest;

import java.util.List;
import java.util.Optional;

import org.proxima.entities.User;
import org.proxima.repository.UserJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@RequestBody final User user) {
		userJpaRepository.save(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") final Integer id) {
		Optional<User> user = userJpaRepository.findById(id);
		return new ResponseEntity<User>(user.get(), HttpStatus.OK);
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@PathVariable("id") final Integer id, @RequestBody User user) {
		// fetch user based on id and set it to currentUser object of type UserDTO
		Optional<User> currentUserOptional = userJpaRepository.findById(id);
		User currentUser = currentUserOptional.get();
		// update currentUser object data with user object data
		currentUser.setFirstname("provaprovaprovaprova" + Math.random());
		currentUser.setLastname("provaprovaprovaprovapropvaprova" + Math.random());
		// save currentUser obejct
		userJpaRepository.saveAndFlush(currentUser);
		// return ResponseEntity object
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}
}
