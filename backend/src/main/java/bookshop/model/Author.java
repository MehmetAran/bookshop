package bookshop.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
@Table
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotBlank
    @NotEmpty
    @NotNull
	private long authorID;
    @NotBlank
    @NotEmpty
    @NotNull
	private String authorName;
    @NotBlank
    @NotEmpty
    @NotNull
    private String authorLastname;
    @NotBlank
    @NotEmpty
    @NotNull
    private String about;
    @NotBlank
    @NotEmpty
    @NotNull
    @OneToOne
    @JoinColumn(name ="FK_AuthorUser")
    private User user;
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
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User userID) {
		this.user = userID;
	}
    
    
    
}
