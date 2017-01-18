package by.bsuir.spp.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.dao.RegistrationDAO;
import by.bsuir.spp.dao.RolesListDAO;
import by.bsuir.spp.entities.Roles;
import by.bsuir.spp.entities.Users;

public class RegistrationService {
	RegistrationDAO crd = new RegistrationDAO();
	public boolean addUser(HttpServletRequest request) {

		Users user = new Users();
		PassScrambler ps = new PassScrambler();
		List<Roles> rolesList = new ArrayList<Roles>();
		RolesListDAO rld = new RolesListDAO();
		rolesList = rld.viewRolesList();
		
		user.setName(request.getParameter("name"));
		user.setLogin(request.getParameter("login"));
		user.setPassword(ps.scramble(request.getParameter("password")));
		for (Roles r: rolesList) {
			if(r.getRole().equals("guest")) {
				user.getRoles().setId(r.getId());
				break;
			}
		}
		
		
		
		boolean isRecordAdded = crd.addUserToDB(user);
		if (isRecordAdded) {
			request.setAttribute("role", "guest");
			request.setAttribute("user", user.getName());
		}
		return isRecordAdded;
	}
}
