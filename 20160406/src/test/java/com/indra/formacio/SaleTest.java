package com.indra.formacio;

import java.text.ParseException;

import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Employee;
import com.indra.formacio.model.Product;
import com.indra.formacio.model.Sale;

import junit.framework.TestCase;

public class SaleTest extends TestCase{
	
	
	public SaleTest() {
		
	}
	
	public void testSettersAndGetters() throws ParseException {
		
		Product p = new Product();
		p.setName("Portatil");
		
		Customer c = new Customer();
		c.setName("Federico");
		
		Sale s = new Sale(p,c);
		
		assertEquals(p.getName(), s.getProduct().getName());
		assertEquals(c.getName(), s.getCustomer().getName());
	}
	
}
