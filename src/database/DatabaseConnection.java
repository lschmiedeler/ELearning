package database;

import java.sql.*;
import java.util.*;

public class DatabaseConnection {
	// DB Credentials
	static String DB_username = "root";
	static String DB_password = "12345678";
	
	// DB Connection Variables
	static String databaseName = "e_learning";
	static String url = "jdbc:mysql://localhost:3306/"+ databaseName;
		
	public String login(String username, String password) {
		String ret = "loginFailure";
		Connection connection = null;
		try {
			// Register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		
			// Open Database Connection
			connection = DriverManager.getConnection(url, DB_username, DB_password);
			// System.out.println("Connected to database successfully...");
		
			// Execute a Query
			// System.out.println("Validating...");
	        String checkData = "SELECT * FROM users WHERE username = ? AND password = MD5(?)";
	        PreparedStatement ps = connection.prepareStatement(checkData);
	        ps.setString(1, username);
	        ps.setString(2, password);
	        ResultSet rs = ps.executeQuery();
			
	        while (rs.next()) {
	             ret = "loginSuccess";
	        }
		}
		catch (Exception e) {
			ret = "loginFailure";
			System.out.println(e);
	    }
		finally {
	    	if (connection != null) {
	    		try {
	    			connection.close();
	            }
	    		catch (Exception e) {
	    			System.out.println(e);
	            }
	    	}
	    }
		return ret;
	}
	
	public String createAccount(String firstname, String lastname, String email, String username, String password, String role) {
		Connection connection = null;
		try {
			// Register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
					
			// Open Database Connection
			connection = DriverManager.getConnection(url, DB_username, DB_password);
			// System.out.println("Connected to database successfully...");
			
			// Execute a Query
	        String checkData = "SELECT * FROM users WHERE username = ?";
	        PreparedStatement ps = connection.prepareStatement(checkData);
	        ps.setString(1, username);
	        ResultSet rs = ps.executeQuery();
			
	        if (rs.next()) {
	        	return "createNewAccountFailureUsernameTaken";
	        }
	        else {
				String sql = "INSERT INTO users (firstname, lastname, role, username, password, email) VALUES (?, ?, ?, ? , MD5(?), ?)";
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, firstname);
				stmt.setString(2, lastname);
				stmt.setString(3, role);
				stmt.setString(4, username);
				stmt.setString(5, password);
				stmt.setString(6, email);
				int row = stmt.executeUpdate();
				if (row > 0) {
					// System.out.println("User inserted successfully...");
				}
	        }
		}
		catch(SQLException se) {
			// Handle Errors for JDBC
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(connection != null) {
					connection.close();
				}
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
		return "createNewAccountSuccess";
	}
	
	public String createCourse(String courseName, String term, String subject, String students, String description, String user_id) {
		Connection connection = null;
		try {
			// Register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
					
			// Open Database Connection
			connection = DriverManager.getConnection(url, DB_username, DB_password);
			// System.out.println("Connected to database successfully...");
			
			// Execute a Query
	        String checkData = "SELECT * FROM courses WHERE courseName = ?";
	        PreparedStatement ps = connection.prepareStatement(checkData);
	        ps.setString(1, courseName);
	        ResultSet rs = ps.executeQuery();
			
	        if (rs.next()) {
	        	return "createNewCourseFailureCourseTaken";
	        }
	        else {
				String sql = "INSERT INTO courses (courseName, term, subject, other) VALUES (?, ?, ?, ?)";
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, courseName);
				stmt.setString(2, term);
				stmt.setString(3, subject);
				stmt.setString(4, description);
				int row = stmt.executeUpdate();
				if (row > 0) {
					// System.out.println("Course inserted successfully...");
				}
				
				// Now, insert into course_user the student and course pairs which were specified
				String[] students_arr = students.split(",");
				// clean whitespace
				for (int i = 0; i < students_arr.length; i++) {
					students_arr[i] = students_arr[i].trim();
				}
				
				// iterate and add to course_user
				for (int i = 0; i < students_arr.length; i++) {
					String sql_inner = "INSERT INTO course_user (course_id, user_id) VALUES (?, ?)";
					PreparedStatement stmt_inner = connection.prepareStatement(sql_inner);
					stmt_inner.setString(1, queryCourseIDGivenCourseName(courseName).get(0).get("id"));
					stmt_inner.setString(2, students_arr[i]);
					int row_inner = stmt_inner.executeUpdate();
					if (row_inner > 0) {
						// System.out.println("Course/student pair inserted successfully...");
					}
				}
				
				String sql_inner = "INSERT INTO course_user (course_id, user_id) VALUES (?, ?)";
				PreparedStatement stmt_inner = connection.prepareStatement(sql_inner);
				stmt_inner.setString(1, queryCourseIDGivenCourseName(courseName).get(0).get("id"));
				stmt_inner.setString(2, user_id);
				int row_inner = stmt_inner.executeUpdate();
				if (row_inner > 0) {
					// System.out.println("Course/teacher pair inserted successfully...");
				}
	        }
		}
		catch(SQLException se) {
			// Handle Errors for JDBC
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(connection != null) {
					connection.close();
				}
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
		return "createNewCourseSuccess";
	}
	
