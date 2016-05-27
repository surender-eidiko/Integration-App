package com.cisco.integrations.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cisco.integrations.model.BitbucketBean;
import com.cisco.integrations.model.JenkinsAppBean;
import com.cisco.integrations.service.CiscoMuleService;
import com.google.gson.Gson;

@Controller
public class JenkinsAppController {
	
	private static final Logger logger = LoggerFactory.getLogger(JenkinsAppController.class);
	
	private CiscoMuleService ciscoMuleService;
	

	public CiscoMuleService getCiscoMuleService() {
		return ciscoMuleService;
	}
	@Autowired(required=true)
	public void setCiscoMuleService(CiscoMuleService ciscoMuleService) {
		this.ciscoMuleService = ciscoMuleService;
	}
	
	@RequestMapping(value="/jenkins/config")
	public String bitbucketPage(Model model, HttpServletRequest request){
		//String bitbucketDetailsResponse = "{\"rooms\": [{\"id\": \"101\",\"title\": \"title1\"}, {\"id\": \"102\",\"title\": \"title2\"	}],\"repos\": [{		\"id\": \"repo101\",\"name\": \"reponame\"	}, {\"id\": \"repo102\",\"name\":\"reponame\"}],\"tokendetails\": {\"detail1\": \"detail1\",	\"detail2\": \"detail2\"	}}";
		//JSONObject json = new JSONObject(bitbucketDetailsResponse);
		//Gson gson = new Gson();
		JenkinsAppBean formBean = new JenkinsAppBean();
		model.addAttribute("formBean",formBean);
		Map<String,String> channelNames = new HashMap<String,String>();
		channelNames.put("Channel1","Channel 1");
		channelNames.put("Channel2","Channel 2");
		channelNames.put("Channel3","Channel 3");
		channelNames.put("Channel4","Channel 4");
		
		model.addAttribute("channelNames",channelNames);
		
		model.addAttribute("token",new String("cLYxzsiIEnDwlVNJ1lbyi5Qz"));
		
		model.addAttribute("description", new String(""));
		model.addAttribute("name", "Jenkins");
		return "jenkinsConfig";
	}
	
	
	@RequestMapping(value={"/jenkins/saveconfig"}, method = RequestMethod.POST)
	public String bitbucketFormProcess(@Validated @ModelAttribute JenkinsAppBean details, BindingResult result, Model model){
		
		model.addAttribute("jsonData", new Gson().toJson(details));
		
		return "success";
	}

}
