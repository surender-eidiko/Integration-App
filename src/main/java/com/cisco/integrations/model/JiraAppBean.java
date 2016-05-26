package com.cisco.integrations.model;

import java.util.List;

public class JiraAppBean extends CommonBean {
	
	private String projectId;
	private List<EventsActionBean> notifications;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public List<EventsActionBean> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<EventsActionBean> notifications) {
		this.notifications = notifications;
	}



}
