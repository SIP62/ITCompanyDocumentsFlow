package by.bsuir.spp.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import by.bsuir.spp.entities.Client;
import by.bsuir.spp.service.ClientListService;

public class ClientListServiceTester {
	
	private ClientListService clientListService;
	private List<Client> clientList;
	
	@Before
	public void initClientListService() {
		clientListService = new ClientListService();
		clientList = new ArrayList<Client>();
	}
	
	@Test
	public void testClientListService() {
		clientList = clientListService.getClientList();
		assertFalse(clientList.isEmpty());
	}
	
	@Test
	public void testClientListService2() {
		int expected = 11;
		int actual = 0;
		clientList = clientListService.getClientList();
		for (Client ce: clientList) {
			if(ce.getId() == 3) {
				actual = ce.getUsers().getId();
				break;
			}
		}
		assertEquals(expected, actual, 0);
	}
	
	@Test
	public void testClientListService3() {
		int expected = 12;
		int actual = 0;
		clientList = clientListService.getClientList();
		for (Client ce: clientList) {
			if(ce.getId() == 3) {
				actual = ce.getUsers().getId();
				break;
			}
		}
		assertEquals(expected, actual, 0);
	}

}
