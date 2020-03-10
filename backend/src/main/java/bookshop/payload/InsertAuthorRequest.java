package bookshop.payload;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class InsertAuthorRequest {
	@NotBlank
	@NotEmpty
	private long userID;
	@NotBlank
	@NotEmpty
	@Size(min = 3,max = 40, message = "Character number of 'authorName' must be between 3 and 40.")
	private String authorName;
	@NotBlank
	@NotEmpty
	@Size(min = 2,max = 40, message = "Character number of 'authorLastname' must be between 2 and 40. ")
	private String authorLastname;
	@NotBlank
	@NotEmpty
	@Size(min = 50,max = 999, message = "Character number of 'about' must be between 50 and 999. ")
	private String about;
	
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorLastname() {
		return authorLastname;
	}
	public void setAuthorLastname(String authorLastname) {
		this.authorLastname = authorLastname;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
	
}
