package com.cisco.integrations.model;

public class JenkinsAppBean extends CommonBean{
	
private String channelName;
	
	private String webhookURL;
	
	private String token;
	
	private String description;
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	

}
