package by.bsuir.spp.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import by.bsuir.spp.db.ConnectionFactory;

public class DeleteExecutantDAO {
	Connection connection;
	Statement stmt;
	
	public DeleteExecutantDAO() {}
	
	private static Connection getConnection() 
			throws SQLException, 
				ClassNotFoundException 
	{
		Connection con = ConnectionFactory.
				getInstance().getConnection();
		return con;
	}

	public boolean deleteExecutant(String projectId, String employeeId) {
		boolean isDeleted = false;
		String deleteExecutantQuery = "delete from project_employee "
				+ "where id_employee = '" + employeeId + 
				"' and id_project = '" + projectId + "'";
		try{
			connection = getConnection();
			stmt = connection.createStatement();
			stmt.executeUpdate(deleteExecutantQuery);
			isDeleted = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally
		{
			try {
				if(stmt != null)
					stmt.close();
				if(connection != null)
					connection.close();
				} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		return isDeleted;
	}

}
