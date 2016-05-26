package com.cisco.integrations.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
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

import com.cisco.integrations.model.BitbucketBean;
import com.cisco.integrations.service.CiscoMuleService;
import com.google.gson.Gson;

@Controller
public class BitbucketAppController {
	
	private static final Logger logger = LoggerFactory.getLogger(BitbucketAppController.class);
	
	private CiscoMuleService ciscoMuleService;
	

	public CiscoMuleService getCiscoMuleService() {
		return ciscoMuleService;
	}
	@Autowired(required=true)
	public void setCiscoMuleService(CiscoMuleService ciscoMuleService) {
		logger.info("settingCiscoMuleService");
		this.ciscoMuleService = ciscoMuleService;
	}
	
	@RequestMapping(value={"/bitbucket/code"})
	public String bitBucketLogin(Model model, HttpServletRequest request, HttpServletResponse response){
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
	
	@RequestMapping(value={"/bitbucket/callback"})
	public String oauthResp(Model model, HttpServletRequest request, HttpServletResponse response){

		logger.info("Got back request to bitbucketcallback");
		//HttpSession session = request.getSession();
		String accessToken = "";
		try{
			HttpGet httpGet = new HttpGet("http://192.168.1.219:8855/invoke?code="+request.getParameter("code"));
			httpGet.setHeader("Content-Type", "application/x-www-form-urlencoded");
			HttpClient client = HttpClientBuilder.create().build();
			HttpEntity entity = client.execute(httpGet).getEntity();
			
			//HttpEntity entity = new DefaultHttpClient().execute(httpGet).getEntity();
			if (entity != null) {
					InputStream instream = entity.getContent();
					BufferedReader reader = new BufferedReader(new InputStreamReader(instream));
					String resp = reader.readLine();
					System.out.println("Reponse :"+resp);
					JSONObject jsonObj = new JSONObject(resp);
					//logger.info("reponse from mule app : {}",jsonObj.toString());
					accessToken = jsonObj.get("access_token").toString();
					logger.info("Recieved access token : {}",accessToken);
				}
			}catch(Exception e){e.printStackTrace();logger.error(e.getMessage(),e);}
		
		model.addAttribute("accessToken",accessToken);		
		
		model.addAttribute("integrationId", request.getAttribute("integrationId"));
		return "accessToken";
	}
	
	
	@RequestMapping(value="/bitbucket/config")
	public String bitbucketPage(Model model, HttpServletRequest request){
		//String bitbucketDetailsResponse = "{\"rooms\": [{\"id\": \"101\",\"title\": \"title1\"}, {\"id\": \"102\",\"title\": \"title2\"	}],\"repos\": [{		\"id\": \"repo101\",\"name\": \"reponame\"	}, {\"id\": \"repo102\",\"name\":\"reponame\"}],\"tokendetails\": {\"detail1\": \"detail1\",	\"detail2\": \"detail2\"	}}";
		//JSONObject json = new JSONObject(bitbucketDetailsResponse);
		//Gson gson = new Gson();
		BitbucketBean formBean = new BitbucketBean();
		model.addAttribute("formBean",formBean);
		Map<String,String> channelNames = new HashMap<String,String>();
		channelNames.put("Channel1","Channel 1");
		channelNames.put("Channel2","Channel 2");
		channelNames.put("Channel3","Channel 3");
		channelNames.put("Channel4","Channel 4");
		
		model.addAttribute("channelNames",channelNames);
		
		model.addAttribute("webhookURL",new String("https://hooks.slack.com/services/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"));
		
		return "bitbucketConfig";
	}
	
	
	@RequestMapping(value={"/bitbucket/saveconfig"}, method = RequestMethod.POST)
	public String bitbucketFormProcess(@Validated @ModelAttribute BitbucketBean details, BindingResult result, Model model){
		
		model.addAttribute("jsonData", new Gson().toJson(details));
		
		return "success";
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
	}
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
	*/

}
