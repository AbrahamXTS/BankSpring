package com.abrahamxts.bank.repositories;

import java.util.*;
import org.springframework.data.jpa.repository.*;

import com.abrahamxts.bank.models.ClienteModel;

public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {

	public Optional<ClienteModel> findByCURP(String CURP);
	
	public Optional<ClienteModel> findByToken(String token);
}
