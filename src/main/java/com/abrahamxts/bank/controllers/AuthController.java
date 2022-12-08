package com.abrahamxts.bank.controllers;

import org.springframework.ui.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Autowired;

import com.abrahamxts.bank.models.ClienteModel;
import com.abrahamxts.bank.services.AuthService;
import com.abrahamxts.bank.utils.WrapperResponse;

@Controller
class AuthController {

	@Autowired
	AuthService authService;

	@GetMapping({ "", "/", "login" })
	public String login() {
		return "login";
	}

	@PostMapping(value = "login")
	public String login(@RequestParam String curp, @RequestParam String contraseña, Model model, RedirectAttributes redirectModel) {
		
		WrapperResponse<ClienteModel> respuesta = authService.login(curp, contraseña);

		if (respuesta.getOk() == false) {
			model.addAttribute("error", respuesta.getMessage());
			return "login";
		}

		redirectModel.addFlashAttribute("token", respuesta.getBody().getToken());
		return "redirect:/dashboard";
	}

	@PostMapping(value = "logout")
	public String logout(@RequestParam String token) {

		authService.logout(token);

		return "redirect:/login";
	}
}