	public String createAssignment(String assignment_name, String course_id, String deadline) {
		Connection connection = null;
		try {
			// Register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
					
			// Open Database Connection
			connection = DriverManager.getConnection(url, DB_username, DB_password);
			// System.out.println("Connected to database successfully...");
			
			// build insertion
	        String checkData = "SELECT * FROM assignments WHERE assignment_name = ?";
	        PreparedStatement ps = connection.prepareStatement(checkData);
			ps.setString(1, assignment_name);
	        ResultSet rs = ps.executeQuery();
			
	        if (rs.next()) {
	        	return "createNewAssignmentFailureAssignmentTaken";
	        }
	        else {
	        	String sql = "INSERT INTO assignments (assignment_name, deadline, course_id) VALUES (?, ?, ?)";
	        	PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, assignment_name);
				stmt.setString(2, deadline);
				stmt.setString(3, course_id);
				int row = stmt.executeUpdate();
	        	
				if (row > 0) {
					// System.out.println("Assignment inserted successfully...");
				}
				
				String assignmentID = queryAssignmentIDGivenAssignmentName(assignment_name).get(0).get("id");
				ArrayList<HashMap<String, String>> users = queryUsersInCourse(course_id);
				for (int i = 0; i < users.size(); i++) {
					String sql_inner = "INSERT INTO assignment_user (Assignment_id, user_id) VALUES (?, ?)";
					PreparedStatement stmt_inner = connection.prepareStatement(sql_inner);
					stmt_inner.setString(1, assignmentID);
					stmt_inner.setString(2, users.get(i).get("user_id"));
					int row_inner = stmt_inner.executeUpdate();
					if (row_inner > 0) {
						// System.out.println("Assignment/user pair inserted successfully...");
					}
				}
	        }
		}
		catch(SQLException se) {
			// Handle Errors for JDBC
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(connection != null) {
					connection.close();
				}
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
		
		return "createNewAssignmentSuccess";
	}
	
