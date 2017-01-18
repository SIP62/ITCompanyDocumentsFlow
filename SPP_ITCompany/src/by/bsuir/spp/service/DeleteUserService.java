package by.bsuir.spp.service;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.dao.DeleteUserDAO;

public class DeleteUserService {
	DeleteUserDAO dud = new DeleteUserDAO();

	public boolean removeUser(HttpServletRequest request) {
		String userId = request.getParameter("userid");
		return dud.deleteUser(userId);
	}

}
