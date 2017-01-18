package by.bsuir.spp.tests;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import by.bsuir.spp.entities.Employee;

//@RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class UpdateEmployeeDataDAOTester {

	Employee employee;
	
	//@InjectMocks annotation is used to create and inject the mock object
	@InjectMocks
	AddUpdateMockServiceImpl addUpdateMockServiceImpl = new AddUpdateMockServiceImpl();
		   
	//@Mock annotation is used to create the mock object to be injected
	@Mock
	IAddUpdateMockService iAddUpdateMockService;
	
	@Test
	public void testUpdateEmployee() {
		employee = new Employee();
		boolean isUpdated = false;
		if(employee != null) isUpdated = true;
		
		when(iAddUpdateMockService.updateEmployeeInDB(employee)).thenReturn(isUpdated);
		assertTrue(addUpdateMockServiceImpl.updateEmployeeInDB(employee));
		
		
	}
}
