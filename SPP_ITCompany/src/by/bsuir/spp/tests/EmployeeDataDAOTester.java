package by.bsuir.spp.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import by.bsuir.spp.dao.EmployeeDataDAO;
import by.bsuir.spp.entities.Employee;

public class EmployeeDataDAOTester {

	private EmployeeDataDAO employeeDataDAO;
	private Employee employee;
	
	@Before
	public void initEmployeeDataDAO() {
		employeeDataDAO = new EmployeeDataDAO();
		employee = new Employee();
	}
	
	@Test
	public void testEmployeeDataDAO() {
		String idUsers = "1";
		employee = employeeDataDAO.viewEmployeeData(idUsers);
		assertEquals(employee.getUsers().getName(),"Alex");
	}
	
	@Test
	public void testEmployeeDataDAO2() {
		String idUsers = "3";
		employee = employeeDataDAO.viewEmployeeData(idUsers);
		assertEquals(employee.getUsers().getName(),"Maxim");
	}
	
	@Test
	public void testEmployeeDataDAO3() {
		String idUsers = "2";
		employee = employeeDataDAO.viewEmployeeData(idUsers);
		assertEquals(employee.getUsers().getName(),"Maxim");
	}
}
