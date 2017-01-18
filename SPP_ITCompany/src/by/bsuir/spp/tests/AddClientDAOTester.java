package by.bsuir.spp.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.mockito.runners.MockitoJUnitRunner;

import by.bsuir.spp.entities.Client;

//@RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class AddClientDAOTester {
	
	Client client;
	
	//@InjectMocks annotation is used to create and inject the mock object
	@InjectMocks
	AddUpdateMockServiceImpl addUpdateMockServiceImpl = new AddUpdateMockServiceImpl();
	   
	 //@Mock annotation is used to create the mock object to be injected
	@Mock
	IAddUpdateMockService iAddUpdateMockService;
	
	@Test
	public void testAddClient() {
		client = new Client();
		boolean isAdded = false;
		if(client != null) isAdded = true;
		
		when(iAddUpdateMockService.addClientInDB(client)).thenReturn(isAdded);
		assertTrue(addUpdateMockServiceImpl.addClientInDB(client));
		
		
	}

}
