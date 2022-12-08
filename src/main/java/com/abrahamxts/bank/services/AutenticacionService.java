package com.abrahamxts.bank.services;

import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.abrahamxts.bank.utils.*;
import com.abrahamxts.bank.models.ClienteModel;
import com.abrahamxts.bank.repositories.ClienteRepository;

@Service
public class AutenticacionService {

	@Autowired
	ClienteRepository clienteRepository;

	public WrapperRespuesta<ClienteModel> login(String curp, String contraseña) {

		Optional<ClienteModel> cliente = clienteRepository.findByCURP(curp);

		if (cliente.isEmpty()) {
			return new WrapperRespuesta<ClienteModel>(false, "El usuario requerido no existe.", null);
		}

		if (!(cliente.get().getContraseña().equals(contraseña))) {
			return new WrapperRespuesta<ClienteModel>(false, "Error de autenticación, esto se debe a un error en sus credenciales.", null);
		}

		cliente.get().setToken(Utileria.generarId()); 

		clienteRepository.save(cliente.get());

		return new WrapperRespuesta<ClienteModel>(true, "Inicio de sesión correcto.", cliente.get());
	}

	public WrapperRespuesta<Boolean> logout(String token) {

		Optional<ClienteModel> cliente = clienteRepository.findByToken(token);

		if (cliente.isEmpty()) {
			return new WrapperRespuesta<Boolean>(false, "Error cerrando la sesión.", null);
		}

		cliente.get().setToken(null);

		clienteRepository.save(cliente.get());

		return new WrapperRespuesta<Boolean>(true, "Cierre de sesión correcto", null);
	}
}
