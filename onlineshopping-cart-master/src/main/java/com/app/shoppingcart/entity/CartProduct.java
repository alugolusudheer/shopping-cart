package com.app.shoppingcart.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.app.shoppingcart.helper.CartProductPK;

import lombok.Data;
@Data
@Entity
public class CartProduct implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CartProductPK pk;

	@Column(name = "PRODUCT_QUANTITY")
	private int quantity;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
		result = prime * result + quantity;
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
		CartProduct other = (CartProduct) obj;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CartProduct [pk=" + pk + ", quantity=" + quantity + "]";
	}

	public CartProduct(CartProductPK pk, int quantity) {
		super();
		this.pk = pk;
		this.quantity = quantity;
	}

	public CartProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

}
