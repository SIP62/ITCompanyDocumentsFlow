package by.bsuir.spp.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import by.bsuir.spp.dao.ProjectInfoDAO;
import by.bsuir.spp.entities.Info;

public class ProjectInfoDAOTester {
	
	private ProjectInfoDAO projectInfoDAO;
	private List<Info> infoList;
	
	@Before
	public void initProjectInfoDAO() {
		projectInfoDAO = new ProjectInfoDAO();
		infoList = new ArrayList<Info>();
	}
	
	@Test
	public void testProjectInfoDAO() {
		String projectId = "1";
		infoList = projectInfoDAO.viewProjectInfo(projectId);
		assertFalse(infoList.isEmpty());
	}
	
	@Test
	public void testProjectInfoDAO2() {
		String projectId = "1";
		int expected = Integer.parseInt(projectId);
		int actual = 0;
		infoList = projectInfoDAO.viewProjectInfo(projectId);
		for (Info in: infoList) {
			if(in.getId() == 2) {
				actual = in.getProject().getId();
				break;
			}
		}
		assertEquals(expected, actual, 0);
	}
	
	@Test
	public void testProjectInfoDAO3() {
		String projectId = "2";
		int expected = Integer.parseInt(projectId);
		int actual = 0;
		infoList = projectInfoDAO.viewProjectInfo(projectId);
		for (Info in: infoList) {
			if(in.getId() == 2) {
				actual = in.getProject().getId();
				break;
			}
		}
		assertEquals(expected, actual, 0);
	}

}
