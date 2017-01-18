package by.bsuir.spp.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import by.bsuir.spp.dao.ProjectListOfEmployeeDAO;
import by.bsuir.spp.entities.Project;

public class ProjectListOfEmployeeDAOTester {

	private ProjectListOfEmployeeDAO projectListOfEmployeeDAO;
	List<Project> projectsList;
	
	@Before
	public void initProjectListOfEmployeeDAO() {
		projectListOfEmployeeDAO = new ProjectListOfEmployeeDAO();
		projectsList = new ArrayList<Project>();
	}
	
	@Test
	public void testProjectListOfEmployeeDAO1() {
		String idUsers = "1";
		projectsList = projectListOfEmployeeDAO.viewProjectsList(idUsers);
		assertFalse(projectsList.isEmpty());
	}
	
	@Test
	public void testProjectListOfClientDAO2() {
		String idUsers = "8";
		projectsList = projectListOfEmployeeDAO.viewProjectsList(idUsers);
		assertTrue(projectsList.isEmpty());
	}
	
	@Test
	public void testProjectListOfEmployeeDAO3() {
		String idUsers = "1";
		String expected = "Library";
		String actual = "";
		projectsList = projectListOfEmployeeDAO.viewProjectsList(idUsers);
		for (Project pr: projectsList) {
			if(pr.getId() == 1) {
				actual = pr.getName();
				break;
			}
		}
		assertEquals(expected, actual);
	}
	
	@Test
	public void testProjectListOfEmployeeDAO4() {
		String idUsers = "2";
		String expected = "Website";
		String actual = "";
		projectsList = projectListOfEmployeeDAO.viewProjectsList(idUsers);
		for (Project pr: projectsList) {
			if(pr.getId() == 1) {
				actual = pr.getName();
				break;
			}
		}
		assertEquals(expected, actual);
	}
}
