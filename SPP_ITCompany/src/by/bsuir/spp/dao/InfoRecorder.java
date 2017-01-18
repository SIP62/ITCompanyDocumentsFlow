package by.bsuir.spp.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.bsuir.spp.entities.Info;

public class InfoRecorder {

	public void insertInfo(PreparedStatement ps, Info info) {
		try {
			ps.setString(1, info.getName());
			java.util.Date date = info.getDate();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			ps.setDate(2, sqlDate);
			ps.setString(3, info.getDescription());
			ps.setInt(4, info.getEmployee().getId());
			ps.setInt(5, info.getProject().getId());
			
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Record to db is failed");
			e.printStackTrace();
		}
	}

}
