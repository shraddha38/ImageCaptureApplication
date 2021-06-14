package com.ImageCaptureApplications.Service;
import com.ImageCaptureApplications.Service.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class ServiceUtility
{
		public static String namep(JSONObject json) {
		JSONArray regionArr = (JSONArray) json.get("regions");
		JSONObject lineObj = (JSONObject) regionArr.get(0);
		JSONArray regionLine = (JSONArray) lineObj.get("lines");
		JSONObject lineName = (JSONObject) regionLine.get(1);
		JSONArray regionN = (JSONArray) lineName.get("words");

		JSONObject lineN = (JSONObject) regionLine.get(2);
		JSONArray regionNu = (JSONArray) lineN.get("words");

		JSONObject lineD = (JSONObject) regionLine.get(3);
		JSONArray regionDOB = (JSONArray) lineD.get("words");

		JSONObject lineP = (JSONObject) regionLine.get(5);
		JSONArray regionPAN = (JSONArray) lineP.get("words");

		//name
		JSONObject first = (JSONObject) regionN.get(0);
		JSONObject second = (JSONObject) regionN.get(1);
		JSONObject last = (JSONObject) regionN.get(2);
		String name = first.get("text") + " "+ second.get("text") + " "+last.get("text");

		return name;

	}
	public static String dobp(JSONObject json) {
		JSONArray regionArr = (JSONArray) json.get("regions");
		JSONObject lineObj = (JSONObject) regionArr.get(0);
		JSONArray regionLine = (JSONArray) lineObj.get("lines");
		JSONObject lineName = (JSONObject) regionLine.get(1);
		JSONArray regionN = (JSONArray) lineName.get("words");

		JSONObject lineN = (JSONObject) regionLine.get(2);
		JSONArray regionNu = (JSONArray) lineN.get("words");

		JSONObject lineD = (JSONObject) regionLine.get(3);
		JSONArray regionDOB = (JSONArray) lineD.get("words");

		JSONObject lineP = (JSONObject) regionLine.get(5);
		JSONArray regionPAN = (JSONArray) lineP.get("words");

		//dob
		JSONObject namedo = (JSONObject) regionDOB.get(0);
		String dob= namedo.get("text")+" ";
		return dob;
	}
	public static String fathern(JSONObject json) {
		JSONArray regionArr = (JSONArray) json.get("regions");
		JSONObject lineObj = (JSONObject) regionArr.get(0);
		JSONArray regionLine = (JSONArray) lineObj.get("lines");
		JSONObject lineName = (JSONObject) regionLine.get(1);
		JSONArray regionN = (JSONArray) lineName.get("words");

		JSONObject lineN = (JSONObject) regionLine.get(2);
		JSONArray regionNu = (JSONArray) lineN.get("words");

		JSONObject lineD = (JSONObject) regionLine.get(3);
		JSONArray regionDOB = (JSONArray) lineD.get("words");

		JSONObject lineP = (JSONObject) regionLine.get(5);
		JSONArray regionPAN = (JSONArray) lineP.get("words");

		//fathersName
		JSONObject Father = (JSONObject) regionNu.get(0);
		String fatherName= Father.get("text")+" ";

return fatherName;
	}
	public static String panc(JSONObject json) {
		JSONArray regionArr = (JSONArray) json.get("regions");
		JSONObject lineObj = (JSONObject) regionArr.get(0);
		JSONArray regionLine = (JSONArray) lineObj.get("lines");
		JSONObject lineName = (JSONObject) regionLine.get(1);
		JSONArray regionN = (JSONArray) lineName.get("words");

		JSONObject lineN = (JSONObject) regionLine.get(2);
		JSONArray regionNu = (JSONArray) lineN.get("words");

		JSONObject lineD = (JSONObject) regionLine.get(3);
		JSONArray regionDOB = (JSONArray) lineD.get("words");

		JSONObject lineP = (JSONObject) regionLine.get(5);
		JSONArray regionPAN = (JSONArray) lineP.get("words");

		//pan
		JSONObject namepan = (JSONObject) regionPAN.get(0);
		String pancard= namepan.get("text")+"";
		
		return pancard;
	}
}