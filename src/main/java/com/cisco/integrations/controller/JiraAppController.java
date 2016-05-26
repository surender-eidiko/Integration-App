package com.cisco.integrations.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cisco.integrations.model.JiraAppBean;
import com.google.gson.Gson;

@Controller
public class JiraAppController {
	
	
	@RequestMapping(value="/jira/config")
	public String bitbucketPage(Model model, HttpServletRequest request){

		JiraAppBean jiraAppBean = new JiraAppBean();
		
		model.addAttribute("jiraAppBean",jiraAppBean);
		Map<String, String> roomsMap = new LinkedHashMap<String,String>();
		Map<String, String> projectsMap = new LinkedHashMap<String, String>();

		roomsMap.put("room01", "Room 01");
		roomsMap.put("room02", "Room 02");
		roomsMap.put("room03", "Room 03");
		
		projectsMap.put("project01", "Project 01");
		projectsMap.put("project02", "Project 02");
		projectsMap.put("project03", "Project 03");
		

		model.addAttribute("roomsList",roomsMap);
		model.addAttribute("projectsList",projectsMap);

		return "jira";
	}
	
	@RequestMapping(value={"/jira/saveconfig"}, method = RequestMethod.POST)
	public String bitbucketFormProcess(Model model, @Validated @ModelAttribute JiraAppBean jiraAppBean, BindingResult result){
		
		String jiraIntegrationData = new Gson().toJson(jiraAppBean);
		model.addAttribute("jsonData", jiraIntegrationData);
		
		
		return "success";
	}

}
