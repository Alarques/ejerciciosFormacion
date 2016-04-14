package com.indra.formacio.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name="PRODUCT_CUSTOMER")
public class Sale {
	@EmbeddedId
	SaleKey key;
	@Column
	protected Date creation_date;
	
	public SaleKey getKey() {
		return key;
	}
	public void setKey(SaleKey key) {
		this.key = key;
	}
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
}