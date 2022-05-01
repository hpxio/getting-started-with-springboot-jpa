package com.app.hpx.jpa.service;

import com.app.hpx.jpa.model.request.UserDetailsRequest;
import com.app.hpx.jpa.model.response.UserDetailsResponse;

public interface UserDetailsService {
	UserDetailsResponse createUserDetails(UserDetailsRequest request);
	UserDetailsResponse removeUserDetails(String userKey, boolean purge);
	UserDetailsResponse displayUserDetails(String userKey);
}
