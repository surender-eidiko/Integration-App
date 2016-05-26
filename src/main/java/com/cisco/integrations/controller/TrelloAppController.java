package com.cisco.integrations.controller;

import java.util.ArrayList;
import java.util.HashMap;
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
		List<String> notifications = new ArrayList<String>();
		notifications.add("List Created");
		notifications.add("List Renamed");
		notifications.add("List Moved to other Board");
		notifications.add("Board renamed");
		
		Map<String,String> boards = new HashMap<String,String>();
		boards.put("board1", "board1");
		boards.put("board2", "board2");
		boards.put("board3", "board3");
		
		TrelloAppBean trelloAppBean = new TrelloAppBean();
		model.addAttribute("trelloAppBean", trelloAppBean);
		model.addAttribute("boardNotifications",notifications);
		model.addAttribute("boards", boards);
		return "trelloDisplayPage";
	}
	@RequestMapping(value="/trello/saveconfig")
	public String displayTrelloPage(@Valid TrelloAppBean trelloAppBean,BindingResult result, Model model){
		model.addAttribute("jsonData", new Gson().toJson(trelloAppBean));
		
		return "success";
	}
	
	
}
