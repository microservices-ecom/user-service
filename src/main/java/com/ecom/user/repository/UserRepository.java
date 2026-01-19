package com.ecom.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.user.model.User;

/**
 * Repository interface for User entity. Provides CRUD operations along with
 * domain-specific query methods.
 *
 * Spring Data JPA automatically generates implementations at runtime.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * Finds a user by email.
	 * 
	 * @param email user email
	 * @return Optional containing User if found, else empty
	 */
	Optional<User> findByEmail(String email);

	/**
	 * Checks whether a phone number is already registered.
	 *
	 * @param phone user phone
	 * @return true if exists, false otherwise
	 */
	boolean existsByPhone(String phone);

	/**
	 * Checks whether an email is already registered.
	 *
	 * @param email email to check
	 * @return true if exists, false otherwise
	 */
	boolean existsByEmail(String email);
}
