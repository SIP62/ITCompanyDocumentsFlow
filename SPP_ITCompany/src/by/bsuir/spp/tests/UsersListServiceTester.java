package by.bsuir.spp.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import by.bsuir.spp.entities.Users;
import by.bsuir.spp.service.UsersListService;

public class UsersListServiceTester {

	private UsersListService usersListService;
	private List<Users> userList;
	
	@Before
	public void initUsersListService() {
		usersListService = new UsersListService();
		userList = new ArrayList<Users>();
	}
	
	@Test
	public void testUsersListService() {
		userList = usersListService.getUsersList();
		assertFalse(userList.isEmpty());
	}
	
	@Test
	public void testUsersListService2() {
		String expected = "Artur";
		String actual = "";
		userList = usersListService.getUsersList();
		for (Users us: userList) {
			if(us.getId() == 4) {
				actual = us.getName();
				break;
			}
		}
		assertEquals(expected, actual);
	}
	
	@Test
	public void testUsersListService3() {
		String expected = "Alex";
		String actual = "";
		userList = usersListService.getUsersList();
		for (Users us: userList) {
			if(us.getId() == 4) {
				actual = us.getName();
				break;
			}
		}
		assertEquals(expected, actual);
	}
}
