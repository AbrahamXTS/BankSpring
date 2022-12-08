package com.abrahamxts.bank.models;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name = "Retiro")
@EqualsAndHashCode(callSuper = true)
public class RetiroModel extends TransaccionModel {

    public RetiroModel(CuentaModel cuenta, double monto) {
        super(monto, cuenta, "Retiro");
    }
}
