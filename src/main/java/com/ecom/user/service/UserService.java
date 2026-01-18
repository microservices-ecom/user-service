package com.ecom.user.service;

import java.util.List;

import com.ecom.user.dto.UserDto;

public interface UserService {
	UserDto createUser(UserDto dto);

	UserDto updateUser(Long id, UserDto dto);

	UserDto getUserById(Long id);

	List<UserDto> getAllUsers();

	void deleteUser(Long id);
}
