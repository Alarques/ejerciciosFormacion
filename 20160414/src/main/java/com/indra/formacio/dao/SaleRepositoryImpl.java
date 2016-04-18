package com.indra.formacio.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Sale;

public class SaleRepositoryImpl implements SaleRepositoryMethods{
//	
//	@Autowired	//Spring Annotation
//	protected EntityManager entityManager;
//	
//	@SuppressWarnings("unchecked")
//	public List<Sale> findByCustomer(Customer cliente){
//		Query q = entityManager.createQuery("FROM Sale s");
////		q.setParameter("cliente", cliente);
//		return (ArrayList<Sale>)q.getResultList();
//	}
}
