package by.bsuir.spp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.dao.AddEmployeeDAO;
import by.bsuir.spp.entities.Employee;

public class AddEmployeeService {
	
	AddEmployeeDAO aed = new AddEmployeeDAO();

	public boolean addEmployee(HttpServletRequest request) {
		
		Employee employee = new Employee();
		PassScrambler ps = new PassScrambler();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		employee.getUsers().setName(request.getParameter("name"));
		employee.setAddress(request.getParameter("address"));
		employee.setPhone(request.getParameter("phone"));
		employee.setPassport(request.getParameter("passport"));
		employee.setCreditCard(request.getParameter("credit_card"));
		employee.setResume(request.getParameter("resume"));
		employee.setSpecialization(request.getParameter("specialization"));
		employee.getUsers().getRoles().setId(Integer.parseInt(request.getParameter("id_roles")));
		employee.setSalary(Float.parseFloat(request.getParameter("salary")));
		try {
			employee.setRecruitmentDate(sdf.parse(request.getParameter("recruitment_date")));
			employee.setContractExpirationDate(sdf.parse(request.getParameter("contract_expiration_date")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		employee.getUsers().setLogin(request.getParameter("login"));
		employee.getUsers().setPassword(ps.scramble(request.getParameter("password")));
		
		return aed.addEmployeeInDB(employee);

	}

}
