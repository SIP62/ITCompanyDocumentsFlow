package by.bsuir.spp.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import by.bsuir.spp.dao.ProjectDataDAO;
import by.bsuir.spp.entities.Project;

public class ProjectDataDAOTester {
	
	private ProjectDataDAO projectDataDAO;
	private Project project;
	
	@Before
	public void initProjectDataDAO() {
		projectDataDAO = new ProjectDataDAO();
		project = new Project();
	}
	
	@Test
	public void testProjectDataDAO() {
		String projectId = "1";
		project = projectDataDAO.viewProjectData(projectId);
		assertEquals(project.getName(),"Library");
	}
	
	@Test
	public void testProjectDataDAO2() {
		String projectId = "3";
		project = projectDataDAO.viewProjectData(projectId);
		assertEquals(project.getName(),"University");
	}
	
	@Test
	public void testProjectDataDAO3() {
		String projectId = "2";
		project = projectDataDAO.viewProjectData(projectId);
		assertEquals(project.getName(),"Library");
	}

}
