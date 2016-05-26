package com.cisco.integrations.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cisco.integrations.model.TrelloAppBean;

@Controller
public class TrelloController {

	@RequestMapping(value="/trello/page")
	public String displayForm(Model model){
		List<String> notifications = new ArrayList<String>();
		notifications.add("List Created");
		notifications.add("List Renamed");
		notifications.add("List Moved to other Board");
		notifications.add("Board renamed");
		TrelloAppBean trelloAppBean = new TrelloAppBean();
		model.addAttribute("trelloAppBean", trelloAppBean);
		model.addAttribute("boardNotifications",notifications);
		model.addAttribute("boardId", new String[]{"board1","board2"});
		return "trelloDisplayPage";
	}
	@RequestMapping(value="/trello/formprocess")
	public String displayTrelloPage(){
		
		return "trelloIntegrationSuccess";
	}
	
	
}
