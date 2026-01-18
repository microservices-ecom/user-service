package com.ecom.user.mapper;

import org.mapstruct.Mapper;

import com.ecom.user.dto.UserDto;
import com.ecom.user.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	UserDto toDto(User user);

	User toEntity(UserDto dto);
}