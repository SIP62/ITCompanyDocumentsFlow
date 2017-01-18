package by.bsuir.spp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.bsuir.spp.db.ConnectionFactory;
import by.bsuir.spp.entities.Client;

public class ClientDataDAO {
	Connection connection;
	Statement stmt;
	public ClientDataDAO() {}
	private static Connection getConnection() 
			throws SQLException, 
				ClassNotFoundException 
	{
		Connection con = ConnectionFactory.
				getInstance().getConnection();
		return con;
	}
	
	public Client viewClientData(String idUsers) {
		String clientDataQuery = "select client.*, users.*, roles.role "
				+ "from (roles inner join users on roles.id = users.id_roles) "
				+ "inner join client on users.id = client.id_users "
				+ "where users.id like '" + idUsers + "'";
		Client client = null;
		
		try{
			connection = getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(clientDataQuery);
			while (rs.next()) {
				client = new Client();
				client.setId(rs.getInt("client.id"));
				client.getUsers().setId(rs.getInt("users.id"));
				client.getUsers().setName(rs.getString("users.name"));
				client.setPaymentCredentials(rs.getString("client.payment_credentials"));
				client.setPhone(rs.getString("client.phone"));
				client.setEmail(rs.getString("client.email"));
				client.setDiscount(rs.getFloat("client.discount"));
				client.setAddress(rs.getString("client.address"));
				client.getUsers().setLogin(rs.getString("users.login"));
				client.getUsers().setPassword(rs.getString("users.password_hash"));
				client.getUsers().getRoles().setRole(rs.getString("roles.role"));
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
		return client;
	}

}
