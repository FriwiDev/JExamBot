package me.friwi.jexam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import me.friwi.jexam.LectureInfoStructs.Day;
import me.friwi.jexam.LectureInfoStructs.EnrollmentStatus;
import me.friwi.jexam.LectureInfoStructs.LectureType;
import me.friwi.jexam.LectureInfoStructs.Slot;
import me.friwi.jexam.LectureInfoStructs.Week;
import me.friwi.jexam.httputil.Http;

public class JExamBot {
	
	public static final String baseURL = "https://jexam.inf.tu-dresden.de/de.jexam.web.v4.5/spring";

	private List<LectureRegex> work = new ArrayList<LectureRegex>();
	
	private Http http;
	
	public JExamBot() {
		http = new Http();
	}
	
	private void addRegex(LectureRegex regex){
		work.add(regex);
	}
	
	private boolean login(String username, String password){
		try {
			return http.login(username, password);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private Lecture[] getLectures(int toID){
		try {
			return http.getLectures(toID);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void enroll(int toID, int lectureID){
		try {
			http.enroll(toID, lectureID, true);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void enqueue(int toID, int lectureID){
		try {
			http.enroll(toID, lectureID, false);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void runBot(String username, String password){
		boolean login = login(username, password);
		if(!login){
			System.err.println("Invalid credentials or JExam not reachable! Please check!");
			return;
		}
		System.out.println("Welcome to JExamBot v1.0");
		System.out.println("Successfully logged into JExam! :)");
		System.out.println("Started working on "+work.size()+" enrollments...");
		while(work.size()>0){
			List<LectureRegex> del = new LinkedList<LectureRegex>(); //Contains all elements to be removed
			
			for(LectureRegex w : work)if(tickRegex(w))del.add(w);
			
			for(LectureRegex d : del){
				work.remove(d);
			}
			
			if(del.size()>0 && work.size()>0){
				System.out.println("Still working on "+work.size()+" enrollments...");
			}
			
			try {
				Thread.sleep(120000-System.currentTimeMillis()%120000); //Sleep till next 2 minutes
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			http.close();
			http = new Http();
			while(!login(username, password))
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
		System.out.println("Finished enrolling for all courses :)");
		http.close();
	}
	/**
	 * 
	 * @param r Regex to tick
	 * @return true when the regex can be dropped because it was found or can definitely not be fulfilled
	 */
	private boolean tickRegex(LectureRegex r) {
		Lecture[] lectures = getLectures(r.toid);
		if(lectures!=null){
			for(Lecture lecture : lectures){
				if(r.matches(lecture)){
					if(lecture.status == EnrollmentStatus.FREE && lecture.start < System.currentTimeMillis() && (lecture.stop<=0 || lecture.stop > System.currentTimeMillis())){
						tryEnrolling(r, lecture);
						return true;
					}else if(lecture.status == EnrollmentStatus.ENROLLED || lecture.status == EnrollmentStatus.PASSED || lecture.status == EnrollmentStatus.FIXED_ENROLLED){
						System.err.println("You are already enrolled in: "+lecture);
						return true;
					}else if(lecture.status == EnrollmentStatus.INQUEUE){
						System.err.println("You are already enqueued in: "+lecture);
						return true;
					}
				}
			}
//			if(lectures.length>3){
//				//This probably was everything we will ever get. We can consider our search as failed, if nothing has been found yet
//				System.err.println("Failed to find a correct match for: "+r);
//				return true;
//			}
		}
		return false;
	}

	private void tryEnrolling(LectureRegex r, Lecture lecture) {
		if(lecture.maxMembers>0 && lecture.currentMembers>=lecture.maxMembers){
			enqueue(lecture.toid, lecture.id);
			lecture.status = EnrollmentStatus.INQUEUE;
			System.out.println("Enqueued for participation in: "+lecture);
		}else{
			enroll(lecture.toid, lecture.id);
			lecture.status = EnrollmentStatus.ENROLLED;
			System.out.println("You are now enrolled in: "+lecture);
		}
	}

	public void addRegex(int toid, Day day, Slot slot, LectureType type, Week week) {
		addRegex(new LectureRegex(toid, day, slot, type, week));
	}
	public void addRegex(int toid, Day day, Slot slot, LectureType type, Week week, String building, String room) {
		addRegex(new LectureRegex(toid, day, slot, type, week, building, room));
	}
}
