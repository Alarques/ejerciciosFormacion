package com.indra.formacio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.indra.formacio.dao.CustomerRepository;
import com.indra.formacio.dao.EmployeeRepository;
import com.indra.formacio.dao.ProductRepository;
import com.indra.formacio.dao.SaleRepository;
import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Employee;
import com.indra.formacio.model.Product;
import com.indra.formacio.model.Sale;
import com.indra.formacio.model.SaleKey;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class SaleRepoTest extends TestCase {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
	
	@Autowired
	CustomerRepository cRepo;
	@Autowired
	ProductRepository pRepo;
	@Autowired
	SaleRepository sRepo;
	@Autowired
	EmployeeRepository eRepo;
	
	@Test
	public void testCrud() throws ParseException {
		Product p = new Product();
//		p.setId(1l);
		p.setName("Test Product");
		
		long numProducts = pRepo.count();
		
		pRepo.save(p);
		assertNotNull(p.getId());
		assertEquals(pRepo.count(), numProducts+1);
		
		Employee e = new Employee();
		e.setName("Empleado Prueba");
		e.setBirthday(sdf.parse("13/04/2016"));
		eRepo.save(e);
		
		Customer c = new Customer();
//		c.setId(1l);
		c.setName("Test");
		c.setSurname("Test Surname");
		c.setEmployee(e);
		
		long numCustomers = cRepo.count();
		
		cRepo.save(c);
		assertNotNull(c.getId());
		assertEquals(cRepo.count(), numCustomers+1);
		
		Sale s = new Sale();
		s.setKey(new SaleKey(p.getId(), c.getId()));
		s.setCreation_date(sdf.parse("13/04/2016"));
		
		sRepo.save(s);
		
		assertNotNull(s.getKey());
		
		List<Sale> resProduct = sRepo.findByKey_productid(p.getId());
		assertFalse(resProduct.isEmpty());
		
		List<Sale> resCustomer = sRepo.findByKey_customerid(c.getId());
		assertFalse(resCustomer.isEmpty());
		
		Sale sRes = sRepo.findOne(new SaleKey(p.getId(), c.getId()));
		
		Sale pRes = resProduct.get(0);
		Sale cRes = resCustomer.get(0);
		
		assertEquals(p.getId(), pRes.getKey().getProduct_id());
		assertEquals(c.getId(), cRes.getKey().getCustomer_id());
		assertEquals(p.getId(), sRes.getKey().getProduct_id());
		assertEquals(c.getId(), sRes.getKey().getCustomer_id());
		
//		assertEquals(a.getId(), b.getId());
//		assertEquals(a.getName(), b.getName());
//		assertEquals(a.getSurname(), b.getSurname());
//		assertEquals(a.getPercentDate(), b.getPercentDate());
//		assertEquals(a.getPercentProduct(), b.getPercentProduct());
//		assertEquals(a.getEmployee().getId(), b.getEmployee().getId());
//		System.out.println(a.getEmployee().equals( b.getEmployee()));
//		assertEquals(a.getEmployee(), b.getEmployee());
//		assertEquals(a.hashCode(), b.hashCode());
//		assertEquals(a,b);
	}

}