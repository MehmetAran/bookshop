package bookshop.payload;

public class ChangeUserRoleResponse {
	private long userID;
	private String message;
	public long getUserID() {
		return userID;
	}
	
	
	public ChangeUserRoleResponse(long userID, String message) {
		super();
		this.userID = userID;
		this.message = message;
	}


	public ChangeUserRoleResponse(String message) {
		super();
		this.message = message;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
