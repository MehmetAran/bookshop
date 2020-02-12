package bookshop.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Index;
import org.hibernate.validator.constraints.UniqueElements;

import com.sun.istack.NotNull;

@Entity
@Table
public class Book {
	@NotBlank
	@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private long bookID;
	@Column(unique = true)
	@NotBlank
	@NotNull
	private String ISBN;
	@NotBlank
	@NotNull
	private String bookName;
	@NotNull
	@ManyToOne(cascade =CascadeType.ALL)
	private Publisher publisher;
	@NotBlank
	@NotNull
	private double price;
	@NotBlank
	@NotNull
	@ManyToOne(cascade =CascadeType.ALL)
	private Author author;
	@NotBlank
	@NotNull
	@ManyToOne(cascade =CascadeType.ALL)
	private Category category;
	@NotBlank
	@NotNull
	private String about;
	
	public long getBookID() {
		return bookID;
	}
	public void setBookID(long bookID) {
		this.bookID = bookID;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
	

}
