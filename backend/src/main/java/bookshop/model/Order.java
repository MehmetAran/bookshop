package bookshop.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

@Entity
@Table
public class Order {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderID;
	@NotEmpty
	@NotBlank
	@ManyToMany
	private User sellerID;
	@ManyToMany
	@NotEmpty
	@NotBlank
	private Book bookId;
	@NotBlank
	@NotEmpty
	private double price;
	@ManyToMany
	@NotEmpty
	@NotBlank
	private User customerID;
    @CreatedBy
    private Long createdBy;
    @LastModifiedBy
    private Long updatedBy;
	public long getOrderID() {
		return orderID;
	}
	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}
	public User getSellerID() {
		return sellerID;
	}
	public void setSellerID(User sellerID) {
		this.sellerID = sellerID;
	}
	public Book getBookId() {
		return bookId;
	}
	public void setBookId(Book bookId) {
		this.bookId = bookId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public User getCustomerID() {
		return customerID;
	}
	public void setCustomerID(User customerID) {
		this.customerID = customerID;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
    
	
}
