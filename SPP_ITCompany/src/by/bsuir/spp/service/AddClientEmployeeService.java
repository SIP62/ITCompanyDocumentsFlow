package by.bsuir.spp.service;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.dao.AddClientEmployeeDAO;
import by.bsuir.spp.entities.ClientEmployee;

public class AddClientEmployeeService {
	AddClientEmployeeDAO aced = new AddClientEmployeeDAO();

	public boolean addClientEmployee(HttpServletRequest request) {
		ClientEmployee clientEmployee = new ClientEmployee();
		clientEmployee.setName(request.getParameter("name"));
		clientEmployee.setPhone(request.getParameter("phone"));
		clientEmployee.setEmail(request.getParameter("email"));
		clientEmployee.setSkype(request.getParameter("skype"));
		clientEmployee.setStatus(request.getParameter("status"));
		clientEmployee.getClient().setId(Integer.parseInt(request.getParameter("clientid")));
		
		return aced.insertClientEmployee(clientEmployee);
	}

}
