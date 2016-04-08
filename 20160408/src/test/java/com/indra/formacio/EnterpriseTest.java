package com.indra.formacio;

import java.text.ParseException;
import java.util.ArrayList;

import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Employee;
import com.indra.formacio.model.Enterprise;

import junit.framework.TestCase;

public class EnterpriseTest extends TestCase{
	
	public void testInitialize(){
		
		Enterprise ent = new Enterprise();		
		
		ent.initialize(new Integer [][] {{1,2},{3,4},{5,6,7,8}});
		
		assertEquals(3, ent.getEmpleadosEmpresa().size());
		assertEquals(8, ent.getClientesEmpresa().size());
		assertEquals(36, ent.getProductosEmpresa().size());
		assertEquals(36, ent.getVentasEmpresa().size());
		
	}
	
	public void testPorcentajes() throws ParseException{
		
		Enterprise ent = new Enterprise();
		
		ent.initialize(new Integer [][] {{1,2},{3,4},{5,6},{7,8}});
		ent.actualizaPorcentajes();
		
		
		assertEquals(25.0f, ent.getEmpleadosEmpresa().get(1).getPercentCustomers());
		assertEquals(22.222221f, ent.getClientesEmpresa().get(7).getPercentProduct());
		
//		ArrayList<Employee> empleados = ent.getEmpleadosEmpresa();
//		ArrayList<Customer> clientes = ent.getClientesEmpresa();
//		
//		float perCli0Emp0 = 2.7777777f;
//		float perCli1Emp3 = 22.222221f;
//		
//		for (Employee employee : empleados) {
//			assertEquals(25.0f, employee.getPercentCustomers());
//			for (Customer customer : clientes) {
//				if(customer.getName()=="Cliente 0 del empleado 0"){
//					assertEquals(perCli0Emp0, customer.getPercentProduct());
//				}
//				if(customer.getName()=="Cliente 1 del empleado 3"){
//					assertEquals(perCli1Emp3, customer.getPercentProduct());
//				}
//			}
//		}
		
	}
}
