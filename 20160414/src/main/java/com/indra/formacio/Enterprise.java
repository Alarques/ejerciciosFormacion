package com.indra.formacio;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.indra.formacio.dao.CustomerRepository;
import com.indra.formacio.dao.EmployeeRepository;
import com.indra.formacio.dao.SaleRepository;
import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Employee;
import com.indra.formacio.model.Sale;

public class Enterprise {

	@Autowired
	CustomerRepository cRepo;
	@Autowired
	EmployeeRepository eRepo;
	@Autowired
	SaleRepository sRepo;
	
	public void pintaClients(){
		System.out.println(cRepo.count());
	}

	public CustomerRepository getcRepo() {
		return cRepo;
	}

	public void setcRepo(CustomerRepository cRepo) {
		this.cRepo = cRepo;
	}
	
	public SaleRepository getsRepo(){
		return sRepo;
	}
	
	public void setsRepo(SaleRepository sRepo){
		this.sRepo = sRepo;
	}
	
	public void pintaEmpleats(){
		System.out.println(eRepo.count());
	}
	
	public EmployeeRepository geteRepo(){
		return eRepo;
	}
	
	public void seteRepo (EmployeeRepository eRepo){
		this.eRepo = eRepo;
	}
	
	public List<Employee> findByYearsWorking(int años){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.YEAR, -años);
		List<Employee> emp = eRepo.findByYearsWorking(calendar);
		return emp;
	}
	
	public List<Employee> findByYearsOld(int años){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.YEAR, -años);
		int year = calendar.get(Calendar.YEAR);
		List<Employee> emp = eRepo.findByYearsOld(year);
		return emp;
	}
	
	public void reasignarClientes(String empName, String empSurname, String empNouName, String empNouSurname){		
		//Selecciono el empleado que tengo que asignar a los clientes.
		List<Employee> emp = eRepo.findByNameAndSurname(empNouName, empNouSurname);
		
		//Selecciono los clientes del empleado a borrar (jubilado).
		List<Customer> cli = cRepo.findByEmployee_NameAndEmployee_Surname(empName, empSurname);
		
		//Guardo el empleado a borrar.
		Employee empBorrar = new Employee();
		empBorrar = cli.get(0).getEmployee();
		
		//Cambio el empleado a los clientes.
		for (Customer customer : cli) {
			customer.setEmployee(emp.get(0));
			cRepo.save(customer);
		}
		
		//Actualizo el porcentaje del empleado al que se le asignaron los clientes.
		List<Customer> cList = cRepo.findByEmployee(emp.get(0));
		double percent = (double) cList.size()*100/cRepo.count();
		emp.get(0).setPercentCustomers(percent);
		emp.get(0).setPercentDate(new Date());
		eRepo.save(emp.get(0));
		
		//Elimino al empleado jubilado.
		eRepo.delete(empBorrar);
		
		
//		Prueba de los porcentajes.
//		List<Employee> allEmp1 = (List<Employee>) eRepo.findAll();
//		for (Employee employee : allEmp1) {
//			System.out.println(employee.getPercentCustomers());
//		}
//
//		Prueba para ver si se cmabiaron los clientes.
//	
//		List<Customer> cli1 = cRepo.findByEmployee_NameAndEmployee_Surname(empNouName, empNouSurname);
//		
//		for (Customer customer : cli1) {
//			System.out.println(customer.getName());
//		}
		
		
	}
	
	public void actualizarPorcentajesEmpleados(){
		List<Employee> allEmp = (List<Employee>) eRepo.findAll();
		
		for (Employee employee : allEmp) {
			List<Customer> cEmp = cRepo.findByEmployee(employee);
			double percent = (double) cEmp.size()*100/cRepo.count();
			employee.setPercentCustomers(percent);
			employee.setPercentDate(new Date());
			eRepo.save(employee);
		}
	}
	
	public void actualizarPorcentajesClientes(){
		List<Customer> allCli = (List<Customer>) cRepo.findAll();
		
		for (Customer customer : allCli) {
			List<Sale> saleCust = sRepo.findByKey_Customer(customer);
			double percent = (double) saleCust.size()*100/sRepo.count();
			customer.setPercentProduct(percent);
			customer.setPercentDate(new Date());
			cRepo.save(customer);
		}
		
		List<Customer> allCli1 = (List<Customer>) cRepo.findAll();
		
		for (Customer customer : allCli1) {
			System.out.println(customer.getPercentProduct());
		}
	}
	
}
