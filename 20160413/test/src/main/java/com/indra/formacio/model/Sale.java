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
}
