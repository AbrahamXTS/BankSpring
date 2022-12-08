package com.abrahamxts.bank.controllers;

import java.util.*;
import javax.servlet.http.*;
import org.springframework.ui.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.abrahamxts.bank.models.*;
import com.abrahamxts.bank.services.*;

@Controller
public class DashboardController {

	@Autowired
	ClienteService clienteService;

	@Autowired
	CuentaService cuentaService;

	@Autowired
	TransaccionService transaccionService;

	@GetMapping(value = "dashboard")
	public String cuentas(HttpServletRequest request, Model model) {

		ClienteModel cliente = clienteService.getClienteByToken(
			(String) request.getSession().getAttribute("token")
		);

		List<CuentaModel> cuentas = cuentaService.getAccountsByClient(cliente);

		request.getSession().setAttribute("cliente", cliente);
	
		model.addAttribute("cuentas", cuentas);
		return "cuentas";
	}

	@GetMapping(value = "movimientos")
	public String movimientos(HttpServletRequest request, Model model) {

		List<TransaccionModel> movimientos = new ArrayList<TransaccionModel>();

		List<CuentaModel> cuentas = cuentaService.getAccountsByClient(
			(ClienteModel) request.getSession().getAttribute("cliente")
		);

		for (CuentaModel cuenta : cuentas) {
			movimientos.addAll(
				transaccionService.getTransactionsByAccountNumber(cuenta)
			);
		}

		model.addAttribute("movimientos", movimientos);
		return "movimientos";
	}

	@GetMapping(value = "transacciones")
	public String transacciones(HttpServletRequest request, Model model) {

		return "transacciones";
	}

	@GetMapping(value = "transferencias")
	public String transferencias(HttpServletRequest request, Model model) {

		return "transferencias";
	}
}
