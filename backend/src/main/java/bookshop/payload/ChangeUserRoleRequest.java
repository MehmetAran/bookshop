package bookshop.payload;

import javax.persistence.ManyToMany;

import bookshop.model.Role;

public class ChangeUserRoleRequest {
	private long userID;
	private String role;
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
