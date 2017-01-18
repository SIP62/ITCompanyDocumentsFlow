package by.bsuir.spp.service;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.dao.DeleteExecutantDAO;

public class DeleteExecutantService {
	DeleteExecutantDAO ded = new DeleteExecutantDAO();

	public boolean removeExecutant(HttpServletRequest request) {
		String projectId = request.getParameter("projectid");
		String employeeId = request.getParameter("employeeid");
		return ded.deleteExecutant(projectId, employeeId);
	}

}
