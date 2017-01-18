package by.bsuir.spp.service;

import java.util.List;

import by.bsuir.spp.dao.ProjectProposalListDAO;
import by.bsuir.spp.entities.ProjectProposal;

public class ProjectProposalListService {

	public List<ProjectProposal> getProjectProposalList() {
		ProjectProposalListDAO ppld = new ProjectProposalListDAO();
		
		return ppld.viewProjectProposalList();
	}
}
