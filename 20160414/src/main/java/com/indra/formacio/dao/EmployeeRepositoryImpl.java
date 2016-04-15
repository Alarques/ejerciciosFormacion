package com.indra.formacio.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;

import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Employee;
import com.indra.formacio.model.Sale;

public class EmployeeRepositoryImpl implements EmployeeRepoMethods{
	
	@Autowired	//Spring Annotation
	protected EntityManager entityManager;
	@Autowired
	protected CustomerRepository cRepo;
	@Autowired
	protected EmployeeRepository eRepo;
	@Autowired
	protected SaleRepository sRepo;
	
	@SuppressWarnings("unchecked")
	public List<Employee> findByYearsWorking(Calendar start_date) {
		Query q = entityManager.createQuery("FROM Employee e WHERE e.startDate BETWEEN '01.01.1900' and :sDate");
		q.setParameter("sDate", start_date, TemporalType.DATE);
		return (ArrayList<Employee>)q.getResultList();
	};
	
	@SuppressWarnings("unchecked")
	public List<Employee> findByYearsOld(int años) {
		Query q = entityManager.createQuery("FROM Employee e WHERE YEAR(e.birthday) = :sDate");
		q.setParameter("sDate", años);
		return (ArrayList<Employee>)q.getResultList();
	};
	
}
