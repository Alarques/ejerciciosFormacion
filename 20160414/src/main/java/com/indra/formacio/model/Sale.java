package com.indra.formacio.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_CUSTOMER")
public class Sale {
	
	@EmbeddedId
	protected SalePK key;
	
	@Column
	protected int cantidad;

	public SalePK getKey() {
		return key;
	}

	public void setKey(SalePK key) {
		this.key = key;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
