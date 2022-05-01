package com.app.hpx.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.hpx.jpa.model.entity.UserDetailsEntity;
import com.app.hpx.jpa.model.request.UserDetailsRequest;
import com.app.hpx.jpa.model.response.UserDetailsResponse;
import com.app.hpx.jpa.service.UserDetailsService;

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

	@GetMapping
	public UserDetailsResponse displayUserDetailsController(@RequestParam String userKey) {
		return userDetailsService.displayUserDetails(userKey);
	}

	@DeleteMapping
	public UserDetailsResponse removeUserDetailsController(@RequestParam String userKey,
																												 @RequestParam(required = false) boolean purge) {
		return userDetailsService.removeUserDetails(userKey, purge);
	}
}