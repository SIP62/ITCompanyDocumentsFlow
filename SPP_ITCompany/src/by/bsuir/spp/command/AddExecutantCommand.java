package by.bsuir.spp.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.entities.Employee;
import by.bsuir.spp.entities.Project;
import by.bsuir.spp.resource.ConfigurationManager;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.AddExecutantService;
import by.bsuir.spp.service.EmployeeListService;
import by.bsuir.spp.service.ProjectDataService;

public class AddExecutantCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String userId = request.getParameter("user_id");
		String user = request.getParameter("user");
		String role = request.getParameter("role");
		
		AddExecutantService addExecutantService = new AddExecutantService();
		boolean isAdded = addExecutantService.addExecutant(request);
		
		EmployeeListService employeeListService = new EmployeeListService();
		List<Employee> employeeList = employeeListService.getEmployeeList();
		request.setAttribute("employeeList", employeeList);
		
		ProjectDataService projectDataService = new ProjectDataService();
		Project project = projectDataService.getProjectData(request);
		request.setAttribute("project", project);
		
		if (!isAdded) {
			request.setAttribute("errorInsertMessage",
					MessageManager.getProperty("message.inserterror"));
		}
		
		page = ConfigurationManager.getProperty("path.page.changeexecutantform");
		request.setAttribute("user_id", userId);
		request.setAttribute("user", user);
		request.setAttribute("role", role);
		
		return page;
	}

}
