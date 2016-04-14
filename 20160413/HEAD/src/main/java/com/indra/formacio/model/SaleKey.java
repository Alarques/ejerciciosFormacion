package com.indra.formacio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;


public class SaleKey implements Serializable{
	@Column(name="PRODUCT_ID")
	protected long productid;
	@Column(name="CUSTOMER_ID")
	protected long customerid;
	
	public SaleKey(){
		
	}
	
	public SaleKey(long product_id, long customer_id){
		this.customerid=customer_id;
		this.productid=product_id;
	}

	public Long getProduct_id() {
		return productid;
	}

	public void setProduct_id(long product_id) {
		this.productid = product_id;
	}

	public Long getCustomer_id() {
		return customerid;
	}

	public void setCustomer_id(long customer_id) {
		this.customerid = customer_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (customerid ^ (customerid >>> 32));
		result = prime * result + (int) (productid ^ (productid >>> 32));
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
		SaleKey other = (SaleKey) obj;
		if (customerid != other.customerid)
			return false;
		if (productid != other.productid)
			return false;
		return true;
	}
}