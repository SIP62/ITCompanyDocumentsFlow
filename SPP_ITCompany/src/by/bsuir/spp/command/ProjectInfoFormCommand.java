package by.bsuir.spp.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.entities.Employee;
import by.bsuir.spp.resource.ConfigurationManager;
import by.bsuir.spp.service.EmployeeListService;

public class ProjectInfoFormCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String userId = request.getParameter("user_id");
		String user = request.getParameter("user");
		String role = request.getParameter("role");
		String projectId = request.getParameter("projectid");
		String projectName = request.getParameter("projectname");
		
		EmployeeListService employeeListService = new EmployeeListService();
		List<Employee> employeeList = employeeListService.getEmployeeList();
		request.setAttribute("employeeList", employeeList);
		
		request.setAttribute("role", role);
		request.setAttribute("user_id", userId);
		request.setAttribute("user", user);
		request.setAttribute("projectid", projectId);
		request.setAttribute("projectname", projectName);
		page = ConfigurationManager.getProperty("path.page.projectinfoform");
		return page;
	}

}
