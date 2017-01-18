package by.bsuir.spp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.dao.ProjectInfoDAO;
import by.bsuir.spp.entities.Info;

public class ProjectInfoService {
	ProjectInfoDAO pid = new ProjectInfoDAO();

	public List<Info> getInfoData(HttpServletRequest request) {
		String projectId = request.getParameter("projectid");
		return pid.viewProjectInfo(projectId);
	}

}
