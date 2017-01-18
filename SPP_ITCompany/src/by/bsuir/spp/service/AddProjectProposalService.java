package by.bsuir.spp.service;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.dao.AddProjectProposalDAO;
import by.bsuir.spp.entities.ProjectProposal;

public class AddProjectProposalService {
	AddProjectProposalDAO appd = new AddProjectProposalDAO();

	public boolean addProjectProposal(HttpServletRequest request) {
		
		ProjectProposal projectProposal = new ProjectProposal();
		projectProposal.setName(request.getParameter("name"));
		projectProposal.setContactName(request.getParameter("contact_name"));
		projectProposal.setPhone(request.getParameter("phone"));
		projectProposal.setEmail(request.getParameter("email"));
		projectProposal.setStatus(request.getParameter("status"));
		projectProposal.setDescription(request.getParameter("description"));;
		projectProposal.setRequirementSpecification(request.getParameter("requirement_specification"));
		projectProposal.setTerm(request.getParameter("term"));
		boolean isRecordAdded = appd.addProjectProposalToDB(projectProposal);
		
		return isRecordAdded;
	}

}
