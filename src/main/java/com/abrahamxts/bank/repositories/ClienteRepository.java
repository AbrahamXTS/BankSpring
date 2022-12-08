package com.abrahamxts.bank.repositories;

import java.util.Optional;
import com.abrahamxts.bank.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {

	public Optional<ClienteModel> findByCURP(String CURP);
	
	public Optional<ClienteModel> findByToken(String token);
}
