package by.bsuir.spp.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExecutantRecorder {

	public void insertExecutant(PreparedStatement ps, String employeeId,
			String projectId) {
		try {
			ps.setString(1, employeeId);
			ps.setString(2, projectId);
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Record to db is failed");
			e.printStackTrace();
		}
	}

}
