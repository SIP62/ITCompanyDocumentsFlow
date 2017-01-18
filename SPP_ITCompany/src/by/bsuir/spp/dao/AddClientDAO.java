package by.bsuir.spp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.bsuir.spp.db.ConnectionFactory;
import by.bsuir.spp.entities.Client;

public class AddClientDAO {
	
	Connection connection;
	
	public AddClientDAO() {}
	
	private static Connection getConnection() 
			throws SQLException, 
				ClassNotFoundException 
	{
		Connection con = ConnectionFactory.
				getInstance().getConnection();
		return con;
	}

	public boolean addClientInDB(Client client) {
		boolean isAdded = false;
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
		PreparedStatement ps2 = null;
		String SQL_INSERT_users =
				"INSERT INTO users(name, login, password_hash, id_roles) "
				+ "VALUES(?,?,?,?)";
		String SQL_INSERT_client =
				"INSERT INTO client (id_users, payment_credentials, phone, "
				+ "email, discount, address) "
				+ "VALUES((SELECT users.id from users where users.name = ?),?,?,?,?,?)";
		try {
			ps = connection.prepareStatement(SQL_INSERT_users);
			UserRecorder userRec = new UserRecorder();
			userRec.insertUser(ps, client.getUsers());
			ps2 = connection.prepareStatement(SQL_INSERT_client);
			ClientRecorder clientRec = new ClientRecorder();
			clientRec.insertClient(ps2, client);
			isAdded = true;
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
		return isAdded;
	}

}
