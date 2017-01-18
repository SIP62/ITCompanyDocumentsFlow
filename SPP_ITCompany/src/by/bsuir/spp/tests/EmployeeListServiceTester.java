package by.bsuir.spp.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import by.bsuir.spp.entities.Employee;
import by.bsuir.spp.service.EmployeeListService;

public class EmployeeListServiceTester {
	
	private EmployeeListService employeeListService;
	private List<Employee> employeeList;
	
	@Before
	public void initEmployeeListService() {
		employeeListService = new EmployeeListService();
		employeeList = new ArrayList<Employee>();
	}
	
	@Test
	public void testEmployeeListService() {
		employeeList = employeeListService.getEmployeeList();
		assertFalse(employeeList.isEmpty());
	}
	
	@Test
	public void testEmployeeListService2() {
		int expected = 1;
		int actual = 0;
		employeeList = employeeListService.getEmployeeList();
		for (Employee e: employeeList) {
			if(e.getId() == 1) {
				actual = e.getUsers().getId();
				break;
			}
		}
		assertEquals(expected, actual, 0);
	}
	
	@Test
	public void testEmployeeListService3() {
		int expected = 21;
		int actual = 0;
		employeeList = employeeListService.getEmployeeList();
		for (Employee e: employeeList) {
			if(e.getId() == 9) {
				actual = e.getUsers().getId();
				break;
			}
		}
		assertEquals(expected, actual, 0);
	}
	
	@Test
	public void testEmployeeListService4() {
		int expected = 1;
		int actual = 0;
		employeeList = employeeListService.getEmployeeList();
		for (Employee e: employeeList) {
			if(e.getId() == 2) {
				actual = e.getUsers().getId();
				break;
			}
		}
		assertEquals(expected, actual, 0);
	}

}
