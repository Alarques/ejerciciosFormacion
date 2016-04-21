package com.indra.formacio.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

import com.indra.formacio.model.Employee;

public interface EmployeeRepository  extends CrudRepository<Employee, Long>, EmployeeRepoMethods  {
	List<Employee> findByName(String name);
	List<Employee> findByNameAndSurname(String empNouName, String empNouSurname);
//	List<Employee> findByNameOrSurnameOrBirthdayBetween(String name, String surname, Date dataIni, Date dataFi);
}
