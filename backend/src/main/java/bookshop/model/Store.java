package bookshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Entity
@Table
public class Store {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long storeID;
	@ManyToOne
	@NotBlank
	@NotEmpty
	private User sellerID;
	@ManyToOne
	@NotBlank
	@NotEmpty
	private User receiverID;
	@ManyToOne
	@NotBlank
	@NotEmpty
	private Book bookID;
	@NotBlank
	@NotEmpty
	@Positive
	private long priceOfOnePiece;
	@NotBlank
	@NotEmpty
	@Positive
	private long piece;
	
	public long getStoreID() {
		return storeID;
	}
	public void setStoreID(long storeID) {
		this.storeID = storeID;
	}
	public User getSellerID() {
		return sellerID;
	}
	public void setSellerID(User sellerID) {
		this.sellerID = sellerID;
	}
	public User getReceiverID() {
		return receiverID;
	}
	public void setReceiverID(User receiverID) {
		this.receiverID = receiverID;
	}
	public Book getBookID() {
		return bookID;
	}
	public void setBookID(Book bookID) {
		this.bookID = bookID;
	}
	public long getPriceOfOnePiece() {
		return priceOfOnePiece;
	}
	public void setPriceOfOnePiece(long priceOfOnePiece) {
		this.priceOfOnePiece = priceOfOnePiece;
	}
	public long getPiece() {
		return piece;
	}
	public void setPiece(long piece) {
		this.piece = piece;
	}

	
	
	

}
