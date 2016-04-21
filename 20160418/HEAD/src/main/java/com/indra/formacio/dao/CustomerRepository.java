package com.indra.formacio.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Employee;

public interface CustomerRepository  extends CrudRepository<Customer, Long> {
	List<Customer> findByName(String name);
	List<Customer> findByEmployee(Employee empleado);
	List<Customer> findByEmployee_NameAndEmployee_Surname(String empName, String empSurname);
}
