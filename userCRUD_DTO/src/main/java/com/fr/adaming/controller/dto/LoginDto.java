package com.fr.adaming.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class LoginDto {

	@NotNull
	@NotEmpty
	@NotBlank
	private String email;

	@NotNull
	private String pwd;
}
