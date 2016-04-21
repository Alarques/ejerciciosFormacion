package com.indra.formacio.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Product;
import com.indra.formacio.model.Sale;
import com.indra.formacio.model.SalePK;

public interface SaleRepository extends CrudRepository<Sale, SalePK>{
	List<Sale> findByKey_Customer(Customer cliente);
	List<Sale> findByKey_ProductOrderByCantidadDesc(Product producte);
}
