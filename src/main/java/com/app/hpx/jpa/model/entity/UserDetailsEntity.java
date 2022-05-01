package com.app.hpx.jpa.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserDetailsEntity {

	@Id
	private Long userUuid;

	@Column(unique = true, length = 32)
	private String userKey;

	@Column(unique = true, length = 32)
	private String userName;
	private String firstName;
	private String lastName;

	@Column(nullable = false)
	private boolean userEnabled;

	private LocalDateTime createdDateTime;
	private LocalDateTime updatedDateTime;

	public Long getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(Long userUuid) {
		this.userUuid = userUuid;
	}

	public String getUserKey() {
		return userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isUserEnabled() {
		return userEnabled;
	}

	public void setUserEnabled(boolean userEnabled) {
		this.userEnabled = userEnabled;
	}

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public LocalDateTime getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	@Override
	public String toString() {
		return "UserDetailsEntity{" +
				"userUuid=" + userUuid +
				", userKey='" + userKey + '\'' +
				", userName='" + userName + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", userEnabled=" + userEnabled +
				", createdDateTime=" + createdDateTime +
				", updatedDateTime=" + updatedDateTime +
				'}';
	}
}