package com.abrahamxts.bank.models;

import lombok.*;
import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Cuenta")
public class CuentaModel {

	@Id
	@Column(name = "NumeroDeCuenta", nullable = false)
    private Integer numeroDeCuenta;

	@ManyToOne
	@JoinColumn(name = "ClienteId", nullable = false)
    private ClienteModel clienteId;

	@Column(name = "Saldo", nullable = false)
    private double saldo;
}