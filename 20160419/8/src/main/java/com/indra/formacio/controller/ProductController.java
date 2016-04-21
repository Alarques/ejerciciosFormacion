package com.indra.formacio.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.indra.formacio.dao.ProductRepository;
import com.indra.formacio.model.Product;

@Controller
public class ProductController {
	
	private static final Logger LOG = Logger.getLogger(CustomerController.class);
	
	@Autowired
	ProductRepository pRepo;
	
	@RequestMapping("/products-view")
	public String productsView(Map<String, Object> model){
		List<Product> proList = (List<Product>)pRepo.findAll();
		model.put("productList",proList);
		return "products-view";
	}
}
