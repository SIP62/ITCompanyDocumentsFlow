package by.bsuir.spp.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.entities.Employee;
import by.bsuir.spp.resource.ConfigurationManager;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.AddEmployeeService;
import by.bsuir.spp.service.EmployeeListService;

public class AddEmployeeCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String userId = request.getParameter("user_id");
		String role = request.getParameter("role");
		String user = request.getParameter("user");
		
		AddEmployeeService addEmployeeService = new AddEmployeeService();
		boolean isAdded = addEmployeeService.addEmployee(request);
		
		EmployeeListService employeeListService = new EmployeeListService();
		List<Employee> employeeList = employeeListService.getEmployeeList();
		request.setAttribute("employeeList", employeeList);
		
		if(isAdded) {
			request.setAttribute("addEmployeeMessage",
					MessageManager.getProperty("message.addemployee"));
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
			request.setAttribute("errorAddEmployeeMessage",
			MessageManager.getProperty("message.addemployeeerror"));
			page = ConfigurationManager.getProperty("path.page.addemployeeform");
		}
		request.setAttribute("user_id", userId);
		request.setAttribute("user", user);
		request.setAttribute("role", role);
		return page;
	}

}
