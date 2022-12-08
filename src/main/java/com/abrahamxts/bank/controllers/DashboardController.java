package com.abrahamxts.bank.controllers;

import java.util.*;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.abrahamxts.bank.models.ClienteModel;
import com.abrahamxts.bank.repositories.ClienteRepository;

import com.abrahamxts.bank.models.CuentaModel;
import com.abrahamxts.bank.repositories.CuentaRepository;

@Controller
public class DashboardController {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	CuentaRepository cuentaRepository;

	@GetMapping(value = "dashboard")
	public String dashboard(@ModelAttribute("token") String token, Model model) {

		Optional<ClienteModel> cliente = clienteRepository.findByToken(token);

		List<CuentaModel> cuentas = cuentaRepository.findAllByClienteId(cliente.get());

		model.addAttribute("token", token);
		model.addAttribute("cuentas", cuentas);
		model.addAttribute("cliente", cliente.get());
		return "dashboard";
	}
}
