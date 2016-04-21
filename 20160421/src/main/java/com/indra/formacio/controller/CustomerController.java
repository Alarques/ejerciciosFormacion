package com.indra.formacio.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.indra.formacio.dao.CustomerRepository;
import com.indra.formacio.dao.EmployeeRepository;
import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Employee;
import com.indra.formacio.webmodel.CustomerBean;

@Controller
public class CustomerController {
	
	@Autowired
	EmployeeRepository eRepo;
	
	@Autowired
	CustomerRepository cRepo;
	
	@RequestMapping("/new-customer-creation")
	public String newCustomer(Map<String, Object> model){
		Customer cust= new Customer();
		model.put("customer",cust);
		
		List<Employee> empList = (List<Employee>)eRepo.findAll();
		model.put("employeeList",empList);
		
		return "customer/new-customer";
	}
	
	
	@RequestMapping("/add-customer")
	public String addCustomer(@ModelAttribute("customer") Customer cust){
		Employee emp = eRepo.findOne(cust.getEmployee().getId());
		
		cust.setEmployee(emp);
		
		cRepo.save(cust);
		
		/*
		 * ALERTA
		 * Si us fixeu no torno a posar a CUST al MODEL de la REQUEST
		 * 
		 * JA hi és!
		 * 
		 */
		
		return "customer/view-customer";
	}

	@RequestMapping("/new-customer-creation-with-back-bean")
	public String newCustomerBean(Map<String, Object> model){
		CustomerBean cust= new CustomerBean();
		model.put("customer",cust);
		
		List<Employee> empList = (List<Employee>)eRepo.findAll();
		model.put("employeeList",empList);
		
		return "customer/new-customer-bean";
	}

	@RequestMapping("/add-customer-bean")
	public String addCustomerBean(@ModelAttribute("customer") CustomerBean cust,
			Map<String, Object> model){
		Employee emp = eRepo.findOne(Long.parseLong(cust.getEmployeeId()));
		
		Customer custAux = new Customer();
		custAux.setEmployee(emp);
		custAux.setName(cust.getName());
		custAux.setSurname(cust.getSurname());
		
		cRepo.save(custAux);
		
		/*
		 * Com que el CUSTOMER que acabo de crear no hi és al model
		 * de la REQUEST, el torno a posar sobreescrivint el customer
		 * 
		 * 
		 */
		
		model.put("customer", custAux);
		
		return "customer/view-customer";
	}
	
	@RequestMapping("/customers-view")
	public String customersView(Map<String, Object> model){
		List<Customer> custList = (List<Customer>)cRepo.findAll();
		model.put("customerList",custList);
		return "customer/customers-view";
	}
	
}
