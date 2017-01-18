package by.bsuir.spp.service;

import java.util.ArrayList;
import java.util.List;

import by.bsuir.spp.dao.RolesListDAO;
import by.bsuir.spp.entities.Roles;

public class RolesListService {

	public List<Roles> getRolesList() {
		List<Roles> rolesList = new ArrayList<Roles>();
		RolesListDAO rld = new RolesListDAO();
		rolesList = rld.viewRolesList();
		return rolesList;
	}

}
