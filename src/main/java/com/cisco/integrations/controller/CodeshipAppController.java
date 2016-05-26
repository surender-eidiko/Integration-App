package com.cisco.integrations.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cisco.integrations.model.CodeshipAppBean;
@Controller
public class CodeshipAppController {
	@RequestMapping(value="/codeship/config")
	public String displayForm(Model model){
		Map<String,String> projects = new HashMap<String, String>();
		projects.put("project1", "project1");
		projects.put("project2", "project2");
		projects.put("project3", "project3");
		CodeshipAppBean codeshipAppBean = new CodeshipAppBean();
		model.addAttribute("codeshipAppBean",codeshipAppBean);
		model.addAttribute("projects",projects);
		return "codeshipConfig";
	}
	@RequestMapping(value="/codeship/formprocess")
	public String displayTrelloPage(@Valid CodeshipAppBean codeshipAppBean, BindingResult result, Model model){
		JSONObject jsonObject = new JSONObject(codeshipAppBean);
		model.addAttribute("jsonData", jsonObject.toString());
		return "success";
	}

}
