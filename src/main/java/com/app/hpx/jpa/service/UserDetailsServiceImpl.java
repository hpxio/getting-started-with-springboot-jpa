package com.app.hpx.jpa.service;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.hpx.jpa.model.entity.UserDetailsEntity;
import com.app.hpx.jpa.model.request.UserDetailsRequest;
import com.app.hpx.jpa.model.response.UserDetailsResponse;
import com.app.hpx.jpa.repository.UserDetailsRepository;
import com.app.hpx.jpa.util.RandomDataGeneratorUtil;

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

	@Override
	public UserDetailsResponse displayUserDetails(String userKey) {
		UserDetailsResponse response = new UserDetailsResponse();

		/* TODO: Result can be null, implement Optional */
		UserDetailsEntity entity = userDetailsRepository.findByUserKey(userKey);

		BeanUtils.copyProperties(entity, response);
		return response;
	}

	/**
	 * Remove user-details such that if purge flag is set then
	 * execute a hard-delete else unset userEnabled flag. If the
	 * record is hard-deleted then copy the record to
	 * user-entity-history table.
	 *
	 * @param userKey public-domain identifier for user-details
	 * @param purge   flag when set, would mean a hard-delete
	 *
	 * @return user-details of the record deleted
	 */
	@Override
	@Transactional
	public UserDetailsResponse removeUserDetails(String userKey, boolean purge) {
		UserDetailsResponse response = new UserDetailsResponse();
		UserDetailsEntity entity = userDetailsRepository.findByUserKey(userKey);

		if (purge) {
			hardDeleteUserDetails(userKey);
		} else {
			softDeleteUserDetails(userKey);
		}

		BeanUtils.copyProperties(entity, response);
		return response;
	}

	private void hardDeleteUserDetails(String userKey) {
		userDetailsRepository.deleteByUserKey(userKey);
	}

	private void softDeleteUserDetails(String userKey) {
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