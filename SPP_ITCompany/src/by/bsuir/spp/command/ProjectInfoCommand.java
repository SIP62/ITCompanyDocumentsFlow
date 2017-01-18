package by.bsuir.spp.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.entities.Info;
import by.bsuir.spp.resource.ConfigurationManager;
import by.bsuir.spp.service.ProjectInfoService;

public class ProjectInfoCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		ProjectInfoService projectInfoService = new ProjectInfoService();
		String userId = request.getParameter("user_id");
		String user = request.getParameter("user");
		String role = request.getParameter("role");
		String projectId = request.getParameter("projectid");
		String projectName = request.getParameter("projectname");
		List<Info> infoList = projectInfoService.getInfoData(request);
		request.setAttribute("infoList", infoList);
		request.setAttribute("user_id", userId);
		request.setAttribute("user", user);
		request.setAttribute("role", role);
		request.setAttribute("projectid", projectId);
		request.setAttribute("projectname", projectName);
		switch (role) {
		case "client":
			page = ConfigurationManager.getProperty("path.page.client");
			break;
		case "programmer":
		case "team_leader":
		case "project_manager":
		case "HR":
		case "client_manager":	
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
//		page = ConfigurationManager.getProperty("path.page.projectinfo");
		return page;
	}

}
