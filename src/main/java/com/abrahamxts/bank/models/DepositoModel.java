package com.abrahamxts.bank.models;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Deposito")
@EqualsAndHashCode(callSuper = false)
public class DepositoModel extends TransaccionModel {

	public DepositoModel(CuentaModel cuenta, double monto, String concepto) {
        super(monto, cuenta, concepto);
    }
}
