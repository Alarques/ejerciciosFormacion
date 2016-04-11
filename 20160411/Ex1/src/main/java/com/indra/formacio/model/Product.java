package com.indra.formacio.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Objects of this class represents a Product of the companys portfolio.
 * 
 * @author ealcalal
 *
 */
@Entity
public class Product {
	@Id
    @GeneratedValue
	protected Long id;
	@Column
	protected String name;
	@Column
	protected String description;
	
	@OneToMany(mappedBy="product")
	protected List<Sale> sales;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
