package com.abrahamxts.bank.DTO;

import lombok.*;

@Data
@AllArgsConstructor
public class LoginRequestDTO {

	private String CURP;
	private String contraseña;
}
