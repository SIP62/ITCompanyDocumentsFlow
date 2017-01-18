package by.bsuir.spp.service;

import java.util.ArrayList;
import java.util.List;

import by.bsuir.spp.dao.UsersListDAO;
import by.bsuir.spp.entities.Users;

public class UsersListService {

	public List<Users> getUsersList() {
		List<Users> userList = new ArrayList<Users>();
		UsersListDAO eld = new UsersListDAO();
		userList = eld.viewUsersList();
		return userList;
	}

}
