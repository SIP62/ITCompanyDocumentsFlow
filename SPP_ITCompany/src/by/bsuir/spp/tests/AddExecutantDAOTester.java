package by.bsuir.spp.tests;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


//@RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class AddExecutantDAOTester {
	
	//@InjectMocks annotation is used to create and inject the mock object
	@InjectMocks
	AddUpdateMockServiceImpl addUpdateMockServiceImpl = new AddUpdateMockServiceImpl();
		   
	//@Mock annotation is used to create the mock object to be injected
	@Mock
	IAddUpdateMockService iAddUpdateMockService;	
	
	@Test
	public void testAddExecutant() {
		String projectId = "1";
		String employeeId = "2";
		boolean isAdded = false;
		if(projectId != null && employeeId != null) isAdded = true;
		
		when(iAddUpdateMockService.insertExecutantInProject(projectId, employeeId)).thenReturn(isAdded);
		assertTrue(addUpdateMockServiceImpl.insertExecutantInProject(projectId, employeeId));
		
		
	}

}
