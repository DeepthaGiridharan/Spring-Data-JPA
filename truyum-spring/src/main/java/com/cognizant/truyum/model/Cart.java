package com.cognizant.truyum.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
@IdClass(CartId.class)
public class Cart {

	@Id
	@Column(name = "ct_us_id")
	private int userId;
	@Id
	@Column(name = "ct_pr_id")
	private int productId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Cart(int userId, int productId) {
		super();
		this.userId = userId;
		this.productId = productId;
	}
}