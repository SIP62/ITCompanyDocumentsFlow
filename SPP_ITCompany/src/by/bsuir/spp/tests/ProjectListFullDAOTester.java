package by.bsuir.spp.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import by.bsuir.spp.dao.ProjectListFullDAO;
import by.bsuir.spp.entities.Project;

public class ProjectListFullDAOTester {
	
	private ProjectListFullDAO projectListFullDAO;
	List<Project> projectsList;
	
	@Before
	public void initProjectListFullDAO() {
		projectListFullDAO = new ProjectListFullDAO();
		projectsList = new ArrayList<Project>();
	}
	
	@Test
	public void testProjectListFullDAO() {
		projectsList = projectListFullDAO.viewProjectsList();
		assertFalse(projectsList.isEmpty());
	}
	
	@Test
	public void testProjectListFullDAO2() {
		String expected = "Library";
		String actual = "";
		projectsList = projectListFullDAO.viewProjectsList();
		for (Project pr: projectsList) {
			if(pr.getId() == 1) {
				actual = pr.getName();
				break;
			}
		}
		assertEquals(expected, actual);
	}
	
	@Test
	public void testProjectListFullDAO3() {
		String expected = "Library";
		String actual = "";
		projectsList = projectListFullDAO.viewProjectsList();
		for (Project pr: projectsList) {
			if(pr.getId() == 2) {
				actual = pr.getName();
				break;
			}
		}
		assertEquals(expected, actual);
	}

}
