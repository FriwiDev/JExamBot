package me.friwi.jexam;

import org.json.simple.JSONObject;

import me.friwi.jexam.LectureInfoStructs.Day;
import me.friwi.jexam.LectureInfoStructs.EnrollmentStatus;
import me.friwi.jexam.LectureInfoStructs.LectureType;
import me.friwi.jexam.LectureInfoStructs.Slot;
import me.friwi.jexam.LectureInfoStructs.Week;

public class Lecture {
	int id;
	int toid;
	String name;
	int maxMembers;
	int currentMembers;
	Day day;
	Slot slot;
	LectureType type;
	Week week;
	String building;
	String roomNo;
	EnrollmentStatus status;
	long start;
	long stop;
	private Lecture(){
		
	}
	public static Lecture fromJSON(JSONObject obj){
		if(obj==null)return null;
		Lecture ret = new Lecture();
		ret.id = Integer.parseInt(obj.get("id")+"");
		ret.toid = Integer.parseInt(obj.get("teachingOfferId")+"");
		ret.name = (String) obj.get("name");
		ret.maxMembers = Integer.parseInt(obj.get("maxMembers")+"");
		ret.currentMembers = Integer.parseInt(obj.get("currentMembers")+"");
		ret.day = Day.get(Integer.parseInt(obj.get("day")+""));
		ret.slot = Slot.get(Integer.parseInt(obj.get("slot")+""));
		ret.type = LectureType.get((String) obj.get("lectureType"));
		ret.week = Week.get(Integer.parseInt(obj.get("week")+""));
		JSONObject room = ((JSONObject)obj.get("room"));
		ret.building = (String) ((JSONObject)room.get("building")).get("abbreviation");
		ret.roomNo = (String) room.get("roomNo");
		ret.status = EnrollmentStatus.get((String) obj.get("enrollmentStatus"));
		JSONObject timeinfo = (JSONObject) obj.get("freeForEnroll");
		ret.stop = (long) timeinfo.get("stop");
		ret.start = (long) timeinfo.get("start");
		return ret;
	}
	
	@Override
	public String toString(){
		return "Lecture(lid="+id+", toid="+toid+", name="+name+", members="+currentMembers+"/"+maxMembers+", day="+day+", slot="+slot+", lecture_type="+type+", week="+week+", building="+building+", roomNo="+roomNo+", enrollmentStatus="+status+")";
	}
}
