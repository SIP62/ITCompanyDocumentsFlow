package by.bsuir.spp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.bsuir.spp.db.ConnectionFactory;
import by.bsuir.spp.entities.Employee;

public class AddEmployeeDAO {
	
	Connection connection;
	
	public AddEmployeeDAO() {}
	
	private static Connection getConnection() 
			throws SQLException, 
				ClassNotFoundException 
	{
		Connection con = ConnectionFactory.
				getInstance().getConnection();
		return con;
	}

	public boolean addEmployeeInDB(Employee employee) {
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
		String SQL_INSERT_employee =
				"INSERT INTO employee (id_users, address, phone, "
				+ "passport, credit_card, resume, specialization, "
				+ "salary, recruitment_date, contract_expiration_date) "
				+ "VALUES((SELECT users.id from users where users.name = ?),?,?,?,?,?,?,?,?,?)";
		
		try {
			ps = connection.prepareStatement(SQL_INSERT_users);
			UserRecorder userRec = new UserRecorder();
			userRec.insertUser(ps, employee.getUsers());
			ps2 = connection.prepareStatement(SQL_INSERT_employee);
			EmployeeRecorder employeeRec = new EmployeeRecorder();
			employeeRec.insertEmployee(ps2, employee);
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
