package by.bsuir.spp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.bsuir.spp.db.ConnectionFactory;
import by.bsuir.spp.entities.Users;

public class UsersListDAO {
	
	Connection connection;
	Statement stmt;
	public UsersListDAO() {}
	private static Connection getConnection() 
			throws SQLException, 
				ClassNotFoundException 
	{
		Connection con = ConnectionFactory.
				getInstance().getConnection();
		return con;
	}

	public List<Users> viewUsersList() {
		String usersQuery = "select users.id, users.name, roles.role "
				+ "from roles inner join users on roles.id = users.id_roles";
				
		List<Users> userList = new ArrayList<Users>();
		Users user = null;
		try{
			connection = getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(usersQuery);
			while (rs.next()) {
				user = new Users();
				user.setId(rs.getInt("users.id"));
				user.setName(rs.getString("users.name"));
				user.getRoles().setRole(rs.getString("roles.role"));
				userList.add(user);
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
		return userList;
	}

}
