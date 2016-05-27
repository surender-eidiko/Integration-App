package com.cisco.integrations.model;

public class GitHubAppBean extends CommonBean{
	
	private String[] repositories;
	private String[] commitEvents;
	private String[] issueOrPullReqEvents;
	private String deployEvents;
	private String[] otherEvents;
	public String[] getCommitEvents() {
		return commitEvents;
	}
	public void setCommitEvents(String[] commitEvents) {
		this.commitEvents = commitEvents;
	}
	public String[] getRepositories() {
		return repositories;
	}
	public void setRepositories(String[] repositories) {
		this.repositories = repositories;
	}
	public String[] getIssueOrPullReqEvents() {
		return issueOrPullReqEvents;
	}
	public void setIssueOrPullReqEvents(String[] issueOrPullReqEvents) {
		this.issueOrPullReqEvents = issueOrPullReqEvents;
	}
	public String getDeployEvents() {
		return deployEvents;
	}
	public void setDeployEvents(String deployEvents) {
		this.deployEvents = deployEvents;
	}
	public String[] getOtherEvents() {
		return otherEvents;
	}
	public void setOtherEvents(String[] otherEvents) {
		this.otherEvents = otherEvents;
	}
	
	
	
}
