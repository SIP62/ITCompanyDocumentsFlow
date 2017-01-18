package by.bsuir.spp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.bsuir.spp.db.ConnectionFactory;
import by.bsuir.spp.entities.Employee;

public class EmployeeListDAO {
	Connection connection;
	Statement stmt;
	public EmployeeListDAO() {}
	
	private static Connection getConnection() 
			throws SQLException, 
				ClassNotFoundException 
	{
		Connection con = ConnectionFactory.
				getInstance().getConnection();
		return con;
	}
	
	public List<Employee> viewEmployeeList() {
		String employeeQuery = "select employee.id, "
				+ "users.id, users.name, roles.role "
				+ "from (roles inner join users on roles.id = users.id_roles) "
				+ "inner join employee on users.id = employee.id_users";
		List<Employee> employeeList = new ArrayList<Employee>();
		Employee employee = null;
		try{
			connection = getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(employeeQuery);
			while (rs.next()) {
				employee = new Employee();
				employee.setId(rs.getInt("employee.id"));
				employee.getUsers().setId(rs.getInt("users.id"));
				employee.getUsers().setName(rs.getString("users.name"));
				employee.getUsers().getRoles().setRole(rs.getString("roles.role"));
				
				employeeList.add(employee);
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
		return employeeList;
	}


}
