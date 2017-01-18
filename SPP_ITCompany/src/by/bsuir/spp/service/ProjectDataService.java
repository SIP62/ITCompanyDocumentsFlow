package by.bsuir.spp.service;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.dao.ProjectDataDAO;
import by.bsuir.spp.entities.Project;

public class ProjectDataService {
	ProjectDataDAO pdd = new ProjectDataDAO();

	public Project getProjectData(HttpServletRequest request) {
		String projectId = request.getParameter("projectid");
		Project project = pdd.viewProjectData(projectId);
		return project;
	}

}
