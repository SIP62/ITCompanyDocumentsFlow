package by.bsuir.spp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.bsuir.spp.db.ConnectionFactory;
import by.bsuir.spp.entities.ClientEmployee;

public class AddClientEmployeeDAO {
	
	Connection connection;
	
	public AddClientEmployeeDAO() {}
	
	private static Connection getConnection() 
			throws SQLException, 
				ClassNotFoundException 
	{
		Connection con = ConnectionFactory.
				getInstance().getConnection();
		return con;
	}

	public boolean insertClientEmployee(ClientEmployee clientEmployee) {
		boolean isRecordAdded = false;
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
		String SQL_INSERT =
				"INSERT INTO clientemployees (name, phone, email, skype, status, id_client) VALUES(?,?,?,?,?,?)";
		try {
			ps = connection.prepareStatement(SQL_INSERT);
			ClientEmployeeRecorder rec = new ClientEmployeeRecorder();
			rec.insertClientEmployee(ps, clientEmployee);
			isRecordAdded = true;
		} catch (SQLException e) {
			System.out.println("Record to db is failed");
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
		return isRecordAdded;
	}

}
