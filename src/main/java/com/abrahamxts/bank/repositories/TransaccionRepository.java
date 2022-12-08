package com.abrahamxts.bank.repositories;

import java.util.*;
import org.springframework.data.jpa.repository.*;

import com.abrahamxts.bank.models.*;

public interface TransaccionRepository extends JpaRepository<TransaccionModel, String> {

	public List<TransaccionModel> findAllByNumeroDeCuenta(CuentaModel numeroDeCuenta);
}
