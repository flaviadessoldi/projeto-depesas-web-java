package br.com.igordev.despesas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;

public class LoginController {
	
	@RequestMapping("logout")
	 public String logout(HttpSession session) {
	 session.invalidate();
	 return "redirect:loginForm";
	 }


}
