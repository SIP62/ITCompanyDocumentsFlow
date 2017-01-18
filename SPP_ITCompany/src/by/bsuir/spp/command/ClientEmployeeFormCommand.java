package by.bsuir.spp.command;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.resource.ConfigurationManager;

public class ClientEmployeeFormCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String userId = request.getParameter("user_id");
		String user = request.getParameter("user");
		String role = request.getParameter("role");
		String clientId = request.getParameter("clientid");
		String clientName = request.getParameter("clientname");
		
		request.setAttribute("role", role);
		request.setAttribute("user_id", userId);
		request.setAttribute("user", user);
		request.setAttribute("clientid", clientId);
		request.setAttribute("clientname", clientName);
		page = ConfigurationManager.getProperty("path.page.clientemployeeform");
		return page;
	}

}
