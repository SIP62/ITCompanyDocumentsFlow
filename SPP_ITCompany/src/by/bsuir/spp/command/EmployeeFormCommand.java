package by.bsuir.spp.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.entities.Employee;
import by.bsuir.spp.entities.Roles;
import by.bsuir.spp.resource.ConfigurationManager;
import by.bsuir.spp.service.EmployeeDataService;
import by.bsuir.spp.service.RolesListService;

public class EmployeeFormCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String userId = request.getParameter("user_id");
		String user = request.getParameter("user");
		String role = request.getParameter("role");
		
		RolesListService rolesListService = new RolesListService();
		List<Roles> rolesList = rolesListService.getRolesList();
		request.setAttribute("rolesList", rolesList);
		
		EmployeeDataService employeeDataService = new EmployeeDataService();
		Employee employee = employeeDataService.getEmployeeData(request);
		request.setAttribute("employee", employee);
		
		request.setAttribute("user_id", userId);
		request.setAttribute("user", user);
		request.setAttribute("role", role);
		page = ConfigurationManager.getProperty("path.page.employeedataform");
		return page;
	}

}
