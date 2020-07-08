package com.in28minutes.rest.webservices.restfulwebservices.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

	static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

	static {
		// Use CreateNewUserPassword to generate the password

		inMemoryUserList.add(new JwtUserDetails(1L, "in28minutes",
				"$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", // dummy
				"ROLE_USER_2"));
		inMemoryUserList.add(new JwtUserDetails(1L, "jarrod.kallis@gmail.com",
				"$2a$10$cB/Yb37wPOvszgm0vn17bOpq.9DD/keiIBmMsq2cnOdqUnvh/eg3S", // password
				"ROLE_USER_2"));
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
				.filter(user -> user.getUsername().equals(username))
				.findFirst();

		if (!findFirst.isPresent()) {
			throw new UsernameNotFoundException(
					String.format("USER_NOT_FOUND '%s'.", username));
		}

		return findFirst.get();
	}

}
