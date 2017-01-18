package by.bsuir.spp.service;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.dao.AddExecutantDAO;

public class AddExecutantService {
	AddExecutantDAO aed = new AddExecutantDAO();

	public boolean addExecutant(HttpServletRequest request) {
		String projectId = request.getParameter("projectid");
		String employeeId = request.getParameter("employeeid");
		return aed.insertExecutantInProject(projectId, employeeId);
	}

}
