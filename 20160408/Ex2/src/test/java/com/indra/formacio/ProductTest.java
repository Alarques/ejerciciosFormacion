package com.indra.formacio;

import java.text.ParseException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import junit.framework.TestCase;

import com.indra.formacio.model.Product;


public class ProductTest extends TestCase {

	public ProductTest() {}
	
	public void testSettersAndGetters() throws ParseException {
		
		Product a = new Product();
		a.setName("Asus");
		a.setDescription("Intel core i7, 8GB, 250GB ssd");
		
		assertEquals("Asus", a.getName());
		assertEquals("Intel core i7, 8GB, 250GB ssd", a.getDescription());
	}
	
	public void testInsert() throws ParseException {
		
		Product a = new Product();
		a.setName("Asus");
		a.setDescription("Intel core i7, 8GB, 250GB ssd");
		
		EntityManager manager = Persistence.createEntityManagerFactory("com.indra.formacio").createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(a);		
		manager.getTransaction().commit();
		
		
		List res = manager.createQuery(
		        "FROM Product p where p.name = :custName")
		        .setParameter("custName", "Asus")
		        .getResultList();
		
		assertFalse(res.isEmpty());
		
		
		Product b = (Product) res.get(0);
		assertNotNull(b);
		assertEquals(a.getName(), b.getName());
		assertEquals(a.getId(), b.getId());
		
				
	}
}
