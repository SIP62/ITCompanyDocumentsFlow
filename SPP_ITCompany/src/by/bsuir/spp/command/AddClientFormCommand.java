package by.bsuir.spp.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.entities.Roles;
import by.bsuir.spp.resource.ConfigurationManager;
import by.bsuir.spp.service.RolesListService;

public class AddClientFormCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
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
		request.setAttribute("user_id", userId);
		request.setAttribute("role", role);
		request.setAttribute("user", user);
		String page = ConfigurationManager.getProperty("path.page.addclientform");
		return page;
	}

}
