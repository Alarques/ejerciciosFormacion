package com.indra.formacio.controller;
 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.indra.formacio.dao.EmployeeRepository;
import com.indra.formacio.model.Employee;
import com.indra.formacio.webmodel.EmployeeSearchForm;
 
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
		return "employee/new-employee";
	}
	
	@RequestMapping("/add-employee")
    public String addEmployee(@ModelAttribute("employee") Employee emp,
            Map<String, Object> model) {
        
		if (emp.getName()!=null && emp.getSurname() != null && emp.getBirthday() != null){
			eRepo.save(emp);
			
	        LOG.info("Empleado añadido, nombre: "+emp.getName());
	        
	        model.put("employee",emp);
	        
	        return "employee/view-employee";
	    } else {
	    	model.put("message", "Todos los campos son obligatorios");
	    	return "employee/new-employee";
	    }
	}
	
	@RequestMapping("/employees-view")
	public String employeesView(Map<String, Object> model){
		List<Employee> empList = (List<Employee>)eRepo.findAll();
		model.put("employeeList",empList);
		return "employee/employees-view";
	}
	
	@RequestMapping("/search-employee-view")
	public String searchEmployeeView(Map<String, Object> model){
		EmployeeSearchForm emp = new EmployeeSearchForm();
		model.put("employeeSearchForm",emp);
		return "employee/search-employee";
	}
	
	@RequestMapping("/search-employee")
	public String searchEmployee(@ModelAttribute("employeeSearchForm") EmployeeSearchForm emp,
			Map<String, Object> model){
		
		Date dataIni, dataFi;
		
		List<Employee> empList;
		
		try {
			if (emp.getBirthdayIni() != null && !emp.getBirthdayIni().equals("")) {
				dataIni = sdf.parse(emp.getBirthdayIni());
			} else {
				dataIni = null;
			}
			if (emp.getBirthdayEnd() != null && !emp.getBirthdayEnd().equals("")) {
				dataFi = sdf.parse(emp.getBirthdayEnd());
			} else {
				dataFi = null;
			}
		
			empList = eRepo.findByNameOrSurnameOrBirthdayBetween(
					emp.getName(), 
					emp.getSurname(), 
					dataIni,
					dataFi
					);
		
		} catch (ParseException e){
			LOG.error("Error en parsejar les dates",e);
			empList = new ArrayList<Employee>();
		}
			
		model.put("employeeList",empList);
		return "employee/search-employee";
	}
	
	@RequestMapping("/edit-employee/{id}")
    public String editEmployee(@PathVariable("id") Long id, Map<String, Object> model){
		
		Employee emp=eRepo.findOne(id);
		model.put("employee",emp);
		
		return "employee/new-employee";
    }
	
	@RequestMapping("/delete-employee/{id}")
    public String removeEmployee(@PathVariable("id") Long id){
		
		eRepo.delete(id);

        return "redirect:/employees-view.do";
    }
	
}