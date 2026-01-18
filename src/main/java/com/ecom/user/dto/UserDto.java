package com.ecom.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private Long id;

	@NotBlank(message = "Full Name is required")
	private String fullName;

	@Email(message = "Invalid Email format")
	private String email;

	private String phone;
	private String address;
}
