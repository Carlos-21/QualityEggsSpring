package com.unmsm.fisi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginController {

	@GetMapping(value = { "/", "/login" })
    public String irLogin(@ModelAttribute("mensajeExcepcion") String mensajeExcepcion, Model model)
    {
        model.addAttribute("mensajeExcepcion", mensajeExcepcion);
        return "login";
    }
	
}
