package com.app.hpx.jpa.service;

import com.app.hpx.jpa.model.entity.UserDetailsEntity;
import com.app.hpx.jpa.model.request.UserDetailsRequest;
import com.app.hpx.jpa.model.response.UserDetailsResponse;
import com.app.hpx.jpa.repository.UserDetailsRepository;
import com.app.hpx.jpa.util.RandomDataGeneratorUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserDetailsRepository userDetailsRepository;

	@Autowired
	public UserDetailsServiceImpl(UserDetailsRepository userDetailsRepository) {
		this.userDetailsRepository = userDetailsRepository;
	}

	@Override
	public UserDetailsResponse createUserDetails(UserDetailsRequest request) {
		UserDetailsResponse response = new UserDetailsResponse();
		UserDetailsEntity entity = buildUserDetailsEntity(request);

		/* call persist and prepare response */
		BeanUtils.copyProperties(userDetailsRepository.save(entity), response);

		return response;
	}

	private UserDetailsEntity buildUserDetailsEntity(UserDetailsRequest request) {
		final UserDetailsEntity entity = new UserDetailsEntity();

		final Long userUuid = RandomDataGeneratorUtil.generateRandomUidKey();
		final String userKey = RandomDataGeneratorUtil.getRandomPlainTextKey();

		entity.setUserEnabled(true);

		entity.setUserKey(userKey);
		entity.setUserUuid(userUuid);

		entity.setCreatedDateTime(LocalDateTime.now());
		entity.setUpdatedDateTime(LocalDateTime.now());

		BeanUtils.copyProperties(request, entity);
		return entity;
	}
}