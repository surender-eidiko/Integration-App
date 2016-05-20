package com.cisco.integrations.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="BitbucketDetails")
public class BitbucketDetails {
	@Id
	@GeneratedValue
	@Column
	private String id;
	
	@Column
	private String sparkId;
	
	@Column
	private String refreshToken;
	
	@Column
	private String accessToken;
	
	@Column
	private Timestamp tokenExpireTime;
	
	@Column
	private Timestamp refreshExpireTime;
	
	@Column
	private Timestamp creationTime;
	
	@Column
	private Timestamp lastModifiedTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSparkId() {
		return sparkId;
	}

	public void setSparkId(String sparkId) {
		this.sparkId = sparkId;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Timestamp getTokenExpireTime() {
		return tokenExpireTime;
	}

	public void setTokenExpireTime(Timestamp tokenExpireTime) {
		this.tokenExpireTime = tokenExpireTime;
	}

	public Timestamp getRefreshExpireTime() {
		return refreshExpireTime;
	}

	public void setRefreshExpireTime(Timestamp refreshExpireTime) {
		this.refreshExpireTime = refreshExpireTime;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public Timestamp getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Timestamp lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

}
