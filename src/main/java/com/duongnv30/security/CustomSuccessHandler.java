package com.duongnv30.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.duongnv30.util.SecurityUtils;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		String targetUrl = determineTargetUrl(authentication);
		if(response.isCommitted()) {
			return; 
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}
	
	private String determineTargetUrl(Authentication authentication) {
		String url = "";
		List<String> listRole = SecurityUtils.getAuthorities();
		if(isAdmin(listRole)) {
			url = "/admin-home";
		}else if(isUser(listRole)) {
			url = "/trang-chu";
		}else {
			url = "/login?Error";
		}
		return url;
	}
	
	private boolean isAdmin(List<String> listRole) {
		if(listRole != null && !listRole.isEmpty()) {
			if(listRole.contains("ADMIN")) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isUser(List<String> listRole) {
		if(listRole != null && !listRole.isEmpty()) {
			if(listRole.contains("USER")) {
				return true;
			}
		}
		return false;
	}
}
