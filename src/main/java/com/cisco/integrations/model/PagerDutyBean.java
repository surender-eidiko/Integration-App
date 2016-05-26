package com.cisco.integrations.model;

import java.util.List;

public class PagerDutyBean extends CommonBean{
	
	private List<String> incidents;
	
	private String channelName;
	
	private String webhookURL;
	
	private String description;

	public List<String> getIncidents() {
		return incidents;
	}

	public void setIncidents(List<String> incidents) {
		this.incidents = incidents;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getWebhookURL() {
		return webhookURL;
	}

	public void setWebhookURL(String webhookURL) {
		this.webhookURL = webhookURL;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
