package me.friwi.jexam;

import me.friwi.jexam.LectureInfoStructs.Day;
import me.friwi.jexam.LectureInfoStructs.LectureType;
import me.friwi.jexam.LectureInfoStructs.Slot;
import me.friwi.jexam.LectureInfoStructs.Week;

public class LectureRegex {
	int toid;
	Day day;
	Slot slot;
	LectureType type;
	Week week;
	String building;
	String roomNo;
	
	
	
	public LectureRegex(int toid, Day day, Slot slot, LectureType type, Week week, String building, String roomNo) {
		this.toid = toid;
		this.day = day;
		this.slot = slot;
		this.type = type;
		this.week = week;
		this.building = building;
		this.roomNo = roomNo;
	}

	public LectureRegex(int toid, Day day, Slot slot, LectureType type, Week week) {
		this(toid, day, slot, type, week, null, null);
	}

	public boolean matches(Lecture info){
		return toid == info.toid
				&& day == info.day
				&& slot == info.slot
				&& type == info.type
				&& week == info.week
				&& (building == null || building.equalsIgnoreCase(info.building))
				&& (roomNo == null || roomNo.equalsIgnoreCase(info.roomNo));
	}
	
	@Override
	public String toString(){
		return "LectureRegex(toid="+toid+", day="+day+", slot="+slot+", lecture_type="+type+", week="+week+", building="+building+", roomNo="+roomNo+")";
	}
}
