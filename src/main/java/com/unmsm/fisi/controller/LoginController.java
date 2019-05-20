package com.unmsm.fisi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

	@GetMapping(value = { "/", "/login" })
    public String irLogin(@ModelAttribute("mensajeExcepcion") String mensajeExcepcion, Model model)
    {
        model.addAttribute("mensajeExcepcion", mensajeExcepcion);
        return "login";
    }
	
	@GetMapping(value = "/login", params = "error=true")
    public String irLoginConExcepcion(RedirectAttributes redirectAttribute,
            @RequestParam String mensajeExcepcion)
    {
        redirectAttribute.addFlashAttribute("mensajeExcepcion", mensajeExcepcion);
        return "redirect:/login";
    }
	
}
