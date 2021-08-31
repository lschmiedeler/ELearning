package objects;

public class Assignment {
	private String assignmentName;
	private String assignmentID;
	private String assignmentDueDate;
	private String assignmentCourse;
	private String pointsEarned;
	private String totalPointsPossible;
	
	public String getAssignmentName() {
		return assignmentName;
	}
	
	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}
	
	public String getAssignmentID() {
		return assignmentID;
	}

	public void setAssignmentID(String assignmentID) {
		this.assignmentID = assignmentID;
	}

	public String getAssignmentDueDate() {
		return assignmentDueDate;
	}
	
	public void setAssignmentDueDate(String assignmentDueDate) {
		this.assignmentDueDate = assignmentDueDate;
	}
	
	public String getAssignmentCourse() {
		return assignmentCourse;
	}
	
	public void setAssignmentCourse(String assignmentCourse) {
		this.assignmentCourse = assignmentCourse;
	}

	public String getPointsEarned() {
		return pointsEarned;
	}

	public void setPointsEarned(String pointsEarned) {
		this.pointsEarned = pointsEarned;
	}

	public String getTotalPointsPossible() {
		return totalPointsPossible;
	}

	public void setTotalPointsPossible(String totalPointsPossible) {
		this.totalPointsPossible = totalPointsPossible;
	}
	
	public String toString() {
		String ret = "id: " + assignmentID + "\n";
		ret += "name: " + assignmentName + "\n";
		ret += "due date: " + assignmentDueDate + "\n";
		ret += "course: " + assignmentCourse + "\n";
		ret += "grade: " + pointsEarned + "/" + totalPointsPossible;
		return ret;
	}
}