package objects;

public class User {
	String userID;
	String firstname;
	String lastname;
	String username;
	String email;
	String pointsEarned;
	String totalPointsPossible;
	
	public String getUserID() {
		return userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		String ret = "id: " + userID + "\n";
		ret += "firstname lastname: " + firstname + " " + lastname + "\n";
		ret += "username: " + username + "\n";
		ret += "email: " + email + "\n";
		ret += "grade: " + pointsEarned + "/" + totalPointsPossible;
		return ret;
	}
}