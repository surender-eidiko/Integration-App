package com.cisco.integrations.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cisco.integrations.model.PagerDutyBean;
import com.cisco.integrations.service.CiscoMuleService;

@Controller
public class PagerDutyController {
	
	private static final Logger logger = LoggerFactory.getLogger(CiscoMuleProjectController.class);
	
	private CiscoMuleService ciscoMuleService;
	
	public CiscoMuleService getCiscoMuleService() {
		return ciscoMuleService;
	}
	@Autowired(required=true)
	public void setCiscoMuleService(CiscoMuleService ciscoMuleService) {
		logger.info("settingCiscoMuleService");
		this.ciscoMuleService = ciscoMuleService;
	}
	
	
	@RequestMapping(value="/pagerduty/config")
	public String displayPage(Model model){
		PagerDutyBean pagerDutyConfigurationForm = new PagerDutyBean();
		model.addAttribute("pagerDutyConfigurationForm", pagerDutyConfigurationForm);
		
		List<String> incidents = new ArrayList<String>();
		incidents.add(" Newly triggered");
		incidents.add("Acknowledged");
		incidents.add("Unacknowledged due to timeout");
		incidents.add("Resolved");
		incidents.add("Manually reassinged");
		incidents.add("Escalated");
		incidents.add("Reassigned to another escalation chain");
		
		model.addAttribute("incidents",incidents);
		
		Map<String,String> channelNames = new HashMap<String,String>();
		channelNames.put("Channel1","Channel 1");
		channelNames.put("Channel2","Channel 2");
		channelNames.put("Channel3","Channel 3");
		channelNames.put("Channel4","Channel 4");
		
		model.addAttribute("channelNames",channelNames);
		
		model.addAttribute("webhookURL",new String("https://hooks.slack.com/services/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"));
		
		return "pagerdutyConfig";
		
		
	}
	
	@RequestMapping(value="/pagerduty/saveintegration")
	public String processPagerduty(@Valid PagerDutyBean pagerDutyBean, BindingResult result, Model model){
		JSONObject jsonObject = new JSONObject(pagerDutyBean);
		model.addAttribute("jsonData", jsonObject.toString());
		
		return "pagerdutySucess";
	}

}
