package com.indra.formacio;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import junit.framework.TestCase;

import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Employee;

public class CustomerTest extends TestCase {

	private SimpleDateFormat sdf;
	
	public CustomerTest() {
		sdf = new SimpleDateFormat("dd/mm/yyyy");	
	}
	
	public void testSettersAndGetters() throws ParseException {
		
		Employee emp = new Employee();
		emp.setName("Emp");
		
		Customer a = new Customer((long) 4, "Federico", "Larcia Gorca", emp);
		a.setPercentDate(sdf.parse("04/04/2016"));
		a.setPercentProduct(2.4f);
		
		assertEquals((long) 4, (long) a.getId());
		assertEquals("Federico", a.getName());
		assertEquals("Larcia Gorca", a.getSurname());
		assertEquals(emp.getName(),a.getEmployee().getName());
		assertEquals(sdf.parse("04/04/2016"), a.getPercentDate());
		assertEquals(2.4f, a.getPercentProduct());
	}
	
	public void testCalculPercentatge(){
		Customer a = new Customer();
		a.setPercentProduct(25f);
		
		assertEquals(a.getPercentProduct(),100f/4);
		
	}
}
