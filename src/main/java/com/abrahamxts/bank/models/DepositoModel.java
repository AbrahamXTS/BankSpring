package com.abrahamxts.bank.models;

import lombok.*;
import javax.persistence.*;


@Data
@Entity
@Table(name = "Deposito")
@EqualsAndHashCode(callSuper = true)
public class DepositoModel extends TransaccionModel {

	public DepositoModel(CuentaModel cuenta, double monto) {
        super(monto, cuenta, "Deposito");
    }
}
