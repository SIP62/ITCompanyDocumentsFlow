package by.bsuir.spp.service;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.dao.AddRecruitDAO;
import by.bsuir.spp.entities.Recruit;

public class AddRecruitService {
	AddRecruitDAO ard = new AddRecruitDAO();
	
	public boolean addRecruit(HttpServletRequest request) {
		
		Recruit recruit = new Recruit();
		recruit.setName(request.getParameter("name"));
		recruit.setPhone(request.getParameter("phone"));
		recruit.setEmail(request.getParameter("email"));
		recruit.setSpecialization(request.getParameter("specialization"));
		recruit.setResume(request.getParameter("resume"));
		boolean isRecordAdded = ard.addRecruitToDB(recruit);
		
		return isRecordAdded;
	}

}
