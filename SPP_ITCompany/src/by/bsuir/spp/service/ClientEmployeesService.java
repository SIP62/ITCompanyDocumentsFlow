package by.bsuir.spp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.dao.ClientEmployeesDAO;
import by.bsuir.spp.entities.ClientEmployee;

public class ClientEmployeesService {
	ClientEmployeesDAO ced = new ClientEmployeesDAO();

	public List<ClientEmployee> getClientEmployeeData(HttpServletRequest request) {
		String clientId = request.getParameter("clientid");
		return ced.viewClientEmployees(clientId);
	}

}
