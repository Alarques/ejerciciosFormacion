package com.indra.formacio.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.indra.formacio.dao.CustomerRepository;
import com.indra.formacio.dao.EmployeeRepository;
import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Employee;

@Controller
public class CustomerController {

	private static final Logger LOG = Logger.getLogger(CustomerController.class);
	
	@Autowired
	CustomerRepository cRepo;
	@Autowired
	EmployeeRepository eRepo;
	
	@RequestMapping("/new-customer-creation")
	public String newCustomer(Map<String, Object> model){
		List<Employee> empList = (List<Employee>)eRepo.findAll();
		Customer cust = new Customer();
		model.put("customer",cust);
		model.put("employeeList", empList);
		return "new-customer";
	}
	
	@RequestMapping("/add-customer")
    public String processRegistration(@ModelAttribute("customer") Customer cust) {
		
		Employee emp = eRepo.findOne(cust.getEmployee().getId());
		
		cust.setEmployee(emp);
		
		cRepo.save(cust);
		
		return "view-customer";
	}

	
	@RequestMapping("/customers-view")
	public String customersView(Map<String, Object> model){
		List<Customer> custList = (List<Customer>)cRepo.findAll();
		model.put("customerList",custList);
		return "customers-view";
	}
}
