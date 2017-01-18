package by.bsuir.spp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.bsuir.spp.db.ConnectionFactory;
import by.bsuir.spp.entities.Roles;

public class RolesListDAO {
	
	Connection connection;
	Statement stmt;
	
	public RolesListDAO() {}
	
	private static Connection getConnection() 
			throws SQLException, 
				ClassNotFoundException 
	{
		Connection con = ConnectionFactory.
				getInstance().getConnection();
		return con;
	}

	public List<Roles> viewRolesList() {
		String rolesQuery = "select * from roles";
		List<Roles> rolesList = new ArrayList<Roles>();
		Roles roles = null;
		try{
			connection = getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(rolesQuery);
			while (rs.next()) {
				roles = new Roles();
				roles.setId(rs.getInt("id"));
				roles.setRole(rs.getString("role"));
				rolesList.add(roles);
			}
			rs.close();
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
		return rolesList;
	}

}
