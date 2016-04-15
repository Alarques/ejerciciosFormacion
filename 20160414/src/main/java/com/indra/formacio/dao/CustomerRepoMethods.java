package com.indra.formacio.dao;

import java.util.List;

import com.indra.formacio.model.Customer;

public interface CustomerRepoMethods{

	List<Customer> findBySurname(String surname);

}
