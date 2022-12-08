package com.abrahamxts.bank.controllers;

import org.springframework.ui.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

import javax.servlet.http.HttpServletRequest;

import com.abrahamxts.bank.models.ClienteModel;
import com.abrahamxts.bank.services.AutenticacionService;
import com.abrahamxts.bank.utils.WrapperRespuesta;

@Controller
class AutenticacionController {

	@Autowired
	AutenticacionService authService;

	@GetMapping({ "", "/", "login" })
	public String login() {
		return "login";
	}

	@PostMapping(value = "login")
	public String login(@RequestParam String curp, @RequestParam String contraseña, Model model, HttpServletRequest request) {
		
		WrapperRespuesta<ClienteModel> respuesta = authService.login(curp, contraseña);

		if (respuesta.getOk() == false) {
			model.addAttribute("error", respuesta.getMessage());
			return "login";
		}

		request.getSession().setAttribute("token", respuesta.getBody().getToken());
		return "redirect:/dashboard";
	}

	@PostMapping(value = "logout")
	public String logout(HttpServletRequest request) {

		authService.logout(
			(String) request.getSession().getAttribute("token")
		);

		request.getSession().removeAttribute("token");
		
		return "redirect:/login";
	}
}