package by.bsuir.spp.service;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.dao.EmployeeDataDAO;
import by.bsuir.spp.entities.Employee;

public class EmployeeDataService {
	EmployeeDataDAO edd = new EmployeeDataDAO();

	public Employee getEmployeeData(HttpServletRequest request) {
		PassDecoder pd = new PassDecoder();
		String idUsers = request.getParameter("id_users");
		
		
		Employee employee = edd.viewEmployeeData(idUsers);
		String password = pd.decode(employee.getUsers().getPassword());
		employee.getUsers().setPassword(password);
		return employee;
	}

}
