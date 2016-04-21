package com.indra.formacio.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.indra.formacio.dao.SaleRepository;
import com.indra.formacio.model.Sale;


@Controller
public class SaleController {
	
	private static final Logger LOG = Logger.getLogger(CustomerController.class);
	
	@Autowired
	SaleRepository sRepo;
	
	@RequestMapping("/sales-view")
	public String salesView(Map<String, Object> model){
		List<Sale> saleList = (List<Sale>)sRepo.findAll();
		model.put("saleList",saleList);
		return "sales-view";
	}
}
