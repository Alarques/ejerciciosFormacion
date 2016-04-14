package com.indra.formacio.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.indra.formacio.model.Sale;
import com.indra.formacio.model.SaleKey;

public interface SaleRepository extends CrudRepository<Sale, SaleKey>{
	List<Sale> findByKey_productid(Long product_id);
	List<Sale> findByKey_customerid(Long customer_id);
}
