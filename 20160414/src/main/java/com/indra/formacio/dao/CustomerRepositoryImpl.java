package com.indra.formacio.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.indra.formacio.model.Customer;

public class CustomerRepositoryImpl implements CustomerRepoMethods{
	
	@PersistenceContext	//JPA annotation
//	@Autowired	//Spring Annotation
	protected EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Customer> findBySurname(String surname){
		
		Query q = entityManager.createQuery("FROM Customer c WHERE c.surname = :sur");
		q.setParameter("sur", surname);
		return (ArrayList<Customer>)q.getResultList();
		
	};

}