	public String setGrades(String assignment_id, String user_id, String grade) {
		Connection connection = null;
		try {
			// Register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
					
			// Open Database Connection
			connection = DriverManager.getConnection(url, DB_username, DB_password);
			// System.out.println("Connected to database successfully...");
			
			// Execute a Query
	       String sql = "UPDATE assignment_user SET grade = ? WHERE Assignment_id = ? AND user_id = ?";
	       PreparedStatement stmt = connection.prepareStatement(sql);
	       stmt.setString(1, grade);
	       stmt.setString(2, assignment_id);
	       stmt.setString(3, user_id);
	       int row = stmt.executeUpdate();
	       if (row > 0) {
	    	   // System.out.println("Grade inserted successfully...");
	       }
		}
		catch(SQLException se) {
			// Handle Errors for JDBC
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(connection != null) {
					connection.close();
				}
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
		return "setGradesSuccess";
	}
	
	public ArrayList<HashMap<String, String>> genericQuery(List<String> target_cols, String target_table, Map<String, String> conditions) {	
		Connection connection = null;
		
		try {
			// Register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
					
			// Open Database Connection
			connection = DriverManager.getConnection(url, DB_username, DB_password);
			// System.out.println("Connected to database successfully...");
		
			// Build Query
			String queryString = "SELECT " + String.join(", ", target_cols) + " FROM " + target_table + " WHERE ";
			Iterator<Map.Entry<String, String>> itr = conditions.entrySet().iterator();
									
			do {
				Map.Entry<String, String> entry = itr.next();
				String col_name = entry.getKey();
				String val = entry.getValue();
				queryString += col_name + " = '" + val + "'";
				if (itr.hasNext()) {
					queryString += " AND ";
				}
			} while (itr.hasNext());
							
			// System.out.println(queryString);
			
			PreparedStatement ps = connection.prepareStatement(queryString);
	        ResultSet rs = ps.executeQuery();
	        ResultSetMetaData md = rs.getMetaData();

	        int columns = md.getColumnCount();
	        ArrayList list = new ArrayList(10);
	        
	        while (rs.next()) {
	        	HashMap<String, String> row;
	        	row = new HashMap<>(columns);
	        	for (int i=1; i <= columns; ++i) {
	        		row.put(md.getColumnName(i), rs.getString(i));
	        	}
	        	list.add(row);
	        }
	        
	        return list;
			
		}
		catch(SQLException se) {
			// handle errors for JDBC
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(connection != null) {
					connection.close();
				}
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
		return null;
	}
	
	public ArrayList<HashMap<String, String>> queryUsersInCourse(String target_course) {
		HashMap<String, String> course_cond = new HashMap<>();
		course_cond.put("course_id", target_course);
		String table_name = "course_user";
		ArrayList<String> column = new ArrayList<String>(Arrays.asList("user_id"));
		return genericQuery(column, table_name, course_cond);
	}
	
	public ArrayList<HashMap<String, String>> queryTeachersInCourse(String target_course) {
		HashMap<String, String> course_cond = new HashMap<>();
		course_cond.put("course_id", target_course);
		String table_name = "course_user";
		ArrayList<String> column = new ArrayList<String>(Arrays.asList("user_id"));
		ArrayList<HashMap<String, String>> all_vals = new ArrayList<HashMap<String, String>>(10);
		ArrayList<HashMap<String, String>> return_vals = new ArrayList<HashMap<String, String>>(10);
		all_vals = genericQuery(column, table_name, course_cond);
		for (int i = 0; i < all_vals.size(); i++) {
			String user_id = all_vals.get(i).get("user_id");
			if (queryRoleGivenUser(user_id).get(0).get("role").equals("teacher")) {
				return_vals.add(all_vals.get(i));
			}
		}
		return return_vals;
	}
	
	public ArrayList<HashMap<String, String>> queryStudentsGivenTeacher(String teacher_id) {
		// first, get the teachers courses
		ArrayList<HashMap<String, String>> courses = queryCoursesGivenUser(teacher_id);
		// iterate through courses and get students
		// initialize return Array
		ArrayList<HashMap<String, String>> all_vals = new ArrayList<HashMap<String, String>>(10);
		ArrayList<HashMap<String, String>> return_vals = new ArrayList<HashMap<String, String>>(10);
		for (int i = 0; i < courses.size(); i++) {
			all_vals.addAll(queryUsersInCourse(courses.get(i).get("course_id")));
		}
		// return_vals gets appended the users from each class
		// now, we remove the teacher(s)
		for (int i = 0; i < all_vals.size(); i++) {
			String user_id = all_vals.get(i).get("user_id");
			if (queryRoleGivenUser(user_id).get(0).get("role").equals("student")) {
				return_vals.add(all_vals.get(i));
			}
		}
		// then, we return
		return return_vals;
	}
	
	public ArrayList<HashMap<String, String>> queryTeachersGivenStudents(String student_id) {
		// first, get the students courses
		ArrayList<HashMap<String, String>> courses = queryCoursesGivenUser(student_id);
		// iterate through courses and get students
		// initialize return Array
		ArrayList<HashMap<String, String>> all_vals = new ArrayList<HashMap<String, String>>(10);
		ArrayList<HashMap<String, String>> return_vals = new ArrayList<HashMap<String, String>>(10);
		for (int i = 0; i < courses.size(); i++) {
			all_vals.addAll(queryUsersInCourse(courses.get(i).get("course_id")));
		}
		// return_vals gets appended the users from each class
		// now, remove the students
		for (int i = 0; i < all_vals.size(); i++) {
			String user_id = all_vals.get(i).get("user_id");
			if (queryRoleGivenUser(user_id).get(0).get("role").equals("teacher")) {
				return_vals.add(all_vals.get(i));
			}
		}
		// then, we return
		return return_vals;
	}
	
	public ArrayList<HashMap<String, String>> queryStudents() {
		HashMap<String, String> user_cond = new HashMap<>();
		user_cond.put("role", "student");
		String table_name = "users";
		ArrayList<String> column = new ArrayList<String>(Arrays.asList("id"));
		return genericQuery(column, table_name, user_cond);
	}
	
	public ArrayList<HashMap<String, String>> queryCoursesGivenUser(String user_id) {
		HashMap<String, String> user_cond = new HashMap<>();
		user_cond.put("user_id", user_id);
		String table_name = "course_user";
		ArrayList<String> column = new ArrayList<String>(Arrays.asList("course_id"));
		return genericQuery(column, table_name, user_cond);
	}
	
	public ArrayList<HashMap<String, String>> queryAssignmentsGivenUser(String user_id) {
		// first, get the courses
		ArrayList<HashMap<String, String>> courses = queryCoursesGivenUser(user_id);
		// iterate through courses and get assignments
		// initialize return Array
		ArrayList<HashMap<String, String>> return_vals = new ArrayList<HashMap<String, String>>(10);
		for (int i = 0; i < courses.size(); i++) {
			return_vals.addAll(queryAssignmentsFromCourse(courses.get(i).get("course_id")));
		}
		// return_vals gets appended the assignments from each class
		// now, we return
		return return_vals;
	}
	
	public ArrayList<HashMap<String, String>> queryAssignmentsFromCourse(String target_course) {
		HashMap<String, String> course_cond = new HashMap<>();
		course_cond.put("course_id", target_course);
		String table_name = "assignments";
		ArrayList<String> columns = new ArrayList<String>(Arrays.asList("assignment_name", "deadline"));
		return genericQuery(columns, table_name, course_cond);
	}

	public ArrayList<HashMap<String, String>> queryUserIDGivenUsername(String username) {
		HashMap<String, String> user_cond = new HashMap<>();
		user_cond.put("username", username);
		String table_name = "users";
		ArrayList<String> column = new ArrayList<String>(Arrays.asList("id"));
		return genericQuery(column, table_name, user_cond);
	}
	
	public ArrayList<HashMap<String, String>> queryRoleGivenUser(String user_id) {
		HashMap<String, String> user_cond = new HashMap<>();
		user_cond.put("id", user_id);
		String table_name = "users";
		ArrayList<String> column = new ArrayList<String>(Arrays.asList("role"));
		return genericQuery(column, table_name, user_cond);
	}
	
	public ArrayList<HashMap<String, String>> queryUserFirstName(String user_id) {
		HashMap<String, String> user_cond = new HashMap<>();
		user_cond.put("id", user_id);
		String table_name = "users";
		ArrayList<String> column = new ArrayList<String>(Arrays.asList("firstname"));
		return genericQuery(column, table_name, user_cond);
	}
	
	public ArrayList<HashMap<String, String>> queryUserLastName(String user_id) {
		HashMap<String, String> user_cond = new HashMap<>();
		user_cond.put("id", user_id);
		String table_name = "users";
		ArrayList<String> column = new ArrayList<String>(Arrays.asList("lastname"));
		return genericQuery(column, table_name, user_cond);
	}
	
	public ArrayList<HashMap<String, String>> queryUserName(String user_id) {
		HashMap<String, String> user_cond = new HashMap<>();
		user_cond.put("id", user_id);
		String table_name = "users";
		ArrayList<String> column = new ArrayList<String>(Arrays.asList("username"));
		return genericQuery(column, table_name, user_cond);
	}
	
	public ArrayList<HashMap<String, String>> queryUserEmailName(String user_id) {
		HashMap<String, String> user_cond = new HashMap<>();
		user_cond.put("id", user_id);
		String table_name = "users";
		ArrayList<String> column = new ArrayList<String>(Arrays.asList("email"));
		return genericQuery(column, table_name, user_cond);
	}
	
	public ArrayList<HashMap<String, String>> queryCourseIDGivenCourseName(String courseName) {
		HashMap<String, String> course_cond = new HashMap<>();
		course_cond.put("courseName", courseName);
		String table_name = "courses";
		ArrayList<String> column = new ArrayList<String>(Arrays.asList("id"));
		return genericQuery(column, table_name, course_cond);
	}
	
	public ArrayList<HashMap<String, String>> queryCourseNameGivenCourseID(String course_id) {
		HashMap<String, String> course_cond = new HashMap<>();
		course_cond.put("id", course_id);
		String table_name = "courses";
		ArrayList<String> column = new ArrayList<String>(Arrays.asList("courseName"));
		return genericQuery(column, table_name, course_cond);
	}
	
	public ArrayList<HashMap<String, String>> queryCourseSubjectGivenCourseID(String course_id) {
		HashMap<String, String> course_cond = new HashMap<>();
		course_cond.put("id", course_id);
		String table_name = "courses";
		ArrayList<String> column = new ArrayList<String>(Arrays.asList("subject"));
		return genericQuery(column, table_name, course_cond);
	}
	
	public ArrayList<HashMap<String, String>> queryCourseTermGivenCourseID(String course_id) {
		HashMap<String, String> course_cond = new HashMap<>();
		course_cond.put("id", course_id);
		String table_name = "courses";
		ArrayList<String> column = new ArrayList<String>(Arrays.asList("term"));
		return genericQuery(column, table_name, course_cond);
	}
	
	public ArrayList<HashMap<String, String>> queryAssignmentIDGivenAssignmentName(String assignmentName) {
		HashMap<String, String> assign_cond = new HashMap<>();
		assign_cond.put("assignment_name", assignmentName);
		String table_name = "assignments";
		ArrayList<String> column = new ArrayList<String>(Arrays.asList("id"));
		return genericQuery(column, table_name, assign_cond);
	}
	
	public ArrayList<HashMap<String, String>> queryAssignmentNameGivenAssignmentID(String assignment_id) {
		HashMap<String, String> assign_cond = new HashMap<>();
		assign_cond.put("id", assignment_id);
		String table_name = "assignments";
		ArrayList<String> column = new ArrayList<String>(Arrays.asList("assignment_name"));
		return genericQuery(column, table_name, assign_cond);
	}
	
	public ArrayList<HashMap<String, String>> queryAssignmentCourseGivenAssignmentID(String assignment_id) {
		HashMap<String, String> assign_cond = new HashMap<>();
		assign_cond.put("id", assignment_id);
		String table_name = "assignments";
		ArrayList<String> column = new ArrayList<String>(Arrays.asList("course_id"));
		return genericQuery(column, table_name, assign_cond);
	}
	
	public ArrayList<HashMap<String, String>> queryAssignmentDetailsGivenUser(String user_id) {
		// first, get the courses
		ArrayList<HashMap<String, String>> courses = queryCoursesGivenUser(user_id);
		// iterate through courses and get assignments
		// initialize return Array
		ArrayList<HashMap<String, String>> return_vals = new ArrayList<HashMap<String, String>>(10);
		for (int i = 0; i < courses.size(); i++) {
			return_vals.addAll(queryAssignmentsFromCourse(courses.get(i).get("courseName")));
		}
		// return_vals gets appended the assignments from each class
		// now, we return
		return return_vals;
	}
	
	public ArrayList<HashMap<String, String>> queryAssignmentInfoGivenUserID(String user_id) {
		HashMap<String, String> assign_cond = new HashMap<>();
		assign_cond.put("user_id", user_id);
		String table_name = "assignment_user";
		ArrayList<String> column = new ArrayList<String>(Arrays.asList("Assignment_id", "grade"));
		return genericQuery(column, table_name, assign_cond);
	}
	
	public ArrayList<HashMap<String, String>> queryAssignmentDetailsGivenID(String assignment_id) {
		HashMap<String, String> assign_cond = new HashMap<>();
		assign_cond.put("Assignment_id", assignment_id);
		String table_name = "assignment_user";
		ArrayList<String> column = new ArrayList<String>(Arrays.asList("user_id", "grade"));
		return genericQuery(column, table_name, assign_cond);
	}
	
	public ArrayList<HashMap<String, String>> queryAssignmentDeadlineGivenAssignmentID(String assignment_id) {
		HashMap<String, String> assign_cond = new HashMap<>();
		assign_cond.put("id", assignment_id);
		String table_name = "assignments";
		ArrayList<String> column = new ArrayList<String>(Arrays.asList("deadline"));
		return genericQuery(column, table_name, assign_cond);
	}
}
