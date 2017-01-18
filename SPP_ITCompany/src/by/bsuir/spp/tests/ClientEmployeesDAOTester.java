package by.bsuir.spp.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import by.bsuir.spp.dao.ClientEmployeesDAO;
import by.bsuir.spp.entities.ClientEmployee;

public class ClientEmployeesDAOTester {
	
	private ClientEmployeesDAO clientEmployeesDAO;
	private List<ClientEmployee> clientEmployeeList;
	
	@Before
	public void initClientEmployeesDAO() {
		clientEmployeesDAO = new ClientEmployeesDAO();
		clientEmployeeList = new ArrayList<ClientEmployee>();
	}
	
	@Test
	public void testClientEmployeesDAO() {
		String clientId = "1";
		clientEmployeeList = clientEmployeesDAO.viewClientEmployees(clientId);
		assertFalse(clientEmployeeList.isEmpty());
	}
	
	@Test
	public void testClientEmployeesDAO2() {
		String clientId = "1";
		String expected = "petr";
		String actual = "";
		clientEmployeeList = clientEmployeesDAO.viewClientEmployees(clientId);
		for (ClientEmployee ce: clientEmployeeList) {
			if(ce.getName().equals("Petrov")) {
				actual = ce.getSkype();
				break;
			}
		}
		assertEquals(expected, actual);
	}
	
	@Test
	public void testClientEmployeesDAO3() {
		String clientId = "1";
		String expected = "ivan";
		String actual = "";
		clientEmployeeList = clientEmployeesDAO.viewClientEmployees(clientId);
		for (ClientEmployee ce: clientEmployeeList) {
			if(ce.getName().equals("Petrov")) {
				actual = ce.getSkype();
				break;
			}
		}
		assertEquals(expected, actual);
	}
}
