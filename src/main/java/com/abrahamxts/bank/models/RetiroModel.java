package com.abrahamxts.bank.models;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Retiro")
@EqualsAndHashCode(callSuper = false)
public class RetiroModel extends TransaccionModel {

    public RetiroModel(CuentaModel cuenta, double monto) {
        super(monto, cuenta, "Retiro");
    }
}
