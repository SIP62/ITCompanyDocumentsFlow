package by.bsuir.spp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.bsuir.spp.db.ConnectionFactory;
import by.bsuir.spp.entities.Employee;

public class EmployeeDataDAO {
	Connection connection;
	Statement stmt;
	public EmployeeDataDAO() {}
	private static Connection getConnection() 
			throws SQLException, 
				ClassNotFoundException 
	{
		Connection con = ConnectionFactory.
				getInstance().getConnection();
		return con;
	}

	public Employee viewEmployeeData(String idUsers) {
		String employeeDataQuery = "select employee.*, users.*, roles.* "
				+ "from (roles inner join users "
				+ "on roles.id = users.id_roles) "
				+ "inner join employee "
				+ "on users.id = employee.id_users "
				+ "where users.id like '" + idUsers + "'";
		Employee employee = null;
		
		try{
			connection = getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(employeeDataQuery);
			while (rs.next()) {
				employee = new Employee();
				employee.getUsers().setId(rs.getInt("users.id"));
				employee.getUsers().setName(rs.getString("users.name"));
				employee.getUsers().setLogin(rs.getString("users.login"));
				employee.getUsers().setPassword(rs.getString("users.password_hash"));
				employee.setId(rs.getInt("employee.id"));
				employee.setAddress(rs.getString("address"));
				employee.setPhone(rs.getString("phone"));
				employee.setPassport(rs.getString("passport"));
				employee.setCreditCard(rs.getString("credit_card"));
				employee.setResume(rs.getString("resume"));
				employee.setSpecialization(rs.getString("specialization"));
				employee.setSalary(rs.getFloat("salary"));
				employee.setRecruitmentDate(rs.getDate("recruitment_date"));
				employee.setContractExpirationDate(rs.getDate("contract_expiration_date"));
				employee.getUsers().getRoles().setId(rs.getInt("roles.id"));
				employee.getUsers().getRoles().setRole(rs.getString("roles.role"));
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
		return employee;
	}

}
