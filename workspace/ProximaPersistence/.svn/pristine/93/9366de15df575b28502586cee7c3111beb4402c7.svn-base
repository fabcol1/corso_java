/**
 * 
 */
package org.proxima.repository;

import java.util.Optional;

import org.proxima.entities.Userlogintoken;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author maurizio
 *
 */
public interface UserTokenRepository extends JpaRepository<Userlogintoken, Long>{
   Optional<Userlogintoken> findByGeneratedToken (String token);
}
