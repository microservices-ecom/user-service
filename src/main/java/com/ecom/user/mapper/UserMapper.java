package com.ecom.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.ecom.user.dto.UserDto;
import com.ecom.user.model.User;

/**
 * Mapper interface to convert between User entity and UserDto. Uses MapStruct
 * to auto-generate implementation at build time.
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

	/**
	 * Converts User entity to UserDto.
	 *
	 * @param user entity object
	 * @return corresponding UserDto
	 */
	UserDto toDto(User user);

	/**
	 * Converts UserDto to User entity.
	 *
	 * @param dto data transfer object
	 * @return corresponding User entity
	 */
	User toEntity(UserDto dto);

	/**
	 * Updates an existing User entity from UserDto. Useful for update operations
	 * without overwriting ID or audit fields.
	 *
	 * @param dto    source DTO with new values
	 * @param entity target entity to update
	 */
	void updateEntityFromDto(UserDto dto, @MappingTarget User entity);
}
