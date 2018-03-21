/**
 * 
 */
package org.proxima.rest.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.proxima.entities.User;
import org.proxima.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author maurizio
 *
 */
@Service
public class LoginService implements UserDetailsService {

	private static final Logger logger = Logger.getLogger(LoginService.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		logger.info("LoginService.loadUserByUsername - START - email: " + email);
		Optional<User> optUser = userRepository.findByEmail(email);
		if (!optUser.isPresent()) {
			throw new UsernameNotFoundException("Opps! user not found with user-name: " + email);
		}
		return new org.springframework.security.core.userdetails.User(optUser.get().getFirstname(), optUser.get().getPassword(),
				getAuthorities(optUser.get()));
	}

	private Collection<GrantedAuthority> getAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities = AuthorityUtils.createAuthorityList("USER");
		return authorities;
	}
}