package com.indra.formacio;

import java.text.ParseException;

import com.indra.formacio.model.Product;

import junit.framework.TestCase;

public class ProductTest extends TestCase{
	
	
	public ProductTest() {
		
	}
	
	public void testSettersAndGetters() throws ParseException {
				
		Product a = new Product();
		a.setName("Portatil");
		a.setDescription("Intel core i5, 13', 8GB");
		
		assertEquals("Portatil", a.getName());
		assertEquals("Intel core i5, 13', 8GB", a.getDescription());
	}
	
}
