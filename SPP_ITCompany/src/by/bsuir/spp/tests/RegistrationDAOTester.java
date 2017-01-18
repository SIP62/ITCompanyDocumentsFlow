package by.bsuir.spp.tests;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import by.bsuir.spp.entities.Users;

//@RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class RegistrationDAOTester {
	
	Users user;
	
	//@InjectMocks annotation is used to create and inject the mock object
	@InjectMocks
	AddUpdateMockServiceImpl addUpdateMockServiceImpl = new AddUpdateMockServiceImpl();
	   
	 //@Mock annotation is used to create the mock object to be injected
	@Mock
	IAddUpdateMockService iAddUpdateMockService;
	
	@Test
	public void testAddUser() {
		user = new Users();
		boolean isAdded = false;
		if(user != null) isAdded = true;
		
		when(iAddUpdateMockService.addUserToDB(user)).thenReturn(isAdded);
		assertTrue(addUpdateMockServiceImpl.addUserToDB(user));
		
		
	}	
}
