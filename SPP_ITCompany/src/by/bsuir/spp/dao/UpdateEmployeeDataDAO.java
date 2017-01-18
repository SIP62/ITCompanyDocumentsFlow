package by.bsuir.spp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.bsuir.spp.db.ConnectionFactory;
import by.bsuir.spp.entities.Employee;

public class UpdateEmployeeDataDAO {
	
	Connection connection;
	
	public UpdateEmployeeDataDAO() {}
	
	private static Connection getConnection() 
			throws SQLException, 
				ClassNotFoundException 
	{
		Connection con = ConnectionFactory.
				getInstance().getConnection();
		return con;
	}

	public boolean updateEmployeeInDB(Employee employee) {
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
		String SQL_UPDATE_employee =
				"UPDATE employee SET id_users = ?, address = ?, phone = ?, "
				+ "passport = ?, credit_card = ?, resume = ?, specialization = ?, "
				+ "salary = ?, recruitment_date = ?, contract_expiration_date = ? "
				+ "WHERE id = ?";
		String SQL_UPDATE_users =
				"UPDATE users SET name = ?, login = ?, password_hash = ?, "
				+ "id_roles = ? WHERE id = ?";
		try {
			ps = connection.prepareStatement(SQL_UPDATE_employee);
			EmployeeUpdater employeeRec = new EmployeeUpdater();
			employeeRec.updateEmployee(ps, employee);
			
			ps = connection.prepareStatement(SQL_UPDATE_users);
			UserUpdater userRec = new UserUpdater();
			userRec.updateUser(ps, employee.getUsers());
			
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
