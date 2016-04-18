package com.indra.formacio.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Sale;
import com.indra.formacio.model.SalePK;

public interface SaleRepository extends CrudRepository<Sale, SalePK>, SaleRepositoryMethods{
	List<Sale> findByKey_Customer(Customer cliente);
}
