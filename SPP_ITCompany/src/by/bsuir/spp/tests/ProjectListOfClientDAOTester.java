package by.bsuir.spp.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import by.bsuir.spp.dao.ProjectListOfClientDAO;
import by.bsuir.spp.entities.Project;

public class ProjectListOfClientDAOTester {
	
	private ProjectListOfClientDAO projectListOfClientDAO;
	List<Project> projectsList;
	
	@Before
	public void initProjectListOfClientDAODAO() {
		projectListOfClientDAO = new ProjectListOfClientDAO();
		projectsList = new ArrayList<Project>();
	}
	
	@Test
	public void testProjectListOfClientDAO1() {
		String idUsers = "9";
		projectsList = projectListOfClientDAO.viewProjectsList(idUsers);
		assertFalse(projectsList.isEmpty());
	}
	
	@Test
	public void testProjectListOfClientDAO2() {
		String idUsers = "11";
		projectsList = projectListOfClientDAO.viewProjectsList(idUsers);
		assertTrue(projectsList.isEmpty());
	}
	
	@Test
	public void testProjectListOfClientDAO3() {
		String idUsers = "9";
		String expected = "Library";
		String actual = "";
		projectsList = projectListOfClientDAO.viewProjectsList(idUsers);
		for (Project pr: projectsList) {
			if(pr.getId() == 1) {
				actual = pr.getName();
				break;
			}
		}
		assertEquals(expected, actual);
	}
	
	@Test
	public void testProjectListOfClientDAO4() {
		String idUsers = "9";
		String expected = "Website";
		String actual = "";
		projectsList = projectListOfClientDAO.viewProjectsList(idUsers);
		for (Project pr: projectsList) {
			if(pr.getId() == 1) {
				actual = pr.getName();
				break;
			}
		}
		assertEquals(expected, actual);
	}
}
