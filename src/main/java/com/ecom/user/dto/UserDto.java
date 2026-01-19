package com.ecom.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for User entity. Used for incoming requests and outgoing
 * API responses.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private Long id;

	@NotBlank(message = "Full Name is required")
	@Size(max = 120, message = "Full Name must not exceed 120 characters")
	private String fullName;

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid Email format")
	@Size(max = 150, message = "Email must not exceed 150 characters")
	private String email;

	@Size(max = 15, message = "Phone number must not exceed 15 digits")
	@Pattern(regexp = "^[0-9+\\-() ]*$", message = "Phone number may contain digits, +, -, space and parentheses only")
	private String phone;

	@Size(max = 255, message = "Address must not exceed 255 characters")
	private String address;
}
