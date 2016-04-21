package com.indra.formacio.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.indra.formacio.dao.ProductRepository;
import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Employee;
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
		return "product/products-view";
	}
	
	@RequestMapping("/new-product-creation")
	public String newProduct(Map<String, Object> model){
		Product prod= new Product();
		model.put("product",prod);		
		return "product/new-product";
	}
	
	@RequestMapping("/add-product")
    public String addEmployee(@ModelAttribute("product") Product prod,
            Map<String, Object> model) {
        
		if (prod.getName()!=null && prod.getDescription() !=null){
			pRepo.save(prod);
			
	        LOG.info("Producto añadido, nombre: "+prod.getName());
	        
	        model.put("product",prod);
	        
	        return "product/view-product";
	    } else {
	    	model.put("message", "Todos los campos son obligatorios");
	    	return "product/new-product";
	    }
	}
}
