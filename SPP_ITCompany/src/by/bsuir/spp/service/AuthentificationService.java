package by.bsuir.spp.service;

import java.util.List;

import by.bsuir.spp.dao.AuthentificationDAO;
import by.bsuir.spp.entities.Users;

public class AuthentificationService {
	
	AuthentificationDAO ad = new AuthentificationDAO();
	PassScrambler ps = new PassScrambler();
	
	public Users checkLogin(String loginTest, String passwordTest) {
		Users user = new Users();
		String passwordHash = ps.scramble(passwordTest);
		List<Users> userList = ad.viewUserList();
		for (Users el: userList) {
			if(el.getLogin().trim().equals(loginTest.trim()) &&
					el.getPassword().trim().equals(passwordHash.trim())) {
				user.setId(el.getId());
				user.setName(el.getName());
				user.getRoles().setRole(el.getRoles().getRole());
				return user;
			}
		}
		return null;
	}

}
