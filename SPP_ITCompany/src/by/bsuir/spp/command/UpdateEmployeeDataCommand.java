package by.bsuir.spp.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.entities.Employee;
import by.bsuir.spp.resource.ConfigurationManager;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.EmployeeListService;
import by.bsuir.spp.service.UpdateEmployeeDataService;

public class UpdateEmployeeDataCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String role = request.getParameter("role");
		String user = request.getParameter("user");
		String userId = request.getParameter("user_id");
		String idUsers = request.getParameter("id_users");
		
		UpdateEmployeeDataService updateEmployeeDataService = new UpdateEmployeeDataService();
		boolean isUpdated = updateEmployeeDataService.updateEmployeeData(request);
		
		EmployeeListService employeeListService = new EmployeeListService();
		List<Employee> employeeList = employeeListService.getEmployeeList();
		request.setAttribute("employeeList", employeeList);
		
		if(isUpdated) {
			if (userId.equals(idUsers)) {
				request.setAttribute("updatePrivateDataMessage",
						MessageManager.getProperty("message.updateprivatedata"));
			} else {
				request.setAttribute("updateEmployeeDataMessage",
						MessageManager.getProperty("message.updateemployeedata"));
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
			request.setAttribute("errorUpdateEmployeeDataMessage",
			MessageManager.getProperty("message.updateemployeedataerror"));
			page = ConfigurationManager.getProperty("path.page.employeedataform");
		}
		request.setAttribute("user_id", userId);
		request.setAttribute("user", user);
		request.setAttribute("role", role);
		return page;
	}

}
