package by.bsuir.spp.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.entities.Client;
import by.bsuir.spp.resource.ConfigurationManager;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.ClientListService;
import by.bsuir.spp.service.UpdateClientDataService;

public class UpdateClientDataCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String role = request.getParameter("role");
		String userId = request.getParameter("user_id");
		String user = request.getParameter("user");
		String idUsers = request.getParameter("id_users");
		
		UpdateClientDataService updateClientDataService = new UpdateClientDataService();
		boolean isUpdated = updateClientDataService.updateClientData(request);
		
		ClientListService clientListService = new ClientListService();
		List<Client> clientList = clientListService.getClientList();
		request.setAttribute("clientList", clientList);
		
		if(isUpdated) {
			if (userId.equals(idUsers)) {
				request.setAttribute("updatePrivateDataMessage",
						MessageManager.getProperty("message.updateprivatedata"));
			} else {
				request.setAttribute("updateClientDataMessage",
						MessageManager.getProperty("message.updateclientdata"));
			}
			
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
			request.setAttribute("errorUpdateClientDataMessage",
			MessageManager.getProperty("message.updateclientdataerror"));
			page = ConfigurationManager.getProperty("path.page.clientdataform");
		}
		request.setAttribute("user_id", userId);
		request.setAttribute("user", user);
		request.setAttribute("role", role);
		return page;
	}

}
