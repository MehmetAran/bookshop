package bookshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

@Entity
@Table
public class Publisher {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long publisherID;
	@NotBlank
	@NotNull
	private String publisherName;
	@NotBlank
	@NotNull
	private String about;
	public long getPublisherID() {
		return publisherID;
	}
	public void setPublisherID(long publisherID) {
		this.publisherID = publisherID;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
	
}
