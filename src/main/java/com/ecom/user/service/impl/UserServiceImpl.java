package com.ecom.user.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.user.dto.UserDto;
import com.ecom.user.exception.BadRequestException;
import com.ecom.user.exception.ResourceNotFoundException;
import com.ecom.user.mapper.UserMapper;
import com.ecom.user.model.User;
import com.ecom.user.repository.UserRepository;
import com.ecom.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	private final UserRepository userRepository;
	private final UserMapper mapper;

	@Override
	@Transactional
	public UserDto createUser(UserDto dto) {
		log.info("Creating new user: {}", dto);

		// Example: Unique email/phone validation (if applicable)
		if (dto.getPhone() != null && userRepository.existsByPhone(dto.getPhone())) {
			log.warn("User creation failed: phone already exists {}", dto.getPhone());
			throw new BadRequestException("Phone number already registered");
		}

		User user = mapper.toEntity(dto);
		User saved = userRepository.save(user);

		log.info("User created successfully with id {}", saved.getId());
		return mapper.toDto(saved);
	}

	@Override
	@Transactional
	public UserDto updateUser(Long id, UserDto dto) {
		log.info("Updating user with id {}: {}", id, dto);

		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));

		// Update fields
		user.setFullName(dto.getFullName());
		user.setPhone(dto.getPhone());
		user.setAddress(dto.getAddress());

		User updated = userRepository.save(user);

		log.info("User updated successfully with id {}", updated.getId());
		return mapper.toDto(updated);
	}

	@Override
	public UserDto getUserById(Long id) {
		log.info("Fetching user by id {}", id);

		return userRepository.findById(id).map(mapper::toDto)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
	}

	@Override
	public List<UserDto> getAllUsers() {
		log.info("Fetching all users");

		List<UserDto> users = userRepository.findAll().stream().map(mapper::toDto).toList();

		log.info("Fetched {} users", users.size());
		return users;
	}

	@Override
	@Transactional
	public void deleteUser(Long id) {
		log.info("Deleting user with id {}", id);

		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));

		userRepository.delete(user);

		log.info("User deleted successfully with id {}", id);
	}
}
