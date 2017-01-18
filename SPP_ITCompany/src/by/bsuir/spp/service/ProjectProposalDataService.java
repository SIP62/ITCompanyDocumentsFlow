package by.bsuir.spp.service;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.dao.ProjectProposalDataDAO;
import by.bsuir.spp.entities.ProjectProposal;

public class ProjectProposalDataService {
	ProjectProposalDataDAO ppdd = new ProjectProposalDataDAO();

	public ProjectProposal getProjectProposalData(HttpServletRequest request) {
		String projectProposalId = request.getParameter("projectProposalid");
		ProjectProposal projectProposal = ppdd.viewProjectProposalData(projectProposalId);
		return projectProposal;
	}

}
