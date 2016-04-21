package com.indra.formacio.controller;
 
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.indra.formacio.dao.EmployeeRepository;
import com.indra.formacio.model.Employee;
 
@Controller
public class EmployeeController {
 
	private static final Logger LOG = Logger.getLogger(EmployeeController.class);

	@Autowired
	EmployeeRepository eRepo;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@RequestMapping("/new-employee-creation")
	public String newEmployee(Map<String, Object> model){
		Employee emp = new Employee();
		model.put("employee",emp);
		return "new-employee";
	}
	
	@RequestMapping("/add-employee")
    public String processRegistration(@ModelAttribute("employee") Employee emp,
            Map<String, Object> model) {
        
		if (emp.getName()!=null){
			Employee newEmp = new Employee();
			newEmp.setName(emp.getName());
			newEmp.setSurname(emp.getSurname());
			newEmp.setBirthday(emp.getBirthday());
			eRepo.save(emp);
			
	        // for testing purpose:
	        System.out.println("name: " + emp.getName());
	        System.out.println("surname: " + emp.getSurname());
	         
	        model.put("employee",newEmp);
	        
	        return "view-employee";
	    } else {
	    	model.put("message", "El nom d'empleat és necessari");
	    	return "new-employee";
	    }
	}

	@RequestMapping("/employees-view")
	public String employeesView(Map<String, Object> model){
		List<Employee> empList = (List<Employee>)eRepo.findAll();
		model.put("employeeList",empList);
		return "employees-view";
	}
	
}