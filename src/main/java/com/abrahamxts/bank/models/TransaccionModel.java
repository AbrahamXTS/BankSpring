package com.abrahamxts.bank.models;

import com.abrahamxts.bank.utils.Utileria;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Transaccion")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class TransaccionModel {

	@Id
	protected String id;

	@Column(name = "Fecha", nullable = false)
    protected String fecha;

	@Column(name = "Monto", nullable = false)
    protected double monto;

	@ManyToOne
	@JoinColumn(name = "NumeroDeCuenta", nullable = false)
    protected CuentaModel numeroDeCuenta;
	
	@Column(name = "Concepto", nullable = false)
    protected String concepto;

    protected TransaccionModel(double monto, CuentaModel cuenta, String concepto) {
		this.monto = monto;
        this.numeroDeCuenta = cuenta;
        this.concepto = concepto;
		this.id = Utileria.generarId();
        this.fecha = Utileria.generarFecha();
    }
}