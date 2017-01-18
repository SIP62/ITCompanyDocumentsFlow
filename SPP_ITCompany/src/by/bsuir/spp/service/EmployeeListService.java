package by.bsuir.spp.service;

import java.util.ArrayList;
import java.util.List;

import by.bsuir.spp.dao.EmployeeListDAO;
import by.bsuir.spp.entities.Employee;

public class EmployeeListService {

	public List<Employee> getEmployeeList() {
		List<Employee> employeeList = new ArrayList<Employee>();
		EmployeeListDAO eld = new EmployeeListDAO();
		employeeList = eld.viewEmployeeList();
		return employeeList;
	}

}
