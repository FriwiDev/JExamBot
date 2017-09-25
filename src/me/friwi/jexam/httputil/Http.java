package me.friwi.jexam.httputil;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import me.friwi.jexam.JExamBot;
import me.friwi.jexam.Lecture;

public class Http {
	private CloseableHttpClient httpclient;
	public Http(){
		httpclient = HttpClients.createDefault();
	}
	public void close(){
		try {
			httpclient.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public boolean login(String username, String password) throws ClientProtocolException, IOException{
		HttpPost httpPost = new HttpPost(JExamBot.baseURL + "/j_acegi_security_check");
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		nvps.add(new BasicNameValuePair("j_username", username));
		nvps.add(new BasicNameValuePair("j_password", password));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response2 = httpclient.execute(httpPost);
		
		boolean ret = false;
		
		try {
		    if(response2.containsHeader("Location")){
		    	Header loc = response2.getFirstHeader("Location");
		    	if(loc.getValue().contains("concurrentsession")){
		    		ret = true;
		    	}
		    }
		    HttpEntity entity2 = response2.getEntity();
		    EntityUtils.consume(entity2);
		} finally {
		    response2.close();
		}
		return ret;
	}
	
	public Lecture[] getLectures(int toID) throws ClientProtocolException, IOException{
		HttpPost httpPost = new HttpPost(JExamBot.baseURL+"/lectures/ajax");
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		nvps.add(new BasicNameValuePair("action", "getLectures"));
		nvps.add(new BasicNameValuePair("toID", String.valueOf(toID)));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response2 = httpclient.execute(httpPost);
		
		Lecture[] lectures = null;
		
		try {
		    HttpEntity entity2 = response2.getEntity();
		    JSONParser parser = new JSONParser();
		    try {
				JSONObject obj = (JSONObject) parser.parse(new InputStreamReader(entity2.getContent()));
				if(obj!=null){
					if(obj.containsKey("success")&&(Boolean)obj.get("success")){
						lectures = new Lecture[Integer.parseInt((Long)obj.get("results")+"")];
						JSONArray array = (JSONArray) obj.get("rows");
						for(int i = 0; i<array.size() && i<lectures.length; i++){
							lectures[i] = Lecture.fromJSON((JSONObject) array.get(i));
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		    
		    EntityUtils.consume(entity2);
		} finally {
		    response2.close();
		}
		
		return lectures;
	}
	public void enroll(int toid, int lid, boolean enroll) throws ClientProtocolException, IOException{
		HttpPost httpPost = new HttpPost(JExamBot.baseURL+"/scheduler/ajax");
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		nvps.add(new BasicNameValuePair("action", enroll ? "enrollForLecture" : "enqueueForLecture"));
		nvps.add(new BasicNameValuePair("toID", String.valueOf(toid)));
		nvps.add(new BasicNameValuePair("lectureID", String.valueOf(lid)));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response2 = httpclient.execute(httpPost);
		
		
		try {
		    HttpEntity entity2 = response2.getEntity();
		    EntityUtils.consume(entity2);
		} finally {
		    response2.close();
		}
	}
}
