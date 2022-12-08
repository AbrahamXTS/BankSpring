package com.abrahamxts.bank.services;

import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

import com.abrahamxts.bank.models.*;
import com.abrahamxts.bank.repositories.*;

@Service
public class CuentaService {
	
	@Autowired
	CuentaRepository cuentaRepository;

	public List<CuentaModel> getAccountsByClient(ClienteModel cliente) {

		return cuentaRepository.findAllByClienteId(cliente);
	}
}
