package com.app.hpx.jpa.controller;

import com.app.hpx.jpa.model.request.UserDetailsRequest;
import com.app.hpx.jpa.model.response.UserDetailsResponse;
import com.app.hpx.jpa.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/v1/user")
public class UserDetailsController {

	private final UserDetailsService userDetailsService;

	@Autowired
	public UserDetailsController(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@PostMapping("/create")
	public UserDetailsResponse createUserDetailsController(@RequestBody UserDetailsRequest request) {
		return userDetailsService.createUserDetails(request);
	}
}