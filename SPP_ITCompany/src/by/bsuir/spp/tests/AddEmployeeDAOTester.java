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
public class AddEmployeeDAOTester {
	
	Employee employee;
	
	//@InjectMocks annotation is used to create and inject the mock object
	@InjectMocks
	AddUpdateMockServiceImpl addUpdateMockServiceImpl = new AddUpdateMockServiceImpl();
		   
	//@Mock annotation is used to create the mock object to be injected
	@Mock
	IAddUpdateMockService iAddUpdateMockService;
	
	@Test
	public void testAddEmployee() {
		employee = new Employee();
		boolean isAdded = false;
		if(employee != null) isAdded = true;
		
		when(iAddUpdateMockService.addEmployeeInDB(employee)).thenReturn(isAdded);
		assertTrue(addUpdateMockServiceImpl.addEmployeeInDB(employee));
		
		
	}
		

}
