package com.app.hpx.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.hpx.jpa.model.entity.UserDetailsEntity;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetailsEntity, Long> {
	UserDetailsEntity findByUserKey(String userKey);
	void deleteByUserKey(String userKey);
}