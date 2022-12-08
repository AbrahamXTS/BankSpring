package com.abrahamxts.bank.models;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Cliente")
public class ClienteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ClienteId;

	@Column(name = "Nombre", nullable = false)
    private String nombre;

	@Column(name = "Apellido", nullable = false)
    private String apellido;

	@Column(name = "CURP", nullable = false)
    private String CURP;

	@Column(name = "Token", nullable = true)
	private String token;

	@Column(name = "Contraseña", nullable = false)
    private String contraseña;
}
