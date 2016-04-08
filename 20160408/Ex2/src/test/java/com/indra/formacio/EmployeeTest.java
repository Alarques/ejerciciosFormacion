package com.indra.formacio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import junit.framework.TestCase;

import com.indra.formacio.model.Employee;


public class EmployeeTest extends TestCase {

	public EmployeeTest() {}
	
	public void testSettersAndGetters() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		Employee a = new Employee();
		a.setName("Pepe");
		a.setSurname("Viyuela");
		a.setBithday(sdf.parse("07/07/1980"));
		a.setPercentDate(sdf.parse("08/04/2016"));
		a.setPercentCustomers(2.4f);
		
		assertEquals("Pepe", a.getName());
		assertEquals("Viyuela", a.getSurname());
		assertEquals(sdf.parse("07/07/1980"), a.getBithday());
		assertEquals(sdf.parse("08/04/2016"), a.getPercentDate());
		assertEquals(2.4f, a.getPercentCustomers());
	}
	
	public void testInsert() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		Employee a = new Employee();
		a.setName("Pepe");
		a.setSurname("Viyuela");
		a.setBithday(sdf.parse("07/07/1980"));
		a.setPercentDate(sdf.parse("08/04/2016"));
		a.setPercentCustomers(2.4f);
		
		EntityManager manager = Persistence.createEntityManagerFactory("com.indra.formacio").createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(a);		
		manager.getTransaction().commit();
		
		
		List res = manager.createQuery(
		        "FROM Employee e where e.name = :custName")
		        .setParameter("custName", "Pepe")
		        .getResultList();
		
		assertFalse(res.isEmpty());
		
		
		Employee b = (Employee) res.get(0);
		assertNotNull(b);
		assertEquals(a.getName(), b.getName());
		assertEquals(a.getId(), b.getId());
		
				
	}
}
