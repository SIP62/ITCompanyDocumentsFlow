package by.bsuir.spp.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import by.bsuir.spp.entities.Roles;
import by.bsuir.spp.service.RolesListService;

public class RolesListServiceTester {
	
	private RolesListService rolesListService;
	private List<Roles> rolesList;
	
	@Before
	public void initRolesListService() {
		rolesListService = new RolesListService();
		rolesList = new ArrayList<Roles>();
	}
	
	@Test
	public void testRolesListService() {
		rolesList = rolesListService.getRolesList();
		assertFalse(rolesList.isEmpty());
	}
	
	@Test
	public void testRolesListService2() {
		String expected = "client";
		String actual = "";
		rolesList = rolesListService.getRolesList();
		for (Roles rs: rolesList) {
			if(rs.getId() == 7) {
				actual = rs.getRole();
				break;
			}
		}
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRolesListService3() {
		String expected = "client";
		String actual = "";
		rolesList = rolesListService.getRolesList();
		for (Roles rs: rolesList) {
			if(rs.getId() == 1) {
				actual = rs.getRole();
				break;
			}
		}
		assertEquals(expected, actual);
	}

}
