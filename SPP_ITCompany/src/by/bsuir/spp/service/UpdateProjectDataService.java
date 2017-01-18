package by.bsuir.spp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.dao.UpdateProjectDataDAO;
import by.bsuir.spp.entities.Project;

public class UpdateProjectDataService {
	UpdateProjectDataDAO updd = new UpdateProjectDataDAO();
	

	public boolean updateProjectData(HttpServletRequest request) {
		Project project = new Project();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		project.setId(Integer.parseInt(request.getParameter("id_project")));
		project.setName(request.getParameter("name"));
		project.setDescription(request.getParameter("description"));
		project.setRequirementSpecification(request.getParameter("requirements_specification"));
		project.setCost(Float.parseFloat(request.getParameter("cost")));
		try {
			project.setStartDate(sdf.parse(request.getParameter("start_date")));
			project.setFinishDate(sdf.parse(request.getParameter("finish_date")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		project.setProgress(Float.parseFloat(request.getParameter("progress")));
		boolean isUpdated = updd.updateProjectInDB(project);
		return isUpdated;
	}

}
