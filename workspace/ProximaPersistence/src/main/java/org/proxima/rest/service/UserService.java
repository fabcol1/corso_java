/**
 * 
 */
package org.proxima.rest.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.proxima.entities.User;
import org.proxima.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author maurizio
 *
 */
@Service
public class UserService {

	private static final Logger logger = Logger.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	public User loadUserByEmail(String email)
			throws Exception {
		logger.debug("UserService.loadUserByEmail - START");
		Optional<User> optionalObj = userRepository.findByEmail(email);
		if (!optionalObj.isPresent()) {
			throw new Exception("Warning! User not found with email: " + email);
		} else {
			return optionalObj.get();
		}
	}
	
	public User loadUserById(Long userId)
			throws Exception {
		logger.debug("UserService.loadUserById - START");
		Optional<User> optionalObj = userRepository.findById(userId);
		if (!optionalObj.isPresent()) {
			throw new Exception("Opps! user not found with user id: " + userId);
		} else {
			return optionalObj.get();
		}
	}
	
	public List<User> getAllUsersOrderByLastname () {
		Sort sort = new Sort(Sort.Direction.ASC, "lastname");
		return (List<User>)userRepository.findAll(sort);
	}
	
	public List<User> getAllUsers () {
		return (List<User>)userRepository.findAll();
	}

	
}
