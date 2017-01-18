package by.bsuir.spp.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import by.bsuir.spp.dao.ClientDataDAO;
import by.bsuir.spp.entities.Client;

public class ClientDataDAOTester {
	
	private ClientDataDAO clientDataDAO;
	private Client client;
	
	@Before
	public void initClientDataDAO() {
		clientDataDAO = new ClientDataDAO();
		client = new Client();
	}
	
	@Test
	public void testClientDataDAO() {
		String idUsers = "11";
		client = clientDataDAO.viewClientData(idUsers);
		assertEquals(client.getUsers().getName(),"Ivan");
	}
	
	@Test
	public void testClientDataDAO2() {
		String idUsers = "13";
		client = clientDataDAO.viewClientData(idUsers);
		assertEquals(client.getUsers().getName(),"Vasya");
	}
	
	@Test
	public void testClientDataDAO3() {
		String idUsers = "1";
		client = clientDataDAO.viewClientData(idUsers);
		assertEquals(client.getUsers().getName(),"Alex");
	}

}
