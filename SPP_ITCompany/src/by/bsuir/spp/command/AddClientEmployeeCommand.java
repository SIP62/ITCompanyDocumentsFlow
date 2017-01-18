package by.bsuir.spp.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.entities.ClientEmployee;
import by.bsuir.spp.resource.ConfigurationManager;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.AddClientEmployeeService;
import by.bsuir.spp.service.ClientEmployeesService;

public class AddClientEmployeeCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String userId = request.getParameter("user_id");
		String user = request.getParameter("user");
		String role = request.getParameter("role");
		String clientId = request.getParameter("clientid");
		String clientName = request.getParameter("clientname");
		
		AddClientEmployeeService addClientEmployeeService = new AddClientEmployeeService();
		boolean isAdded = addClientEmployeeService.addClientEmployee(request);
		
		ClientEmployeesService clientEmployeesService = new ClientEmployeesService();
		List<ClientEmployee> clientEmployeeList = clientEmployeesService.getClientEmployeeData(request);
		
		request.setAttribute("clientEmployeeList", clientEmployeeList);
		
		if (!isAdded) {
			request.setAttribute("errorInsertMessage",
				MessageManager.getProperty("message.insertclientemployeeerror"));
		}
		
		request.setAttribute("role", role);
		request.setAttribute("user_id", userId);
		request.setAttribute("user", user);
		request.setAttribute("clientid", clientId);
		request.setAttribute("clientname", clientName);
		page = ConfigurationManager.getProperty("path.page.clientemployees");
		return page;
	}

}
