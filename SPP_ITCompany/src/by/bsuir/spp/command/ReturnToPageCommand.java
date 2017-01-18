package by.bsuir.spp.command;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.resource.ConfigurationManager;

public class ReturnToPageCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String userId = request.getParameter("user_id");
		String user = request.getParameter("user");
		String role = request.getParameter("role");
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
		request.setAttribute("user_id", userId);
		request.setAttribute("role", role);
		request.setAttribute("user", user);
		return page;
	}

}
