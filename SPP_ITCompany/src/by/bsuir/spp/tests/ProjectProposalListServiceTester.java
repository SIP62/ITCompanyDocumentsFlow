package by.bsuir.spp.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import by.bsuir.spp.entities.ProjectProposal;
import by.bsuir.spp.service.ProjectProposalListService;

public class ProjectProposalListServiceTester {

	private ProjectProposalListService projectProposalListService;
	private List<ProjectProposal> projectProposalList;
	
	@Before
	public void initProjectProposalListService() {
		projectProposalListService = new ProjectProposalListService();
		projectProposalList = new ArrayList<ProjectProposal>();
	}
	
	@Test
	public void testProjectProposalListService() {
		projectProposalList = projectProposalListService.getProjectProposalList();
		assertFalse(projectProposalList.isEmpty());
	}
	
	@Test
	public void testProjectProposalListService2() {
		String expected = "Website of school";
		String actual = "";
		projectProposalList = projectProposalListService.getProjectProposalList();
		for (ProjectProposal pp: projectProposalList) {
			if(pp.getId() == 7) {
				actual = pp.getName();
				break;
			}
		}
		assertEquals(expected, actual);
	}
	
	@Test
	public void testProjectProposalListService3() {
		String expected = "Website";
		String actual = "";
		projectProposalList = projectProposalListService.getProjectProposalList();
		for (ProjectProposal pp: projectProposalList) {
			if(pp.getId() == 7) {
				actual = pp.getName();
				break;
			}
		}
		assertEquals(expected, actual);
	}
}
