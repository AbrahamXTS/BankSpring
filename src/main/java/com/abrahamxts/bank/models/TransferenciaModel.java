package com.abrahamxts.bank.models;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Transferencia")
@EqualsAndHashCode(callSuper = false)
public class TransferenciaModel extends TransaccionModel {
    
	@Column(name = "Destino", nullable = false)
    private Integer destino;

	public TransferenciaModel(CuentaModel cuenta, Integer destino, double monto, String concepto) {
        super(monto, cuenta, concepto);
        this.destino = destino;
    }
}
