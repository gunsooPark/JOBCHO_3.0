package org.jobcho.domain;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
public class AuthVO implements Serializable, GrantedAuthority{
	private String user_email;
	private String auth;
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return auth;
	}
	
}
