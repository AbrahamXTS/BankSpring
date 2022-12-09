package com.abrahamxts.bank.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.*;

import com.abrahamxts.bank.services.TransaccionService;

@Controller
public class TransaccionController {

	@Autowired
	TransaccionService transaccionService;

	@PostMapping(value = "deposito")
	public String deposito(@RequestParam int numeroDeCuenta, @RequestParam double monto) {
		
		transaccionService.deposito(numeroDeCuenta, monto);

		return "redirect:/movimientos";
	}

	@PostMapping(value = "retiro")
	public String retiro(@RequestParam int numeroDeCuenta, @RequestParam double monto) {

		transaccionService.retiro(numeroDeCuenta, monto);

		return "redirect:/movimientos";
	}

	@PostMapping(value = "transferencia")
	public String transferencia(@RequestParam int numeroDeCuenta, @RequestParam int destino, @RequestParam double monto, @RequestParam String concepto) {

		transaccionService.transferencia(numeroDeCuenta, destino, monto, concepto);

		return "redirect:/movimientos";
	}
}
