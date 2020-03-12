package bookshop.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class UpdateAuthorRequest {
	@Positive
	private long authorID;
	@NotBlank
	@NotEmpty
	@Size(min = 3 ,max = 40)
	private String authorName;
	@NotBlank
	@NotEmpty
	@Size(min = 2 ,max = 40)
	private String authorLastname;
	@NotBlank
	@NotEmpty
	@Size(min = 100 ,max = 999)
	private String authorAbout;
	public long getAuthorID() {
		return authorID;
	}
	public void setAuthorID(long authorID) {
		this.authorID = authorID;
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
	public String getAuthorAbout() {
		return authorAbout;
	}
	public void setAuthorAbout(String authorAbout) {
		this.authorAbout = authorAbout;
	}
	
	
	
}
