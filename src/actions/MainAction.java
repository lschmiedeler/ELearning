package actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.SessionMap;  
import org.apache.struts2.interceptor.SessionAware;

import java.util.*;
import java.text.*;

import database.DatabaseConnection;
import objects.*;

public class MainAction extends ActionSupport implements SessionAware {
	private String user_id;
	private String firstname;
	private String lastname;
	private String email;
	private String username;
	private String password;
	private String role;
	
	private String courseName;
	private String term;
	private String subject;
	private String students = "";
	private ArrayList<String> selectedStudents = new ArrayList<String>();
	private String description;
	private ArrayList<String> selectStudentsList = new ArrayList<String>();
	
	private String assignmentName;
	private Date assignmentDueDate;
	private String assignmentCourse;
    private ArrayList<String> selectCourseList = new ArrayList<String>();
	
    private ArrayList<Course> courseList = new ArrayList<Course>();
    private ArrayList<User> studentList = new ArrayList<User>();
	private ArrayList<User> teacherList = new ArrayList<User>();
	private ArrayList<Assignment> assignmentList = new ArrayList<Assignment>();
	
	private String selectedAssignment;
	private ArrayList<String> selectAssignmentList = new ArrayList<String>();
	private String totalPointsPossible;
	
	private ArrayList<String> studentsList = new ArrayList<String>();
	
	private ArrayList<Assignment> gradeListStudent = new ArrayList<Assignment>();
	private ArrayList<User> gradeListTeacher = new ArrayList<User>();

	private SessionMap<String, Object> sessionMap; 

	@Override
	public void setSession(Map<String, Object> map) {  
	    sessionMap = (SessionMap) map;
	}
	
	public Date getTodayDate(){
        return new Date();
    }
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getStudents() {
		return students;
	}

	public void setStudents(String students) {
		this.students = students;
	}

	public ArrayList<String> getSelectedStudents() {
		return selectedStudents;
	}

	public void setSelectedStudents(ArrayList<String> selectedStudents) {
		this.selectedStudents = selectedStudents;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public ArrayList<String> getSelectStudentsList() {
		return selectStudentsList;
	}

	public void setSelectStudentsList(ArrayList<String> selectStudentsList) {
		this.selectStudentsList = selectStudentsList;
	}

	public String getAssignmentName() {
		return assignmentName;
	}

	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}

	public Date getAssignmentDueDate() {
		return assignmentDueDate;
	}

	public void setAssignmentDueDate(Date assignmentDueDate) {
		this.assignmentDueDate = assignmentDueDate;
	}
	
	public String getAssignmentCourse() {
		return assignmentCourse;
	}

	public void setAssignmentCourse(String assignmentCourse) {
		this.assignmentCourse = assignmentCourse;
	}
	
	public ArrayList<String> getSelectCourseList() {
		return selectCourseList;
	}

