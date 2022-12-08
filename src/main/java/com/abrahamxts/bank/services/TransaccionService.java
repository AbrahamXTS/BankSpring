package com.abrahamxts.bank.services;

import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

import com.abrahamxts.bank.models.*;
import com.abrahamxts.bank.repositories.*;

@Service
public class TransaccionService {

	@Autowired
	DepositoRepository depositoRepository;

	@Autowired
	RetiroRepository retiroRepository;

	@Autowired
	TransferenciaRepository transferenciaRepository;

	@Autowired
	TransaccionRepository transaccionRepository;

	public List<TransaccionModel> getTransactionsByAccountNumber(CuentaModel numeroDeCuenta) {	
		return transaccionRepository.findAllByNumeroDeCuenta(numeroDeCuenta);
	}
	
}
