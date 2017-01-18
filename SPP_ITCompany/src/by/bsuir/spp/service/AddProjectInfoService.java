package by.bsuir.spp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.dao.AddProjectInfoDAO;
import by.bsuir.spp.entities.Info;

public class AddProjectInfoService {
	AddProjectInfoDAO apid = new AddProjectInfoDAO();

	public boolean addProjectInfo(HttpServletRequest request) {
		Info info = new Info();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		info.setName(request.getParameter("name"));
		try {
			info.setDate(sdf.parse(request.getParameter("date")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		info.setDescription(request.getParameter("description"));
		info.getEmployee().setId(Integer.parseInt(request.getParameter("author_id")));
		info.getProject().setId(Integer.parseInt(request.getParameter("projectid")));
		
		return apid.insertProjectInfo(info);
	}

}
