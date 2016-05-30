package com.cisco.integrations.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cisco.integrations.model.TrelloAppBean;
import com.google.gson.Gson;

import antlr.collections.impl.Vector;

@Controller
public class TrelloAppController {

	@RequestMapping(value="/trello/home")
	public String redirect(){
		return "trelloHome";
	}
	@RequestMapping(value = { "/trello/code" })
	public String trelloLogin(Model model, HttpServletRequest request, HttpServletResponse response) {
		String integrationId = request.getParameter("integrationId");
		String sparkId = request.getParameter("sparkId");
		HttpSession session = request.getSession();
		session.setAttribute("integrationId", integrationId);
		session.setAttribute("sparkId", sparkId);
		try {
			OAuthClientRequest request1 = OAuthClientRequest
					.authorizationLocation(
							"https://trello.com/1/authorize?expiration=never&scope=read,write,account&response_type=token&name=Cisco%20Spark&key=ab7870583126b41b7c4b83710f5d5878&return_url=http://localhost:8080/CiscoMuleProject/trello/callback")
					.buildQueryMessage();
			String req = request1.getLocationUri();
			model.addAttribute("redirectURL", req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "loginBitBucket";
	}

	@RequestMapping(value = "/trello/callback")
	public String trelloCallback(Model model,HttpServletRequest request,HttpServletResponse response){
		/*System.out.println(request.getParameter("token"));
		Map vector = request.getParameterMap();
		System.out.println(vector.size());
			
		System.out.println(request.getRequestURL().toString()+" "+request.getQueryString()) ;
		System.out.println(request.getRequestURI().toString()+" "+request.getPathInfo());*/
		return "trelloAccessToken";
	}
	@RequestMapping(value = "/trello/config")
	public String displayForm(Model model) {
		List<String> boardNotifications = new ArrayList<String>();
		List<String> cardNotifications = new ArrayList<String>();
		List<String> checklistNotifications = new ArrayList<String>();
		boardNotifications.add("List Created");
		boardNotifications.add("List Renamed");
		boardNotifications.add("List Moved to other Board");
		boardNotifications.add("Board renamed");

		cardNotifications.add("Card Created");
		cardNotifications.add("Card Renamed");
		cardNotifications.add("Comment Added to Card");

		checklistNotifications.add("Card Created");
		checklistNotifications.add("Card Renamed");
		checklistNotifications.add("Card Moved");

		Map<String, String> roomsMap = new LinkedHashMap<String, String>();
		Map<String, String> boards = new HashMap<String, String>();
		roomsMap.put("room1", "room1");
		roomsMap.put("room2", "room2");
		roomsMap.put("room3", "room3");

		boards.put("board1", "board1");
		boards.put("board2", "board2");
		boards.put("board3", "board3");

		TrelloAppBean trelloAppBean = new TrelloAppBean();
		model.addAttribute("trelloAppBean", trelloAppBean);
		model.addAttribute("boardNotifications", boardNotifications);
		model.addAttribute("cardNotifications", cardNotifications);
		model.addAttribute("checklistNotifications", checklistNotifications);
		model.addAttribute("roomsList", roomsMap);
		model.addAttribute("boards", boards);
		
		return "trelloConfig";
	}
	@RequestMapping(value="/trello/editconfig")
	public String editConfig(Model model){
		String jsonData = "{\"boardId\":\"board3\",\"roomId\":\"room1\",\"displayName\":\"trello\",\"checkLists\":[\"Card Created\",\"Card Renamed\"],\"cardsNotifications\":[\"Card Created\",\"Comment Added to Card\"],\"boardsAndListNotifications\":[\"List Created\",\"Board renamed\"]}";
		TrelloAppBean trelloAppBean = new Gson().fromJson(jsonData, TrelloAppBean.class);
		model.addAttribute("trelloAppBean",trelloAppBean);
		return "trelloConfig";
	}
	@RequestMapping(value = "/trello/saveconfig")
	public String displayTrelloPage(@Valid TrelloAppBean trelloAppBean, BindingResult result, Model model) {
		JSONObject jsonObject = new JSONObject(trelloAppBean);
		model.addAttribute("jsonData", jsonObject.toString());
		return "success";
	}

}
