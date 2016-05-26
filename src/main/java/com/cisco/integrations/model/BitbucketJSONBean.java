package com.cisco.integrations.model;

public class BitbucketJSONBean {
	
	Rooms[] rooms;
	
	Repos[] repos;
	
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
	

}
