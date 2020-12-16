package com.example.bypassAlgorithm.controller;

import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//import com.example.bypassAlgorithm.entity.LoginAccount;
import com.example.bypassAlgorithm.entity.LoginUserReposne;
import com.example.bypassAlgorithm.entity.UserAccount;
import com.example.bypassAlgorithm.repository.UserAccountRepository;
import com.google.gson.Gson;

//import sun.jvm.hotspot.tools.JSnap;


@RestController
public class HomeController {
	private static final DateFormat portableDateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
//
//	private RestTemplate restTemplate;
//	@Autowired
//	CourseService courseService;
	@Autowired
	UserAccountRepository userAccountRepository;	

	
	
	
	@GetMapping("/fun")
	public void fun() {
//		System.out.println(portableDateFormatter.format(new Date()));
//		private static final DateFormat portableDateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
//		this.dateWithCurrentTiemzone();
		// Creating a TimeZone 
//        TimeZone the_time_zone = TimeZone.getDefault();
//		Date date = new Date();  
//		// 	date.getTime();
//        System.out.println(date.getTime());
//        System.out.println(the_time_zone);
////        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
//        String timeZone = TimeZone.getDefault().getID();
//        System.out.println(timeZone);
////       
//        
//        Date today = Calendar.getInstance().getTime();
//        SimpleDateFormat sdf = new SimpleDateFormat("Z");
//        String gmt = sdf.format(today);
//        System.out.println(gmt);
//        
//        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"),
//		Locale.getDefault());
//		Date currentLocalTime = calendar.getTime();
//		DateFormat date1 = new SimpleDateFormat("Z");
//		String localTime = date1.format(currentLocalTime);
//        System.out.println(localTime);
//        
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd | X");
//        System.out.println(sdf.format(new Date()));
//        
//        SimpleDateFormat date3 = new SimpleDateFormat("yyyy/MM/dd");
//        SimpleDateFormat zone = new SimpleDateFormat("ZZZZZ"); // = +03:00
//        String tz = zone.format(new Date()).split(":")[0]
//            .replaceAll("^(\\+|-)0", "$1"); // = +3
//        System.out.println(sdf.format(new Date()) + " | " + tz);
	}
	
//	@GetMapping("/courses")
//	public List<Courses> getCourses(){
//		return this.courseService.getCourses();
//		
//	}
	
//	{
//	    "data": {
//	        "accounts": [
//	            {
//	                "session": "AuthToken cceb5dc4-4066-4d6d-824a-b75c73aefaf6 2020-12-16T13:10:52.586+0530 8f392160-1b8b-4c80-88bf-eb742073bad2 zMokpX9czRReRP3/WabT8g6MCiKmD9sYlVh48WgdsSw=",
//	                "msgstartdate": "/Date(1608104834808+0530)/",
//	                "accountid": "5886030"
//	            }
//	        ],
//	        "contacts": [
//	                {
//	                    "groupId": null,
//	                    "inmateId": 774759,
//	                    "active": true,
//	                    "agencyName": "BOP",
//	                    "costPerMessage": 0.0000,
//	                    "inmateNumber": "48613044",
//	                    "maxBodyLength": 12750,
//	                    "maxBodyLines": 13000,
//	                    "name": "NASH, JEROME",
//	                    "recipientCount": 1
//	                },
//	                {
//	                    "groupId": null,
//	                    "inmateId": 730257,
//	                    "active": true,
//	                    "agencyName": "BOP",
//	                    "costPerMessage": 0.0000,
//	                    "inmateNumber": "19281104",
//	                    "maxBodyLength": 12750,
//	                    "maxBodyLines": 13000,
//	                    "name": "DENIS, CHRISTOPHER SERGO",
//	                    "recipientCount": 1
//	                }                
//	            ]
//	    }
//	}
	private String finalPayload(String responseBody, int status, String custom_auth_token) {
//		System.out.println(status);
//		System.out.println("@@@@@@@@@@@");
//		System.out.println(responseBody);
//		System.out.println("@@@@@@@@@@@");
		
		
		try {
			JSONObject loginReposne = new JSONObject(responseBody);
			JSONObject finalPayload = new JSONObject();
			JSONObject data = new JSONObject();
			for(int i =0; i<loginReposne.getJSONArray("accounts").length();i++) {
				JSONArray accounts = new JSONArray();
				JSONObject accontdetail = new JSONObject();
				accontdetail.put("session", custom_auth_token);
				accontdetail.put("msgstartdate",this.dateWithCurrentTiemzone() );
				accontdetail.put("accountid", loginReposne.getJSONArray("accounts").getJSONObject(i).getLong("id"));
				accounts.put(accontdetail);
				data.put("accounts",accounts);
				data.put("contacts",loginReposne.getJSONArray("accounts").getJSONObject(i).optJSONArray("contacts"));
				
			};
			
			finalPayload.put("data", data);
			
			System.out.println(loginReposne);
			
			return finalPayload.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		
	}
	
	@PostMapping("/login")
	private String loginWithData(@RequestBody UserAccount userAccount) {
		String email = userAccount.getEmail();
		UserAccount user = userAccountRepository.findByEmailContaining(email);
		if(user != null) {
			LoginUserReposne loginUser  = this.login(user);
			return this.finalPayload(loginUser.getResponseBody(), loginUser.getStatus(), loginUser.getCustomAuthToken());			
		}
		else {
			String uuid = UUID.randomUUID().toString();
			userAccount.setClientDeviceId(uuid);
			LoginUserReposne loginUser = this.login(userAccount);
			String authToken = loginUser.getAuthToken();
			int userId = loginUser.getUserId();
			int status = loginUser.getStatus();
			if(status == 200) {
				userAccount.setAuthToken(authToken);
				userAccount.setUser_id(userId);
				userAccount.setUuid(uuid);
				userAccountRepository.save(userAccount);
				return this.finalPayload(loginUser.getResponseBody(), loginUser.getStatus(),loginUser.getCustomAuthToken());
			}
			else {
				return this.finalPayload(loginUser.getResponseBody(), loginUser.getStatus(),loginUser.getCustomAuthToken());
			}
		}		
	}
	
	private LoginUserReposne login(UserAccount user) {		
		System.out.println("In login page @@@@@@@@@@@@@@");
		LoginUserReposne loginUserReposne = new LoginUserReposne();
		//username : terry532@outlook.com
		//pwd :		Intouchcall#3
		final String url = "https://api.corrlinks.com/1/Session.svc/Authenticate";
		// create an instance of RestTemplate
		RestTemplate restTemplate = new RestTemplate();		
		String deviceInfo = user.getDeviceInfo();
		String fireBaseToken = user.getFireBaseToken();
		String deviceName = user.getDeviceName();
		String username = user.getEmail();
		String password = user.getPassword();
		String currentDate = portableDateFormatter.format(new Date());
		String clientDeviceId = user.getClientDeviceId();

		// request body parameters
		Map<String, String> map = new HashMap<>();
		map.put("clientDeviceId", clientDeviceId);
		map.put("currentDate", currentDate);
		map.put("deviceName", deviceName);
		map.put("loginName", username);
		map.put("notificationToken", fireBaseToken);
		map.put("password", password);
		map.put("xml", deviceInfo);

		// send POST request
		ResponseEntity<String> response = restTemplate.postForEntity(url, map, String.class);
//		String msg = null;
		// 
		if (response.getStatusCode() == HttpStatus.OK) {			
			JSONObject jobj;
			try {
				jobj = new JSONObject(response.getBody());				
				JSONArray arr_data = jobj.getJSONArray("accounts");				
				if(arr_data.length() > 0) {
					JSONObject account_obj = arr_data.getJSONObject(0);
					int user_id = account_obj.optInt("id");
//					String lastName = account_obj.optString("lastName");				
//					String loginName = account_obj.optString("loginName");
//				    String lastSyncDate = account_obj.optString("lastSyncDate");				
					String login_token = jobj.optString("authToken");
					String custom_auth_token = this.genrateAuthToken(login_token);
//					return custom_auth_token;
//					lastSyncDate = this.removeHrs(lastSyncDate, 60 /*Mins*/);
//					String loginUserData = this.syncAccount(custom_auth_token, lastSyncDate, user_id, deviceInfo,deviceName, fireBaseToken);
//					System.out.println(lastSyncDate);
//					System.out.println("Authorization token :"+ custom_auth_token);
					
//					return this.finalResponse(response.getBody(),loginUserData);//
					
					 loginUserReposne.setStatus(200);
					 loginUserReposne.setAuthToken(login_token);
					 loginUserReposne.setUserId(user_id);		
					 loginUserReposne.setResponseBody(response.getBody());
					 loginUserReposne.setCustomAuthToken(custom_auth_token);
				}
				else {
					System.out.println("invalid login or no contacts found");
					System.out.println(response.getBody());
					System.out.println(arr_data);	
					loginUserReposne.setStatus(400);
				}
			} catch (Exception e) {				
				// TODO Auto-generated catch block
				// System.out.println(e.printStackTrace());
				loginUserReposne.setStatus(400);
			}
			//authToken
		} else {
			System.out.println("Request Failed");//			
			loginUserReposne.setStatus(400);
		}
		return loginUserReposne;
	}
		
	private String genrateAuthToken(String login_token){
		String str = "/4sgam7MtTHCbLpXN1H2D2+q8l/FQYSfXdhAuxsyYJo=";
	    // String login_token ="9aaf7004-3e50-4bf7-9c81-a640543f42be";
	    byte[] base64decodedBytes = Base64.getDecoder().decode(str);
	    String final_token ="";
        try{
            Mac instance = Mac.getInstance("HmacSHA256");
    	    
            instance.init(new SecretKeySpec(base64decodedBytes, instance.getAlgorithm()));
            
            String format = portableDateFormatter.format(new Date());
            String uuid = UUID.randomUUID().toString();
            StringBuilder sb = new StringBuilder();
            sb.append(login_token);
            sb.append(format);
            sb.append(uuid);
            
            String base64encodedString = Base64.getEncoder().encodeToString(instance.doFinal(sb.toString().getBytes("utf-8")));
            final_token="AuthToken "+login_token+" "+format+" "+uuid+" "+base64encodedString;
            return final_token;
        }
        catch(Exception e) {
        	//  Block of code to handle errors
        }
        return final_token;
	}
	
	private String syncAccount(UserAccount userAccount) {
		String auth_token = this.genrateAuthToken(userAccount.getAuthToken());
		String date = this.dateWithCurrentTiemzone();
		int user_id = userAccount.getUser_id();
		String deviceInfo = userAccount.getDeviceInfo();
		String deviceName = userAccount.getDeviceName();
		String notificationToken = userAccount.getFireBaseToken();
		// request URL		
		String url = "https://api.corrlinks.com/1/Account.svc/Sync";
		System.out.println("current datetime");
		System.out.println(date);
		System.out.println(auth_token);
		// create an instance of RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		// create headers
		HttpHeaders headers = new HttpHeaders();			
		
		// set `content-type` header
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		// set `accept` header
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		// set `Authorization`,`Accept-Language`, `user-agent`, `X-Requested-Id` headers
		headers.set("Authorization",auth_token);
		headers.set("Accept-Language","en");
		headers.set("User-Agent","CorrLinks 1.2.1 rv:80837300 (sdk_gphone_x86_arm; Android 11; en_US)");
		headers.set("X-Requested-Id","0198cb30-fdea-4ac8-b491-639bab0ffe3d");			
		
		// request body parameters
		Map <String, Object> map = new HashMap<>();
		Map <String, Object> account = new HashMap<>();			
		List <Map<String, Object>> listOfAccount= new ArrayList<Map<String, Object>>();					
					
		account.put("date",date);
		account.put("id",user_id);
		listOfAccount.add(account);
		
		map.put("accounts",listOfAccount);
		map.put("deviceInfo", deviceInfo);
		map.put("deviceName", deviceName);
		map.put("notificationToken", notificationToken);		
		
		// build the request
		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

		// send POST request
		ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);	
		// check response
		if (response.getStatusCode() == HttpStatus.OK ) {
		    System.out.println("SYNC Request Successful~~~~~~~~~~~~~~~~~~~~~");		   
		    System.out.println(response.getBody());
		    return response.getBody();
		} else {
		    System.out.println("SYNC Request Failed");
		    System.out.println(response.getBody());
		    System.out.println(response.getStatusCode());
		    return response.getBody();
		}
	}
	
//	private String finalResponse(String loginUserData, String userData) {
//		System.out.println("printing final response....~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//		System.out.println(loginUserData);
//		System.out.println("printing final response ###############################");
//		String msg = null;
//		JSONObject jsonLoginUserData;
//		
//		try {
//			jsonLoginUserData = new JSONObject(loginUserData);
//			JSONArray arr_data = jsonLoginUserData.getJSONArray("accounts");	
//			JSONObject account = arr_data.getJSONObject(0);
//			JSONArray contacts = account.getJSONArray("contacts");
//			JSONArray inbox = account.getJSONArray("inbox");
//			
//			JSONArray unreadMsgs = new JSONArray();
//			for(int i= 0; i < inbox.length(); i++) {
//				if(inbox.getJSONObject(i).getBoolean("unread")) {
//					unreadMsgs.put(inbox.getJSONObject(i));
//				}				
//			}
//			System.out.println(unreadMsgs);
//			msg = "check console";
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return msg;
//	}	

	private String removeHrs(Long datetime, long min) {
		Long seconds = min * 60000;
//		String timestamp = datetime.substring(datetime.indexOf('(') + 1, datetime.indexOf('-'));
//		long time = Long.parseLong(timestamp);		
//		
//        String[] separated = datetime.split("\\(");
//        String[] final_date_array = separated[1].split("-");        
//        String end_string=final_date_array[1];
//        String convertedTime = "/Date(" + String.valueOf(time - seconds) + "-" + end_string;
        String convertedTime = String.valueOf(datetime - seconds);
        return convertedTime;
	}	
	
	private String dateWithCurrentTiemzone() {
		Date today = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("Z");
        String gmt = sdf.format(today);
        Date date = new Date();   	
//        System.out.println(date.getTime());
//        System.out.println(gmt);
        System.out.println(date.getTime());
//        String timestamp = this.removeHrs(date.getTime(), 60 /*mins*/);        
//        System.out.println(timestamp);
        String current_date_time = "/Date(" + date.getTime()  + gmt + ")/";
        
//        current_date_time  = this.removeHrs(current_date_time, 10 /* min*/);
        System.out.println(current_date_time);
        return current_date_time;
	}
}
