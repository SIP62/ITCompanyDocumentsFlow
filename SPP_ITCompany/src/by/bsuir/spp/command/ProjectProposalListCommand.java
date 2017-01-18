package by.bsuir.spp.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.entities.ProjectProposal;
import by.bsuir.spp.resource.ConfigurationManager;
import by.bsuir.spp.service.ProjectProposalListService;

public class ProjectProposalListCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String userId = request.getParameter("user_id");
		String user = request.getParameter("user");
		String role = request.getParameter("role");
		
		ProjectProposalListService projectProposalListService = new ProjectProposalListService();
		List<ProjectProposal> projectProposalList = projectProposalListService.getProjectProposalList();
		request.setAttribute("projectProposalList", projectProposalList);
		
		request.setAttribute("user_id", userId);
		request.setAttribute("role", role);
		request.setAttribute("user", user);
		page = ConfigurationManager.getProperty("path.page.employee");
		return page;
	}

}
