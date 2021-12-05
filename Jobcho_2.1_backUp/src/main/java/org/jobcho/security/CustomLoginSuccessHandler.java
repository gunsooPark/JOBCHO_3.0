package org.jobcho.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		
		
		log.warn("Login Success");

		List<String> roleNames = new ArrayList<>();

		auth.getAuthorities().forEach(authority -> {

			roleNames.add(authority.getAuthority());

		});

		log.warn("ROLE NAMES: " + roleNames);

		//권한이 member일 경우 -> 이번프로젝트는 권한을 한가지로 할 예정 ㅇ
		if (roleNames.contains("member")) {

			response.sendRedirect("/team/choose");
			return;
		}

		if (roleNames.contains("ROLE_MEMBER")) {
		
			response.sendRedirect("/team/choose");
			return;
		}

		response.sendRedirect("/");
	}
}


