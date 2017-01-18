package by.bsuir.spp.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.entities.Roles;
import by.bsuir.spp.resource.ConfigurationManager;
import by.bsuir.spp.service.RolesListService;

public class AddEmployeeFormCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String userId = request.getParameter("user_id");
		String user = request.getParameter("user");
		String role = request.getParameter("role");
		
		RolesListService rolesListService = new RolesListService();
		List<Roles> rolesList = rolesListService.getRolesList();
		request.setAttribute("rolesList", rolesList);
		
		request.setAttribute("user_id", userId);
		request.setAttribute("role", role);
		request.setAttribute("user", user);
		String page = ConfigurationManager.getProperty("path.page.addemployeeform");
		return page;
	}

}
