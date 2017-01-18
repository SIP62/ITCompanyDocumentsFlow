package by.bsuir.spp.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.bsuir.spp.entities.Recruit;

public class RecruitRecorder {

	public void insertRecruit(PreparedStatement ps, Recruit recruit) {
		try {
			ps.setString(1, recruit.getName());
			ps.setString(2, recruit.getPhone());
			ps.setString(3, recruit.getEmail());
			ps.setString(4, recruit.getSpecialization());
			ps.setString(5, recruit.getResume());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Record to db is failed");
			e.printStackTrace();
		}
		
	}

}
