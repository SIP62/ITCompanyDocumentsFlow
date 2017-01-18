package by.bsuir.spp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.bsuir.spp.db.ConnectionFactory;
import by.bsuir.spp.entities.Client;

public class ClientListDAO {
	Connection connection;
	Statement stmt;
	public ClientListDAO() {}
	private static Connection getConnection() 
			throws SQLException, 
				ClassNotFoundException 
	{
		Connection con = ConnectionFactory.
				getInstance().getConnection();
		return con;
	}

	public List<Client> viewClientList() {
		String clientQuery = "select client.id, users.id, users.name, roles.role "
				+ "from (roles inner join users on roles.id = users.id_roles) "
				+ "inner join client on users.id = client.id_users";
				
		List<Client> clientList = new ArrayList<Client>();
		Client client = null;
		try{
			connection = getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(clientQuery);
			while (rs.next()) {
				client = new Client();
				client.setId(rs.getInt("client.id"));
				client.getUsers().setId(rs.getInt("users.id"));
				client.getUsers().setName(rs.getString("users.name"));
				client.getUsers().getRoles().setRole(rs.getString("roles.role"));
				clientList.add(client);
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
		return clientList;
	}

}
