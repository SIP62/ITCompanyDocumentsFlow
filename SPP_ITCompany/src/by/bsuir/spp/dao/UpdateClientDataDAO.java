package by.bsuir.spp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.bsuir.spp.db.ConnectionFactory;
import by.bsuir.spp.entities.Client;

public class UpdateClientDataDAO {
	
	Connection connection;
	
	public UpdateClientDataDAO() {}
	
	private static Connection getConnection() 
			throws SQLException, 
				ClassNotFoundException 
	{
		Connection con = ConnectionFactory.
				getInstance().getConnection();
		return con;
	}

	public boolean updateClientInDB(Client client) {
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
		String SQL_UPDATE_client =
				"UPDATE client SET  payment_credentials = ?, phone = ?, "
				+ "email = ?, discount = ?, address = ?"
				+ "WHERE id = ?";
		String SQL_UPDATE_users =
				"UPDATE users SET name = ?, login = ?, password_hash = ?, "
				+ "id_roles = ? WHERE id = ?";
		try {
			ps = connection.prepareStatement(SQL_UPDATE_client);
			ClientUpdater clientRec = new ClientUpdater();
			clientRec.updateClient(ps, client);
			
			ps = connection.prepareStatement(SQL_UPDATE_users);
			UserUpdater userRec = new UserUpdater();
			userRec.updateUser(ps, client.getUsers());
			
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
