package objects;

import java.util.*;

public class Course {
	private String courseID;
	private String courseName;
	private String courseSubject;
	private String courseTerm;
	private String courseTeachers;
	
	public String getCourseID() {
		return courseID;
	}
	
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public String getCourseSubject() {
		return courseSubject;
	}
	
	public void setCourseSubject(String courseSubject) {
		this.courseSubject = courseSubject;
	}

	public String getCourseTerm() {
		return courseTerm;
	}

	public void setCourseTerm(String courseTerm) {
		this.courseTerm = courseTerm;
	}

	public String getCourseTeachers() {
		return courseTeachers;
	}

	public void setCourseTeachers(String courseTeachers) {
		this.courseTeachers = courseTeachers;
	}
}