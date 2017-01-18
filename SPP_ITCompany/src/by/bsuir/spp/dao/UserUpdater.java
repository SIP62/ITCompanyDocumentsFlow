package by.bsuir.spp.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.bsuir.spp.entities.Users;

public class UserUpdater {

	public void updateUser(PreparedStatement ps, Users user) {
		try {
			ps.setString(1, user.getName());
			ps.setString(2, user.getLogin());
			ps.setString(3, user.getPassword());
			ps.setInt(4, user.getRoles().getId());
			
			ps.setInt(5, user.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Record to db is failed");
			e.printStackTrace();
		}
	}

}
