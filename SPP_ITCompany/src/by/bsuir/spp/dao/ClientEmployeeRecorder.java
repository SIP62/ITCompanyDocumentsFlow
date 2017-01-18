package by.bsuir.spp.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.bsuir.spp.entities.ClientEmployee;

public class ClientEmployeeRecorder {

	public void insertClientEmployee(PreparedStatement ps,
			ClientEmployee clientEmployee) {
		try {
			ps.setString(1, clientEmployee.getName());
			ps.setString(2, clientEmployee.getPhone());
			ps.setString(3, clientEmployee.getEmail());
			ps.setString(4, clientEmployee.getSkype());
			ps.setString(5, clientEmployee.getStatus());
			ps.setInt(6, clientEmployee.getClient().getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Record to db is failed");
			e.printStackTrace();
		}
	}

}
