package com.ecom.user.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecom.user.dto.UserDto;
import com.ecom.user.exception.ResourceNotFoundException;
import com.ecom.user.mapper.UserMapper;
import com.ecom.user.model.User;
import com.ecom.user.repository.UserRepository;
import com.ecom.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final UserMapper mapper;

	@Override
	public UserDto createUser(UserDto dto) {
		User user = mapper.toEntity(dto);
		return mapper.toDto(userRepository.save(user));
	}

	@Override
	public UserDto updateUser(Long id, UserDto dto) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
		user.setFullName(dto.getFullName());
		user.setPhone(dto.getPhone());
		user.setAddress(dto.getAddress());
		return mapper.toDto(userRepository.save(user));
	}

	@Override
	public UserDto getUserById(Long id) {
		return userRepository.findById(id).map(mapper::toDto)
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));
	}

	@Override
	public List<UserDto> getAllUsers() {
		return userRepository.findAll().stream().map(mapper::toDto).toList();
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
