package com.indra.formacio.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.indra.formacio.dao.CustomerRepository;
import com.indra.formacio.dao.ProductRepository;
import com.indra.formacio.dao.SaleRepository;
import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Employee;
import com.indra.formacio.model.Product;
import com.indra.formacio.model.Sale;
import com.indra.formacio.model.SalePK;
import com.indra.formacio.webmodel.EmployeeSearchForm;


@Controller
public class SaleController {
	
	private static final Logger LOG = Logger.getLogger(CustomerController.class);
	
	@Autowired
	SaleRepository sRepo;
	@Autowired
	CustomerRepository cRepo;
	@Autowired
	ProductRepository pRepo;
	
	@RequestMapping("/sales-view")
	public String salesView(Map<String, Object> model){
		List<Sale> saleList = (List<Sale>)sRepo.findAll();
		model.put("saleList",saleList);
		return "sale/sales-view";
	}
	
	@RequestMapping("/new-sale-creation")
	public String newSale(Map<String, Object> model){
		Sale sale= new Sale();
		model.put("sale",sale);
		
		List<Customer> cusList = (List<Customer>)cRepo.findAll();
		model.put("customerList",cusList);
		
		List<Product> prodList = (List<Product>) pRepo.findAll();
		model.put("productList", prodList);
		
		return "sale/new-sale";
	}
	
	@RequestMapping("/add-sale")
	public String addSale(@ModelAttribute("sale") Sale sale){
		Product prod = pRepo.findOne(sale.getKey().getProduct().getId());
		Customer cust = cRepo.findOne(sale.getKey().getCustomer().getId());
		
		SalePK sPK = new SalePK();
		sPK.setCustomer(cust);
		sPK.setProduct(prod);
		sPK.setBuyDate(new Date());
		
		sale.setKey(sPK);
		
		sRepo.save(sale);
		
		/*
		 * ALERTA
		 * Si us fixeu no torno a posar a CUST al MODEL de la REQUEST
		 * 
		 * JA hi és!
		 * 
		 */
		
		return "sale/view-sale";
	}
	
	@RequestMapping("/search-sale-view")
	public String searchSaleView(Map<String, Object> model){
		List<Customer> cusList = (List<Customer>) cRepo.findAll();
		model.put("customerList", cusList);
		Sale sl = new Sale();
		model.put("saleSearch",sl);
		return "sale/search-sale";
	}
	
	@RequestMapping("/search-sale")
	public String searchEmployee(@ModelAttribute("saleSearch") Sale sal,
			Map<String, Object> model){
		List<Customer> cusList = (List<Customer>) cRepo.findAll();
		model.put("customerList", cusList);
		
		List<Sale> saleList;
		
		Customer cust = cRepo.findOne(sal.getKey().getCustomer().getId());
		
		saleList= sRepo.findByKey_Customer(cust);
			
		model.put("saleList",saleList);
		return "sale/search-sale";
	}
}
