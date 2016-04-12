package com.indra.formacio;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Employee;
import com.indra.formacio.model.Product;
import com.indra.formacio.model.Sale;

import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

public class SaleTest extends TestCase {
	
	public static final int NUMERO_SALES = 3;
	
	public void testInserts(){
		
		EntityManager manager = Persistence.createEntityManagerFactory("com.indra.formacio").createEntityManager();
		
		manager.getTransaction().begin();
		Customer c;
		List<Customer> cList = new ArrayList<Customer>();
		for (int i = 0; i < NUMERO_SALES; i++){
			c = new Customer();
			c.setName("Nom client "+i);
			c.setSurname("Cognom client "+i);
			cList.add(c);
			manager.persist(c);
		}
		manager.getTransaction().commit();
		
		manager.getTransaction().begin();
		Product p;
		List<Product> pList = new ArrayList<Product>();
		for (int i = 0; i < NUMERO_SALES; i++){
			p = new Product();
			p.setName("Producte "+i);
			p.setDescription("Desc producte "+i);
			pList.add(p);
			manager.persist(p);
		}
		manager.getTransaction().commit();
		
		manager.getTransaction().begin();
		Sale sal;
		for (int i = 0; i < NUMERO_SALES; i++) {
			sal = new Sale();
			sal.setProduct(pList.get(i));
			sal.setCustomer(cList.get(i));
			manager.persist(sal);
		}
		
		manager.getTransaction().commit();
		List<Sale> res = new ArrayList<Sale>();
		res = manager.createQuery(
		        "FROM Sale s order by s.id asc")
		        .getResultList();
		
		int index = 0;
		for (Sale sale : res) {
			assertEquals(sale.getCustomers().getName(), cList.get(index).getName());
			assertEquals(sale.getProduct().getName(), pList.get(index).getName());
			index++;
		}
		
//		for (int i = 0; i < NUMERO_SALES; i++) {
//			assertEquals(sal.getCustomers().getName(), cList.get(i).getName());
//			assertEquals(sal.getProduct().getName(), pList.get(i).getName());
//		}
		
	}

}
