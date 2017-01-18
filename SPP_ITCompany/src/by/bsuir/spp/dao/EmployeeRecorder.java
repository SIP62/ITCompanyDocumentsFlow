package by.bsuir.spp.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.bsuir.spp.entities.Employee;

public class EmployeeRecorder {

	public void insertEmployee(PreparedStatement ps, Employee employee) {
		try {
			ps.setString(1, employee.getUsers().getName());
			ps.setString(2, employee.getAddress());
			ps.setString(3, employee.getPhone());
			ps.setString(4, employee.getPassport());
			ps.setString(5, employee.getCreditCard());
			ps.setString(6, employee.getResume());
			ps.setString(7, employee.getSpecialization());
			ps.setFloat(8, employee.getSalary());
			java.util.Date utilRecruitmentDate = employee.getRecruitmentDate();
			java.sql.Date sqlRecruitmentDate = new java.sql.Date(utilRecruitmentDate.getTime());
			ps.setDate(9, sqlRecruitmentDate);
			java.util.Date utilContractExpirationDate = employee.getContractExpirationDate();
			java.sql.Date sqlContractExpirationDate = new java.sql.Date(utilContractExpirationDate.getTime());
			ps.setDate(10, sqlContractExpirationDate);
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Record to db is failed");
			e.printStackTrace();
		}
	}

}
