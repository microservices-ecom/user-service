package com.ecom.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecom.user.dto.UserDto;
import com.ecom.user.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	// Create User
	@Operation(summary = "Create a new user", description = "Creates a new user with given details")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "User created successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid input data"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	@PostMapping
	public ResponseEntity<?> createUser(@Valid @RequestBody UserDto dto) {
		try {
			log.info("Request to create user: {}", dto);
			UserDto createdUser = userService.createUser(dto);
			log.info("User created successfully with id: {}", createdUser.getId());
			return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
		} catch (Exception e) {
			log.error("Error creating user: {}", e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to create user. " + e.getMessage());
		}
	}

	// Get user by ID
	@Operation(summary = "Get user by ID", description = "Fetches user details by user ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "User fetched successfully"),
			@ApiResponse(responseCode = "404", description = "User not found"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	@GetMapping("/{id}")
	public ResponseEntity<?> getUser(@PathVariable Long id) {
		try {
			log.info("Fetching user with id: {}", id);
			UserDto user = userService.getUserById(id);
			log.info("User fetched successfully: {}", user);
			return ResponseEntity.ok(user);
		} catch (Exception e) {
			log.error("Error fetching user with id {}: {}", id, e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to fetch user. " + e.getMessage());
		}
	}

	// Get all users
	@Operation(summary = "Get all users", description = "Fetches a list of all users")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Users fetched successfully"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	@GetMapping
	public ResponseEntity<?> getAllUsers() {
		try {
			log.info("Fetching all users");
			List<UserDto> users = userService.getAllUsers();
			log.info("Total users fetched: {}", users.size());
			return ResponseEntity.ok(users);
		} catch (Exception e) {
			log.error("Error fetching users: {}", e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to fetch users. " + e.getMessage());
		}
	}

	// Update user
	@Operation(summary = "Update user", description = "Updates user details by ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "User updated successfully"),
			@ApiResponse(responseCode = "404", description = "User not found"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@PathVariable Long id, @Valid @RequestBody UserDto dto) {
		try {

			log.info("Updating user with id {}: {}", id, dto);
			UserDto updatedUser = userService.updateUser(id, dto);
			log.info("User updated successfully: {}", updatedUser);
			return ResponseEntity.ok(updatedUser);
		} catch (Exception e) {
			log.error("Error updating user with id {}: {}", id, e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to update user. " + e.getMessage());
		}
	}

	// Delete user
	@Operation(summary = "Delete user", description = "Deletes a user by ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "User deleted successfully"),
			@ApiResponse(responseCode = "404", description = "User not found"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		try {
			log.info("Deleting user with id: {}", id);
			userService.deleteUser(id);
			log.info("User deleted successfully with id: {}", id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			log.error("Error deleting user with id {}: {}", id, e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to delete user. " + e.getMessage());
		}
	}
}
