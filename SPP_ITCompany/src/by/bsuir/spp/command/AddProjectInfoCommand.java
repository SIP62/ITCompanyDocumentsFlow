package by.bsuir.spp.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.entities.Info;
import by.bsuir.spp.resource.ConfigurationManager;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.AddProjectInfoService;
import by.bsuir.spp.service.ProjectInfoService;

public class AddProjectInfoCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String userId = request.getParameter("user_id");
		String user = request.getParameter("user");
		String role = request.getParameter("role");
		String projectId = request.getParameter("projectid");
		String projectName = request.getParameter("projectname");
		
		AddProjectInfoService addProjectInfoService = new AddProjectInfoService();
		boolean isAdded = addProjectInfoService.addProjectInfo(request);
		
		ProjectInfoService projectInfoService = new ProjectInfoService();
		List<Info> infoList = projectInfoService.getInfoData(request);
		request.setAttribute("infoList", infoList);
		
		if (!isAdded) {
			request.setAttribute("errorInsertMessage",
					MessageManager.getProperty("message.inserterror"));
		}
		
		page = ConfigurationManager.getProperty("path.page.projectinfo");
		request.setAttribute("user", user);
		request.setAttribute("user_id", userId);
		request.setAttribute("role", role);
		request.setAttribute("projectid", projectId);
		request.setAttribute("projectname", projectName);
		
		return page;
	}

}
