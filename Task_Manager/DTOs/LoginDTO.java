package com.Task_Manager.DTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDTO {

	@NotBlank(message="PIN cann't be blank")
	private String pin;
}
