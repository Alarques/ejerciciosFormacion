package com.indra.formacio;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.indra.formacio.model.Employee;

import junit.framework.TestCase;

public class EmployeeTest extends TestCase{
	
	private SimpleDateFormat sdf;
	
	public EmployeeTest() {
		sdf = new SimpleDateFormat("dd/mm/yyyy");	
	}
	
	public void testSettersAndGetters() throws ParseException {
				
		Employee a = new Employee();
		a.setName("Pepe");
		a.setSurname("Viyuela");
		a.setPercentDate(sdf.parse("06/04/2016"));
		a.setPercentCustomers(2.4f);
		
		assertEquals("Pepe", a.getName());
		assertEquals("Viyuela", a.getSurname());
		assertEquals(sdf.parse("06/04/2016"), a.getPercentDate());
		assertEquals(2.4f, a.getPercentCustomers());
	}
	
	public void testCalculPercentatge(){
		Employee a = new Employee();
		a.setPercentCustomers(25f);
		
		assertEquals(a.getPercentCustomers(),100f/4);
		
	}
	
	public void testEquals() throws ParseException{
		Employee a = new Employee();
		a.setName("Pepe");
		a.setSurname("Viyuela");
		a.setPercentDate(sdf.parse("06/04/2016"));
		a.setPercentCustomers(2.4f);
		
		Employee a1 = new Employee();
		a1.setName("Pepe");
		a1.setSurname("Viyuela");
		a1.setPercentDate(sdf.parse("06/04/2016"));
		a1.setPercentCustomers(2.4f);
		
		assertEquals(a, a1);
	}
}
