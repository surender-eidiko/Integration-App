package com.cisco.integrations.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
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

import com.cisco.integrations.bean.BitbucketDetails;
import com.cisco.integrations.bean.BitbucketDetailsPojo;
import com.cisco.integrations.bean.Repos;
import com.cisco.integrations.bean.Rooms;
import com.cisco.integrations.service.CiscoMuleService;
import com.google.gson.Gson;

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
	
	@RequestMapping(value={"/bitbucket/callback"})
	public String oauthResp(Model model, HttpServletRequest request, HttpServletResponse response){

		logger.info("Got back request to bitbucketcallback");
		HttpSession session = request.getSession();
		String accessToken = "";
		try{
			HttpGet httpGet = new HttpGet("http://192.168.1.219:8855/invoke?code="+request.getParameter("code"));
			httpGet.setHeader("Content-Type", "application/x-www-form-urlencoded");
			HttpEntity entity = new DefaultHttpClient().execute(httpGet).getEntity();
			if (entity != null) {
					InputStream instream = entity.getContent();
					BufferedReader reader = new BufferedReader(new InputStreamReader(instream));
					String resp = reader.readLine();
					System.out.println("Reponse :"+resp);
					JSONObject jsonObj = new JSONObject(resp);
					logger.info("reponse from mule app : {}",jsonObj.toString());
					accessToken = jsonObj.get("access_token").toString();
					logger.info("Recieved access token : {}",accessToken);
				}
			}catch(Exception e){e.printStackTrace();logger.error(e.getMessage(),e);}
		
		model.addAttribute("accessToken",accessToken);		
		
		model.addAttribute("integrationId", request.getAttribute("integrationId"));
		return "accessToken";
	}
	
	
	@RequestMapping(value="/bitbucket/page")
	public String bitbucketPage(Model model, HttpServletRequest request){
		//HttpSession session = request.getSession();
		//session.getAttribute("integrationId");
		//System.out.println("Got IntegrsationId from request parameter!");
		//model.addAttribute("code",request.getParameter("code"));
				
		
		//String bitbucketAccessToken;
		//String sparkAccessToken= "YzRiNGFkNzctYjNjYi00Y2E3LTlhNTMtZjAzZTVlNDhmNDJkZDEzN2ViMjUtMThi";
		String bitbucketDetailsResponse = "{\"rooms\": [{\"id\": \"101\",\"title\": \"title1\"}, {\"id\": \"102\",\"title\": \"title2\"	}],\"repos\": [{		\"id\": \"repo101\",\"name\": \"reponame\"	}, {\"id\": \"repo102\",\"name\":\"reponame\"}],\"tokendetails\": {\"detail1\": \"detail1\",	\"detail2\": \"detail2\"	}}";
		JSONObject json = new JSONObject(bitbucketDetailsResponse);
		Gson gson = new Gson();
		BitbucketDetails details = new BitbucketDetails();
		
		model.addAttribute("details",details);
		BitbucketDetailsPojo bitbucketDetails = gson.fromJson(json.toString(), BitbucketDetailsPojo.class);
		//Map<String, Map<String, String>> referenceData = new HashMap();
		Map<String, String> roomsMap = new LinkedHashMap<String,String>();
		
		Map<String, String> reposMap = new LinkedHashMap<String, String>();
		
		Rooms[] rooms =bitbucketDetails.getRooms();
		for(Rooms r : rooms){
			roomsMap.put(r.getId(), r.getTitle());
		}
		logger.info("Repos...");
		Repos[] repos = bitbucketDetails.getRepos();
		for(Repos r : repos){
			reposMap.put(r.getId(), r.getName());
		}
		

		model.addAttribute("roomsList",roomsMap);
		model.addAttribute("reposList",reposMap);
		//getRooms(request);
		
		model.addAttribute("bitbucketDetailsResponse", bitbucketDetailsResponse);
		return "bitbucketDetails";
	}
	
	
	@RequestMapping(value={"/bitbucket/formprocess"}, method = RequestMethod.POST)
	public String bitbucketFormProcess(@Validated @ModelAttribute BitbucketDetails details, BindingResult result){
		
		//model.addAttribute("success", "sucess");
		
		return "bitbucketIntegrationSucess";
	}
	
	/*private void getAccessToken(HttpServletRequest request){
		try{
			HttpGet httpGet = new HttpGet("192.168.1.219:8855/invoke?code="+request.getParameter("code"));
			httpGet.setHeader("Content-Type", "application/x-www-form-urlencoded");
			HttpEntity entity = new DefaultHttpClient().execute(httpGet).getEntity();
			if (entity != null) {
				InputStream instream = entity.getContent();
				BufferedReader reader = new BufferedReader(new InputStreamReader(instream));
				String resp = reader.readLine();
				System.out.println("Reponse :"+resp);
				JSONObject jsonObj = new JSONObject(resp);
				jsonObj.get("accessToken");
				}
			}catch(Exception e){e.printStackTrace();logger.error(e.getMessage(),e);}
	}*/
	private void getRooms(HttpServletRequest request) {
		String roomId;
		String roomTitle;
		
		try{
			HttpGet httpGet = new HttpGet("http://192.168.1.216:8855/bitbucket/details");
			httpGet.setHeader("Content-Type", "application/x-www-form-urlencoded");
			HttpEntity entity = new DefaultHttpClient().execute(httpGet).getEntity();
			if (entity != null) {
				InputStream instream = entity.getContent();
				BufferedReader reader = new BufferedReader(new InputStreamReader(instream));
				//String bitbucketDetailsResponse = reader.readLine();
				String bitbucketDetailsResponse = "{\"rooms\": [{\"id\": \"101\",\"title\": \"title1\"}, {\"id\": \"101\",\"title\": \"title1\"	}],\"repos\": [{		\"id\": \"repo101\",\"name\": \"reponame\"	}, {\"id\": \"repo101\",\"name\":\"reponame\"}],\"tokendetails\": [{\"detail1\": \"detail1\",	\"detail2\": \"detail2\"	}, {		\"detail1\": \"detail1\",\"detail2\": \"detail2\"	}]}";
				
				
				System.out.println(bitbucketDetailsResponse);
				logger.info("Get Rooms Response : {}"+bitbucketDetailsResponse);
				JSONObject jsonObject = new JSONObject(bitbucketDetailsResponse);
				roomId = jsonObject.get("id").toString();
				roomTitle =jsonObject.get("title").toString(); 
				}
			}catch(Exception e){e.printStackTrace();logger.error(e.getMessage(),e);}
	}
	
	
	@RequestMapping(value={"/bitbucket/code"})
	public String bitBucketLogin(Model model, HttpServletRequest request, HttpServletResponse response){
		//logger.info("going to hit bitbucket ");
		String integrationId = request.getParameter("integrationId");
		String sparkId = request.getParameter("sparkId");
		HttpSession session = request.getSession();
		session.setAttribute("integrationId", integrationId);
		session.setAttribute("sparkId", sparkId);
		try{
		OAuthClientRequest request1 = OAuthClientRequest
				   .authorizationLocation("https://bitbucket.org/site/oauth2/authorize")
				   .setClientId("2jSJzgNghgvKMzQ8Hc")
				   //.setRedirectURI("http://183.82.99.100:1321/CiscoMuleProject/bitbucket/callback")
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
		
		return "loginBitBucket";
	}

}