	public void setSelectCourseList(ArrayList<String> selectCourseList) {
		this.selectCourseList = selectCourseList;
	}

	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}

	public ArrayList<User> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<User> studentList) {
		this.studentList = studentList;
	}

	public ArrayList<User> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(ArrayList<User> teacherList) {
		this.teacherList = teacherList;
	}

	public ArrayList<Assignment> getAssignmentList() {
		return assignmentList;
	}

	public void setAssignmentList(ArrayList<Assignment> assignmentList) {
		this.assignmentList = assignmentList;
	}
	
	public String getSelectedAssignment() {
		return selectedAssignment;
	}

	public void setSelectedAssignment(String selectedAssignment) {
		this.selectedAssignment = selectedAssignment;
	}

	public ArrayList<String> getSelectAssignmentList() {
		return selectAssignmentList;
	}

	public void setSelectAssignmentList(ArrayList<String> selectAssignmentList) {
		this.selectAssignmentList = selectAssignmentList;
	}

	public String getTotalPointsPossible() {
		return totalPointsPossible;
	}

	public void setTotalPointsPossible(String totalPointsPossible) {
		this.totalPointsPossible = totalPointsPossible;
	}

	public ArrayList<String> getStudentsList() {
		return studentsList;
	}

	public void setStudentsList(ArrayList<String> studentsList) {
		this.studentsList = studentsList;
	}

	public ArrayList<Assignment> getGradeListStudent() {
		return gradeListStudent;
	}

	public void setGradeListStudent(ArrayList<Assignment> gradeListStudent) {
		this.gradeListStudent = gradeListStudent;
	}

	public ArrayList<User> getGradeListTeacher() {
		return gradeListTeacher;
	}

	public void setGradeListTeacher(ArrayList<User> gradeListTeacher) {
		this.gradeListTeacher = gradeListTeacher;
	}

	public void setID(DatabaseConnection databaseConnection, String username) {
		user_id = databaseConnection.queryUserIDGivenUsername(username).get(0).get("id");
	}
	
	public void setUserInformation(DatabaseConnection databaseConnection, String user_id) {
		firstname = databaseConnection.queryUserFirstName(user_id).get(0).get("firstname");
		lastname = databaseConnection.queryUserLastName(user_id).get(0).get("lastname");
		email = databaseConnection.queryUserEmailName(user_id).get(0).get("email");
		role = databaseConnection.queryRoleGivenUser(user_id).get(0).get("role");
	}
	
	public void setCourses(DatabaseConnection databaseConnection, String user_id) {
		courseList.clear();
		
		ArrayList<HashMap<String, String>> courses = new ArrayList<HashMap<String, String>>();
		courses = databaseConnection.queryCoursesGivenUser(user_id);
		for (int i = 0; i < courses.size(); i++) {
			String id = courses.get(i).get("course_id");
			Course course = new Course();
			course.setCourseID(id);
			course.setCourseName(databaseConnection.queryCourseNameGivenCourseID(id).get(0).get("courseName"));
			course.setCourseSubject(databaseConnection.queryCourseSubjectGivenCourseID(id).get(0).get("subject"));
			course.setCourseTerm(databaseConnection.queryCourseTermGivenCourseID(id).get(0).get("term"));
			ArrayList<HashMap<String, String>> teachers = new ArrayList<HashMap<String, String>>();
			teachers = databaseConnection.queryTeachersInCourse(id);
			String teachersString = "";
			for (int j = 0; j < teachers.size(); j++) {
				String teacher_id = teachers.get(j).get("user_id");
				teachersString += databaseConnection.queryUserFirstName(teacher_id).get(0).get("firstname") + " ";
				teachersString += databaseConnection.queryUserLastName(teacher_id).get(0).get("lastname");
				if (j != teachers.size() - 1) {
					teachersString += ", ";
				}
			}
			course.setCourseTeachers(teachersString);
			courseList.add(course);
		}
	}
	
	public void setStudentsOrTeachers(DatabaseConnection databaseConnection, String user_id) {
		studentList.clear();
		teacherList.clear();
		
		if (role.equals("teacher")) { 
			ArrayList<HashMap<String, String>> students = new ArrayList<HashMap<String, String>>();
			students = databaseConnection.queryStudentsGivenTeacher(user_id);
			ArrayList<String> ids = new ArrayList<String>();
			for (int i = 0; i < students.size(); i++) {
				String id = students.get(i).get("user_id");
				if (ids.contains(id)) {
				}
				else {
					User user = new User();
					user.setUserID(id);
					user.setFirstname(databaseConnection.queryUserFirstName(id).get(0).get("firstname"));
					user.setLastname(databaseConnection.queryUserLastName(id).get(0).get("lastname"));
					user.setUsername(databaseConnection.queryUserName(id).get(0).get("username"));
					user.setEmail(databaseConnection.queryUserEmailName(id).get(0).get("email"));
					studentList.add(user);
				}
				ids.add(id);
			}
		}
		else {
			ArrayList<HashMap<String, String>> teachers = new ArrayList<HashMap<String, String>>();
			teachers = databaseConnection.queryTeachersGivenStudents(user_id);
			ArrayList<String> ids = new ArrayList<String>();
			for (int i = 0; i < teachers.size(); i++) {
				String id = teachers.get(i).get("user_id");
				if (ids.contains(id)) {
					
				}
				else {
					User user = new User();
					user.setUserID(id);
					user.setFirstname(databaseConnection.queryUserFirstName(id).get(0).get("firstname"));
					user.setLastname(databaseConnection.queryUserLastName(id).get(0).get("lastname"));
					user.setUsername(databaseConnection.queryUserName(id).get(0).get("username"));
					user.setEmail(databaseConnection.queryUserEmailName(id).get(0).get("email"));
					teacherList.add(user);
				}
				ids.add(id);
			}
		}
	}
	
	public void setAssignments(DatabaseConnection databaseConnection, String user_id) {
		assignmentList.clear();
		
		ArrayList<HashMap<String, String>> assignments = new ArrayList<HashMap<String, String>>();
		assignments = databaseConnection.queryAssignmentsGivenUser(user_id);
		for (int i = 0; i < assignments.size(); i++) {
			String name = assignments.get(i).get("assignment_name");
			String id = databaseConnection.queryAssignmentIDGivenAssignmentName(name).get(0).get("id");
			String split = assignments.get(i).get("deadline");
			String deadline = split.split(" ")[0];
			try {
				SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
				String todayString = newFormat.format(getTodayDate());				
				Date todayDate = newFormat.parse(todayString);
				Date deadlineDate = newFormat.parse(deadline);
				if (!(deadlineDate.before(todayDate))) {
					Assignment assignment = new Assignment();
					assignment.setAssignmentID(id);
					assignment.setAssignmentName(name);
					assignment.setAssignmentDueDate(deadline.split(" ")[0]);
					String course_id = databaseConnection.queryAssignmentCourseGivenAssignmentID(id).get(0).get("course_id");
					assignment.setAssignmentCourse(databaseConnection.queryCourseNameGivenCourseID(course_id).get(0).get("courseName"));
					assignmentList.add(assignment);
				}
				else {
					
				}
			}
			catch (java.text.ParseException e) {
				
			}
		}
	}
	
	public String viewGradesStudent() {
		try {
			gradeListStudent.clear();
		
			DatabaseConnection databaseConnection = new DatabaseConnection();
			username = (String) sessionMap.get("username");
			setID(databaseConnection, username);
		
			ArrayList<HashMap<String, String>> grades = new ArrayList<HashMap<String, String>>();
			grades = databaseConnection.queryAssignmentInfoGivenUserID(user_id);
			for (int i = 0; i < grades.size(); i++) {
				Assignment assignment = new Assignment();
				String assignment_id = grades.get(i).get("Assignment_id");
				assignment.setAssignmentID(assignment_id);
				String assignment_name = databaseConnection.queryAssignmentNameGivenAssignmentID(assignment_id).get(0).get("assignment_name");
				assignment.setAssignmentName(assignment_name);
				String split_duedate = databaseConnection.queryAssignmentDeadlineGivenAssignmentID(assignment_id).get(0).get("deadline");
				String assignment_duedate = split_duedate.split(" ")[0];
				assignment.setAssignmentDueDate(assignment_duedate);
				String course_id = databaseConnection.queryAssignmentCourseGivenAssignmentID(assignment_id).get(0).get("course_id");
				assignment.setAssignmentCourse(databaseConnection.queryCourseNameGivenCourseID(course_id).get(0).get("courseName"));
			
				String grade = grades.get(i).get("grade");
				if (grade != null) {
					String[] split = grade.split("/");
					String earned = split[0];
					assignment.setPointsEarned(earned);
					String possible = split[1];
					assignment.setTotalPointsPossible(possible);
					gradeListStudent.add(assignment);
				}
			}
		
			return "viewGradesStudentSuccess";
		}
		catch(Exception e) {
			return "viewGradesStudentFailure";
		}
	}
	
	public String viewGradesTeacher() {
		try {
			gradeListTeacher.clear();
		
			DatabaseConnection databaseConnection = new DatabaseConnection();
			username = (String) sessionMap.get("username");
			setID(databaseConnection, username);
		
			String[] split = selectedAssignment.split("Assignment ID = ");
			String assignmentID = split[split.length - 1];
			assignmentID = assignmentID.substring(0, assignmentID.length() - 1);
		
			ArrayList<HashMap<String, String>> grades = new ArrayList<HashMap<String, String>>();
			grades = databaseConnection.queryAssignmentDetailsGivenID(assignmentID);
			for (int i = 0; i < grades.size(); i++) {
				User user = new User();
				String id = grades.get(i).get("user_id");
				user.setUserID(id);
				String first = databaseConnection.queryUserFirstName(id).get(0).get("firstname");
				user.setFirstname(first);
				String last = databaseConnection.queryUserLastName(id).get(0).get("lastname");
				user.setLastname(last);
				String student_username = databaseConnection.queryUserName(id).get(0).get("username");
				user.setUsername(student_username);
				String student_email = databaseConnection.queryUserEmailName(id).get(0).get("email");
				user.setEmail(student_email);
			
				String grade = grades.get(i).get("grade");
				if (grade != null) {
					String[] split_grade = grade.split("/");
					String earned = split_grade[0];
					user.setPointsEarned(earned);
					String possible = split_grade[1];
					user.setTotalPointsPossible(possible);
					gradeListTeacher.add(user);
				}
			}
		
			return "viewGradesTeacherSuccess";
		}
		catch (Exception e) {
			return "viewGradesTeacherFailure";
		}
	}
	
	public void setDashboardInformation(String user_id, DatabaseConnection databaseConnection) {
		setUserInformation(databaseConnection, user_id);
		setCourses(databaseConnection, user_id);
		setStudentsOrTeachers(databaseConnection, user_id);
		setAssignments(databaseConnection, user_id);
	}

	public String executeLogin() {		
		try {
			DatabaseConnection databaseConnection = new DatabaseConnection();
			String ret = databaseConnection.login(username, password);
			if (ret.equals("loginFailure")) {
				addActionError("Invalid username or password.  Please try again.");
				return ret;
			}
		
			sessionMap.put("username", username);
			setID(databaseConnection, username);
			setDashboardInformation(user_id, databaseConnection);
		
			if (role.equals("student")) {
				return "loginSuccessStudent";
			}
			return "loginSuccessTeacher";
		}
		catch (Exception e) {
			return "loginFailureTeacher";
		}
	}
	
	public String executeCreateNewAccount() {
		try {
			DatabaseConnection databaseConnection = new DatabaseConnection();
			String ret = databaseConnection.createAccount(firstname, lastname, email, username, password, role);
			if (ret.equals("createNewAccountFailureUsernameTaken")) {
				addActionError("Username taken.  Please choose another one.");
				return "createNewAccountFailureUsernameTaken";
			}
		
			sessionMap.put("username", username); 
			setID(databaseConnection, username);
			setDashboardInformation(user_id, databaseConnection);

			if (role.equals("student")) {
				return "createNewAccountSuccessStudent";
			}
			return "createNewAccountSuccessTeacher";
		}
		catch (Exception e) {
			return "createNewAccountFailure";
		}
	}
	
	public String executeCreateNewCourse() {
		try {
			for (int i = 0; i < selectedStudents.size(); i++) {
				String student = selectedStudents.get(i);
				String[] split = student.split("User ID = ");
				String id = split[split.length - 1];
				id = id.substring(0, id.length() - 1);
				students += id;
				if (i < selectedStudents.size() - 1) {
					students += ",";
				}
			}
				
			DatabaseConnection databaseConnection = new DatabaseConnection();
			username = (String) sessionMap.get("username");
			setID(databaseConnection, username);
			String ret = databaseConnection.createCourse(courseName, term, subject, students, description, user_id);
			if (ret.equals("createNewCourseFailureCourseTaken")) {
				sessionMap.put("errorMessage", "Course name taken.  Please choose another one.");
			}
		
			setDashboardInformation(user_id, databaseConnection);
		
			return ret;
		}
		catch (Exception e) {
			return "createNewCourseFailure";
		}
	}
	
	public String executeSelectStudents() {
		try {
			String errorMessage = (String) sessionMap.get("errorMessage");
			addActionError(errorMessage);
		
			DatabaseConnection databaseConnection = new DatabaseConnection();
			username = (String) sessionMap.get("username");
			setID(databaseConnection, username);
		
			ArrayList<HashMap<String, String>> students = new ArrayList<HashMap<String, String>>();
			students = databaseConnection.queryStudents();
			for (int i = 0; i < students.size(); i++) {
				String id = students.get(i).get("id");
				String first = databaseConnection.queryUserFirstName(id).get(0).get("firstname");
				String last = databaseConnection.queryUserLastName(id).get(0).get("lastname");
				selectStudentsList.add(first + " " + last + " (User ID = " + id + ")");
			}
			return "selectStudentsSuccess";
		}
		catch (Exception e) {
			return "selectStudentsFailure";
		}
	}
	
	public String executeCreateNewAssignment() {
		try {
			DatabaseConnection databaseConnection = new DatabaseConnection();
			username = (String) sessionMap.get("username");

			String[] split = assignmentCourse.split("Course ID = ");
			String assignmentCourseID = split[split.length - 1];
			assignmentCourseID = assignmentCourseID.substring(0, assignmentCourseID.length() - 1);
		
			DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");  
			String duedate = dateFormat.format(assignmentDueDate);
			duedate += " 23:59:59";
		
			String ret = databaseConnection.createAssignment(assignmentName, assignmentCourseID, duedate);
			if (ret.equals("createNewAssignmentFailureAssignmentTaken")) {
				sessionMap.put("errorMessage", "Assignment name taken.  Please choose another one.");
				return "createNewAssignmentFailureAssignmentTaken";
			}
		
			setID(databaseConnection, username);
			setDashboardInformation(user_id, databaseConnection);
		
			return "createNewAssignmentSuccess";
		}
		catch (Exception e) {
			return "createNewAssignmentFailure";
		}
	}
	
	public String executeSelectCourse() {
		try {
			String errorMessage = (String) sessionMap.get("errorMessage");
			addActionError(errorMessage);
		
			DatabaseConnection databaseConnection = new DatabaseConnection();
			username = (String) sessionMap.get("username");
			setID(databaseConnection, username);
		
			ArrayList<HashMap<String, String>> courses = new ArrayList<HashMap<String, String>>();
			courses = databaseConnection.queryCoursesGivenUser(user_id);
			for (int i = 0; i < courses.size(); i++) {
				String id = courses.get(i).get("course_id");
				String name = databaseConnection.queryCourseNameGivenCourseID(id).get(0).get("courseName");
				selectCourseList.add(name + " (Course ID = " + id + ")");
			}
		
			return "selectCourseSuccess";
		}
		catch (Exception e) {
			return "selectCourseFailure";
		}
	}
	
	public String executeSelectCourseForGrades() {
		try {
			DatabaseConnection databaseConnection = new DatabaseConnection();
			username = (String) sessionMap.get("username");
			setID(databaseConnection, username);
		
			ArrayList<HashMap<String, String>> courses = new ArrayList<HashMap<String, String>>();
			courses = databaseConnection.queryCoursesGivenUser(user_id);
			for (int i = 0; i < courses.size(); i++) {
				String id = courses.get(i).get("course_id");
				String name = databaseConnection.queryCourseNameGivenCourseID(id).get(0).get("courseName");
				selectCourseList.add(name + " (Course ID = " + id + ")");
			}
		
			return "selectCourseForGradesSuccess";
		}
		catch (Exception e) {
			return "selectCourseForGradesFailure";
		}
	}
	
	public String executeSelectAssignmentForGrades() {
		try {
			DatabaseConnection databaseConnection = new DatabaseConnection();
			username = (String) sessionMap.get("username");
			setID(databaseConnection, username);
		
			ArrayList<HashMap<String, String>> assignments = new ArrayList<HashMap<String, String>>();
			String[] split = assignmentCourse.split("Course ID = ");
			String assignmentCourseID = split[split.length - 1];
			assignmentCourseID = assignmentCourseID.substring(0, assignmentCourseID.length() - 1);
		
			sessionMap.put("courseID", assignmentCourseID);
		
			assignments = databaseConnection.queryAssignmentsFromCourse(assignmentCourseID);
			for (int i = 0; i < assignments.size(); i++) {
				String name = assignments.get(i).get("assignment_name");
				String id = databaseConnection.queryAssignmentIDGivenAssignmentName(name).get(0).get("id");
				selectAssignmentList.add(name + " (Assignment ID = " + id + ")");
			}
		
			return "selectAssignmentForGradesSuccess";
		}
		catch (Exception e) {
			return "selectAssignmentForGradesFailure";
		}
	}
	
	public String executeEnterGrades() {
		try {
			DatabaseConnection databaseConnection = new DatabaseConnection();
			username = (String) sessionMap.get("username");
			String courseID = (String) sessionMap.get("courseID");
			setID(databaseConnection, username);
		
			String[] split = selectedAssignment.split("Assignment ID = ");
			String assignmentID = split[split.length - 1];
			assignmentID = assignmentID.substring(0, assignmentID.length() - 1);
		
			sessionMap.put("assignmentID", assignmentID);
			sessionMap.put("totalPointsPossible", totalPointsPossible);
		
			ArrayList<HashMap<String, String>> users = new ArrayList<HashMap<String, String>>();
			users = databaseConnection.queryUsersInCourse(courseID);
			for (int i = 0; i < users.size(); i++) {
				String id = users.get(i).get("user_id");
				if (databaseConnection.queryRoleGivenUser(id).get(0).get("role").equals("student")) {
					User student = new User();
					String first = databaseConnection.queryUserFirstName(id).get(0).get("firstname");
					String last = databaseConnection.queryUserLastName(id).get(0).get("lastname");
					student.setUserID(id);
					student.setFirstname(first);
					student.setLastname(last);
					studentList.add(student);
				}
			}
		
			sessionMap.put("studentListOld", (Object) studentList);
		
			return "enterGradesSuccess";
		}
		catch (Exception e) {
			return "enterGradesFailure";
		}
	}
	
	public String executeSetGrades() {
		try {
			DatabaseConnection databaseConnection = new DatabaseConnection();
		
			for (int i = 0; i < studentList.size(); i++) {
				User student = new User();
				student = studentList.get(i);
			
				String assignmentID = (String) sessionMap.get("assignmentID");
				String pointsEarned = student.getPointsEarned();
				String totalPointsPossible = (String) sessionMap.get("totalPointsPossible");
				String grade = pointsEarned + "/" + totalPointsPossible;
			
				ArrayList<User> studentListOld = new ArrayList<User>();
				studentListOld = (ArrayList<User>) sessionMap.get("studentListOld");
			
				String userID = studentListOld.get(i).getUserID();
				
				String ret = databaseConnection.setGrades(assignmentID, userID, grade);
			}
		
			sessionMap.remove("courseID");
			sessionMap.remove("assignmentID");
			sessionMap.remove("totalPointsPossible");
			sessionMap.remove("studentListOld");
		
			username = (String) sessionMap.get("username");
			setID(databaseConnection, username);
			setDashboardInformation(user_id, databaseConnection);
		
			return "setGradesSuccess";
		}
		catch (Exception e) {
			return "setGradesFailure";
		}
	}
	
	public String executeReturnToDashboard() {
		try {
			DatabaseConnection databaseConnection = new DatabaseConnection();
			username = (String) sessionMap.get("username");
			setID(databaseConnection, username);
			setDashboardInformation(user_id, databaseConnection);
			if (role.equals("student")) {
				return "returnToDashboardSuccessStudent";
			}
			else {
				return "returnToDashboardSuccessTeacher";
			}
		}
		catch (Exception e) {
			return "returnToDashboardFailure";
		}
	}
	
	public String executeLogout() {
        sessionMap.clear();
        addActionMessage("You have been successfully logged out.");
        return "logoutSuccess";
	}
}