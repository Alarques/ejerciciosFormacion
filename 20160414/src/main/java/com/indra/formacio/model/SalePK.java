package com.indra.formacio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SalePK implements Serializable {

	@Column(name="CUSTOMER_ID")
	protected Long customer;
	
	@Column(name="PRODUCT_ID")
	protected Long product;	
	
}
