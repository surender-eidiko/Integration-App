package com.cisco.integrations.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cisco.integrations.service.CiscoMuleService;

@Controller
public class CiscoMuleProjectController {
	
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
	
	@RequestMapping(value={"/bitbucketcallback"})
	public String oauthResp(Model model, HttpServletRequest request, HttpServletResponse response){
		logger.info("Got back request to bitbucketcallback");
		HttpSession session = request.getSession();
		session.getAttribute("integrationId");
		model.addAttribute("code",request.getParameter("code"));
		logger.info("recieved code : {}",request.getParameter("code"));
		model.addAttribute("integrationId", session.getAttribute("integrationId"));
		return "callBack";
	}
	
	@RequestMapping(value={"/bitbucket"})
	public String bitBucketLogin(Model model, HttpServletRequest request, HttpServletResponse response){
		logger.info("going to hit bitbucket ");
		String integrationId = request.getParameter("integrationId");
		String sparkId = request.getParameter("sparkId");
		HttpSession session = request.getSession();
		session.setAttribute("integrationId", integrationId);
		session.setAttribute("sparkId", sparkId);
		try{
		OAuthClientRequest request1 = OAuthClientRequest
				   .authorizationLocation("https://bitbucket.org/site/oauth2/authorize")
				   .setClientId("2jSJzgNghgvKMzQ8Hc")
				   .buildQueryMessage();
		String req = request1.getLocationUri()+"&response_type=code";
		
		model.addAttribute("redirectURL", req);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "loginBitBucket";
	}
	
	@RequestMapping(value={"/bitbucket/add"})
	public String addBitBucket(Model model, HttpServletRequest request, HttpServletResponse response){
		logger.info("going to hit bitbucket ");
		String integrationId = request.getParameter("integrationId");
		String sparkId = request.getParameter("sparkId");
		HttpSession session = request.getSession();
		session.setAttribute("integrationId", integrationId);
		session.setAttribute("sparkId", sparkId);
		try{
		OAuthClientRequest request1 = OAuthClientRequest
				   .authorizationLocation("https://bitbucket.org/site/oauth2/authorize")
				   .setClientId("2jSJzgNghgvKMzQ8Hc")
				   .buildQueryMessage();
		String req = request1.getLocationUri()+"&response_type=code";
		
		model.addAttribute("redirectURL", req);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "loginBitBucket";
	}

}
