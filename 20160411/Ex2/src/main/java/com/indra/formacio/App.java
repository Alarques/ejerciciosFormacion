package com.indra.formacio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.apache.derby.tools.sysinfo;

import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Employee;
import com.indra.formacio.model.Product;
import com.indra.formacio.model.Sale;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * Hello world!
 *
 */
public class App 
{
	
	public static EntityManager manager = Persistence.createEntityManagerFactory("com.indra.formacio").createEntityManager();
	
    public static void main( String[] args )
    {
    	
//		Employee emp = new Employee();
//		emp.setName("Empleat 1");
//		emp.setSurname("Cognom 1");
//		
//		manager.getTransaction().begin();
//		manager.persist(emp);
//		manager.getTransaction().commit();
//		
//		Customer c;
//		
//		manager.getTransaction().begin();
//		for (int i = 0; i < 5; i++){
//			c = new Customer();
//			c.setName("Nom client "+i);
//			c.setSurname("Cognom client "+i);
//			c.setEmployee(emp);
//			manager.persist(c);
//		}
//		manager.getTransaction().commit();
//		
//		manager.refresh(emp);
//		
//		List<Customer> clients = emp.getCustomers();
//		
//		System.out.println("L'empleat "+emp.getName()+" t� els seg�ents clients");
//		
//		for (Customer customer : clients) {
//			System.out.println(customer.toString());
//		}
    	
		initialize(new Integer [][] {{1,2},{3,4},{5,6,7,8}});		
		porcentajeEmp();
		porcentajeCli();
		mostrarLlista();
		
    }
    
    private static void initialize(Integer [][] empCliProd){
    	Employee e = new Employee();
    	Customer c = new Customer();
    	Sale s = new Sale();
    	Product p = new Product();
    	
    	for (int i = 0; i < empCliProd.length; i++) {
    		manager.getTransaction().begin();
			e = new Employee();
			e.setName("Empleado "+i);
			manager.persist(e);
			manager.getTransaction().commit();
			for (int j = 0; j < empCliProd[i].length; j++) {
				manager.getTransaction().begin();
				c = new Customer();
				c.setName("Cliente " +j+ " del empleado "+i);
				c.setEmployee(e);
				manager.persist(c);
				manager.getTransaction().commit();
				for (int k = 0; k < empCliProd[i][j]; k++) {
					manager.getTransaction().begin();
					p = new Product();
					p.setName("Producto " +k + " del "+c.getName());
					manager.persist(p);
					s = new Sale();
					s.setProduct(p);
					s.setCustomer(c);
					manager.persist(s);
					manager.getTransaction().commit();
				}
			}
		}
    	manager.refresh(e);
    	manager.refresh(c);
    	manager.refresh(p);
    	manager.refresh(s);
    }
    
    private static void porcentajeEmp() throws ParseException{
    	float percent;
    	Employee empleado = new Employee();
    	
		List resEmp = manager.createQuery(
		        "FROM Employee e")
		        .getResultList();
		
		List resCus = manager.createQuery(
		        "FROM Customer c")
		        .getResultList();
		
    	for (int i = 0; i < resEmp.size(); i++) {
    		empleado = (Employee) resEmp.get(i);
    		List resNumCli = manager.createQuery(
    				"SELECT customers "+
    				"FROM Employee e where e.id = :eid")
    				.setParameter("eid", empleado.getId())
    				.getResultList();
        	percent = (float) resNumCli.size()*100/resCus.size();
        	empleado.setPercentCustomers(percent);
        	manager.getTransaction().begin();
        	manager.persist(empleado);
        	manager.getTransaction().commit();
		}
    }
    
    private static void porcentajeCli() throws ParseException{
    	float percent;
    	Customer cliente = new Customer();
    	
		List resCli = manager.createQuery(
		        "FROM Customer e")
		        .getResultList();
		
		List resProd = manager.createQuery(
		        "FROM Product c")
		        .getResultList();
		
    	for (int i = 0; i < resCli.size(); i++) {
    		cliente = (Customer) resCli.get(i);
    		List resNumProd = manager.createQuery(
    				"SELECT product "+
    				"FROM Sale s where s.customer.id = :pid")
    				.setParameter("pid", cliente.getId())
    				.getResultList();
        	percent = (float) resNumProd.size()*100/resProd.size();
        	cliente.setPercentProduct(percent);
        	manager.getTransaction().begin();
        	manager.persist(cliente);
        	manager.getTransaction().commit();
		}
    }
    
    private static void mostrarLlista(){
    	Employee empleado = new Employee();
    	Customer cliente = new Customer();
    	Product producte = new Product();
    	
		List resEmp = manager.createQuery(
		        "FROM Employee e")
		        .getResultList();
		
		for(int i = 0; i < resEmp.size(); i++){
			empleado = (Employee) resEmp.get(i);
			System.out.println("- "+empleado.getName());
			System.out.println("- Porcentaje de clientes: "+empleado.getPercentCustomers()+"%");
			System.out.println("- Clientes:");
			List resCli = manager.createQuery(
    				"SELECT customers "+
    				"FROM Employee e where e.id = :eid")
    				.setParameter("eid", empleado.getId())
    				.getResultList();
			for(int j = 0; j < resCli.size(); j++){
				cliente = (Customer) resCli.get(j);
				System.out.println("\t- "+cliente.getName()+", porcentaje de productos: "+cliente.getPercentProduct()+"%");
				List resProd = manager.createQuery(
	    				"SELECT product "+
	    				"FROM Sale s where s.customer.id = :pid")
	    				.setParameter("pid", cliente.getId())
	    				.getResultList();
				for(int x = 0; x < resProd.size(); x++){
					producte = (Product) resProd.get(x);
					System.out.println("\t\t- "+producte.getName());
				}
			}
		}
    }
}
