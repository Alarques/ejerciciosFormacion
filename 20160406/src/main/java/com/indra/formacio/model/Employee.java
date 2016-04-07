package com.indra.formacio.model;

//import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Objects of this class represent an Employee
 * 
 * @author ealcalal
 *
 */
public class Employee {
	
	SimpleDateFormat	sdf = new SimpleDateFormat("dd/mm/yyyy");	
	
	protected Long id;
	protected String name;
	protected String surname;
	protected Date birthday;
	protected Float percentCustomers;
	protected Date percentDate;
	
//	public Employee (long id, String name, String surname, String birthday){
//		this.id = id;
//		this.name = name;
//		this.surname = surname;
//		//Alerta con el SURROUND!!
//		try {
//			this.birthday = sdf.parse(birthday);
//		} catch (ParseException e) {
//			System.out.println("Error seteando la fecha!!");
//			e.printStackTrace();
//			this.birthday = new Date();
//		}
//	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Float getPercentCustomers() {
		return percentCustomers;
	}
	public void setPercentCustomers(Float percentCustomers) {
		this.percentCustomers = percentCustomers;
	}
	public Date getPercentDate() {
		return percentDate;
	}
	public void setPercentDate(Date percentDate) {
		this.percentDate = percentDate;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (birthday == null) {
			if (other.getBirthday() != null)
				return false;
		} else if (!birthday.equals(other.getBirthday()))
			return false;
		if (id == null) {
			if (other.getId() != null)
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		if (name == null) {
			if (other.getName() != null)
				return false;
		} else if (!name.equals(other.getName()))
			return false;
		if (percentCustomers == null) {
			if (other.getPercentCustomers() != null)
				return false;
		} else if (!percentCustomers.equals(other.getPercentCustomers()))
			return false;
		if (percentDate == null) {
			if (other.getPercentDate() != null)
				return false;
		} else if (!percentDate.equals(other.getPercentDate()))
			return false;
		if (sdf == null) {
			if (other.sdf != null)
				return false;
		} else if (!sdf.equals(other.sdf))
			return false;
		if (surname == null) {
			if (other.getSurname() != null)
				return false;
		} else if (!surname.equals(other.getSurname()))
			return false;
		return true;
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		Employee empAux = (Employee)obj;
//		
//		boolean equals = true;
//		
//		if(this.name != null)(
//			if(!this.name.equals(empAux));
//		)
//		
//		equals = equals && (this.name == null && empAux.getName() == null);
//		equals = equals && (this.surname == null && empAux.getSurname() == null);
//		
//		return (
//			this.id == empAux.getId()
//			&& this.name.equals(empAux.getName())
//			&& this.surname.equals(empAux.getName())
//			&& this.percentCustomers.equals(empAux.getPercentCustomers())
//			&& this.birthday.equals(empAux.getBirthday())
//		);
//	}
	
}
