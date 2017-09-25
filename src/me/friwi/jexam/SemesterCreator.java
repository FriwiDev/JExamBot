package me.friwi.jexam;

import java.io.InputStreamReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class SemesterCreator {
	public static void main(String[] args) throws Exception{
		JSONParser parse = new JSONParser();
		JSONArray array = (JSONArray) parse.parse(new InputStreamReader(SemesterCreator.class.getResourceAsStream("semester.json")));
		for(Object obj : array){
			JSONObject o = (JSONObject) obj;
			System.out.println("public static final int "+((String)o.get("name")).replace(" ", "_").replace("-", "_").replace(".", "").replace("(", "").replace(")", "").replace(":", "")+" = "+o.get("id")+";");
		}
	}
}
