package com.abrahamxts.bank.repositories;

import java.util.*;
import org.springframework.data.jpa.repository.*;

import com.abrahamxts.bank.models.*;

public interface CuentaRepository extends JpaRepository<CuentaModel, Integer> {

	public List<CuentaModel> findAllByClienteId(ClienteModel cliente);
}
