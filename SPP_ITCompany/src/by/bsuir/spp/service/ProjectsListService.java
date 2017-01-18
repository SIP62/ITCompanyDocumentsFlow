package by.bsuir.spp.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.dao.ProjectListFullDAO;
import by.bsuir.spp.dao.ProjectListOfClientDAO;
import by.bsuir.spp.dao.ProjectListOfEmployeeDAO;
import by.bsuir.spp.entities.Project;

public class ProjectsListService {
	
	
	public List<Project> getProjectsList(HttpServletRequest request) {
		List<Project> projectsList = new ArrayList<Project>();
		
		String userId = request.getParameter("user_id");
		String role = request.getParameter("role");
		switch(role) {
			case "client":
				ProjectListOfClientDAO plocd = new ProjectListOfClientDAO();
				projectsList = plocd.viewProjectsList(userId);
				break;
			case "programmer":
			case "team_leader":	
				ProjectListOfEmployeeDAO ploed = new ProjectListOfEmployeeDAO();
				projectsList = ploed.viewProjectsList(userId);
				break;
			case "client_manager":
			case "project_manager":
			case "HR":	
				ProjectListFullDAO plfd = new ProjectListFullDAO();
				projectsList = plfd.viewProjectsList();
				break;
			default:
				projectsList = null;
		}
		request.setAttribute("user_id", userId);
		request.setAttribute("role", role);
		
		return projectsList;
	}

}
