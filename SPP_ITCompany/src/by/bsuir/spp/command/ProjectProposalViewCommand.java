package by.bsuir.spp.command;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.entities.ProjectProposal;
import by.bsuir.spp.resource.ConfigurationManager;
import by.bsuir.spp.service.ProjectProposalDataService;

public class ProjectProposalViewCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		ProjectProposalDataService projectProposalDataService = new ProjectProposalDataService();
		String userId = request.getParameter("user_id");
		String user = request.getParameter("user");
		String role = request.getParameter("role");
		
		ProjectProposal projectProposal = projectProposalDataService.getProjectProposalData(request);
		request.setAttribute("project_proposal", projectProposal);
		
		System.out.println("from ProjectProposalViewCommand: name = " 
				+ projectProposal.getName());
		
		switch (role) {
		case "client":
			page = ConfigurationManager.getProperty("path.page.client");
			break;
		case "programmer":
		case "team_leader":
		case "project_manager":
		case "HR":
		case "client_manager":	
			page = ConfigurationManager.getProperty("path.page.employee");
			break;
		case "admin":
		
			page = ConfigurationManager.getProperty("path.page.admin");
			break;
		case "guest":
			page = ConfigurationManager.getProperty("path.page.login");
			break;
		default:
			page = ConfigurationManager.getProperty("path.page.login");
		}
		request.setAttribute("user_id", userId);
		request.setAttribute("user", user);
		request.setAttribute("role", role);
//		page = ConfigurationManager.getProperty("path.page.projectproposal");
		return page;
	}

}
