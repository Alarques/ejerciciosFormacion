package com.indra.formacio.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity(name="PRODUCT_CUSTOMER")
@IdClass(SalePK.class)
public class Sale {
	
	@ManyToOne
	@Id
	@JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
	protected Customer customer;
	
	@ManyToOne
	@Id
	@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
	protected Product product;
	
	@Column(name="CREATION_DATE")
	protected Date creationDate;
}
