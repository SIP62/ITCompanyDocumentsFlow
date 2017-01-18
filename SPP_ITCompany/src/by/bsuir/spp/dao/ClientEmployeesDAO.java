package by.bsuir.spp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.bsuir.spp.db.ConnectionFactory;
import by.bsuir.spp.entities.ClientEmployee;

public class ClientEmployeesDAO {
	Connection connection;
	Statement stmt;
	
	public ClientEmployeesDAO() {}
	
	private static Connection getConnection() 
			throws SQLException, 
				ClassNotFoundException 
	{
		Connection con = ConnectionFactory.
				getInstance().getConnection();
		return con;
	}

	public List<ClientEmployee> viewClientEmployees(String clientId) {
		String clientEmployeesQuery = "select clientemployees.* "
				+ "from clientemployees inner join client "
				+ "on client.id = clientemployees.id_client "
				+ "where client.id like '" + clientId + "'";
		
		ClientEmployee clientEmployee = null;
		List<ClientEmployee> clientEmployeeList = new ArrayList<ClientEmployee>();
		
		try{
			connection = getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(clientEmployeesQuery);
			while (rs.next()) {
				clientEmployee = new ClientEmployee();
				clientEmployee.setId(rs.getInt("id"));
				clientEmployee.setName(rs.getString("name"));
				clientEmployee.setPhone(rs.getString("phone"));
				clientEmployee.setEmail(rs.getString("email"));
				clientEmployee.setSkype(rs.getString("skype"));
				clientEmployee.setStatus(rs.getString("status"));
				clientEmployeeList.add(clientEmployee);
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
		return clientEmployeeList;
	}

}
