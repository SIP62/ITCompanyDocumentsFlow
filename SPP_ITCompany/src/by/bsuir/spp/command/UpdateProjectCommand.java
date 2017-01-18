package by.bsuir.spp.command;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.resource.ConfigurationManager;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.UpdateProjectDataService;

public class UpdateProjectCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String userId = request.getParameter("user_id");
		String user = request.getParameter("user");
		String role = request.getParameter("role");

		UpdateProjectDataService updateProjectDataService = new UpdateProjectDataService();
		boolean isUpdated = updateProjectDataService.updateProjectData(request);
		if(isUpdated) {
			request.setAttribute("updateProjectDataMessage",
					MessageManager.getProperty("message.updateprojectdata"));
			switch (role) {
			case "client":
				page = ConfigurationManager.getProperty("path.page.client");
				break;
			case "programmer":
			case "team_leader":
			case "project_manager":
			case "client_manager":	
			case "HR":
				page = ConfigurationManager.getProperty("path.page.employee");
				break;
			case "admin":
				page = ConfigurationManager.getProperty("path.page.admin");
				break;
			case "guest":
				page = ConfigurationManager.getProperty("path.page.user");
				break;
			default:
				page = ConfigurationManager.getProperty("path.page.login");
			}
			
		} else {
			request.setAttribute("errorUpdateProjectDataMessage",
			MessageManager.getProperty("message.updateprojectdataerror"));
			page = ConfigurationManager.getProperty("path.page.projectdataform");
		}
		request.setAttribute("user_id", userId);
		request.setAttribute("user", user);
		request.setAttribute("role", role);
		return page;
	}

}
