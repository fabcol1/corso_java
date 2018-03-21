/**
 * 
 */
package org.proxima.repository;

import java.util.Optional;

import org.proxima.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author maurizio
 *
 */
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByEmail (String email) ;
}
