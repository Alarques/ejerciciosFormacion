package com.indra.formacio.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Enterprise {
	
	private ArrayList<Employee> empleadosEmpresa;
	private ArrayList<Customer> clientesEmpresa;
	private ArrayList<Product> productosEmpresa;
	private ArrayList<Sale> ventasEmpresa;
	private SimpleDateFormat	sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Enterprise(){
		this.empleadosEmpresa = new ArrayList<Employee>();
		this.clientesEmpresa = new ArrayList<Customer>();
		this.productosEmpresa = new ArrayList<Product>();
		this.ventasEmpresa = new ArrayList<Sale>();		
	}
	
	

	public Enterprise(ArrayList<Employee> empleadosEmpresa, ArrayList<Customer> clientesEmpresa,
			ArrayList<Product> productosEmpresa, ArrayList<Sale> ventasEmpresa) {
		this.empleadosEmpresa = empleadosEmpresa;
		this.clientesEmpresa = clientesEmpresa;
		this.productosEmpresa = productosEmpresa;
		this.ventasEmpresa = ventasEmpresa;
	}



	public ArrayList<Employee> getEmpleadosEmpresa() {
		return empleadosEmpresa;
	}

	public void setEmpleadosEmpresa(ArrayList<Employee> empleadosEmpresa) {
		this.empleadosEmpresa = empleadosEmpresa;
	}

	public ArrayList<Customer> getClientesEmpresa() {
		return clientesEmpresa;
	}

	public void setClientesEmpresa(ArrayList<Customer> clientesEmpresa) {
		this.clientesEmpresa = clientesEmpresa;
	}

	public ArrayList<Product> getProductosEmpresa() {
		return productosEmpresa;
	}

	public void setProductosEmpresa(ArrayList<Product> productosEmpresa) {
		this.productosEmpresa = productosEmpresa;
	}

	public ArrayList<Sale> getVentasEmpresa() {
		return ventasEmpresa;
	}

	public void setVentasEmpresa(ArrayList<Sale> ventasEmpresa) {
		this.ventasEmpresa = ventasEmpresa;
	}
	
    public void actualizaPorcentajes() throws ParseException{
    	int numCli;
    	int numProd;
    	float percentEmp;
    	float percentCli;
    	Date date = new Date();
    	String bb = this.sdf.format(date);
    	for (Employee employee : this.empleadosEmpresa) {
    		numCli = 0;
        	for (Customer customer : this.clientesEmpresa) {
        		numProd = 0;
        		if(employee.getId() == customer.getEmployee().getId()){
        			numCli++;
        		}
        		for (Sale sale : this.ventasEmpresa) {
    				if(customer.getId() == sale.getCustomer().getId()){
    					numProd++;
    				}
    			}
        		percentCli = (float) numProd*100/this.ventasEmpresa.size();
        		customer.setPercentProduct(percentCli);
        		customer.setPercentDate(this.sdf.parse(bb));
    		}
        	percentEmp = (float) numCli*100/this.clientesEmpresa.size();
        	employee.setPercentCustomers(percentEmp);
			employee.setPercentDate(this.sdf.parse(bb));
		}
    }
    
    public void muestraPorcentajes(){
    	for (Employee employee : this.empleadosEmpresa) {
			System.out.println("- "+employee.getName());
			System.out.println("- Porcentaje de clientes: "+employee.getPercentCustomers()+"%");
			System.out.println("- Clientes:");
			for (Customer customer : this.clientesEmpresa) {
				if(customer.getEmployee().getId() == employee.getId()){
					System.out.println("\t- "+customer.getName()+", porcentaje de productos: "+customer.getPercentProduct()+"%");
					for (Sale sale : this.ventasEmpresa) {
						if(sale.getCustomer().getId() == customer.getId())System.out.println("\t\t- "+sale.getProduct().getName());
					}
				}
			}
		}
    }

    public void initialize(Integer [][] empCliProd){
    	
    	Employee e;
    	Customer c;
    	int numProduct;
    	Product p;
    	Sale s;
    	
    	for (int i = 0; i < empCliProd.length; i++) {
			e = new Employee();
			e.setId(new Long(i));
			e.setName("Empleado "+i);
			empleadosEmpresa.add(e);
			for (int j = 0; j < empCliProd[i].length; j++) {
				c = new Customer();
				c.setId(new Long(j));
				c.setName("Cliente " +j+ " del empleado "+i);
				c.setEmployee(e);
				clientesEmpresa.add(c);
				numProduct = empCliProd[i][j];
				for (int k = 0; k < numProduct; k++) {
					p = new Product();
					p.setId(new Long(k));
					p.setName("Producto " +k + " del "+c.getName());
					productosEmpresa.add(p);
					s = new Sale(p,c);
					ventasEmpresa.add(s);
				}
			}
		} 	
    	
    }
	
	
}
