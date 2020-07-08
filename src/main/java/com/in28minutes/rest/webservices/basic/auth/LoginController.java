package com.in28minutes.rest.webservices.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {

	@PostMapping(path = "/login")
	public AuthenticationModel login(
			@RequestBody AuthenticationModel credentials) {
		AuthenticationModel result = new AuthenticationModel();

		if (credentials.getUsername()
				.equalsIgnoreCase("jarrod.kallis@gmail.com")
				&& credentials.getPassword().equals("password")) {
			result.setAuthenticated(true);
		}

		return result;
	}
}
