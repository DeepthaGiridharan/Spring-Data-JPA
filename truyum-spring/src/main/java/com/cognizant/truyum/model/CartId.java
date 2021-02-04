package com.cognizant.truyum.model;
import java.io.Serializable;

public class CartId implements Serializable {
	private int userId;
	private int productId;
	
	public CartId(int userId, int productId) {
		super();
		this.userId = userId;
		this.productId = productId;
	}
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productId;
		result = prime * result + userId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartId other = (CartId) obj;
		if (productId != other.productId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	}