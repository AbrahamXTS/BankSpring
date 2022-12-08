package com.abrahamxts.bank.repositories;

import com.abrahamxts.bank.models.*;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<CuentaModel, Integer> {

	public List<CuentaModel> findAllByClienteId(ClienteModel cliente);
}
