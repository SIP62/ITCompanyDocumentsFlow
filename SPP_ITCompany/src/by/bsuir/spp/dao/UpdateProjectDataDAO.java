package by.bsuir.spp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.bsuir.spp.db.ConnectionFactory;
import by.bsuir.spp.entities.Project;

public class UpdateProjectDataDAO {
	
	Connection connection;
	
	public UpdateProjectDataDAO() {}
	
	private static Connection getConnection() 
			throws SQLException, 
				ClassNotFoundException 
	{
		Connection con = ConnectionFactory.
				getInstance().getConnection();
		return con;
	}

	public boolean updateProjectInDB(Project project) {
		boolean isUpdated = false;
		try {
			connection = getConnection();
		} catch (SQLException e1) {
			System.out.println("Connection to db is failed");
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("ConnectionFactory is not found");
			e.printStackTrace();
		}
		
		PreparedStatement ps = null;
		String SQL_UPDATE =
				"UPDATE project SET name = ?, description = ?, requirements_specification = ?, "
				+ "cost = ?, start_date = ?, finish_date = ?, progress = ?"
				+ "WHERE id = ?";
		try {
			ps = connection.prepareStatement(SQL_UPDATE);
			ProjectUpdater rec = new ProjectUpdater();
			rec.updateProject(ps, project);
			isUpdated = true;
		} catch (SQLException e) {
			System.out.println("Update db is failed");
			e.printStackTrace();
		} finally {
			try {
				if(ps != null)
					ps.close();
				if(connection != null)
					connection.close();
				} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isUpdated;
	}

}
