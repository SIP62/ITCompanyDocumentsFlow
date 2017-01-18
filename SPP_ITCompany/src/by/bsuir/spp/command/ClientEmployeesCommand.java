package by.bsuir.spp.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.entities.ClientEmployee;
import by.bsuir.spp.resource.ConfigurationManager;
import by.bsuir.spp.service.ClientEmployeesService;

public class ClientEmployeesCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String userId = request.getParameter("user_id");
		String user = request.getParameter("user");
		String role = request.getParameter("role");
		String clientId = request.getParameter("clientid");
		String clientName = request.getParameter("clientname");
		
		ClientEmployeesService clientEmployeesService = new ClientEmployeesService();
		List<ClientEmployee> clientEmployeeList = clientEmployeesService.getClientEmployeeData(request);
		
		request.setAttribute("clientEmployeeList", clientEmployeeList);
		request.setAttribute("user_id", userId);
		request.setAttribute("user", user);
		request.setAttribute("role", role);
		request.setAttribute("clientid", clientId);
		request.setAttribute("clientname", clientName);
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
//		page = ConfigurationManager.getProperty("path.page.clientemployees");
		return page;
	}

}
