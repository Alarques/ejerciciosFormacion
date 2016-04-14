package com.indra.formacio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;


public class SaleKey implements Serializable{
	@Column
	protected long product_id;
	@Column
	protected long customer_id;
}
