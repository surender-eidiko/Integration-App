package com.cisco.integrations.helper;

import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MuleIntegrationHelper {
	
	public String getBitbucketAccessToken(){
		String accessToken = "";
		try{
			OkHttpClient client = new OkHttpClient();MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
			RequestBody body = RequestBody.create(mediaType, "client_id=2jSJzgNghgvKMzQ8Hc&client_secret=VGBeaLu3mVXwxnuv3jJzN8g3gR5bt27h&code=rVRj7ZU9XKMuSt7up7&grant_type=authorization_code");
			Request request = new Request.Builder()
			 .url("https://bitbucket.org/site/oauth2/access_token")
			 .post(body)
			 .addHeader("cache-control", "no-cache")
			 //.addHeader("postman-token", "5bccf743-f38d-6e45-1c45-4526a06ea559")
			 .addHeader("content-type", "application/x-www-form-urlencoded")
			 .build();
			Response response = client.newCall(request).execute();
			
			if(response.code() == 200){
				String s = new String(response.body().bytes());
				//System.out.println(s);
				JSONObject json = new JSONObject(s);
				//System.out.println("Access Token : "+);
				accessToken = json.get("access_token").toString();
			
			}
			
			}catch(Exception e){
				e.printStackTrace();
			}
		return accessToken;
	}

}
