package org.proxima.repository;

import org.proxima.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {
	User findByFirstname(String firstname);
	User findByEmail(String email);

}