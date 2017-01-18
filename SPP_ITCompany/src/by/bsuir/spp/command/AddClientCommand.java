package by.bsuir.spp.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.entities.Client;
import by.bsuir.spp.resource.ConfigurationManager;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.AddClientService;
import by.bsuir.spp.service.ClientListService;

public class AddClientCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String userId = request.getParameter("user_id");
		String role = request.getParameter("role");
		String user = request.getParameter("user");
		
		AddClientService addClientService = new AddClientService();
		boolean isAdded = addClientService.addClient(request);
		
		ClientListService clientListService = new ClientListService();
		List<Client> clientList = clientListService.getClientList();
		request.setAttribute("clientList", clientList);
		
		if(isAdded) {
			request.setAttribute("addClientMessage",
					MessageManager.getProperty("message.addclient"));
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
				page = ConfigurationManager.getProperty("path.page.login");
				break;
			default:
				page = ConfigurationManager.getProperty("path.page.login");
			}
		} else {
			request.setAttribute("errorAddClientMessage",
			MessageManager.getProperty("message.addclienterror"));
			page = ConfigurationManager.getProperty("path.page.addclientform");
		}
		request.setAttribute("user_id", userId);
		request.setAttribute("user", user);
		request.setAttribute("role", role);
		return page;
	}

}
