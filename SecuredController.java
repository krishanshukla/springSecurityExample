package com.nets.springSecurity.controller;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nets")
public class SecuredController {
	@GetMapping(value = "/audit")

	public String audityLogin(Authentication authentication) {

		String name = "";

		String username = authentication.getName();
		/*
		 * UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		 * System.out.println("User has authorities: " + userDetails.getAuthorities());
		 */

		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder
				.getContext().getAuthentication().getAuthorities();
		System.out.println("User has authorities: " + username);

		for (SimpleGrantedAuthority auth : authorities) {
			name = name + " " + auth.getAuthority();

		}
		return "Logged user name is::" + " " + username + " " + "and " + "Logged user role is::" + name;

	}

}
