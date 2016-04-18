package com.indra.formacio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import com.indra.formacio.dao.EmployeeRepository;
import com.indra.formacio.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class EmployeeRepoTest extends TestCase {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	EmployeeRepository erepo;
	
	
	@Test
	public void testFileInsertedData() throws ParseException {
		List<Employee> res = erepo.findByBirthday(sdf.parse("01/10/1970"));
		assertFalse(res.isEmpty());
		Employee e = res.get(0);
		assertEquals("Treballador 3", e.getName());
	}
	@Test
	public void testFindByName(){
		List<Employee> res = erepo.findByName("Treballador 1");
		assertFalse(res.isEmpty());
		Employee e = res.get(0);
		assertEquals("Cognom treballador 1",e.getSurname());
	}
	@Test
	public void testFindBySurname(){
		List<Employee> res = erepo.findBySurname("Cognom treballador 2");
		assertFalse(res.isEmpty());
		Employee e = res.get(0);
		assertEquals("Treballador 2", e.getName());
	}
	@Test
	public void testFindByNameAndSurname() throws ParseException{
		List<Employee> res = erepo.findByNameAndSurname("Treballador 1", "Cognom treballador 1");
		assertFalse(res.isEmpty());
		Employee e = res.get(0);
		assertEquals(sdf.parse("01/01/1980"), e.getBirthday());
	}
	@Test
	public void testFindByYearsWorking(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.YEAR, -10);
		List<Employee> res = erepo.findByYearsWorking(calendar);
		assertFalse(res.isEmpty());
		assertEquals(3,res.size());
	}
	@Test
	public void testFindByYearsOld(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.YEAR, -26);
		int year = calendar.get(Calendar.YEAR);
		List<Employee> res = erepo.findByYearsOld(year);
		assertFalse(res.isEmpty());
		assertEquals(1, res.size());
	}
	
}
