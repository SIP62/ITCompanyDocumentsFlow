package by.bsuir.spp.command;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.entities.Project;
import by.bsuir.spp.resource.ConfigurationManager;
import by.bsuir.spp.service.ProjectDataService;

public class ProjectFormCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		ProjectDataService projectDataService = new ProjectDataService();
		String userId = request.getParameter("user_id");
		String user = request.getParameter("user");
		String role = request.getParameter("role");
		Project project = projectDataService.getProjectData(request);
		request.setAttribute("project", project);
		request.setAttribute("user_id", userId);
		request.setAttribute("user", user);
		request.setAttribute("role", role);
		page = ConfigurationManager.getProperty("path.page.projectdataform");
		return page;
	}

}
