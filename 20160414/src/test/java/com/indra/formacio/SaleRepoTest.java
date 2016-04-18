package com.indra.formacio;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.indra.formacio.dao.CustomerRepository;
import com.indra.formacio.dao.ProductRepository;
import com.indra.formacio.dao.SaleRepository;
import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Product;
import com.indra.formacio.model.Sale;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class SaleRepoTest extends TestCase{
	
	@Autowired
	SaleRepository sRepo;
	@Autowired
	CustomerRepository cRepo;
	@Autowired
	ProductRepository pRepo;
	
	@Test
	public void testFindByKey_Customer(){
		Customer c = cRepo.findOne(1L);
		List<Sale> res = sRepo.findByKey_Customer(c);
		assertFalse(res.isEmpty());
		assertEquals(3, res.size());
	}
	@Test
	public void testFindByKey_ProductOrderByCantidadDesc(){
		Product p = pRepo.findOne(4L);
		List<Sale> res = sRepo.findByKey_ProductOrderByCantidadDesc(p);
		assertFalse(res.isEmpty());
		assertEquals(17, res.get(0).getCantidad());
	}

}
