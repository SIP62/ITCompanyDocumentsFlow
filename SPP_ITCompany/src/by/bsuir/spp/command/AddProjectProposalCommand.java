package by.bsuir.spp.command;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.resource.ConfigurationManager;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.AddProjectProposalService;

public class AddProjectProposalCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String userId = request.getParameter("user_id");
		String user = request.getParameter("user");
		String role = request.getParameter("role");
		
		AddProjectProposalService addProjectProposalService = new AddProjectProposalService();
		boolean isProposalAdded = addProjectProposalService.addProjectProposal(request);
		if (isProposalAdded) {
			request.setAttribute("addProjectProposalMessage",
					MessageManager.getProperty("message.newprojectproposal"));
			//  определение пути к jsp
			if (role.equals("client")) 
				page = ConfigurationManager.getProperty("path.page.client");
			if (role.equals("guest")) 
				page = ConfigurationManager.getProperty("path.page.user");
		} else {
			request.setAttribute("errorProjectProposalMessage",
			MessageManager.getProperty("message.projectproposalerror"));
			page = ConfigurationManager.getProperty("path.page.projectproposalform");
		}
		request.setAttribute("user_id", userId);
		request.setAttribute("role", role);
		request.setAttribute("user", user);			
		return page;
	}

}
