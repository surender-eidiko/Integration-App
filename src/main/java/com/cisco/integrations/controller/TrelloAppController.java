package com.cisco.integrations.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cisco.integrations.model.TrelloAppBean;
import com.google.gson.Gson;

@Controller
public class TrelloAppController {

	@RequestMapping(value="/trello/config")
	public String displayForm(Model model){
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
		
		Map<String, String> roomsMap = new LinkedHashMap<String,String>();
		Map<String,String> boards = new HashMap<String,String>();
		roomsMap.put("room1", "room1");
		roomsMap.put("room2", "room2");
		roomsMap.put("room3", "room3");
		
		boards.put("board1", "board1");
		boards.put("board2", "board2");
		boards.put("board3", "board3");
		
		TrelloAppBean trelloAppBean = new TrelloAppBean();
		model.addAttribute("trelloAppBean", trelloAppBean);
		model.addAttribute("boardNotifications",boardNotifications);
		model.addAttribute("cardNotifications",cardNotifications);
		model.addAttribute("checklistNotifications",checklistNotifications);
		model.addAttribute("roomsList",roomsMap);
		model.addAttribute("boards", boards);
		return "trelloConfig";
	}
	@RequestMapping(value="/trello/saveconfig")
	public String displayTrelloPage(@Valid TrelloAppBean trelloAppBean,BindingResult result, Model model){
		JSONObject jsonObject = new JSONObject(trelloAppBean);
		model.addAttribute("jsonData", jsonObject.toString());
		return "success";
	}
	
}
