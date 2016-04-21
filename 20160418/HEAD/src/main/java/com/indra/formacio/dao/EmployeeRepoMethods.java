package com.indra.formacio.dao;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.indra.formacio.model.Employee;

public interface EmployeeRepoMethods {
	
	List<Employee> findByYearsWorking(Calendar start_date);
	
	List<Employee> findByYearsOld(int year);
	
	List<Employee> findByNameOrSurnameOrBirthdayBetween(
			String name, String surname, Date ini, Date end);

}
