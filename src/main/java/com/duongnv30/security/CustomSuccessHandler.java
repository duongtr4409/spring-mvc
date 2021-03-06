package com.duongnv30.security;

import java.io.IOException;
import java.util.List;

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
			throws IOException {
		String targerUrl = determineTargetUrl(authentication);
		if(response.isCommitted()) {
			return;
		}
		
		
		redirectStrategy.sendRedirect(request, response, targerUrl);
	}

	private String determineTargetUrl(Authentication authentication) {
		String url = "";
		List<String> roles = SecurityUtils.getAuthorities();
		if(isAdmin(roles)) {
			url = "/admin-home";
		}else if(isUser(roles)) {
			url = "/trang-chu";
		}
		return url;
	}
	
	private boolean isAdmin(List<String> roles) {
		if(roles != null) {
			if(roles.contains("ADMIN")) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isUser(List<String> roles) {
		if(roles != null) {
			if(roles.contains("USER")) {
				return true;
			}
		}
		return false;
	}
}
