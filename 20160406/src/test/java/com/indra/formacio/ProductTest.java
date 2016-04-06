package com.indra.formacio;

import java.text.ParseException;

import com.indra.formacio.model.Product;

import junit.framework.TestCase;

public class ProductTest extends TestCase{
	
	
	public ProductTest() {
		
	}
	
	public void testSettersAndGetters() throws ParseException {
				
		Product a = new Product((long) 4,"Portatil");
		a.setDescription("Intel core i5, 13', 8GB");
		
		assertEquals((long) 4, (long) a.getId());
		assertEquals("Portatil", a.getName());
		assertEquals("Intel core i5, 13', 8GB", a.getDescription());
	}
	
}
