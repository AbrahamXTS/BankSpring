package com.abrahamxts.bank.services;

import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

import com.abrahamxts.bank.models.*;
import com.abrahamxts.bank.repositories.*;
import com.abrahamxts.bank.utils.WrapperRespuesta;

@Service
public class TransaccionService {

	@Autowired
	CuentaRepository cuentaRepository;

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

	public WrapperRespuesta<Boolean> deposito(int numeroDeCuenta, double monto) {

		CuentaModel cuenta = cuentaRepository.findByNumeroDeCuenta(numeroDeCuenta);

		cuenta.setSaldo(cuenta.getSaldo() + monto);

		cuentaRepository.save(cuenta);
		depositoRepository.save(new DepositoModel(cuenta, monto, "Deposito"));

        return new WrapperRespuesta<Boolean>(true, "Deposito realizado correctamente", null);
    }

	public WrapperRespuesta<Boolean> retiro(int numeroDeCuenta, double monto) {

		CuentaModel cuenta = cuentaRepository.findByNumeroDeCuenta(numeroDeCuenta);

		if (monto > cuenta.getSaldo()) {
			retiroRepository.save(new RetiroModel(cuenta, monto, "Retiro rechazado por saldo insuficiente"));
			return new WrapperRespuesta<Boolean>(false, "Retiro rechazado por saldo insuficiente", null);
		}

		cuenta.setSaldo(cuenta.getSaldo() - monto);

		cuentaRepository.save(cuenta);
		retiroRepository.save(new RetiroModel(cuenta, monto, "Retiro"));

        return new WrapperRespuesta<Boolean>(true, "Retiro realizado correctamente", null);
	}

	public WrapperRespuesta<Boolean> transferencia(int numeroDeCuenta, int destino, double monto, String concepto) {

		CuentaModel cuenta = cuentaRepository.findByNumeroDeCuenta(numeroDeCuenta);
		CuentaModel cuentaDestino = cuentaRepository.findByNumeroDeCuenta(destino);

		if (monto > cuenta.getSaldo()) {
			transferenciaRepository.save(new TransferenciaModel(cuenta, destino, monto, "Transferencia rechazada por saldo insuficiente"));
			return new WrapperRespuesta<Boolean>(false, "Transferencia a " + destino + " rechazada por saldo insuficiente", null);
		}

		if (cuentaDestino == null) {
			transferenciaRepository.save(new TransferenciaModel(cuenta, destino, monto, "Transferencia rechazada por cuenta destino inexistente"));
			return new WrapperRespuesta<Boolean>(false, "Transferencia a " + destino + " rechazada por cuenta destino inexistente", null);
		}

		// Actualizando los saldos
		cuenta.setSaldo(cuenta.getSaldo() - monto);
		cuentaDestino.setSaldo(cuentaDestino.getSaldo() + monto);
		
		cuentaRepository.save(cuenta);
		cuentaRepository.save(cuentaDestino);

		// Registrando las transferencias correctas
		depositoRepository.save(new DepositoModel(cuentaDestino, monto, "Transferencia recibida de " + cuenta.getClienteId().getNombre() + " " + cuenta.getClienteId().getApellido() + " por " + concepto.toLowerCase()));
		transferenciaRepository.save(new TransferenciaModel(cuenta, destino, monto, "Transferencia a " + cuentaDestino.getClienteId().getNombre() + " " + cuentaDestino.getClienteId().getApellido() + " por " + concepto.toLowerCase()));

        return new WrapperRespuesta<Boolean>(true, "Transferencia realizada correctamente.", null);
	}
}
