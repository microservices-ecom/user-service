package com.ecom.user.service;

import java.util.List;

import com.ecom.user.dto.UserDto;

/**
 * Service interface for managing User entities. Provides CRUD operations and
 * can be extended for business-specific operations.
 */
public interface UserService {

	/**
	 * Creates a new user.
	 *
	 * @param dto data transfer object containing user details
	 * @return the created user as a DTO
	 */
	UserDto createUser(UserDto dto);

	/**
	 * Updates an existing user identified by ID.
	 *
	 * @param id  the ID of the user to update
	 * @param dto data transfer object containing updated fields
	 * @return the updated user as a DTO
	 */
	UserDto updateUser(Long id, UserDto dto);

	/**
	 * Retrieves a user by their ID.
	 *
	 * @param id the ID of the user to fetch
	 * @return the user as a DTO
	 */
	UserDto getUserById(Long id);

	/**
	 * Retrieves all users.
	 *
	 * @return a list of user DTOs
	 */
	List<UserDto> getAllUsers();

	/**
	 * Deletes a user by their ID.
	 *
	 * @param id the ID of the user to delete
	 */
	void deleteUser(Long id);
}
