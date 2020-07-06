package com.in28minutes.rest.webservices.restfulwebservices.basic.auth;

public class AuthenticationModel {

	private String username;
	private String password;
	private boolean authenticated;

	public AuthenticationModel() {
		super();
	}

	public AuthenticationModel(boolean authenticated) {
		super();
		this.authenticated = authenticated;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}
}
