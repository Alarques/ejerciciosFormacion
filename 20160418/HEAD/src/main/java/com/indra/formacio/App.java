package com.indra.formacio;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.indra.formacio.dao.CustomerRepository;
import com.indra.formacio.dao.EmployeeRepository;
import com.indra.formacio.dao.ProductRepository;
import com.indra.formacio.dao.SaleRepository;
import com.indra.formacio.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	
    	Enterprise empresa = new Enterprise();
    	
    	empresa.setcRepo((CustomerRepository)context.getBean(CustomerRepository.class));
    	empresa.seteRepo((EmployeeRepository)context.getBean(EmployeeRepository.class));
    	empresa.setsRepo((SaleRepository)context.getBean(SaleRepository.class));
    	empresa.setpRepo((ProductRepository)context.getBean(ProductRepository.class));
    	
    	empresa.pintaClients();
    	empresa.pintaEmpleats();
    	

//    	Ex--------1
    	List<Employee> empYearsWorking = empresa.findByYearsWorking(10);
    	
    	for (Employee employee : empYearsWorking) {
			System.out.println(employee.getName());
		}
    	

//    	Ex------2
    	List<Employee> empYearsOld = empresa.findByYearsOld(36);
    	
    	for (Employee employee : empYearsOld) {
			System.out.println(employee.getName());
		}
    	

//    	Ex------3
//    	(Emp a borrar, Emp a asignar els treballadors anteriors)
    	empresa.actualizarPorcentajesEmpleados();
    	empresa.actualizarPorcentajesClientes();
//    	empresa.reasignarClientes("Treballador 141", "Cognom 141", "Treballador 2", "Cognom 2");
        

//    	Ex------5
    	empresa.mejorComprador();
    }
}
