package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LoginRequest {
	@NotBlank(message = "Email can't be blank")
	@Email(message = "Invalid email format")
	private String email;
//	@NotBlank
	@Length(min = 5,max=20,message = "Invalid password length")
	private String password;
}
