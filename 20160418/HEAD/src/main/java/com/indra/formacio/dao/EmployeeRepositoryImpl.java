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

public class EmployeeRepositoryImpl implements EmployeeRepoMethods{
	
	@Autowired	//Spring Annotation
	protected EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Employee> findByYearsWorking(Calendar start_date) {
		Query q = entityManager.createQuery("FROM Employee e WHERE e.startDate < :sDate");
		q.setParameter("sDate", start_date, TemporalType.DATE);
		return (ArrayList<Employee>)q.getResultList();
	};
	
	@SuppressWarnings("unchecked")
	public List<Employee> findByYearsOld(int años) {
		Query q = entityManager.createQuery("FROM Employee e WHERE YEAR(e.birthday) = :sDate");
		q.setParameter("sDate", años);
		return (ArrayList<Employee>)q.getResultList();
	};
	
	public List<Employee> findByNameOrSurnameOrBirthdayBetween(
			String name, String surname, Date ini, Date end) {
		
		
		StringBuilder sQuery = new StringBuilder();
		sQuery.append(" FROM Employee e WHERE 1 = 1 ");
		
		if (name!=null && !name.equals("")) {
			sQuery.append(" AND e.name = :name ");
		}
		if (surname!=null  && !surname.equals("")){
			sQuery.append(" AND e.surname = :surname ");
		}
		if (ini != null){
			sQuery.append(" AND e.birthday >= :ini");
		}
		if (end != null){
			sQuery.append(" AND e.birthday <= :end ");
		}
		
		Query q = entityManager.createQuery(sQuery.toString());
		
		if (name!=null  && !name.equals("")) {
			q.setParameter("name", name);
		}
		if (surname!=null  && !surname.equals("")){
			q.setParameter("surname", surname);
		}
		if (ini != null){
			q.setParameter("ini", ini);
		}
		if (end != null){
			q.setParameter("end", end);
		}
		
		return (List<Employee>)q.getResultList();
	}
	
}
