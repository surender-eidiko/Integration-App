package com.cisco.integrations.bean;

public class BitbucketDetailsPojo {
	
	Rooms[] rooms;
	
	Repos[] repos;
	
	TokenDetails tokenDetails;

	public Rooms[] getRooms() {
		return rooms;
	}

	public void setRooms(Rooms[] rooms) {
		this.rooms = rooms;
	}

	public Repos[] getRepos() {
		return repos;
	}

	public void setRepos(Repos[] repos) {
		this.repos = repos;
	}

	public TokenDetails getTokenDetails() {
		return tokenDetails;
	}

	public void setTokenDetails(TokenDetails tokenDetails) {
		this.tokenDetails = tokenDetails;
	}
	
	
	

}
