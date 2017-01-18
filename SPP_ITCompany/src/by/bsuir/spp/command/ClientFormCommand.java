package by.bsuir.spp.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.entities.Client;
import by.bsuir.spp.entities.Roles;
import by.bsuir.spp.resource.ConfigurationManager;
import by.bsuir.spp.service.ClientDataService;
import by.bsuir.spp.service.RolesListService;

public class ClientFormCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String userId = request.getParameter("user_id");
		String user = request.getParameter("user");
		String role = request.getParameter("role");
		int idRoles = 0;
		
		RolesListService rolesListService = new RolesListService();
		List<Roles> rolesList = rolesListService.getRolesList();
		for (Roles rl: rolesList) {
			if (rl.getRole().equals("client")) {
				idRoles = rl.getId();
				break;
			}
		}
		request.setAttribute("id_roles", idRoles);
		
		ClientDataService clientDataService = new ClientDataService();
		Client client = clientDataService.getClientData(request);
		request.setAttribute("client", client);
		
		request.setAttribute("user_id", userId);
		request.setAttribute("user", user);
		request.setAttribute("role", role);
		page = ConfigurationManager.getProperty("path.page.clientdataform");
		return page;
	}

}
