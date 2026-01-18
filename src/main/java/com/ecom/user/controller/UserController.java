package com.ecom.user.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.user.dto.UserDto;
import com.ecom.user.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(dto));
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
		return ResponseEntity.ok(userService.getUserById(id));
	}

	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto dto) {
		return ResponseEntity.ok(userService.updateUser(id, dto));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}
