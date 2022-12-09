package com.abrahamxts.bank.services;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

import com.abrahamxts.bank.models.*;
import com.abrahamxts.bank.repositories.*;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public ClienteModel getClienteByToken(String token) {
		
		return clienteRepository.findByToken(token).orElse(null);
	}
}
