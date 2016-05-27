package com.cisco.integrations.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cisco.integrations.model.GitHubAppBean;

@Controller
public class GitHubAppController {
	@RequestMapping(value="/git/config")
	public String bitbucketPage(Model model, HttpServletRequest request){

		GitHubAppBean gitAppBean = new GitHubAppBean();
		model.addAttribute("gitAppBean",gitAppBean);
		Map<String,String> repos = new HashMap<String,String>();
		repos.put("repo1","repo 1");
		repos.put("repo2","repo 2");
		repos.put("repo3","repo 3");
		
		Map<String, String> roomsMap = new LinkedHashMap<String,String>();
		roomsMap.put("room01", "Room 01");
		roomsMap.put("room02", "Room 02");
		roomsMap.put("room03", "Room 03");
		
		List<String> commitEvents = new ArrayList<String>();
		commitEvents.add("Commits pushed to the repository");
		commitEvents.add("New comment on commit");
		
		List<String> issueOrPullReqEvents = new ArrayList<String>();
		issueOrPullReqEvents.add("Pull request opened or closed");
		issueOrPullReqEvents.add("Issues opened or closed");
		issueOrPullReqEvents.add("New comment on issue or pull request");
		issueOrPullReqEvents.add("Only show titles of new issues and pull requests");
		
		List<String> otherEvents = new ArrayList<String>();
		otherEvents.add("Branch or tag created or deleted");
		otherEvents.add("Branch force-pushed");
		
		model.addAttribute("repos",repos);
		model.addAttribute("roomsList", roomsMap);
		model.addAttribute("commitEvents",commitEvents);
		model.addAttribute("issueOrPullReqEvents",issueOrPullReqEvents);
		model.addAttribute("otherEvents",otherEvents);
		
		return "gitHubConfig";
	}
	@RequestMapping(value="/git/saveconfig")
	public String gitHubConfig(@Valid GitHubAppBean gitAppBean, BindingResult result, Model model){
		JSONObject jsonObject = new JSONObject(gitAppBean);
		model.addAttribute("jsonData", jsonObject.toString());
		return "success";
	}
}
