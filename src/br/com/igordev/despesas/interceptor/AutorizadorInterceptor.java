package br.com.igordev.despesas.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
	 @Override
	 public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	 throws Exception {
	 // liberar p�ginas e recursos que n�o necessitem de login
	 String uri = request.getRequestURI();

	 if (uri.endsWith("loginForm") || uri.endsWith("efetuaLogin") || uri.contains("resources")) {
	 return true;
	 }
	 if (request.getSession().getAttribute("usuarioLogado") != null) {
	 return true;
	 }
	 response.sendRedirect("loginForm");
	 return false;
	 }
	}
