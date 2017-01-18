package by.bsuir.spp.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import by.bsuir.spp.dao.ProjectProposalDataDAO;
import by.bsuir.spp.entities.ProjectProposal;

public class ProjectProposalDataDAOTester {

	private ProjectProposalDataDAO projectProposalDataDAO;
	private ProjectProposal projectProposal;
	
	@Before
	public void initProjectProposalDataDAO() {
		projectProposalDataDAO = new ProjectProposalDataDAO();
		projectProposal = new ProjectProposal();
	}
	
	@Test
	public void testProjectProposalDataDAO() {
		String projectProposalId = "7";
		projectProposal = projectProposalDataDAO.viewProjectProposalData(projectProposalId);
		assertEquals(projectProposal.getName(),"Website of school");
	}
	
	@Test
	public void testProjectProposalDataDAO2() {
		String projectProposalId = "11";
		projectProposal = projectProposalDataDAO.viewProjectProposalData(projectProposalId);
		assertEquals(projectProposal.getName(),"Website of theater");
	}
	
	@Test
	public void testProjectProposalDataDAO3() {
		String projectProposalId = "8";
		projectProposal = projectProposalDataDAO.viewProjectProposalData(projectProposalId);
		assertEquals(projectProposal.getName(),"Website of theater");
	}
}
