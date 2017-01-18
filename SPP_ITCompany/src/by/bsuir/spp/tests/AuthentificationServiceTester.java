package by.bsuir.spp.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import by.bsuir.spp.entities.Users;
import by.bsuir.spp.service.AuthentificationService;

public class AuthentificationServiceTester {
	
	private AuthentificationService authentificationService;
	private Users user;
	
	@Before
	public void initAuthentificationService() {
		authentificationService = new AuthentificationService();
		user = new Users();
	}
	
	@After
	public void clearAuthentificationService() {
		authentificationService = null;
		user = null;
	}
	
	@Test
	public void testLoginCheckProgrammer() {
		String login = "alex";
		String pass = "alex";
		user = authentificationService.checkLogin(login, pass);
		String expectedRole = "programmer";
		String actualRole = user.getRoles().getRole();
		assertEquals(expectedRole, actualRole);
	}
	
	@Test
	public void testLoginCheckTeamLeader() {
		String login = "max";
		String pass = "max";
		user = authentificationService.checkLogin(login, pass);
		String expectedRole = "team_leader";
		String actualRole = user.getRoles().getRole();
		assertEquals(expectedRole, actualRole);
	}
	
	@Test
	public void testLoginCheckProjectManager() {
		String login = "artur";
		String pass = "artur";
		user = authentificationService.checkLogin(login, pass);
		String expectedRole = "project_manager";
		String actualRole = user.getRoles().getRole();
		assertEquals(expectedRole, actualRole);
	}
	
	@Test
	public void testLoginCheckClientManager() {
		String login = "vadim";
		String pass = "vadim";
		user = authentificationService.checkLogin(login, pass);
		String expectedRole = "client_manager";
		String actualRole = user.getRoles().getRole();
		assertEquals(expectedRole, actualRole);
	}
	
	@Test
	public void testLoginCheckHR() {
		String login = "oleg";
		String pass = "oleg";
		user = authentificationService.checkLogin(login, pass);
		String expectedRole = "HR";
		String actualRole = user.getRoles().getRole();
		assertEquals(expectedRole, actualRole);
	}
	
	@Test
	public void testLoginCheckAdmin() {
		String login = "andrew";
		String pass = "andrew";
		user = authentificationService.checkLogin(login, pass);
		String expectedRole = "admin";
		String actualRole = user.getRoles().getRole();
		assertEquals(expectedRole, actualRole);
	}
	
	@Test
	public void testLoginCheckClient() {
		String login = "ivan";
		String pass = "ivan";
		user = authentificationService.checkLogin(login, pass);
		String expectedRole = "client";
		String actualRole = user.getRoles().getRole();
		assertEquals(expectedRole, actualRole);
	}
	
	@Test
	public void testLoginCheckGuest() {
		String login = "gorg";
		String pass = "gorg";
		user = authentificationService.checkLogin(login, pass);
		String expectedRole = "guest";
		String actualRole = user.getRoles().getRole();
		assertEquals(expectedRole, actualRole);
	}
	
	@Test
	public void testLoginCheckNull() {
		String login = "one";
		String pass = "one";
		user = authentificationService.checkLogin(login, pass);
		assertNull(user);
	}
	

}
